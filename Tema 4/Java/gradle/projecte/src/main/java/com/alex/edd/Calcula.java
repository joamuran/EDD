package com.alex.edd;

import com.alex.edd.Calculadora;

/**
 * @version 13.03.2020
 * @author alex
 */
public class Calcula {
    private static float operand1;
    private static float operand2;

    /**
     * Funció main en la que calculará els dos arguments que li pasarem al executar
     * @param args 
     */
    public static void main(String[] args) {
        
        /**
         * Comprovem que es pasen exactament 2 arguments
         */
        if (args.length != 2) {
            System.out.println("\nSintaxi incorrecta. Necessite dos números.");
            System.exit(-1);
        }

        /**
         * Convertim els operands a float
         */
        operand1=Float.parseFloat(args[0]);
        operand2=Float.parseFloat(args[1]);

        /**
         * Instanciem un objecte de la classe Calculadora
         */
        Calculadora myCalc=new Calculadora();
        
        /**
         * Imprimim per pantalla el resultat de les operacions.
         */
        System.out.println("La suma entre "+operand1+" i "+operand2+" és "+myCalc.suma(operand1, operand2));
        System.out.println("La resta entre "+operand1+" i "+operand2+" és "+myCalc.resta(operand1, operand2));
        System.out.println("La multiplicació entre "+operand1+" i "+operand2+" és "+myCalc.multiplica(operand1, operand2));
        System.out.println("La divisió entre "+operand1+" i "+operand2+" és "+myCalc.divideix(operand1, operand2));
        System.out.println("¿És "+operand1+" major qué "+operand2+"? "+myCalc.majorQue(operand1, operand2));
        System.out.println("La mitjana entre "+operand1+" i "+operand2+" és: "+myCalc.mitjana(operand1, operand2));
        System.out.println("El número "+operand1+(myCalc.esPrim(operand1) ? " " : " NO ")+"és prim");
        System.out.println("El número prim següent de "+operand1+" és "+myCalc.proximPrim(operand1));
        System.out.println("Última operació realitzada: "+myCalc.getLastOp()+"; Últim resultat: "+myCalc.getLastResult());
    }
}
