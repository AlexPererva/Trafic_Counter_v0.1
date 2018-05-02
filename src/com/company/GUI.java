package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {
    private JButton button = new JButton("СЧИТАТЬ СУММУ");
   // private JTextField general = new JTextField("");
    private JTextField dails = new JTextField("");
    private JTextField night = new JTextField("");
   // private JLabel labelgeneral = new JLabel("Введите значение - ОБЩЕЕ");
    private JLabel labeldails = new JLabel("Введите значение - ДЕНЬ");
    private JLabel labelnight = new JLabel("Введите значение - НОЧЬ");
    private JLabel labelall = new JLabel("Text");

    public GUI () {

        super("TraficCounter");
        this.setBounds(100,200,350,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(5,1,2,2));
       // container.add(labelgeneral);
       // container.add(general);
        container.add(labeldails);
        container.add(dails);
        container.add(labelnight);
        container.add(night);
        button.addActionListener(new ButtonEventListener());
        container.add(button);

    }


    class ButtonEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String message = "Сумма к оплате: "+"\n";
            double sp = (100*0.90);
            double d = Integer.parseInt(dails.getText());
            double dp = ((d-100)*1.68);
            double n = Integer.parseInt(night.getText());
            double np = (n*(1.68/2));
            double ap = (sp+dp+np);
            message += ("Оплата за дневной расход: "+(dp+sp)+"\n");
            message += ("Оплата за ночной расход: "+np+"\n");
            message += ("Общая сумма оплаты: "+ ap);
            JOptionPane.showMessageDialog(null, message, "Выписка", JOptionPane.PLAIN_MESSAGE);

        }
    }
}
