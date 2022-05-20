package org.apcsp.portfolio;

import javax.swing.*;
import java.awt.*;

public class Project {

    public static void main(String[] args) {
        // Create and set up the window.
        JFrame ManagerWindow = new JFrame("Manager");
        ManagerWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //show the window and set up its properties
        ManagerWindow.add(new ServerPanel(), BorderLayout.CENTER);
        ManagerWindow.setResizable(false);
        ManagerWindow.pack();
        ManagerWindow.setVisible(true);

    }
}