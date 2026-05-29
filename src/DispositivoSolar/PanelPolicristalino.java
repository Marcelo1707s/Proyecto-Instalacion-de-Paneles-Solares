/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DispositivoSolar;

public class PanelPolicristalino extends PanelSolar {

    public PanelPolicristalino(String nombre, double eficiencia, double potenciaWp, double area, double costo) {
        super(nombre, eficiencia, potenciaWp, area, costo);
    }

    @Override
    public double procesarEnergia(double entrada, double temperatura) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}