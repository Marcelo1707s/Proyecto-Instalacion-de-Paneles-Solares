/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import DispositivoSolar.Cliente;
import DispositivoSolar.Inversor;
import DispositivoSolar.PanelMonocristalino;
import DispositivoSolar.PanelSolar;
import DispositivoSolar.ZonaGeografica;
import Excepciones.DatoInvalidoException;
import Guardar.GestorPersistencia;
import Simulador.SimuladorSolar;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Prueba");

        try {
           
            ZonaGeografica zona = new ZonaGeografica("Asuncion", "Paraguay", 5.2, 28.0);
            System.out.println("1. Zona Geografica: " + zona.getNombreCiudad() + ", " + zona.getPais());

           
            Cliente cliente = new Cliente(
                "Raul Mesa", 
                450.0,  
                0.15,   
                50.0,   
                3000.0, 
                zona
            );
            System.out.println("2. Cliente: " + cliente.getNombre());

            PanelSolar panel = new PanelMonocristalino("EcoGreen 450W", 0.20, 450.0, 2.1, 150.0);
            Inversor inversor = new Inversor("SunnyBoy 3000", 0.96, 800.0);
            
            System.out.println("3. Panel creado: " + panel.getNombre() + " (Potencia: " + panel.getPotenciaWp() + "Wp)");
            System.out.println("4. Inversor creado: " + inversor.getNombre() + " (Eficiencia: " + (inversor.getEficiencia() * 100) + "%)");
         
            SimuladorSolar simulador = new SimuladorSolar(cliente, panel, inversor);
            simulador.ejecutarSimulacion();
            System.out.println("5. Simulacion de datos");
            System.out.println("   - Paneles recomendados: " + simulador.getCantidadPaneles());
            System.out.println("   - Inversion Total: " + simulador.getInversionTotal() + " USD");
            System.out.println("   - Ahorro Mensual: " + simulador.getAhorroMensual() + " USD");
            System.out.println("   - Retorno estimado: " + String.format("%.2f", simulador.getRoiAnos()) + " anhos");

            
            String archivoPrueba = "proyecto_progreso.dat";
            System.out.println("6. Guardando proyecto en " + archivoPrueba + "...");
            GestorPersistencia.guardarProyecto(simulador, archivoPrueba);
            System.out.println("   Proyecto guardado");

            System.out.println("7. Cargando proyecto desde " + archivoPrueba + "...");
            SimuladorSolar simuladorCargado = GestorPersistencia.cargarProyecto(archivoPrueba);
            System.out.println("   Proyecto cargado");
            System.out.println("   - Cliente cargado: " + simuladorCargado.getCliente().getNombre());
            System.out.println("   - Paneles cargados: " + simuladorCargado.getCantidadPaneles());
            System.out.println("   - Inversion total cargada: " + simuladorCargado.getInversionTotal() + " USD");
        try {
            Cliente clienteInvalido = new Cliente(
                "Luis Duarte",
                -100.0,  
                0.20,
                30.0,
                1500.0,
                zona
            );
            System.out.println("Cliente invalido creado inesperadamente: " + clienteInvalido.getNombre());
        } catch (DatoInvalidoException e) {
            System.out.println("Capturada excepcion para datos invalidos: " + e.getMessage());
        }


        } catch (DatoInvalidoException e) {
            System.err.println("Error de datos: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de lectura/escritura de archivo: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Error al reconstruir la clase cargada: " + e.getMessage());
        }
    }
}
