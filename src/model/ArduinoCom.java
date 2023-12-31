package model;

import java.util.concurrent.CountDownLatch;
import javax.swing.JOptionPane;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import jssc.SerialPortList;

public class ArduinoCom {
    
    private static final CountDownLatch countDownLatch = new CountDownLatch(5);
    private SerialPort sp;
    private LecturaSerial sensor;
    private static String valorSensor;

    public String conexionpuerto() {
        String a;
        if (!"".equals(puerto())) {
            this.sp = new SerialPort(puerto());
            conectar();
            a = "Se conectó en: " + puerto();
        } else {
            a = "Ningún puerto en uso";
        }
        return a;
    }

    private String lecturaSensor() {
        String a = "sensor null";
        if (this.sensor.equals(null)) {
            JOptionPane.showMessageDialog(null, "no hay lectura serial");
        } else {
            a = this.sensor.getMsg();
        }
        return a;
    }

    public String verificarpuerto() {
        String a = "";
        
        if (this.sp.equals("") || this.sp == null) {
            try {
                Thread.sleep(200);
            } catch (Exception e) {
            }
            JOptionPane.showMessageDialog(null, "No conectado");
            a = "No conectado";
        } else {
            a = "Puerto en uso: " + this.sp;
        }
        return a;
    }

    private String puerto() {
        String puerto[] = SerialPortList.getPortNames();
        String a = "";
        for (String n : puerto) {
            a = a + n;
        }
        return a;
    }

    private void escribirPuerto(String num) {
        conectar();

        try {
            sp.writeString(num); // temperatura
            Thread.sleep(7000);
        } catch (SerialPortException ex) {
            System.out.print("Error con el puerto (escritura)");
        } catch (InterruptedException ex) {
            System.out.print("Error con el tiempo de espera");
            //Logger.getLogger(ArduinoCom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void openPort() {
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

            Thread.sleep(200);

        } catch (SerialPortException ex) {
            System.out.println("excepcion en la conexion con el puerto");
        } catch (InterruptedException ex) {
            System.out.println("Interrumpción en la conexión");
            //Logger.getLogger(ArduinoCom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String conectar() {

        if (this.sp.isOpened()) {

            try {
                /*this.sensor = new LecturaSerial(this.sp);
                this.sp.addEventListener(this.sensor,
                SerialPort.MASK_RXCHAR
                );*/
                Thread.sleep(200);
                /* } catch (SerialPortException ex) {
                System.out.println("(metodo conectar arduinoCom)1");
                //Logger.getLogger(ArduinoCom.class.getName()).log(Level.SEVERE, null, ex);
                 */}catch (InterruptedException ex) {
                System.out.println("(espera arduinoCom)");
                //Logger.getLogger(ArduinoCom.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            try {

                openPort();
                Thread.sleep(200);
                this.sensor = new LecturaSerial(this.sp);

                this.sp.addEventListener(sensor,
                        SerialPort.MASK_RXCHAR
                );

                Thread.sleep(200);

            } catch (SerialPortException ex) {
                System.out.println("No se pudo conectar con el puerto");
            } catch (InterruptedException ex) {
                System.out.println("Interrumpción en la conexión");
                //Logger.getLogger(ArduinoCom.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return "Conexión exitosa";
    }

    public static void setMsg(String num) {
        ArduinoCom.valorSensor = num;
    }

    public String obtenerValorSensor(String num) {
        escribirPuerto(num);
        countDownLatch.countDown();
        //String a = lecturaSensor();
        String a = ArduinoCom.valorSensor;
        countDownLatch.countDown();
        //System.out.print(a);
        return a;
    }
}

class LecturaSerial implements SerialPortEventListener {

    private String msg;
    private SerialPort sp;

    public LecturaSerial(SerialPort a) {
        this.msg = "";
        this.sp = a;
    }

    @Override
    public void serialEvent(SerialPortEvent spe) {
        
        try {
            //leer mensaje en Arduino SerialPort
            this.msg = sp.readString() + "";
            Thread.sleep(3000);
            if (this.msg!=null){
                ArduinoCom.setMsg(msg);
            }
            //System.out.print(msg);
            //sp.removeEventListener();
        } catch (Exception e) {
            System.out.println("Error en lectura");
            //e.printStackTrace();
        }
    }

    public String getMsg() {
        return this.msg;
    }
}
