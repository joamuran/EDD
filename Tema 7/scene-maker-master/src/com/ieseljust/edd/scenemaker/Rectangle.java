package com.ieseljust.edd.scenemaker;

import java.awt.Graphics;
import java.awt.Color;

public class Rectangle extends Figura{
    /*
     * Aquesta classe representa un element gràfic de tipus rectangle
     */

    private Integer width;
    private Integer height;

    // Constructors
    Rectangle() {
        super(0, 0, Color.BLACK);
        // Constructor per defecte sense paràmetres
        this.width = 100;
        this.height = 100;
    }

    Rectangle(int x, int y) {
        super(x, y, Color.BLACK);
        // Constructor on s'especifica només pa posició
        this.width = 100;
        this.height = 100;
    };

    Rectangle(int x, int y, Color color) {
        super(x, y, color);
        // Constructor on s'especifica la posició i el color
        this.width = 100;
        this.height = 100;
    }

    Rectangle(int x, int y, int width, int height, Color color) {
        super(x, y, color);
        // Constructor on s'especifica la posició, el color i les dimensions
        this.width = width;
        this.height = height;
    }

    // Mètode Accessors


    @Override
    public void describeMe() {
        /*
         * Mètode que mostra en mode text una descripció de la figura per la consola.
         * S'utilitzarà per al mètode llista de la CLI.
         */
        System.out.println("rectangle " + this.getPosX() + " " + this.getPosY() + " " + width + " " + height + " " + this.getColor());
    };

    @Override
    public void render(Graphics g) {
        /*
         * Mètode que dibuixa sobre un context gràfic la figura rectangle.
         * S'utilitza per al mètode render() de la cli.
         * 
         * Per dibuixar altres primitives de la classe Graphics, podeu consultar
         * https://docs.oracle.com/javase/10/docs/api/java/awt/Graphics.html
         */

        super.render(g);             // Establim el color interior
        g.fillRect(this.getPosX(), this.getPosY(), width, height);    // Dibuixem un rectangle en la posició i mida indicades
    };

}
