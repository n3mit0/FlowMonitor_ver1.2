package modelView;

import model.Datos;
import java.io.IOException;
import model.ArduinoCom;

/**
 *
 * @author julie
 */
public class EstadoPlanta {

    private final ArduinoCom arduino;
    private final Estado estadoActual;
    private final Datos registrarDatos;
    private float pressure;
    private String lastMsgFromArduino = "";

    public EstadoPlanta() throws InterruptedException, IOException {
        // Instanciar los objetos que vamos a usar
        this.arduino = new ArduinoCom();
        this.estadoActual = new Estado();
        this.registrarDatos = new Datos();

        // Leer el ultimo mensaje del arduino
        this.lastMsgFromArduino = this.arduino.lecturaSensor();

        // Volverlo un float
        float temperature = Float.parseFloat(lastMsgFromArduino);
        float press = obtenerPresion(temperature);

        // agregar atributos al objeto estadoActual
        this.estadoActual.settemperature(temperature);
        this.estadoActual.setPressure(press);

        // guardarlos en la base de datos
        registrarDatos.elemadd(this.estadoActual.gettemperature(), this.estadoActual.getPressure());

    }

    public Float temperaturaActual() {
        return this.estadoActual.gettemperature();
    }
    
    public Float presionActual(){
        return this.estadoActual.getPressure();
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
