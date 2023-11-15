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
    private static final CountDownLatch countDownLatch = new CountDownLatch(5);
    private final ArduinoCom arduino;
    private final Estado estadoActual;
    private final Datos registrarDatos;
    private float pressure;

    public EstadoPlanta() throws InterruptedException, IOException {
        
        // Instanciar los objetos que vamos a usar
        this.arduino = new ArduinoCom();
        this.estadoActual = new Estado();
        this.registrarDatos = new Datos();

        while (true) {

            // Leer el ultimo mensaje del arduino
            float temperature = Float.parseFloat(this.arduino.obtenerValorSensor(1));
            //float caudal = Float.parseFloat(this.arduino.obtenerValorSensor(2));

            // Volverlo un float
            float press = obtenerPresion(temperature);

            // agregar atributos al objeto estadoActual
            this.estadoActual.settemperature(temperature);
            this.estadoActual.setPressure(press);
            //this.estadoActual.setcaudal(caudal);

            // guardarlos en la base de datos
            registrarDatos.elemadd(this.estadoActual.gettemperature(),
                    this.estadoActual.getPressure());
            countDownLatch.countDown();
            Thread.sleep(5000);
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
        this.pressure = Float.parseFloat(Double.toHexString(funcion));

        return this.pressure;
    }
}
