package org.tutorial.game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.stream.Collectors;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void keyPressed(KeyEvent e) {
       Player player = (Player) this.handler.gameObjectList.stream().filter(gameObject -> gameObject.id == ID.Player).collect(Collectors.toList()).get(0);
       if(e.getKeyCode() == KeyEvent.VK_W){
           ///player.setVelY(-5);
       }else if(e.getKeyCode() == KeyEvent.VK_S){
           //player.setVelY(5);
       }else if(e.getKeyCode() == KeyEvent.VK_A){
           //player.setVelX(-5);
       }else if(e.getKeyCode() == KeyEvent.VK_D){
           //player.setVelX(5);
       }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Player player = (Player) this.handler.gameObjectList.stream().filter(gameObject -> gameObject.id == ID.Player).collect(Collectors.toList()).get(0);
        if(e.getKeyCode() == KeyEvent.VK_W){
            //player.setVelY(0);
        }else if(e.getKeyCode() == KeyEvent.VK_S){
            //player.setVelY(0);
        }else if(e.getKeyCode() == KeyEvent.VK_A){
            //player.setVelX(0);
        }else if(e.getKeyCode() == KeyEvent.VK_D){
            //player.setVelX(0);
        }
    }
}
