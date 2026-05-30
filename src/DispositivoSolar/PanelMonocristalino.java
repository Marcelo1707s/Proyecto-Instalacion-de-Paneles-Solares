/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DispositivoSolar;

public class PanelMonocristalino extends PanelSolar {

    public PanelMonocristalino(String nombre, double eficiencia, double potenciaWp, double area, double costo) {
        super(nombre, eficiencia, potenciaWp, area, costo);
    }

    @Override
    public double procesarEnergia(double radiacionSolar, double temperaturaAmbiente) {
       
        double tPanel = temperaturaAmbiente + 25;
        double coefTemperatura = -0.0035;

        double eficienciaReal = this.getEficiencia() * (1 + coefTemperatura * (tPanel - 25));
       
        return (this.getPotenciaWp() / 1000.0) * radiacionSolar * 30.0 * (eficienciaReal / this.getEficiencia());
    }

   
}