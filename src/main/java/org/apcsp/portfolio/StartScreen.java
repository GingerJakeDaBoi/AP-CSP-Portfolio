package org.apcsp.portfolio;

import java.awt.*;
import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.OperatingSystemMXBean;
import java.text.AttributedCharacterIterator;
import java.text.MessageFormat;
import javax.swing.*;

public class StartScreen extends ServerState {
    OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    private final String[] LABELS={"System Resources","File Manager"};

    public StartScreen(ServerStateManager ssm){
        super(ssm);
    }

    public void init() {

    }

    public void draw(Graphics g) {
        //Set the background color
        g.setColor(new Color(93, 93, 93, 255));
        g.fillRect(0,0,ServerPanel.width,ServerPanel.height);

        //Draw the labels, look at the top for the list
        for(int i = 0; i < LABELS.length; i++) {
            g.setColor(Color.white);

            //Category Labels
            g.setFont(new Font("Arial",Font.BOLD,16));
            g.drawString(LABELS[i],25,80+i*300);

            //OS name and version
            g.setFont(new Font("Arial",Font.PLAIN,12));
            g.drawString(System.getProperty("os.name"),10,20);
            g.drawString(System.getProperty("os.version"),10,40);

            // CPU usage
            g.setFont(new Font("Arial",Font.PLAIN,16));
            g.drawString("CPU Count: "+ String.valueOf(Runtime.getRuntime().availableProcessors()),25,125);
            g.drawString("Average CPU Usage: "+String.valueOf(MessageFormat.format("{0}%", operatingSystemMXBean.getSystemLoadAverage()%2f)),175,125);

            // Disk usage
            File root = new File("/");
            g.drawString("Total space: "+root.getTotalSpace()/1073741824+" GB",425,125);
            g.drawString("Free space: "+root.getFreeSpace()/1073741824+" GB",600,125);
            }
        }

    public void tick() {

    }
}
