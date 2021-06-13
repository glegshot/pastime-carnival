package org.tutorial.game.main;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage sprite;

    public SpriteSheet(BufferedImage sprite){
        this.sprite = sprite;
    }

    public BufferedImage grabImage(int row, int col, int width, int height){
        BufferedImage img = sprite.getSubimage((row * 155) - 155, (col * 165) - 165, width, height);
        return img;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }
}
