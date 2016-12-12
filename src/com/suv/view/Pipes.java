package com.suv.view;

import java.awt.*;

/**
 * Created by Kramer on 2016/12/11.
 */
public class Pipes {
    private Pipe a,b;
    private int between;
    private GamePanel gamePanel;
    public Pipes(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        a = new Pipe(gamePanel);
        b = new Pipe(gamePanel);
        between = (gamePanel.getWidth()-a.width) /2;

        b.x = a.x +between + a.width;

    }
    public void paint(Graphics g){
        a.paint(g);
        if(a.x <= -a.width){
            a.reset();
            a.x = b.x+b.width+between;
        }
        b.paint(g);
        if(b.x <= -b.width){
            b.reset();
            b.x = a.x+a.width+between;
        }
    }
}
