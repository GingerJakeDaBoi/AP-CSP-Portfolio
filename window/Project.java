import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project {

    public static void main(String[] args) {
        // Create and set up the window.
        JFrame frame = new JFrame("MainWindow");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //System Resources text
        JLabel resources = new JLabel();
        resources.setText("System Resources");
        
        //Terminal text
        JLabel terminal = new JLabel();
        terminal.setText("Terminal");


        resources.setPreferredSize(new Dimension(800, 600));
        frame.getContentPane().add(resources, BorderLayout.CENTER);
        
        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}