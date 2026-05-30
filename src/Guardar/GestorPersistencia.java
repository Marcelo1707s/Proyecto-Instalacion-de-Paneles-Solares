/* Gestor de persistencia para la simulacion solar.
 * Utiliza serializacion Java para guardar y cargar el objeto SimuladorSolar.
 */
package Guardar;

import Simulador.SimuladorSolar;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GestorPersistencia {

    public static void guardarProyecto(SimuladorSolar simulacion, String ruta) throws IOException {
        File archivo = new File(ruta);
        File carpeta = archivo.getParentFile();
        if (carpeta != null && !carpeta.exists()) {
            carpeta.mkdirs();
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(simulacion);
        }
    }

    public static SimuladorSolar cargarProyecto(String ruta) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
            return (SimuladorSolar) ois.readObject();
        }
    }
}