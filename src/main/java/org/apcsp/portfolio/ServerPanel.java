package org.apcsp.portfolio;

import javax.swing.*;
import java.awt.*;

public class ServerPanel extends JPanel implements Runnable{
    private boolean isRunning = false;
    private final int width = 800;
    private final int height = 900;
    private Thread thread;

    private final int FPS = 60;
    private final long TARGET_TIME=1000/FPS;

    public ServerPanel() {
        setPreferredSize(new Dimension(width,height));
        setFocusable(true);
        start();
    }

    private void start() {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }


    public void run() {
        long start,elapsed,wait;

        while(isRunning) {
            start = System.nanoTime();
            repaint();

            elapsed = System.nanoTime()-start;
            wait = (TARGET_TIME-elapsed) / 1000000;

            if(wait <=0) wait = 5;
            try {
                Thread.sleep(wait);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
