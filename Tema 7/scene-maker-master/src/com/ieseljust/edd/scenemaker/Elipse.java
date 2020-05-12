package com.ieseljust.edd.scenemaker;

import java.awt.Graphics;
import java.awt.Color;

public class Elipse extends Figura{
    private int radiX;
    private int radiY;


    /**
     * Constructor unic
     * @param x
     * @param y
     * @param radiX
     * @param radiY
     * @param color
     */
    Elipse(int x, int y, int radiX, int radiY, Color color){
        super(x, y, color);
        this.radiX = radiX;
        this.radiY = radiY;
    }

    @Override
    public void describeMe(){
        System.out.println("El.lipse " + this.getPosX() + " " + this.getPosY() + " " + radiX + " " + radiY + " " + this.getColor());
    }

    
    @Override
    public void render(Graphics g) {
        super.render(g);
        g.fillOval(this.getPosX()-this.radiX, this.getPosY()-this.radiY, this.radiY*2, this.radiX*2);
    }
}