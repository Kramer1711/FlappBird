package com.suv.view;

import com.suv.Util.ImageUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Kramer on 2016/12/11.
 */
public class Status {
    private GamePanel gamePanel;

    public Status(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    public void paintReady(Graphics g){
        BufferedImage start = ImageUtil.load("start.png");
        g.drawImage(start,0,0,null);
    }
    public void paintGameOver(){

    }
}
