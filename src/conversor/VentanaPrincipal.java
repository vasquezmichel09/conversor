package conversor;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaPrincipal extends JFrame implements ActionListener {
    
    Dimension d = new Dimension(350, 200);
    
    JComboBox combo = new JComboBox();
    JLabel tipoDeConversion = new JLabel();
    JButton btnAceptar = new JButton();

    
    
    public VentanaPrincipal() {
        
        Container con = this.getContentPane();
        con.setLayout(null);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(d);
        this.setTitle("Conversor");
        this.setLocationRelativeTo(null);
        
        tipoDeConversion.setText("Seleccione el tipo de conversion que desea realizar");
        tipoDeConversion.setBounds(5, 10, 310, 20);
        con.add(tipoDeConversion);

        btnAceptar.setText("Aceptar");
        btnAceptar.setBounds(95, 95, 130, 20);
        con.add(btnAceptar);
        btnAceptar.addActionListener(this);
        
        combo.setBounds(75, 40, 180, 20);
        combo.addItem("Conversor de moneda");
        combo.addItem("Conversor de temperatura");
        con.add(combo);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAceptar) {
            
            String opcion = combo.getSelectedItem().toString();
            
            if (opcion.equals("Conversor de moneda")) {
                dispose();
                ConversorDeMoneda conversordemoneda = new ConversorDeMoneda();
                conversordemoneda.setVisible(true);
            } else if (opcion.equals("Conversor de temperatura")) {
                ConversorDeTemperatura conversordetemperatura = new ConversorDeTemperatura();
                conversordetemperatura.setVisible(true);
            }
            
        }
    }
    
}
