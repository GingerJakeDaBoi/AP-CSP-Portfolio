package org.apcsp.portfolio;

import java.awt.*;
import javax.swing.*;

// This class is used to open the JFrame, that's it.
public class Project {

    public static void main(String[] args) {
        // Create and set up the window.
        JFrame ManagerWindow = new JFrame("Server Manager");
        ManagerWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ManagerWindow.add(new ServerPanel(),BorderLayout.CENTER);
        
        // Display the window.
        ManagerWindow.setResizable(false);
        ManagerWindow.pack();
        ManagerWindow.setVisible(true);
    }
}