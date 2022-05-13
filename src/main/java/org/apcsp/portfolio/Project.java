package org.apcsp.portfolio;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.ui.RefineryUtilities;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Objects;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class Project extends LineChart_AWT {

    public Project(String applicationTitle, String chartTitle) {
        super(applicationTitle, chartTitle);
    }

    public static void main(String[] args) {
        // Create and set up the window.
        JFrame ManagerWindow = new JFrame("Manager");
        ManagerWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set up the terminal button
        JButton termButton = new JButton("Terminal");
        termButton.setVisible(true);
        termButton.addActionListener(actionEvent -> {
            try {
                Process process = Runtime.getRuntime().exec("cmd /c start cmd.exe /K"); //TODO: Replace gnome-terminal with Windows CMD with the "cmd /c start cmd.exe /K" command, should probably change this later so that you can do it on both systems
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        final LineChart_AWT[] chart = new LineChart_AWT[1];
        class LineChart_AWT {
            public LineChart_AWT(String applicationTitle, String chartTitle) {
                JFreeChart lineChart = ChartFactory.createLineChart(chartTitle, "Cpu usage", "CPU Usage", createDataset(), PlotOrientation.VERTICAL, true, true, false);
                ChartPanel chartPanel = new ChartPanel(lineChart);
                chartPanel.setPreferredSize(new java.awt.Dimension(420, 210));

                org.apcsp.portfolio.LineChart_AWT chart = new org.apcsp.portfolio.LineChart_AWT("Cpu usage", "Cpu usage");
                chart.pack();
                RefineryUtilities.centerFrameOnScreen(chart);
                chart.setVisible(true);
                ManagerWindow.add(chart,BorderLayout.SOUTH);
            }

        }


        JPanel panel = new JPanel();
        final JTree browser = new JTree();
        panel.add(new JScrollPane(browser));
        JButton btn = new JButton("Expand all");
        btn.addActionListener(ae -> {
            for (Enumeration<? extends TreeNode> e = ((TreeNode) browser.getModel().getRoot()).children(); e.hasMoreElements(); ) {
                TreeNode tn = (TreeNode) e.nextElement();
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