package org.apcsp.portfolio;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.Border;

// This class is used to open the JFrame, that's it.
public class Project {

    public static void main(String[] args) throws IOException {
        // Create and set up the window.
        JFrame ManagerWindow = new JFrame("Server Manager");
        ManagerWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton termButton = new JButton("Terminal");
        termButton.setVisible(true);
        termButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Process process = Runtime.getRuntime().exec("cmd /c start cmd.exe /K");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        ManagerWindow.add(new ServerPanel(), BorderLayout.CENTER);
        // Display the window.
        ManagerWindow.setResizable(false);
        ManagerWindow.pack();
        ManagerWindow.setVisible(true);
        ManagerWindow.add(termButton,BorderLayout.NORTH);

    }
}