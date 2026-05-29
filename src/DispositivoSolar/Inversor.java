/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DispositivoSolar;

public class Inversor extends DispositivoSolar {
     private double costo;

    public Inversor(String nombre, double eficiencia, double costo) {
        super(nombre, eficiencia);
        this.costo = costo;
    }

    @Override
    public double procesarEnergia(double entrada, double temperatura) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
}