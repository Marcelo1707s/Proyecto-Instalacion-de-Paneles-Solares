/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DispositivoSolar;

public abstract class PanelSolar extends DispositivoSolar {
    private double potenciaWp; 
    private double area;      
    private double costo;      

    public PanelSolar(String nombre, double eficiencia, double potenciaWp, double area, double costo) {
        super(nombre, eficiencia);
        this.potenciaWp = potenciaWp;
        this.area = area;
        this.costo = costo;
    }

    public double getPotenciaWp() {
        return potenciaWp;
    }
    public void setPotenciaWp(double potenciaWp) {
        this.potenciaWp = potenciaWp;
    }
    public double getArea() {
        return area;
    }
    public void setArea(double area) {
        this.area = area;
    }
    public double getCosto() {
        return costo;
    }
    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    
}