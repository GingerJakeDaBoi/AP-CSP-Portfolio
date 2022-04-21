package org.apcsp.portfolio;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class Project {

    public static void main(String[] args) throws IOException {
        // Create and set up the window.
        JFrame ManagerWindow = new JFrame("Server Manager");
        ManagerWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a button for the terminal

        JButton termButton = new JButton("Terminal");
        termButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Process process = Runtime.getRuntime().exec("cmd /c start cmd.exe /K");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        ManagerWindow.add(new ServerPanel(),BorderLayout.CENTER);


        // Display the window.
        ManagerWindow.setResizable(false);
        ManagerWindow.pack();
        ManagerWindow.setVisible(true);
        ManagerWindow.add(new JButton("Terminal"),BorderLayout.NORTH);
    }
}