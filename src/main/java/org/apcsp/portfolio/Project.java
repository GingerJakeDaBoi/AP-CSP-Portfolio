package org.apcsp.portfolio;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.Border;


public class Project extends JPanel {

    public static void main(String[] args) throws IOException {
        // Create and set up the window.
        JFrame ManagerWindow = new JFrame("Server Manager");
        ManagerWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set up the terminal button
        JButton termButton = new JButton("Terminal");
        termButton.setVisible(true);
        termButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Process process = Runtime.getRuntime().exec("gnome-terminal"); //TODO: Replace gnome-terminal with Windows CMD with the "cmd /c start cmd.exe /K" command, should probably change this later so that you can do it on both systems
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        //show the window and set up its properties
        ManagerWindow.add(new ServerPanel(), BorderLayout.CENTER);
        ManagerWindow.setResizable(false);
        ManagerWindow.pack();
        ManagerWindow.setVisible(true);

        //show the terminal button
        ManagerWindow.add(termButton,BorderLayout.NORTH);

    }
}