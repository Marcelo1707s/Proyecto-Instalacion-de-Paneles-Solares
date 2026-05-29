/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DispositivoSolar;
import java.io.Serializable;

public class Cliente implements Serializable {
    private String nombre;
    private double consumoMensual; 
    private double tarifaElectrica; 
    private double areaDisponible; 
    private double presupuesto;    
    private ZonaGeografica ubicacion; 

    public Cliente(String nombre, double consumoMensual, double tarifaElectrica, double areaDisponible, double presupuesto, ZonaGeografica ubicacion) {
        this.nombre = nombre;
        this.consumoMensual = consumoMensual;
        this.tarifaElectrica = tarifaElectrica;
        this.areaDisponible = areaDisponible;
        this.presupuesto = presupuesto;
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getConsumoMensual() {
        return consumoMensual;
    }
    public void setConsumoMensual(double consumoMensual) {
        this.consumoMensual = consumoMensual;
    }
    public double getTarifaElectrica() {
        return tarifaElectrica;
    }
    public void setTarifaElectrica(double tarifaElectrica) {
        this.tarifaElectrica = tarifaElectrica;
    }
    public double getAreaDisponible() {
        return areaDisponible;
    }
    public void setAreaDisponible(double areaDisponible) {
        this.areaDisponible = areaDisponible;
    }
    public double getPresupuesto() {
        return presupuesto;
    }
    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }
    public ZonaGeografica getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(ZonaGeografica ubicacion) {
        this.ubicacion = ubicacion;
    }
    
}