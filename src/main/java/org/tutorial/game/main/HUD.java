package org.tutorial.game.main;

import java.awt.*;

public class HUD {

    public static int HEALTH = 100;

    public void tick(){
        //HEALTH--;
        HEALTH = clamp(HEALTH,0,100);
    }

    private int clamp(int val, int min, int max) {
        if(val >= max)
            return max;
        else if(val <= min)
            return min;
        else
            return val;
    }

    public void render(Graphics graphics){
        graphics.setColor(Color.GRAY);
        graphics.fillRect(15,15,200,32);
        graphics.setColor(Color.GREEN);
        graphics.fillRect(15,15,HEALTH * 2,32);
        graphics.setColor(Color.WHITE);
        graphics.drawRect(15,15,200,32);
    }
}
