package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelView.EstadoPlanta;

/**
 *
 * @author julie
 */
public class Datos {

    private static LinkedHashMap<Float, Float> tempre;
    //private static final HashMap<Float, Float> caupre = new HashMap<>();
    private static final CountDownLatch countDownLatch = new CountDownLatch(1);
    private LinkedHashMap<Float, Float> tabla;
    public ArrayList<String> presion;
    public ArrayList<String> temperatura;
    private EstadoPlanta estado;
    private float temp;
    private float press;
    private float value;

    public Datos() throws IOException {
        this.temp = 0f;
        this.press = 0f;
        this.value = 0f;
        this.tempre = new LinkedHashMap<>();
    }

    public float buscar(float temperatura) {
        // Recuperar el datos desde el archivo
        this.tabla = new LinkedHashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(
                "C:\\Users\\julie\\OneDrive\\Documentos\\doc_uni\\"
                + "Programación\\Prog java\\FlowMonitor\\"
                + "PresionTemp.txt\\"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length == 2) {
                    float clave = Float.parseFloat(partes[0]);
                    float valor = Float.parseFloat(partes[1]);
                    this.tabla.put(clave, valor);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (this.tabla.containsKey(temperatura)) {
            value = this.tabla.get(temperatura);
        } else {
            int num = (int) temperatura;
            value = this.tabla.get(num);
        }

        return value;
    }

    public String elemadd(float sensor, float funcion) throws IOException {

        if (sensor != 0.0) {

            this.temp = sensor;
            this.press = funcion;
            tempre.put(this.temp, this.press);
            elemsave();
        } else {
            elemsave();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Datos.class.getName()).log(
                    Level.SEVERE, null, ex);
        }

        return "Registro guardado";

    }

    public void elemsave() throws IOException {

        // Para guardar datos de presion y temperatura en un archivo en modo append
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(
                "PresionTemp.txt", true))) {

            int fil = tempre.size(); // Número de filas

            for (int i = 0; i < fil; i++) {
                tempre.entrySet().forEach(entry -> {
                    Float press = entry.getKey();
                    Float temp = entry.getValue();

                    try {
                        writer.write(press + ":" + temp); // Tabulador para separar los elementos
                        writer.newLine(); // Nueva línea para separar las filas
                    } catch (IOException ex) {
                        Logger.getLogger(Datos.class.getName()).log(
                                Level.SEVERE, null, ex);
                    }
                });
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        countDownLatch.countDown();

        try {
            countDownLatch.await();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        //System.out.println("Registro guardado");

    }

    private void historial() throws FileNotFoundException, IOException {

        // Recuperar el datos desde el archivo
        this.tabla = new LinkedHashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(
                "C:\\Users\\julie\\OneDrive\\Documentos\\doc_uni\\"
                + "Programación\\Prog java\\MonitoreoPlanta\\"
                + "FlowMonitor\\PresionTemp.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length == 2) {
                    float clave = Float.parseFloat(partes[0]);
                    float valor = Float.parseFloat(partes[1]);
                    this.tabla.put(clave, valor);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Imprimir tabla
        System.out.println("Presión  |  Temperatura");

        this.tabla.entrySet().forEach(entry -> {
            Float temp = entry.getKey();
            Float press = entry.getValue();

            System.out.println(press + "    =      " + temp);

        });
    }

    public void tablaHistorial() throws IOException {
        this.presion = new ArrayList();
        this.temperatura = new ArrayList();

        historial();

        this.tabla.entrySet().forEach(entry -> {
            Float temp = entry.getKey();
            Float press = entry.getValue();

            this.presion.add(Float.toString(press));
            this.temperatura.add(Float.toString(temp));

        });

    }

}
