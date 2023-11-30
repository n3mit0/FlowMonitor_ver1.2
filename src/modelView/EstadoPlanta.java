package modelView;

import model.Datos;
import java.io.IOException;
import model.ArduinoCom;
import java.util.concurrent.CountDownLatch;

/**
 *
 * @author julie
 */
public class EstadoPlanta {

    private static final CountDownLatch countDownLatch = new CountDownLatch(1);
    private final ArduinoCom arduino;
    private final Estado estadoActual;
    private final Datos registrarDatos;
    private float pressure;
    private float caudal;

    public EstadoPlanta(ArduinoCom conexion) throws InterruptedException, IOException {
        // Instanciar los objetos que vamos a usar
        this.arduino = conexion;
        this.estadoActual = new Estado();
        this.registrarDatos = new Datos();

        if (!"No conectado".equals(arduino.verificarpuerto())) {

            // Leer el ultimo mensaje del arduino
            String[] val = this.arduino.obtenerValorSensor("3").split(":");

            // Volverlo un float
            float temperature = Float.parseFloat(String.valueOf(val[0]));
            float cau = obtenerCaudal(Float.parseFloat(val[1]));
            float press = obtenerPresion(temperature);

            // agregar atributos al objeto estadoActual
            this.estadoActual.setPressure(press);
            this.estadoActual.settemperature(temperature);
            this.estadoActual.setcaudal(cau);
            
            countDownLatch.countDown();
            try {
                // guardarlos en la base de datos
                registrarDatos.elemadd(this.estadoActual.gettemperature(),
                        this.estadoActual.getPressure());
                Thread.sleep(200);
            } catch (IOException ex) {
                //Logger.getLogger(EstadoPlanta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                //Logger.getLogger(EstadoPlanta.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
            System.out.println("Error en Estado Planta puerto Arduino");
        }

    }

    public Float temperaturaActual() {
        return this.estadoActual.gettemperature();
    }

    public Float presionActual() {
        return this.estadoActual.getPressure();
    }

    public Float caudalActual() {
        return this.estadoActual.getcaudal();
    }

    private Float obtenerPresion(float inTemp) {
        // funcion de presion = (2*10^-7)*(x^3,9246)
        //conversion a double
        double temp = Double.parseDouble(Float.toString(inTemp));
        double funcion = (2 * (Math.pow(10, -7))) * (Math.pow(temp, 3.9246));

        //conversion a float 
        this.pressure = Float.parseFloat(Double.toString(funcion));

        return this.pressure;
    }

    private Float obtenerCaudal(float num) {
        // funcion de caudal con rpm de entrada
        double rpm = Double.parseDouble(Float.toString(num));
        double funcion = (rpm);

        //conversion a float
        this.caudal = Float.parseFloat(Double.toString(funcion));
        return this.caudal;

    }
}
