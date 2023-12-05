# FlowMonitor

- Desarrollar un programa de java que permita dar seguimiento al estado de planta procesadora de miel de panela en flujo continuo
- Para la base de datos utilizamos un archivo de texto alojado en el dispositivo
- A continuación se encuentra una guía de instalación del programa y algunas recomendaciones


## Guía de instalación
<p> Se inicia con la descarga del archivo zip de este repositorio y, como acto seguido, se abre el proyecto con el programa NetBeans.
Dentro del paquete "model" y la clase "Datos" se tiene que modificar el url de ubicación del archivo donde se va a guardar el archivo txt de la base de datos.
Primero crea un archivo de texto dentro de la carpeta del programa titulado: "PresionTemp", y copia la dirección del mismo archivo para reemplazarla dentro de la clase "Datos".

Línea de código original en método "historial()":
</p>

```
try (BufferedReader reader = new BufferedReader(new FileReader(
                "C:\\Users\\julie\\OneDrive\\Documentos\\doc_uni\\"
                + "Programación\\Prog java\\MonitoreoPlanta\\"
                + "PresionTemp.txt\\"))) {
```
<p> En la línea anterior, se debe modificar la url de la dirección del archivo dentro de tu propio dispositivo. Específicamente el: "C:\\user...."
Ya dentro del método "tablaHistorial", el link url de la ubicación del archivo se cambiaría a partir del "FileProtocolHandler". Específicamente el: "C:\\user...."
</p>

```
Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "
                    + "C:\\Users\\julie\\OneDrive\\Documentos\\doc_uni\\"
                    + "Programación\\Prog java\\MonitoreoPlanta\\"
                    + "FlowMonitor\\PresionTemp.txt");
```
<p> Si se modifica el texto anterior, no ejecutaría el lanzador que abre el archivo de texto de la base de datos.

Finalmente, solo queda guardar los cambios y poner a correr la aplicación

</p>

#### Recomendaciones
- Para la lectura del arduino, se tiene que tener conectado el arduino a un puerto com, del dispositivo, que tenga envío y recepción de datos.
- Hablando ya del código del arduino, se tiene que importar la librería DHT11, para la correcta lectura del sensor de temperatura DHT11.
- Todo error correspondiente a la conexión con el arduino, se declara en una ventana emergente de aviso.
- Se recomienda, para dispositivos con más de un puerto de conexión disponible para emisión y recepción de datos, se conecte solamente el del arduino, para evitar errores de asignación de puertos dentro de la aplicación.

## Ejecutando el programa
<p>Cuando ejecutamos el programa, nos aparecerá el splashscreen con el logo de la aplicación y luego la pantalla de conexión, con la que se verifica si hay o no un puerto de conexión utilizado.
Luego, si no se detecta conexión, aparecerá un aviso "Sin conexión". Y se desactivarán los botones para obtener datos del arduino. Y únicamente se podrían consultar, historial y el último registro dentro de la base de datos.
En cambio, si se ha conectado correctamente el arduino, se podrá consultar la temperatura registrada por el arduino, la presión asociada a esta y la velocidad a la que gira el motor.
Además de la funcionalidad principal de monitorear el estado de la planta. Dentro del programa, se agregó una ventana de ayuda para que el usuario se pueda comunicar con los desarrolladores del programa y de la planta. Y una ventana "AboutUs" con información de la empresa dueña de la planta procesadora. Y medios de contacto.


</p>

###### Desarrollado por: Julieth Manuela Rojas Castro
###### e-mail: julrojasc@unal.edu.co
