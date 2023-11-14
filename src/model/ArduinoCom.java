package model;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import jssc.SerialPortList;

/**
 *
 * @author julie
 */
public class ArduinoCom {

    SerialPort sp;
    LecturaSerial sensor;

    public ArduinoCom() {
        this.sp = new SerialPort("COM3");
        conectar();
    }

    private String lecturaSensor() {
        return this.sensor.getMsg();
    }

    public String puerto() {
        String puerto[] = SerialPortList.getPortNames();
        String a = "";

        for (String n : puerto) {
            System.out.println(n);
            a = a + n;
        }
        return a;
    }

    private void escribirPuerto(int num) {
        try {
            sp.writeInt(num); // temperatura
        } catch (SerialPortException ex) {
            System.out.print("Error con el puerto");
        }
    }

    private String conectar() {

        if (this.sp.isOpened()) {
            this.sensor = new LecturaSerial(sp);
        } else {
            try {
                //abrir puerto
                sp.openPort();

                //parámetros del puerto
                sp.setParams(
                        SerialPort.BAUDRATE_115200,
                        SerialPort.DATABITS_8,
                        SerialPort.STOPBITS_1,
                        SerialPort.PARITY_NONE
                );

                sp.addEventListener(sensor,
                        SerialPort.MASK_RXCHAR
                );

                Thread.sleep(2000);

            } catch (SerialPortException ex) {
                System.out.println("No se pudo conectar con el puerto");
            } catch (InterruptedException ex) {
                System.out.println("Interrumpción en la conexión");
                //Logger.getLogger(ArduinoCom.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return "Conexión exitosa";
    }

    public String obtenerValorSensor(int num) {
        escribirPuerto(num);
        return lecturaSensor();
    }
}

class LecturaSerial implements SerialPortEventListener {

    private String msg;
    private SerialPort sp;

    public LecturaSerial(SerialPort sp) {
        this.msg = "";
        this.sp = sp;
    }

    @Override
    public void serialEvent(SerialPortEvent spe) {
        try {
            //leer mensaje en Arduino SerialPort
            this.msg = sp.readString(12);
            //imprimir mensaje de arduino SerialPort
            //System.out.println("Temperatura actual: " + msg); 
            Thread.sleep(200);
        } catch (Exception e) {
            System.out.println("Error en lectura");
            //e.printStackTrace();
        }
    }

    public String getMsg() {
        return this.msg;
    }
}
