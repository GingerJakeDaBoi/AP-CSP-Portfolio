package org.apcsp.portfolio;

import java.awt.*;

public class StartScreen  extends ServerState {
    private final String[] LABELS={"Terminal","System Resources","File Manager"};

    public StartScreen(ServerStateManager ssm){
        super(ssm);
    }

    public void init() {

    }

    public void draw(Graphics g) {
        g.setColor(new Color(63, 63, 63, 255));
        g.fillRect(0,0,ServerPanel.width,ServerPanel.height);
        g.setColor(new Color(0, 0, 0, 255));
        g.fillRect(300,20,480,275);

        for(int i = 0; i < LABELS.length; i++) {
            g.setColor(Color.white);

            g.setFont(new Font("Arial",Font.PLAIN,16));
            g.drawString(LABELS[i],25,175+i*300);
        }
    }

    public void tick() {

    }
}
