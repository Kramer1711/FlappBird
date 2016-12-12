package com.suv.view;

import com.suv.Util.ImageUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Kramer on 2016/12/10.
 */
public class Bird {
    private BufferedImage[] birdImage = new BufferedImage[3];
    private int index = 0;
    private long lastPaintSwingMs;
    public int center[] = new int[2];
    private int y = 0,x = 0;
    private int FrameY = 1;
    private int downY = 10;
    int w,h;
    private double angle;
    private GamePanel gamePanel;

    public Bird(GamePanel gamePanel){
        this.gamePanel = gamePanel;

        birdImage[0] = ImageUtil.load("0.png");
        birdImage[1] = ImageUtil.load("1.png");
        birdImage[2] = ImageUtil.load("2.png");

        center[0] = gamePanel.getWidth()/2;
        center[1] = gamePanel.getHeight()/2;
        x = gamePanel.skyWidth;
        y = gamePanel.skyHeight;
        w = birdImage[0].getWidth();
        h = birdImage[0].getHeight();

    }
    public void fly(){
        //y-=50;
        FrameY = - 10;
    }

    public void paint(Graphics g){
        Graphics2D gd = (Graphics2D) g;
        gd.rotate(angle,(x-w)/2, (y-h)/2);

        gd.drawImage(birdImage[index % 3],(x-w)/2, (y-h)/2,null);

        gd.rotate(-angle,(x-w)/2, (y-h)/2);
        if (System.currentTimeMillis() - lastPaintSwingMs > 150){
            index++;
            lastPaintSwingMs = System.currentTimeMillis();
        }
        //FrameY = 1.6f - downY;
        y += FrameY;
        FrameY+=2;
        angle = Math.atan(FrameY/8);
    }
}
