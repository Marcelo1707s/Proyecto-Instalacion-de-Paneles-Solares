/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Simulador;

import DispositivoSolar.Cliente;
import DispositivoSolar.Inversor;
import DispositivoSolar.PanelSolar;
import java.io.Serializable;

public class SimuladorSolar implements Serializable {
    private Cliente cliente;
    private PanelSolar panel;
    private Inversor inversor;
    private int cantidadPaneles;
    private double inversionTotal;
    private double ahorroMensual;
    private double roiAnos;
    private String observaciones;

    public SimuladorSolar(Cliente cliente, PanelSolar panel, Inversor inversor) {
        this.cliente = cliente;
        this.panel = panel;
        this.inversor = inversor;
    }

    public void ejecutarSimulacion() {
         double energiaNecesaria = cliente.getConsumoMensual();
        double radiacion = 5.0;
        double temperatura = 25.0;
        
        // 1. Cálculo Ideal
        double energiaPanel = panel.procesarEnergia(radiacion, temperatura);
        if (energiaPanel <= 0) energiaPanel = 0.1;
        this.cantidadPaneles = (int) Math.ceil(energiaNecesaria / energiaPanel);
        this.inversionTotal = (cantidadPaneles * panel.getCosto()) + inversor.getCosto();
        
        // 2. Generar una Evaluacion comparando el caso ideal vs los parametros ingresados por el cliente
         this.observaciones = ""; 
        
        // Análisis de Presupuesto
        double plataFaltante = this.inversionTotal - cliente.getPresupuesto();
        if (plataFaltante > 0) {
            double plataSobrante = cliente.getPresupuesto() - inversor.getCosto();
            int maxPanelesPlata = (plataSobrante > 0) ? (int)(plataSobrante / panel.getCosto()) : 0;
            
            this.observaciones += " PRESUPUESTO INSUFICIENTE:\n"
                               + "  - Le faltan " + String.format("%.2f", plataFaltante) + " USD.\n"
                               + "  - Con su presupuesto actual solo podría comprar " + maxPanelesPlata + " paneles.\n\n";
        }
        
        //  Análisis de Espacio 
        double areaNecesaria = this.cantidadPaneles * panel.getArea();
        double areaFaltante = areaNecesaria - cliente.getAreaDisponible();
        if (areaFaltante > 0) {
            int maxPanelesArea = (int)(cliente.getAreaDisponible() / panel.getArea());
            
            this.observaciones += "ESPACIO INSUFICIENTE:\n"
                               + "  - Le faltan " + String.format("%.2f", areaFaltante) + " m² en el techo.\n"
                               + "  - En su espacio actual solo caben físicamente " + maxPanelesArea + " paneles.\n\n";
        }
        
        //Si no hubo alertas 
        if (this.observaciones.isEmpty()) {
            this.observaciones = " PROYECTO VIABLE:\n"
                               + "Su presupuesto y espacio disponible cubren perfectamente la instalación de los " + this.cantidadPaneles + " paneles necesarios.";
        }
        
        // 3. Cálculos de ahorro basados en el sistema ideal
        double energiaGenerada = energiaPanel * cantidadPaneles;
        double energiaAhorrada = (energiaGenerada > energiaNecesaria) ? energiaNecesaria : energiaGenerada;
        this.ahorroMensual = energiaAhorrada * cliente.getTarifaElectrica();
        
        if (this.ahorroMensual > 0) {
            this.roiAnos = inversionTotal / (this.ahorroMensual * 12);
        } else {
            this.roiAnos = Double.POSITIVE_INFINITY;
        }
    }

    public int getCantidadPaneles() { return cantidadPaneles; }
    public double getInversionTotal() { return inversionTotal; }
    public double getAhorroMensual() { return ahorroMensual; }
    public double getRoiAnos() { return roiAnos; }
    public Cliente getCliente() { return cliente; }
    public PanelSolar getPanel() { return panel; }
    public Inversor getInversor() { return inversor; }
     public String getObservaciones() { return observaciones; }
}