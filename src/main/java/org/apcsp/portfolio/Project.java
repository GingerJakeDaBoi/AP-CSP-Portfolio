package org.apcsp.portfolio;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Objects;

public class Project {

    public static void main(String[] args) {
        // Create and set up the window.
        JFrame ManagerWindow = new JFrame("Manager");
        ManagerWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set up the terminal button
        JButton termButton = new JButton("Terminal");
        termButton.setVisible(true);
        termButton.addActionListener(actionEvent -> {
            try {
                Runtime.getRuntime().exec("cmd /c start cmd.exe /K");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        JPanel panel = new JPanel();
        final JTree browser = new JTree();
        panel.add(new JScrollPane(browser));
        JButton btn = new JButton("Expand all");
        btn.addActionListener(ae -> {
            for (Enumeration<? extends TreeNode> e = ((TreeNode) browser.getModel().getRoot()).children(); e.hasMoreElements(); ) {
                TreeNode tn = e.nextElement();
                browser.expandPath(new TreePath(((DefaultTreeModel) browser.getModel()).getPathToRoot(tn)));
            }
        });

        File fileRoot = new File("/");

        DefaultMutableTreeNode root = new DefaultMutableTreeNode(fileRoot);
        DefaultTreeModel model = new DefaultTreeModel(root);

        File[] subItems = fileRoot.listFiles();
        for (File file : Objects.requireNonNull(subItems)) {

            if (file.isDirectory()) {

                // generates a node newDir using filename
                DefaultMutableTreeNode newDir = new DefaultMutableTreeNode(file.getName());
                // adds a node to the root of the JTree
                root.add(newDir);
                model.reload();

            } else {
                DefaultMutableTreeNode newFile = new DefaultMutableTreeNode(file.getName());
                root.add(newFile);
            }
        }

        browser.setModel(model);

        panel.add(btn, BorderLayout.SOUTH);
        JFrame frame = new JFrame("");
        frame.getContentPane().add(panel);
        frame.setSize(300, 300);
        frame.setLocation(100, 100);
        frame.pack();
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setResizable(false);

        //Button
        JButton fileManager = new JButton("Files");
        fileManager.setVisible(true);

        //Mouse click
        fileManager.addActionListener(actionEvent -> {
            frame.pack();
            frame.setVisible(true);
            frame.setPreferredSize(new Dimension(500, 500));
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