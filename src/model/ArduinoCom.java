package model;

import java.util.concurrent.CountDownLatch;
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
    
    private static final CountDownLatch countDownLatch = new CountDownLatch(5);
    private SerialPort sp;
    private LecturaSerial sensor;

    public String ArduinoCom() {
        String a;
        if (!"".equals(puerto())) {
            this.sp = new SerialPort(puerto());
            countDownLatch.countDown();
            a="Conectado en "+puerto();
        } else {
            a="Ningún puerto en uso";
        }
        return a;
    }

    private String lecturaSensor() {
        conectar();
        countDownLatch.countDown();
        return this.sensor.getMsg();
    }

    private String puerto() {
        String puerto[] = SerialPortList.getPortNames();
        String a = "";

        for (String n : puerto) {
            System.out.println(n);
            a = a + n;
        }
        return a;
    }

    private void escribirPuerto(int num) {
        conectar();
        try {
            sp.writeInt(num); // temperatura
            Thread.sleep(3000);
        } catch (SerialPortException ex) {
            System.out.print("Error con el puerto (escritura)");
        } catch (InterruptedException ex) {
            System.out.print("Error con el tiempo de espera");
            //Logger.getLogger(ArduinoCom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String conectar() {

        if (this.sp.isOpened()) {
            this.sensor = new LecturaSerial(this.sp);
        } else {
            try {
                //abrir puerto
                this.sp.openPort();

                //parámetros del puerto
                this.sp.setParams(
                        SerialPort.BAUDRATE_115200,
                        SerialPort.DATABITS_8,
                        SerialPort.STOPBITS_1,
                        SerialPort.PARITY_NONE
                );

                this.sp.addEventListener(sensor,
                        SerialPort.MASK_RXCHAR
                );

                this.sensor = new LecturaSerial(this.sp);

                Thread.sleep(3000);

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
        countDownLatch.countDown();
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
            this.msg = sp.readString();
            //imprimir mensaje de arduino SerialPort
            //System.out.println("Temperatura actual: " + msg); 
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Error en lectura");
            //e.printStackTrace();
        }
    }

    public String getMsg() {
        return this.msg;
    }
}
