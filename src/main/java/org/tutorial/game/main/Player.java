package org.tutorial.game.main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject{

    private Handler handler;
    private String spriteSheetPath = "/Idle.png";

    protected int row = 1;
    protected int col = 1;

    public Player(int x, int y, ID id, Handler handler,BufferedImageLoader imageLoader) {
        super(x, y, id, imageLoader);
        this.handler = handler;
        BufferedImage bufferedImage = this.bufferedImageLoader.loadImage(spriteSheetPath);
        this.spriteSheet = new SpriteSheet(bufferedImage);
    }

    @Override
    public void tick() {
        this.y += velY;
        this.x += velX;

        this.row++;
        if(this.row > 6){
            this.row = this.row % 6;
        }

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
        //graphics.setColor(Color.WHITE);
        //graphics.fillRect(x,y,32,32);
        graphics.drawImage(this.spriteSheet.grabImage(row, col,155,155),x,y,null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }



}
