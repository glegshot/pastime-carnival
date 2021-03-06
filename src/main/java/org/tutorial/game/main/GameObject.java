package org.tutorial.game.main;

import javax.swing.*;
import java.awt.*;

public abstract class GameObject {

    protected int x;
    protected int y;
    protected ID id;
    protected int velX;
    protected int velY;

    protected BufferedImageLoader bufferedImageLoader;
    protected SpriteSheet spriteSheet;


    public GameObject(int x, int y, ID id, BufferedImageLoader bufferedImageLoader){
        this.x = x;
        this.y = y;
        this.id = id;
        this.bufferedImageLoader = bufferedImageLoader;
    }

    public abstract void tick();
    public abstract void render(Graphics graphics);
    public abstract Rectangle getBounds();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public int getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public int getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }
}
