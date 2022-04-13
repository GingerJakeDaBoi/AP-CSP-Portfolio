package components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project {

    public static void main(String[] args) {
        // Create and set up the window.
        JFrame frame = new JFrame("MainWindow");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel resources = new JLabel("System Resources");
        resources.setPreferredSize(new Dimension(800, 600));
        frame.getContentPane().add(resources, BorderLayout.CENTER);

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}