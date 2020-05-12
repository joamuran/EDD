package com.ieseljust.edd.scenemaker;

import java.awt.Graphics;
import java.awt.Color;

import com.ieseljust.edd.scenemaker.Renderizable;

public abstract class Figura implements Renderizable{

    private int posX;
    private int posY;
    private Color color;

    Figura(int x, int y, Color color){
        this.posX = x;
        this.posY = y;
        this.color = color;
    }

    public Color getColor(){
        return this.color;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public int getPosX(){
        return this.posX;
    }
    
    public int getPosY(){
        return this.posY;
    }

    public abstract void describeMe();

    public void render(Graphics g) {
        /*
         * Mètode que dibuixa sobre un context gràfic la figura rectangle.
         * S'utilitza per al mètode render() de la cli.
         * 
         * Per dibuixar altres primitives de la classe Graphics, podeu consultar
         * https://docs.oracle.com/javase/10/docs/api/java/awt/Graphics.html
         */

        g.setColor(this.color);             // Establim el color interior
    };
}