package org.tutorial.game.main;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = -6472910296922747910L;

    public static final int WIDTH = 640;
    public static final int HEIGHT = 640 / 12 * 9;

    private Thread thread;
    private boolean isRunning;

    private Handler handler;
    private HUD hud;
    private BufferedImageLoader bufferedImageLoader;

    public Game(){
        this.bufferedImageLoader = new BufferedImageLoader();
        this.handler = new Handler();
        this.handler.addObject(new Player(100,320,ID.Player, this.handler, this.bufferedImageLoader));
        this.handler.addObject(new BasicEnemy(500,350,ID.Enemy,this.bufferedImageLoader));
        this.hud = new HUD();

        this.addKeyListener(new KeyInput(this.handler));
        new Window(WIDTH, HEIGHT, "Let's Build A Game", this);
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        isRunning = true;
    }

    public synchronized void stop(){
        try {
            thread.join();
            isRunning = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Game();
    }

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(isRunning){
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(isRunning){
                render();
            }
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                //System.out.println("FPS : "+frames);
                frames = 0;
            }
        }
        stop();
    }

    private void render() {
        BufferStrategy bufferStrategy = this.getBufferStrategy();
        if(bufferStrategy == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics graphics = bufferStrategy.getDrawGraphics();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0,WIDTH,HEIGHT);
        this.handler.render(graphics);
        graphics.setColor(Color.GREEN);
        graphics.drawLine(0,352,640,352);
        this.hud.render(graphics);
        graphics.dispose();
        bufferStrategy.show();


    }

    private void tick() {

        this.handler.tick();
        this.hud.tick();
    }
}
