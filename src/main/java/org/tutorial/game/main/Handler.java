package org.tutorial.game.main;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Handler {

    List<GameObject> gameObjectList = new LinkedList<>();

    public void tick(){
        gameObjectList.stream().forEach(gameObject -> gameObject.tick());
    }

    public void render(Graphics graphics){
        gameObjectList.stream().forEach(gameObject -> gameObject.render(graphics));
    }

    public void addObject(GameObject gameObject){
        this.gameObjectList.add(gameObject);
    }

    public void removeObject(GameObject gameObject){
        this.gameObjectList.remove(gameObject);
    }

}
