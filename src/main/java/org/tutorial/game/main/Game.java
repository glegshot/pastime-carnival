package org.tutorial.game.main;

import java.awt.*;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = -6472910296922747910L;

    private static final int WIDTH = 640;
    private static final int HEIGHT = 640 / 12 * 9;


    public Game(){
        new Window(WIDTH, HEIGHT, "Let's Build A Game", this);
    }

    public synchronized void start(){

    }

    public static void main(String[] args) {
        new Game();
    }

    @Override
    public void run() {

    }
}
