package com.ieseljust.edd.scenemaker;

import java.awt.Graphics;
import java.awt.Color;

public class Quadrat extends Figura{
    private int side;

    Quadrat(int x, int y, int side, Color color){
        super(x, y, color);
        this.side = side;
    }

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