package com.ieseljust.edd.scenemaker;

// Imports per a entrada de dades
import java.util.Scanner;

// Imports per gestionar el color de les imatges
import java.awt.Color;

// Imports per a gestió de llistes
import java.util.ArrayList;

public class Cli {
    /*
     * Classe principal de l'aplicació. S'encarrega de la interacció amb l'usuari i
     * de la generació de l'escena amb les imatges.
     */

    // Escena serà una classe que mantindrà la llista
    // de figures a representar.
    private static Escena AppEscena;

    public void run(String[] args) {
        /*
         * Mètode llançador de la classe. S'encarrega de mantindre la CLI activa,
         * preguntant a l'usuari i executant les ordres que aquest introdueix.
         */

        Scanner keyboard = new Scanner(System.in);

        // Dimensions de la finestra
        int width, height;

        try {
            // Si s'especifiquen les dimensions, les inicialitzem
            width = Integer.parseInt(args[0]);
            height = Integer.parseInt(args[1]);
        } catch (Exception e) {
            // Si no s'especifiquen, la imatge serà de 800x600
            width = 800;
            height = 600;
        }

        // Inicialitzem l'escena, amb una finestra de width x height
        AppEscena = new Escena(width, height);

        // Iniciem el bucle infinit fins que escriga "quit".
        String figura;

        do {
            // Preguntem la següent figura a emmagatzemar
            System.out.print("# Figura: ");
            String ordre = keyboard.nextLine();

            // Separem l'ordre introduida pel teclat en la forma: "Figura Posicio Mida
            // Color"
            String[] components = ordre.split(" ");

            figura = components[0];

            switch (figura) {
                case "get":
                    // Descarreguem una figura en el format que estem treballant des d'Internet
                    // D'això s'encarrega la classe RemoteManager ja implementada
                    try {
                        // Descarrega una llista de figures
                        String fitxer = components[1];
                        RemoteManager rm = new RemoteManager();

                        ArrayList<String> novesFigures = rm.download(fitxer);
                        AppEscena = new Escena();

                        for (String linia : novesFigures) {
                            // Aci hem de tornar a fer el switch per "desmembrar" la línia
                            String[] items = linia.split(" ");
                            afegeixFigura(items[0], items);
                        }
                    } catch (Exception e) {
                        System.out.println("Excepció en la càrrega del fitxer: ");
                        System.err.println(e);
                    }
                    break;

                case "remotelist":
                    try {
                        // Descarrega l'index de figures del servidor remot
                        RemoteManager rm = new RemoteManager();

                        ArrayList<String> liniaFitxers = rm.download("index.php");
                        String[] fitxers = liniaFitxers.get(0).split("<br/>");

                        for (String fitxer : fitxers) {
                            System.out.println(fitxer);
                        }

                    } catch (Exception e) {
                        System.out.println("Excepció en la càrrega del fitxer: ");
                        System.err.println(e);
                    }

                    break;

                case "list":
                    // Si l'ordre indicada és llista, imprimirem la llista de figures
                    AppEscena.renderText();

                    break;

                case "render":
                    AppEscena.renderScene();
                    break;

                case "quit":
                    System.out.println("Adéu!");
                    System.exit(0);

                default:
                    // Si hem arribat aci, és perque es vol afegir una figura
                    afegeixFigura(figura, components);
            }

        } while (true);
    }

    Color getColor(String color) {
        /*
         * Mètode auxiliar per tal de "traduir" els colors en mode text a la seua
         * representació com a constants en awt.Color
         */

        switch (color) {
            case "roig":
                return Color.RED;
            case "verd":
                return Color.GREEN;
            case "blau":
                return Color.BLUE;
            case "groc":
                return Color.YELLOW;
            case "magenta":
                return Color.MAGENTA;
            case "cyan":
                return Color.CYAN;
            case "blanc":
                return Color.WHITE;
            case "negre":
                return Color.BLACK;
            case "gris":
                return Color.GRAY;
            case "grisClar":
                return Color.LIGHT_GRAY;
            case "grisFosc":
                return Color.DARK_GRAY;
            case "rosa":
                return Color.PINK;
            case "taronja":
                return Color.ORANGE;
            default:
                return Color.BLACK;
        }
    }

    public static void main(String[] args) {
        /*
         * Mètode d'inici de l'aplicació. Creem un nou objecte de tipus Cli, i
         * l'executem amb el mètode run.
         * 
         * Els arguments que li passem seran les dimensions per defecte d'una imatge.
         */

        Cli myCli = new Cli();
        myCli.run(args);
    }
    
    private static void afegeixFigura(String figura, String[] components){
        Cli myCli = new Cli();
        switch(figura){
            case "dimensions":
                    try {
                        AppEscena.setX(Integer.parseInt(components[1]));
                        AppEscena.setY(Integer.parseInt(components[2]));
                    } catch (Exception e) {
                        // Si s'ha produït algun error als paràmetres, s'indica un error de sintaxi
                        System.out.println(
                                "\u001B[31m Error de sintaxi. La sintaxi correcta és:\n dimensions x y\u001B[0m");
                    }
                    break;
            case "rectangle": 
                // Creació d'una figura de la classe cercle
                try {
                    // Extraiem les dimensions
                    int x = Integer.parseInt((components[1]));
                    int y = Integer.parseInt((components[2]));
                    int w = Integer.parseInt((components[3]));
                    int h = Integer.parseInt((components[4]));
                    String color = components[5];

                    // Si tot és correcte creem la figura cercle
                    Rectangle nouRect = new Rectangle(x, y, w, h, myCli.getColor(color));
                    // I l'afegim a la llista
                    AppEscena.add(nouRect);

                } catch (Exception e) {
                    // Si s'ha produït algun error als paràmetres, s'indica un error de sintaxi
                    System.out.println(
                            "\u001B[31m Error de sintaxi. La sintaxi correcta és:\nrectangle x y width height color\u001B[0m");
                }
                ;
                break;
            case "quadrat":
                // Creació d'una figura de la classe quadrat
                try {
                    // Extraiem les dimensions
                    int x = Integer.parseInt((components[1]));
                    int y = Integer.parseInt((components[2]));
                    int s = Integer.parseInt((components[3]));
                    String color = components[4];

                    // Si tot és correcte creem la figura quadrat
                    Quadrat nouQuad = new Quadrat(x, y, s, myCli.getColor(color));
                    // I l'afegim a la llista
                    AppEscena.add(nouQuad);

                } catch (Exception e) {
                    // Si s'ha produït algun error als paràmetres, s'indica un error de sintaxi
                    System.out.println(
                            "\u001B[31m Error de sintaxi. La sintaxi correcta és:\nquadrat x y side color\u001B[0m");
                }
                ;
                break;
            case "ellipse":
                // Creació d'una figura de la classe quadrat
                try {
                    // Extraiem les dimensions
                    int x = Integer.parseInt((components[1]));
                    int y = Integer.parseInt((components[2]));
                    int rx = Integer.parseInt((components[3]));
                    int ry = Integer.parseInt((components[4]));
                    String color = components[5];

                    // Si tot és correcte creem la figura quadrat
                    Elipse nouEli = new Elipse(x, y, rx, ry, myCli.getColor(color));
                    // I l'afegim a la llista
                    AppEscena.add(nouEli);

                } catch (Exception e) {
                    // Si s'ha produït algun error als paràmetres, s'indica un error de sintaxi
                    System.out.println(
                            "\u001B[31m Error de sintaxi. La sintaxi correcta és:\nellipse x y radiX radiY color\u001B[0m");
                }
                ;
                break;

            case "cercle":
                // Creació d'una figura de la classe quadrat
                try {
                    // Extraiem les dimensions
                    int x = Integer.parseInt((components[1]));
                    int y = Integer.parseInt((components[2]));
                    int r = Integer.parseInt((components[3]));
                    String color = components[4];

                    // Si tot és correcte creem la figura quadrat
                    Cercle nouCer = new Cercle(x, y, r, myCli.getColor(color));
                    // I l'afegim a la llista
                    AppEscena.add(nouCer);

                } catch (Exception e) {
                    // Si s'ha produït algun error als paràmetres, s'indica un error de sintaxi
                    System.out.println(
                            "\u001B[31m Error de sintaxi. La sintaxi correcta és:\ncercle x y radi color\u001B[0m");
                }
                ;
                break;

            case "linia":
                // Creació d'una figura de la classe quadrat
                try {
                    // Extraiem les dimensions
                    int x = Integer.parseInt((components[1]));
                    int y = Integer.parseInt((components[2]));
                    int x2 = Integer.parseInt((components[3]));
                    int y2 = Integer.parseInt((components[4]));

                    // Si tot és correcte creem la figura quadrat
                    Linia nouLin = new Linia(x, y, x2, y2);
                    // I l'afegim a la llista
                    AppEscena.add(nouLin);

                } catch (Exception e) {
                    // Si s'ha produït algun error als paràmetres, s'indica un error de sintaxi
                    System.out.println(
                            "\u001B[31m Error de sintaxi. La sintaxi correcta és:\nlinia x y x2 y2\u001B[0m");
                }
                ;
                break;
            default:
                System.out.println("\u001B[31m Figura no reconeguda \u001B[0m");
        }
    }

}