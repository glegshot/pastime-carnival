package org.tutorial.game.main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BufferedImageLoader {

    BufferedImage bufferedImage;

    public BufferedImage loadImage(String path){
        try {
            bufferedImage = ImageIO.read(getClass().getResource(path));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return bufferedImage;
    }

}
