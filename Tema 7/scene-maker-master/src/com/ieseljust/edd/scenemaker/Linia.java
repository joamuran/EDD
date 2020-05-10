package com.ieseljust.edd.scenemaker;

import java.awt.Graphics;
import java.awt.Color;

public class Linia extends Figura{
    private int x2;
    private int y2;


    /**
     * Constructor
     * @param x
     * @param y
     * @param x2
     * @param y2
     */ 
    Linia(int x, int y, int x2, int y2){
        super(x, y, Color.BLACK);
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void describeMe(){
        System.out.println("Cercle " + this.getPosX() + " " + this.getPosY() + " " + this.x2 + " " + this.y2);
    }

    
    @Override
    public void render(Graphics g) {
        super.render(g);
        g.drawLine(this.getPosX(), this.getPosY(), this.x2, this.y2);
    }
}