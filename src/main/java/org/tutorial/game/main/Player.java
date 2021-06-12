package org.tutorial.game.main;

import java.awt.*;

public class Player extends GameObject{

    public Player(int x, int y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {
        this.y += velY;
        this.x += velX;

        x = clamp(x,0,Game.WIDTH - 32);
        y = clamp(y,0,Game.HEIGHT - 64);
    }

    private int clamp(int val, int min, int max) {
        if(val >= max)
            return max;
        else if(val <= min)
            return min;
        else
            return val;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(x,y,32,32);
    }
}
