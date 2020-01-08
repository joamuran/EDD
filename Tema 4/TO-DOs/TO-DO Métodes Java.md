# TO-DO Funcions/Métodes Java

El primer que hem de fer es crear l'estructura de carpetes que en el meu cas serà `com/alex/edd/calc` i despres crearem els arxius font `Calcula.java` i `Calculadora.java`\
\
El nostre arxiu `Calculadora.java` deuría estar de la següent forma (Amb el métode "majorQue" afegit):

```java
package com.alex.edd.calc;

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

    public float majorQue(float op1, float op2){
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
    }

}
```

I l'arxiu `Calcula.java` de la següent forma:

```java
package com.alex.edd.calc;

import com.alex.edd.calc.Calculadora;

public class Calcula {
    private static float operand1;
    private static float operand2;

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("\nSintaxi incorrecta. Necessite dos números.");
            System.exit(-1);
        }

        operand1=Float.parseFloat(args[0]);
        operand2=Float.parseFloat(args[1]);

        Calculadora myCalc=new Calculadora();

        System.out.println("La suma entre "+operand1+" i "+operand2+" és "+myCalc.suma(operand1, operand2));
        System.out.println("La resta entre "+operand1+" i "+operand2+" és "+myCalc.resta(operand1, operand2));
        System.out.println("La multiplicació entre "+operand1+" i "+operand2+" és "+myCalc.multiplica(operand1, operand2));
        System.out.println("La divisió entre "+operand1+" i "+operand2+" és "+myCalc.divideix(operand1, operand2));
        System.out.println("¿És "+operand1+" major qué "+operand2+"? "+myCalc.majorQue(operand1, operand2));
        System.out.println("Última operació realitzada: "+myCalc.getLastOp()+" | Últim resultat no lógic: "+myCalc.getLastResult());
    }
}
```
Una vegada ho tingam tot implementat, sols cal que executem el compilador de Java en l'arxiu de `Calcula.java`i compilarà els dos per igual amb l'ordre `javac com/alex/edd/calc/Calcula.java` i ja tindriem creat els dos `.class`\
Per a executar la nostra calculadora farem el seguent (desde la carpeta on tenim `com`): 

```bash
$ java com.alex.edd.calc.Calculadora 3 2
La suma entre 3.0 i 2.0 és 5.0
La resta entre 3.0 i 2.0 és 1.0
La multiplicació entre 3.0 i 2.0 és 6.0
La divisió entre 3.0 i 2.0 és 1.5
¿És 3.0 major qué 2.0? true
Última operació realitzada: Comparació major que; Últim resultat: 1.5
```
