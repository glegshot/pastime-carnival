package org.tutorial.game.main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject{

    private Handler handler;
    private String spriteSheetPath = "/Player.png";

    protected int row = 1;
    protected int col = 6;

    protected int maxHeight = 20;
    protected int currentHeight = 0;

    private long delay;

    boolean isJump = false;
    boolean isFall = false;

    public Player(int x, int y, ID id, Handler handler,BufferedImageLoader imageLoader) {
        super(x, y, id, imageLoader);
        this.delay = System.currentTimeMillis();
        this.handler = handler;
        BufferedImage bufferedImage = this.bufferedImageLoader.loadImage(spriteSheetPath);
        this.spriteSheet = new SpriteSheet(bufferedImage);
    }

    @Override
    public void tick() {
        this.x += velX;

        if(isJump){
            //System.out.println("in JUMP x: "+x+" ,y: "+y);
            if(currentHeight <= maxHeight){
                //System.out.println(currentHeight);
                currentHeight++;
                this.y += velY;
            }else{
                isJump = false;
                isFall = true;
                currentHeight = maxHeight;
                this.setVelY(5);
            }
        }

        if(isFall){
            //System.out.println("in FALL x: "+x+" ,y: "+y);
            if(currentHeight >= 0){
                this.y += velY;
                //System.out.println("in fall"+ currentHeight);
                currentHeight--;
            }else{
                isFall = false;
                this.setVelY(0);
                currentHeight = 0;
            }
        }

        x = clamp(x,0,Game.WIDTH - 36);
        y = clamp(y,0,Game.HEIGHT - 70);

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
        graphics.drawRect(x,y,32,32);
        //graphics.drawImage(this.spriteSheet.grabImage(row, col,155,165),x,y,null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }



}
