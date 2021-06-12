package org.tutorial.game.main;

import java.awt.*;

public class Player extends GameObject{

    private Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    @Override
    public void tick() {
        this.y += velY;
        this.x += velX;

        x = clamp(x,0,Game.WIDTH - 32);
        y = clamp(y,0,Game.HEIGHT - 64);

        collisionDetection();

    }

    private void collisionDetection() {
        this.handler.gameObjectList
                .stream()
                .filter(gameObject -> gameObject.id == ID.Enemy)
                .forEach(gameObject -> {
                    if(gameObject.getBounds().intersects(this.getBounds())){
                        HUD.HEALTH -= 2;
                    }
                });
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

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }


}
