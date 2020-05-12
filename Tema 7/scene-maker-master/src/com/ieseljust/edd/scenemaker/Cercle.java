package com.ieseljust.edd.scenemaker;

import java.awt.Graphics;
import java.awt.Color;

public class Cercle extends Figura{
    private int radi;


    /**
     * Constructor unic
     * @param x
     * @param y
     * @param radi
     * @param color
     */
    Cercle(int x, int y, int radi, Color color){
        super(x, y, color);
        this.radi = radi;
    }

    @Override
    public void describeMe(){
        System.out.println("Cercle " + this.getPosX() + " " + this.getPosY() + " " + radi + " " + this.getColor());
    }

    
    @Override
    public void render(Graphics g) {
        super.render(g);
        g.fillOval(this.getPosX()-this.radi, this.getPosY()-this.radi, this.radi*2, this.radi*2);
    }
}