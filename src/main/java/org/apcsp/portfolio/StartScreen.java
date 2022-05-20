package org.apcsp.portfolio;

import com.sun.management.OperatingSystemMXBean;

import java.awt.*;
import java.io.File;
import java.lang.management.ManagementFactory;
import java.text.MessageFormat;

public class StartScreen extends ServerState {
    OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    private final String[] LABELS={"Operating System", "Storage"};

    public StartScreen(ServerStateManager ssm){
        super(ssm);
    }

    public void init() {

    }

    public void draw(Graphics g) {
        //Set the background color
        g.setColor(new Color(128, 122, 122, 255));
        g.fillRect(0, 0, ServerPanel.width, ServerPanel.height);

        //Draw the labels, look at the top for the list
        for (int i = 0; i < LABELS.length; i++) {
            g.setColor(Color.white);

            //Category Labels
            g.setFont(new Font("Arial", Font.BOLD, 16));
            g.drawString(LABELS[i], 25, 80 + i * 225);

            //OS name and version
            g.setFont(new Font("Arial", Font.PLAIN, 16));
            g.drawString(System.getProperty("os.name"), 25, 108);
            g.drawString(System.getProperty("os.version"), 25, 133);

            // CPU Arch
            g.setFont(new Font("Arial",Font.PLAIN, 12));
            g.drawString(System.getProperty("os.arch"),755,20);

            // Disk usage
            File root = new File("/");
            g.setFont(new Font("Arial", Font.PLAIN, 16));
            g.drawString("Total space: " + root.getTotalSpace() / 1073741824 + " GB", 25, 335);
            g.drawString("Free space: " + root.getFreeSpace() / 1073741824 + " GB", 200, 335);
        }
    }
    public void tick() {

    }


}
