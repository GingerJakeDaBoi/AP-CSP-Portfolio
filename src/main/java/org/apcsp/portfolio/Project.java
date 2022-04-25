package org.apcsp.portfolio;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

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

        //set up the File Manager button and window

        //Window
        JFrame browserWindow = new JFrame("Files");
        browserWindow.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        browserWindow.setPreferredSize(new Dimension(200, 500));

        //File Tree
        JTree browser = new JTree();
        browser.setRootVisible(true);
        browserWindow.add(browser, BorderLayout.CENTER);

        File fileRoot = null;
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(fileRoot);
        DefaultTreeModel model = new DefaultTreeModel(root);

        fileRoot = new File("/");
        File[] subItems = fileRoot.listFiles();
        for (File file : subItems) {
            root.add(new DefaultMutableTreeNode(file));
        }

        browser.setModel(model);

        //Button
        JButton fileManager = new JButton("Files");
        fileManager.setVisible(true);

        //Mouse click
        fileManager.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                browserWindow.pack();
                browserWindow.setVisible(true);
                browserWindow.setPreferredSize(new Dimension(200, 500));
            }
        });

        //show the window and set up its properties
        ManagerWindow.add(new ServerPanel(), BorderLayout.CENTER);
        ManagerWindow.setResizable(false);
        ManagerWindow.pack();
        ManagerWindow.setVisible(true);

        //show the terminal and file manager buttons
        ManagerWindow.add(termButton, BorderLayout.NORTH);
        ManagerWindow.add(fileManager, BorderLayout.SOUTH);
    }
}