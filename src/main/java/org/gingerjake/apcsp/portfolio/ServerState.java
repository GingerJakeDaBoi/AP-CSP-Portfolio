package org.gingerjake.apcsp.portfolio;

import java.awt.*;

public abstract class ServerState {
    public abstract void init();
    protected ServerStateManager ssm;
    public abstract void draw(Graphics g);
    public abstract void tick();

    public ServerState(ServerStateManager ssm){
        this.ssm = ssm;
        init();
    }
}
