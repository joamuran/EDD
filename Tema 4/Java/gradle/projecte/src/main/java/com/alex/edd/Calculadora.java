package com.alex.edd;

import org.apache.commons.math3.primes.Primes;

public class Calculadora {

    private float lastResult;
    private String lastOp;

    public float getLastResult(){
        return this.lastResult;
    }

    public String getLastOp(){
        return this.lastOp;
    }

    public float suma(float op1, float op2){
        float result=op1+op2;
        this.lastResult=result;
        this.lastOp="Suma";

        return result;
    }

    public float resta(float op1, float op2){
        float result=op1-op2;
        this.lastResult=result;
        this.lastOp="Resta";

        return result;
    }

    public float multiplica(float op1, float op2){
        // Fem els càlculs
        float result=op1*op2;

        // Actualitzem els atributs de la classe
        this.lastResult=result;
        this.lastOp="Multiplica";

        // I finalment retornem els resultats
        return result;
    }

    public float divideix(float op1, float op2){
        // Fem els càlculs
        float result=op1/op2;

        // Actualitzem els atributs de la classe
        this.lastResult=result;
        this.lastOp="Divideix";

        // I finalment retornem els resultats
        return result;
    }

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

    public Boolean esPrim(float op1){
        this.lastOp="Comprovació de número primer";
        
        return Primes.isPrime((int)op1); // Retorna true si és prim i false si no ho és.
    }

    public int proximPrim(float op1){
        int result;
        result = Primes.nextPrime((int)op1); // Retornarà el pròxim numero prim. Si el mateix num és prim, retorna el mateix num.
        this.lastResult=result;
        this.lastOp="Proxim número primer";
        return result;
    }
}