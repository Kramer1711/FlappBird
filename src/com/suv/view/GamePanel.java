package com.suv.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Kramer on 2016/12/10.
 */
public class GamePanel extends JPanel implements Runnable{
    private Thread gameThread = null;
    private Background background;
    private Bird bird;
    private Status status;
    private Pipes pipes;
    public int skyHeight;
    public int skyWidth;

    public final static int READY = 0;
    public final static int PALYING = 1;
    public final static int GAMEOVER = -1;
    public int state;

    public GamePanel(){

    }
    public void setSkyHeightAndWidth(int h,int w){
        this.skyHeight = h;
        this.skyWidth = w;

    }
    @Override
    protected void paintComponent(Graphics g) {
        //  1   背景-天空
        background.paintSky(g);
        if(state == PALYING) {
            //  2   鸟
            bird.paint(g);
            //  3   管子
            pipes.paint(g);
        }

        if(state == READY) {
            //  4   开始按钮
            status.paintReady(g);
        }
        if(state == GAMEOVER){
            status.paintGameOver();
        }

        //  5   草坪
        background.paintGround(g);
    }

    /**
     *
     */
    @Override
    public void doLayout() {
        background = new Background(this);
        setSkyHeightAndWidth(background.height,background.width);
        bird = new Bird(this);
        pipes = new Pipes(this);
        status = new Status(this);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                holdMouse();
            }
        });

        state = READY;
        //  游戏线程开始
        gameThread = new Thread(this);
        gameThread.start();

    }

    private void holdMouse(){
        if(state == READY){
            state = PALYING;
        }else if(state == PALYING){
            //fly
            bird.fly();
        }else if(state == GAMEOVER){
            state = READY;
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                this.repaint();
                Thread.sleep(1000/30);
                //if(bird.getY() > (getHeight()*0.40)) break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
