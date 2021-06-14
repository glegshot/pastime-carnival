package org.tutorial.game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
           if(!(player.isJump || player.isFall)) {
               System.out.println("inside w press");
               player.setVelY(-2);
               player.isJump = true;
               player.isFall = false;
               printCoordinates(player);
           }
       }
       if(e.getKeyCode() == KeyEvent.VK_S){
           printCoordinates(player);
       }
       if(e.getKeyCode() == KeyEvent.VK_A){
           player.setVelX(-5);
           printCoordinates(player);
       }
       if(e.getKeyCode() == KeyEvent.VK_D){
           player.setVelX(5);
           printCoordinates(player);
       }
    }

    public void printCoordinates(Player player){
        System.out.println("x: "+player.getX()+", y: "+player.getY());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Player player = (Player) this.handler.gameObjectList.stream().filter(gameObject -> gameObject.id == ID.Player).collect(Collectors.toList()).get(0);
        if(e.getKeyCode() == KeyEvent.VK_W){
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            player.setVelX(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            player.setVelX(0);
        }
    }
}
