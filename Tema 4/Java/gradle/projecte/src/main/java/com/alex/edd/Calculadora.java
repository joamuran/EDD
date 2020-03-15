package com.alex.edd;

import org.apache.commons.math3.primes.Primes;


/**
 * @version 13.03.2020
 * @author alex
 */
public class Calculadora {

    private float lastResult;
    private String lastOp;

    /**
     * Aques és el getter del últim resultat.
     * @return Ultim resultat
     */
    public float getLastResult(){
        return this.lastResult;
    }

    /**
     * Getter de l'última operació feta
     * @return Ultima operació
     */
    public String getLastOp(){
        return this.lastOp;
    }

    /**
     * Funció de suma
     * @param op1
     * @param op2
     * @return Resultat de la suma dels paràmetres que li pasem
     */
    public float suma(float op1, float op2){
        float result=op1+op2;
        this.lastResult=result;
        this.lastOp="Suma";

        return result;
    }

    /**
     * Funció de resta
     * @param op1
     * @param op2
     * @return Resultat de la resta dels paràmetres que li pasem
     */
    public float resta(float op1, float op2){
        float result=op1-op2;
        this.lastResult=result;
        this.lastOp="Resta";

        return result;
    }

    /**
     * Funció de multiplicació
     * @param op1
     * @param op2
     * @return Resultat de la multiplicació del primer operador que li pasem per el segon
     */
    public float multiplica(float op1, float op2){
        // Fem els càlculs
        float result=op1*op2;

        // Actualitzem els atributs de la classe
        this.lastResult=result;
        this.lastOp="Multiplica";

        // I finalment retornem els resultats
        return result;
    }

    /**
     * Funció de divisió
     * @param op1
     * @param op2
     * @return Resultat de la divisió del primer operador que li pasem per el segon
     */
    public float divideix(float op1, float op2){
        // Fem els càlculs
        float result=op1/op2;

        // Actualitzem els atributs de la classe
        this.lastResult=result;
        this.lastOp="Divideix";

        // I finalment retornem els resultats
        return result;
    }

    /**
     * Funció booleana de num major que num
     * @param op1
     * @param op2
     * @return True si el primer número és major que el segon, false si és menor o igual
     */
    public boolean majorQue(float op1, float op2){
        boolean result;
        // Fem els càlculs
        if (op1 > op2){
            result = true;
        }
        else{
            result = false;
        }

        // Actualitzem els atributs de la classe
        this.lastOp="Comparació major que";
        
        return result;
    }

    /**
     * Funció de mitjana 
     * @param op1
     * @param op2
     * @return La mitja en float dels dos numeros que li pasem
     */
    public float mitjana(float op1, float op2){
        float result;
        // Fem els càlculs:
        result = (op1+op2)/2;

        // Actualitzem els atributs de la classe
        this.lastResult=result;
        this.lastOp="Mitjana";

        // Retornem el resultat
        return result;
    }

    /**
     * Funció esPrim
     * @param op1
     * @return Comprova si el numero passat és prim o no
     */
    public boolean esPrim(float op1){
        this.lastOp="Comprovació de número primer";
        
        return Primes.isPrime((int)op1); // Retorna true si és prim i false si no ho és.
    }

    /**
     * Funció proximPrim
     * @param op1
     * @return El próxim número prim a partir del que li pasem
     */
    public int proximPrim(float op1){
        int result;
        result = Primes.nextPrime((int)op1); // Retornarà el pròxim numero prim. Si el mateix num és prim, retorna el mateix num.
        this.lastResult=result;
        this.lastOp="Proxim número primer";
        return result;
    }
}