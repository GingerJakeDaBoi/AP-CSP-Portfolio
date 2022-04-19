package org.apcsp.portfolio;

import java.awt.*;
import javax.swing.*;

public class Project {

    public static void main(String[] args) {
        // Create and set up the window.
        JFrame ManagerWindow = new JFrame("Server Manager");
        ManagerWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a button for the terminal (breaks the UI currently)
        JButton termButt = new JButton("Terminal");

        ManagerWindow.add(new ServerPanel(),BorderLayout.CENTER);


        // Display the window.
        ManagerWindow.setResizable(false);
        ManagerWindow.pack();
        ManagerWindow.setVisible(true);
        ManagerWindow.add(new JButton("Terminal"),BorderLayout.NORTH);
    }
}