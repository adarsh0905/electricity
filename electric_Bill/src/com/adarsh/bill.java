package com.adarsh;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class bill extends JFrame{
    public bill(){
        setSize(700,400);
        setVisible(true);
        setLayout(null);
        setTitle("Electricity Bill Calculator");
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextField f = new JTextField("");
        f.setBounds(300,50,200,40);
        f.setHorizontalAlignment(SwingConstants.RIGHT);
        add(f);
        f.setBackground(Color.CYAN);
        JLabel l11 = new JLabel("Previous Reading");
        l11.setBounds(80,50,200,40);
        add(l11);
        l11.setBackground(Color.GREEN);
        String s[] = {"None","Kilo-Watt(Kw)","Watt(W)"};
        final JComboBox jc1 = new JComboBox<>(s);
        jc1.setBounds(520,50,130,40);
        add(jc1);
        jc1.setBackground(Color.GREEN);

        JTextField f1 = new JTextField("");
        f1.setBounds(300,100,200,40);
        add(f1);
        f1.setHorizontalAlignment(SwingConstants.RIGHT);
        f1.setBackground(Color.CYAN);
        JLabel l1 = new JLabel("Electricity Consumption");
        l1.setBounds(80,100,200,40);
        add(l1);
        l1.setBackground(Color.GREEN);
        final JComboBox jc = new JComboBox<>(s);
        jc.setBounds(520,100,130,40);
        add(jc);
        jc.setBackground(Color.GREEN);

        JLabel l3 = new JLabel("Cost Of 1 Unit");
        l3.setBounds(80,150,170,40);
        add(l3);
        l3.setBackground(Color.GREEN);

        Integer unitJCB[] = {0,1,2,3,4,5,6,7,8,9};
        final JComboBox jcb = new JComboBox<>(unitJCB);
        jcb.setBounds(300,150,200,40);
        add(jcb);
        jcb.setBackground(Color.GREEN);
        jcb.getEditor().toString().toUpperCase();

        JLabel f5 = new JLabel("Total Cost");
        f5.setBounds(220,250,190,40);
        add(f5);
        f5.setBackground(Color.GREEN);

        JButton b1 = new JButton("COMPUTE");
        b1.setBounds(250,200,100,40);
        add(b1);
        b1.setBackground(Color.YELLOW);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    float reading,result = 0;
                    float Consumption = Float.parseFloat(f1.getText());
                    float Previous = Float.parseFloat(f.getText());
                    Integer Unit = Integer.parseInt(String.valueOf(jcb.getSelectedItem()));
                    if(Consumption > Previous){
                        reading = Consumption - Previous;
                        result = reading * Unit;
                        f5.setText(String.valueOf(result));
                    }else{
                        f5.setText(String.valueOf("ReCheck The Values"));
                    }
                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                    f5.setText("Wrong Input");
                }
            }
        });
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                bill b = new bill();
            }
        });

    }
}
