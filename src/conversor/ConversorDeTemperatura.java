package conversor;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ConversorDeTemperatura extends JFrame implements ActionListener {

    Dimension d = new Dimension(350, 400);
    JLabel titulo = new JLabel("La conversión de temperatura calcula la temperatura ");
    JLabel titulo2 = new JLabel("del cero absoluto o superior.");
    JLabel celcius = new JLabel("Celcius:");
    JTextField txtcelcius = new JTextField();
    JLabel Fahrenheit = new JLabel("Fahrenheit:");
    JTextField txtFahrenheit = new JTextField();
    JLabel Kelvin = new JLabel("Kelvin:");
    JTextField txtKelvin = new JTextField();
    JLabel Rankine = new JLabel("Rankine:");
    JTextField txtRankine = new JTextField();
    JButton convertir = new JButton("Convertir");
    JButton limpiar = new JButton("Limpiar");
    JComboBox combo = new JComboBox();
    JTextField txtingresa = new  JTextField();
    
            
    public ConversorDeTemperatura() {
        

        Container con = this.getContentPane();
        con.setLayout(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(d);
        this.setTitle("Conversor de temperatura");
        this.setLocationRelativeTo(null);

        titulo.setBounds(15, 10, 310, 20);
        con.add(titulo);
        titulo2.setBounds(15, 30, 310, 20);
        con.add(titulo2);
        
        txtingresa.setBounds(150, 120, 180, 20);
        con.add(txtingresa);

        celcius.setBounds(15, 70, 310, 20);
        con.add(celcius);
        txtcelcius.setBounds(15, 90, 130, 20);
        con.add(txtcelcius);
        txtcelcius.setEnabled(false);
        Fahrenheit.setBounds(15, 120, 310, 20);
        con.add(Fahrenheit);
        txtFahrenheit.setBounds(15, 140, 130, 20);
        con.add(txtFahrenheit);
        txtFahrenheit.setEnabled(false);
        Kelvin.setBounds(15, 170, 310, 20);
        con.add(Kelvin);
        txtKelvin.setBounds(15, 190, 130, 20);
        con.add(txtKelvin);
        txtKelvin.setEnabled(false);
        Rankine.setBounds(15, 220, 310, 20);
        con.add(Rankine);
        txtRankine.setBounds(15, 240, 130, 20);
        con.add(txtRankine);
        txtRankine.setEnabled(false);
        
        combo.setBounds(150, 90, 180, 20);
        combo.addItem("De Celcius");
        combo.addItem("De Kelvin");
        combo.addItem("De Fahrenheit");
        combo.addItem("De Rankine");
        con.add(combo);

        convertir.setBounds(100, 280, 100, 20);
        con.add(convertir);
        convertir.addActionListener(this);
        limpiar.setBounds(100, 310, 100, 20);
        con.add(limpiar);
        limpiar.addActionListener(this);
        
        solonum(txtingresa);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertir) {
           conversion();
        }
        if (e.getSource() == limpiar) {
            limpiar();
        }
     
    }
    
    public void conversion(){
        String opcion = combo.getSelectedItem().toString();
        
        switch (opcion){
            case "De Celcius":
                Celcius();
                break;
            case "De Fahrenheit":
                Faren();
                break;
            case "De Kelvin":
                kelvin();
                break;
            case "De Rankine":
                rankine();
                break;
            case "":
              limpiar();
                break;
        }
    }

    public void Celcius() {

        //C° a F°
        String ingresa = txtingresa.getText();
        double numero = Double.parseDouble(ingresa);
        double conversioncf = numero * 9 / 5 + 32;
        String res = Double.toString(conversioncf);
        txtFahrenheit.setText(res);
        //C° a K°       
        double conversionck = numero + 273.15;
        res = Double.toString(conversionck);
        txtKelvin.setText(res);

        // F° a C°
        ingresa = txtFahrenheit.getText();
        numero = Double.parseDouble(ingresa);
        double conversionfc = (numero - 32) * 5 / 9;
        res = Double.toString(conversionfc);
        txtcelcius.setText(res);
        //F° a K°
        double conversionfk = (numero + 459.67) * 5 / 9;
        res = Double.toString(conversionfk);
        txtKelvin.setText(res);
        //F a R°      
        double conversionfr = numero + 459.67;
        res = Double.toString(conversionfr);
        txtRankine.setText(res);

    }

    public void Faren() {

        //F° a C°
        String ingresa = txtingresa.getText();
        double numero = Double.parseDouble(ingresa);
        double conversioncf = (numero - 32)* 5/9;
        String res = Double.toString(conversioncf);
        txtcelcius.setText(res);

        //F° a K°
        double conversionfk = (numero + 459.67) * 5 / 9;
        res = Double.toString(conversionfk);
        txtKelvin.setText(res);
        
        //F a R°      
        double conversionfr = numero + 459.67;
        res = Double.toString(conversionfr);
        txtRankine.setText(res);
        
        txtFahrenheit.setText(ingresa);

    }
    
    public void kelvin(){
        
        //°K a C°
        String ingresa = txtingresa.getText();
        double numero = Double.parseDouble(ingresa);
        double conversionkc = numero - 273.15;
        String res = Double.toString(conversionkc);
        txtcelcius.setText(res);
       
        //°K a F° 
        double conversionkf = (numero - 273.15)*9/5+32;
        res = Double.toString(conversionkf);
        txtFahrenheit.setText(res);
        
        //°K a R
        
        double conversionkr = numero * 9/5;
        res = Double.toString(conversionkr);
        txtRankine.setText(res);
        
        txtKelvin.setText(ingresa);    
        
    }
    
    public void rankine(){
        //°R a C°
        String ingresa = txtingresa.getText();
        double numero = Double.parseDouble(ingresa);
        double conversionrc = (numero - 491.67)*5/9;
        String res = Double.toString(conversionrc);
        txtcelcius.setText(res);
       
        //°R a F° 
        double conversionrf = numero - 459.67 ;
        res = Double.toString(conversionrf);
        txtFahrenheit.setText(res);
        
        //R a K
        
        double conversionrk = numero * 5/9;
        res = Double.toString(conversionrk);
        txtKelvin.setText(res);
        
        txtRankine.setText(ingresa); 
    }
    
    public void limpiar(){
        txtFahrenheit.setText("");
        txtKelvin.setText("");
        txtRankine.setText("");
        txtcelcius.setText("");
        txtingresa.setText("");
        
        
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
