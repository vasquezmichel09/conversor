
package conversor;


public class Conversor {

 
    public static void main(String[] args) {
       
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);
        
        ConversorDeTemperatura cp = new ConversorDeTemperatura();
        cp.setVisible(false);
    }
    
}
