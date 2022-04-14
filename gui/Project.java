import java.awt.*;
import javax.swing.*;

public class Project {

    public static void main(String[] args) {
        // Create and set up the window.
        JFrame frame = new JFrame("Server Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //System Resources text
        JLabel resources = new JLabel();
        resources.setText("System Resources");
        frame.getContentPane().add(resources, BorderLayout.CENTER);

        //Terminal text
        JLabel terminal = new JLabel();
        terminal.setText("Terminal");
        frame.getContentPane().add(terminal,BorderLayout.NORTH);

        //Filesystem Text
        JLabel Filesystem = new JLabel();
        Filesystem.setText("Filesystem");
        frame.getContentPane().add(Filesystem,BorderLayout.SOUTH);

        //Set the sizes of the tabs
        resources.setPreferredSize(new Dimension(800, 400));
        terminal.setPreferredSize(new Dimension(800,400));
        Filesystem.setPreferredSize(new Dimension(800,400));
        
        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}