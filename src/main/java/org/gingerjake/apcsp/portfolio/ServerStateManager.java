package org.gingerjake.apcsp.portfolio;

import java.awt.*;
import java.util.Stack;

public class ServerStateManager {
    public Stack<ServerState> states;

    public ServerStateManager() {
        states = new Stack<ServerState>();
        states.push(new StartScreen(this));
    }

    public void tick() {
        states.peek().tick();
    }

    public void draw(Graphics g) {
        states.peek().draw(g);
    }
}

