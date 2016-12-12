package com.suv.view;

import javax.swing.*;

/**
 * Created by Kramer on 2016/12/10.
 */
public class GameFrame extends JFrame {
    public GameFrame(){
        init();
    }
    public void init(){
        this.setTitle("FlappyBird");
        this.setSize(320,480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        GamePanel gamePanel = new GamePanel();
        this.add(gamePanel);
    }
}
