/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DispositivoSolar;
import java.io.Serializable;

public class ZonaGeografica implements Serializable {
    private String nombreCiudad;
    private String pais;
    private double radiacionSolar;      
    private double temperaturaPromedio;  

    public ZonaGeografica(String nombreCiudad, String pais, double radiacionSolar, double temperaturaPromedio) {
        this.nombreCiudad = nombreCiudad;
        this.pais = pais;
        this.radiacionSolar = radiacionSolar;
        this.temperaturaPromedio = temperaturaPromedio;
    }
    public String getNombreCiudad() {
        return nombreCiudad;
    }
    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public double getRadiacionSolar() {
        return radiacionSolar;
    }
    public void setRadiacionSolar(double radiacionSolar) {
        this.radiacionSolar = radiacionSolar;
    }
    public double getTemperaturaPromedio() {
        return temperaturaPromedio;
    }
    public void setTemperaturaPromedio(double temperaturaPromedio) {
        this.temperaturaPromedio = temperaturaPromedio;
    }

    
}