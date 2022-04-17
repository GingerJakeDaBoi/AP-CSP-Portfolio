package org.apcsp.portfolio;

import java.awt.*;
import javax.swing.*;

public class Project {

    public static void main(String[] args) {
        // Create and set up the window.
        JFrame ManagerWindow = new JFrame("Server Manager");
        ManagerWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //System Resources text
        JLabel resources = new JLabel();
        resources.setText("System Resources");

        //Terminal text
        JLabel terminal = new JLabel();
        terminal.setText("Terminal");

        //Filesystem Text
        JLabel Filesystem = new JLabel();
        Filesystem.setText("Filesystem");

        ManagerWindow.add(new ServerPanel(),BorderLayout.CENTER);
        
        // Display the window.
        ManagerWindow.pack();
        ManagerWindow.setVisible(true);
    }
}