package conversor;

import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ConversorDeMoneda extends JFrame implements ActionListener {

    Dimension d = new Dimension(350, 300);

    JLabel tipo = new JLabel();
    JLabel titulo = new JLabel();
    JComboBox combo = new JComboBox();
    JButton btnAceptar = new JButton();
    JButton regresarMenu = new JButton();
    JTextField txtingresa = new JTextField();
    JTextField txtimostrar = new JTextField();
    JLabel mensajeConversion = new JLabel();

    double dolar = 0.056;
    double euro = 0.052;
    double libra = 0.046;
    double yen = 7.57;
    double wonCoreano = 72.16;
    
    double dolarInv = 17.96;
    double euroInv = 19.09;
    double libraInv = 21.61;
    double yenInv = 0.13 ;
    double wonCoreanoInv = 0.014;
    

    public ConversorDeMoneda() {
        Container con = this.getContentPane();
        con.setLayout(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(d);
        this.setTitle("Conversor de moneda");
        this.setLocationRelativeTo(null);

        titulo.setText("La base del peso mexicano es al dia de 01/03/2023");
        titulo.setBounds(20, 10, 310, 20);
        con.add(titulo);

        tipo.setText("eliga la moneda a la que deseas convertir tu dinero: ");
        tipo.setBounds(20, 30, 310, 20);
        con.add(tipo);

        combo.setBounds(75, 60, 180, 20);
        combo.addItem("De pesos a Dolar");
        combo.addItem("De pesos a Euro");
        combo.addItem("De pesos a Libras");
        combo.addItem("De pesos a Yen");
        combo.addItem("De pesos a Won Coreano");
        combo.addItem("De Dolar a pesos");
        combo.addItem("De Euro a pesos");
        combo.addItem("De Libras a pesos");
        combo.addItem("De Yen a pesos");
        combo.addItem("De Won Coreano a pesos");
        con.add(combo);
        
        mensajeConversion.setText("Su conversión es:");
        mensajeConversion.setBounds(105, 126, 130, 20);
        con.add(mensajeConversion);

        txtingresa.setText("");
        txtingresa.setBounds(95, 106, 130, 20);
        con.add(txtingresa);
        
        txtimostrar.setText("");
        txtimostrar.setEnabled(false);
        txtimostrar.setBounds(55, 156, 230, 30);
        con.add(txtimostrar);

        btnAceptar.setText("Aceptar");
        btnAceptar.setBounds(85, 230, 150, 20);
        con.add(btnAceptar);
        btnAceptar.addActionListener(this);
        
        regresarMenu.setText("Regresar");
        regresarMenu.setBounds(243, 230, 88, 20);
        con.add(regresarMenu);
        regresarMenu.addActionListener(this);
        solonum(txtingresa);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnAceptar) {
            Conversion();
        }
        if (e.getSource() == regresarMenu) {
            dispose();
            VentanaPrincipal vp = new VentanaPrincipal();
            vp.setVisible(true);
        }
        
    }

    public void Conversion() {

        String opcion = combo.getSelectedItem().toString();
        String ingresa = txtingresa.getText();
        double numero = Double.parseDouble(ingresa);
        
        switch (opcion) {
            case "De pesos a Dolar":
                double conversion = numero * dolar;
                String res = Double.toString(conversion);
                txtimostrar.setText(res+ " dolares");
                txtingresa.setText("");
                break;
            case "De pesos a Euro":                
                conversion = numero * euro;
                res = Double.toString(conversion);
                txtimostrar.setText(res+ " euros");
                txtingresa.setText("");
                break;
            case "De pesos a Libras":
                conversion = numero * libra;
                res = Double.toString(conversion);
                txtimostrar.setText(res+ " libras");
                txtingresa.setText("");
                break;
            case "De pesos a Yen":
                conversion = numero * yen;
                res = Double.toString(conversion);
                txtimostrar.setText(res+ " Yenes");
                txtingresa.setText("");
                break;
            case "De pesos a Won Coreano":
                conversion = numero * wonCoreano;
                res = Double.toString(conversion);
                txtimostrar.setText(res+ " Wones Coreano");
                txtingresa.setText("");
                break;
            case "De Dolar a pesos":
                conversion = numero * dolarInv;
                res = Double.toString(conversion);
                txtimostrar.setText(res+ " pesos");
                txtingresa.setText("");
                break;
            case "De Euro a pesos":                
                conversion = numero * euroInv;
                res = Double.toString(conversion);
                txtimostrar.setText(res+ " pesos");
                txtingresa.setText("");
                break;
            case "De Libras a pesos":
                conversion = numero * libraInv;
                res = Double.toString(conversion);
                txtimostrar.setText(res+ " pesos");
                txtingresa.setText("");
                break;
            case "De Yen a pesos":
                conversion = numero * yenInv;
                res = Double.toString(conversion);
                txtimostrar.setText(res+ " pesos");
                txtingresa.setText("");
                break;
            case "De Won Coreano a pesos":
                conversion = numero * wonCoreanoInv;
                res = Double.toString(conversion);
                txtimostrar.setText(res+ " pesos");
                txtingresa.setText("");
                break;
        }
        
        

    }
    private void solonum(JTextField a){
        a.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(! Character.isDigit(c) && c!='.') {
                    e.consume();
                }
                if (c== '.' && txtingresa.getText().contains(".")) {
                    e.consume();
                }
            }
        });
    }

}
