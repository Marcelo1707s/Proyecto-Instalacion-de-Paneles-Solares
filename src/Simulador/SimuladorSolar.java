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

    public SimuladorSolar(Cliente cliente, PanelSolar panel, Inversor inversor) {
        this.cliente = cliente;
        this.panel = panel;
        this.inversor = inversor;
    }

    public void ejecutarSimulacion() {
        double energiaNecesaria = cliente.getConsumoMensual();
        double radiacion = 5.0;
        double temperatura = 25.0;
        double energiaPanel = panel.procesarEnergia(radiacion, temperatura);
        if (energiaPanel <= 0) {
            energiaPanel = 0.1;
        }
        this.cantidadPaneles = (int) Math.ceil(energiaNecesaria / energiaPanel);
        this.inversionTotal = cantidadPaneles * panel.getCosto() + inversor.getCosto();
        double energiaGenerada = energiaPanel * cantidadPaneles;
        double energiaAhorrada;
        if (energiaGenerada > energiaNecesaria) {
            energiaAhorrada = energiaNecesaria;
        } else {
            energiaAhorrada = energiaGenerada;
        }
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
}