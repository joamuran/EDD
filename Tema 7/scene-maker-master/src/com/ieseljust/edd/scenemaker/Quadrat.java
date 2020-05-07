package com.ieseljust.edd.scenemaker;

import java.awt.Graphics;
import java.awt.Color;

public class Quadrat extends Figura{
    private int side;

    // Constructor

    /**
     * Constructor únic
     * @param x
     * @param y
     * @param side
     * @param color
     */
    Quadrat(int x, int y, int side, Color color){
        super(x, y, color);
        this.side = side;
    }

    // Métodes

    /**
     * Retorna el costat del objecte (No s'utilitza)
     */
    public int getSide(){
        return this.side;
    }

    /**
     * Descriu l'objecte. Com un toString() però sense return
     */
    @Override
    public void describeMe(){
        System.out.println("quadrat " + this.getPosX() + " " + this.getPosY() + " " + side + " " + this.getColor());
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        g.fillRect(this.getPosX(), this.getPosY(), this.side, this.side);
    }
}