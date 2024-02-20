package org.example;

import javax.swing.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Userview userview = new Userview();
        userview.setContentPane(userview.mainPanel);
        userview.setTitle("Chitengu-Danai_Prodigy_Task-03");
        userview.setSize(500,350);
        userview.setVisible(true);
        userview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}