package com.dmoram.componentes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUI extends JFrame {
    JButton boton1 = new JButton("Papi te vas");
    JButton boton2 = new JButton("Papi te vienes");
    JLabel titulo = new JLabel("Conversor de moneda");

    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();

    JPanel p4 = new JPanel(new GridLayout(1,3));
    Font font = new Font("Arial", Font.PLAIN, 20);

    public GUI(){
        super("Conversor de monedas");
        setVisible(true);
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4,1));
        titulo.setFont(font);
        p1.add(titulo);

        JTextField textField = new JTextField(20);
        JComboBox<String> comboBox1 = new JComboBox<>(new String[]{"USD", "EUR", "GBP"}); // Ejemplo de monedas
        JComboBox<String> comboBox2 = new JComboBox<>(new String[]{"USD", "EUR", "GBP"}); // Ejemplo de monedas

        p2.add(textField);
        p2.add(comboBox1);
        p2.add(comboBox2);

        JButton convertButton = new JButton("Convertir");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar la lógica para convertir la moneda
                // Obtén el valor del TextField
                String inputValue = textField.getText();
                // Obtén las monedas seleccionadas en los JComboBox
                String currencyFrom = (String) comboBox1.getSelectedItem();
                String currencyTo = (String) comboBox2.getSelectedItem();
                // Realiza la conversión y muestra el resultado
                // (aquí se necesita la lógica de conversión real)
                // Por ahora, simplemente mostraremos el valor ingresado
                JOptionPane.showMessageDialog(GUI.this, "Valor ingresado: " + inputValue +
                        "\nMoneda origen: " + currencyFrom +
                        "\nMoneda destino: " + currencyTo);
            }
        });
        p3.add(convertButton);

        add(p1);
        add(p2);
        add(p3);
    }

}