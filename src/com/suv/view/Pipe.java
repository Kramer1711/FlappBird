package com.suv.view;

import com.suv.Util.ImageUtil;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Kramer on 2016/12/10.
 */
public class Pipe {
    private BufferedImage up ;
    private BufferedImage down;
    public int x;
    private int upY,downY;
    private int spaceH = 100;
    public int width ;
    //private int skyHeight;
    private GamePanel gamePanel;
    public Pipe(GamePanel gamePanel){
        up = ImageUtil.load("up.png");
        down = ImageUtil.load("down.png");
        this.gamePanel = gamePanel;
        width = up.getWidth();
        //this.skyHeight = gamePanel.getHeight();
        this.reset();
    }

    public void reset(){
        //x为天空宽度(管道出现在最右边)
        x=gamePanel.skyWidth;
        //计算两个管道的坐标
        int temp=random(50,gamePanel.skyHeight-spaceH-50);
        //上面管道等于关键点减去管道的高度
        downY = temp-down.getHeight();
        //下面管道等于关键点+空隙
        upY=temp+spaceH;
    }

    private static int random(int a, int b){
        return (int)(Math.random()*Math.abs(a-b))+Math.min(a,b);
    }

    public void paint(Graphics g){
        g.drawImage(up,x,upY,null);
        g.drawImage(down,x,downY,null);
        x--;
        /*
        if(x < -56)
            this.reset();
            */
    }
}
