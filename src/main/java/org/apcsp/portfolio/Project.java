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
        resources.setText("System Resources");        ManagerWindow.getContentPane().add(resources, BorderLayout.CENTER);

        //Terminal text
        JLabel terminal = new JLabel();
        terminal.setText("Terminal");
        ManagerWindow.getContentPane().add(terminal,BorderLayout.NORTH);

        //Filesystem Text
        JLabel Filesystem = new JLabel();
        Filesystem.setText("Filesystem");
        ManagerWindow.getContentPane().add(Filesystem,BorderLayout.SOUTH);

        //Set the sizes of the tabs
        resources.setPreferredSize(new Dimension(800, 300));
        terminal.setPreferredSize(new Dimension(800,300));
        Filesystem.setPreferredSize(new Dimension(800,300));
        
        // Display the window.
        ManagerWindow.pack();
        ManagerWindow.setVisible(true);
    }
}