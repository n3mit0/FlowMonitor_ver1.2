package model;

import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

/**
 *
 * @author julie
 */
public class ArduinoCom {

    SerialPort sp;
    LecturaSerial sensor;

    public String lecturaSensor() {
        conectar();
        try {
            sp.closePort();
        } catch (SerialPortException ex) {
            Logger.getLogger(ArduinoCom.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.sensor.getMsg();
    }

    private void conectar() {
        this.sp = new SerialPort("COM3");
        this.sensor = new LecturaSerial(sp);

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
            Logger.getLogger(ArduinoCom.class.getName()).log(
                    Level.SEVERE,
                    null,
                    ex
            );
        } catch (InterruptedException ex) {
            Logger.getLogger(ArduinoCom.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            this.msg = sp.readString(5);
            //imprimir mensaje de arduino SerialPort
            //System.out.println("Temperatura actual: " + msg); 
            Thread.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getMsg() {
        return this.msg;
    }
}
