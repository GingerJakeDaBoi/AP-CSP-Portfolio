package org.apcsp.portfolio;

import java.awt.*;

public class StartScreen  extends ServerState {
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

        //Draw the terminal button
        g.setColor(new Color(62, 56, 56));
        g.fillRect(0,0,100,35);
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.BOLD,16));
        g.drawString("Terminal",15,25);

        //Draw the labels, look at the top for the list
        for(int i = 0; i < LABELS.length; i++) {
            g.setColor(Color.white);

            g.setFont(new Font("Arial",Font.BOLD,16));
            g.drawString(LABELS[i],25,175+i*300);
        }
    }

    public void tick() {

    }
}
