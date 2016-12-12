package com.suv.view;

import com.suv.Util.ImageUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Kramer on 2016/12/10.
 */
public class Background {
    private GamePanel gamePanel;
    private BufferedImage sky = null;
    private BufferedImage ground = null;
    public int width,height;
    //private BufferedImage start = null;

    private int x = 0;
    protected Background(GamePanel gamePanel){

        sky = ImageUtil.load("bg.png");
        this.gamePanel = gamePanel;
        width = sky.getWidth();
        height = sky.getHeight();
    }

    public void paintSky(Graphics g){
        g.drawImage(sky,0,0,null);

    }
    public void paintGround(Graphics g){
        ground = ImageUtil.load("ground.png");
        g.drawImage(ground,x,400,null);
        x--;
        if(x < -27) x = 0;
    }/*
    public void paintStart(Graphics g){
        start = ImageUtil.load("start.png");
        g.drawImage(start,0,0,null);
    }*/
}
