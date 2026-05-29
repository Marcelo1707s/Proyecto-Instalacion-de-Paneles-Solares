/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DispositivoSolar;

/**
 *
 * @author Usuario
 */
public abstract class DispositivoSolar {
    private String nombre;
    private double eficiencia;

    public DispositivoSolar(String nombre, double eficiencia) {
        this.nombre = nombre;
        this.eficiencia = eficiencia;
    }
    public abstract double procesarEnergia(double entrada, double temperatura);

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getEficiencia() {
        return eficiencia;
    }
    public void setEficiencia(double eficiencia) {
        this.eficiencia = eficiencia;
    }
    
     
}
