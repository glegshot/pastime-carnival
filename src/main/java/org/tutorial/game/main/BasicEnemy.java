package org.tutorial.game.main;

import java.awt.*;

public class BasicEnemy extends GameObject{

    public BasicEnemy(int x, int y, ID id) {
        super(x, y, id);
        this.velX = 5;
        this.velY = 5;
    }

    @Override
    public void tick() {
        this.x += velX;
        this.y += velY;

        if(this.y <= 0 || this.y >= Game.HEIGHT - 48)
            this.velY *= -1;
        if(this.x <= 0 || this.x >= Game.WIDTH - 16)
            this.velX *= -1;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillRect(x,y,16,16);
    }
}
