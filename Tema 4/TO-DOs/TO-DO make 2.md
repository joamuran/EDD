# TO-DO make. Activitat 2

## Creeu i compileu el primer programa de la calculadora per verificar que funciona

```c
#include <stdio.h>

int suma(int x, int y){
    return(x+y);
}

int resta(int x, int y){
    return(x-y);
}

int multiplica(int x, int y){
    return(x*y);
}

int divideix(int x, int y){
    return (x/y);
}

int main(){
    int a=15;
    int b=5;

    printf("La suma de %d i %d és %d\n", a, b, suma(a,b));
    printf("La resta de %d i %d és %d\n", a, b, resta(a,b));
    printf("La multiplicació de %d i %d és %d\n", a, b, multiplica(a,b));
    printf("La divisió de %d i %d és %d\n", a, b, divideix(a,b));
}
```

Ho compilarem amb `gcc prova1.c -o prova1`

```bash
$ ./prova1

La suma de 15 i 5 és 20
La resta de 15 i 5 és 10
La multiplicació de 15 i 5 és 75
La divisió de 15 i 5 és 3
```

## Afegiu una nova funció que es diga *major*, i que retonrarà quin dels dos números és major

```c
[...]
int major (int x, int y){
    if (x > y){
        return x;
    }
    else{
        if (y > x){
            return y;
        }
        else{
            return printf("Son iguals");
        }
    }
}

[...]

printf("El major número entre %d i %d és %d\n", a, b, major(a,b));
```

Quan estiga editat, utilitzarem `make prova1`

```bash
$ ./prova1

La suma de 15 i 5 és 20
La resta de 15 i 5 és 10
La multiplicació de 15 i 5 és 75
La divisió de 15 i 5 és 3
El major número entre 15 i 5 és 15
```


## Una vegada comprovat el funcionament, feu el mateix amb el segon exemple, afegint les modificacions corresponents a cada fitxer

Aquest será l'arxiu `calculadora.c`:

```c
int suma(int x, int y){
    return(x+y);
}

int resta(int x, int y){
    return(x-y);
}

int multiplica(int x, int y){
    retunr(x*y);
}

int divideix(int x, int y){
    return (x/y);
}

int major (int x, int y){
    if (x > y){
        return x;
    }
    else{
        if (y > x){
            return y;
        }
        else{
            return printf("Son iguals");
        }
    }
}
```

I aquest el fitxer `calculadora.h`:

```c
#ifndef CALCULADORA
#define CALCULADORA

int suma(int x, int y);
int resta(int x, int y);
int multiplica(int x, int y);
int divideix(int x, int y);
int resta(int x, int y);

#endif
```

## Compileu el segon exemple i verifiqueu que tot funciona correctament

Començarem compilant el primer fitxer que és el `calculadora.c`. Per a això farem `gcc -c calculadora.c -o calculadora.o`\
En aquest cas hem introduït l'opció `-c` per a que no execute el linker ja que és necessari en el cas de les llibreríes per a que no busque enllaçar la funció main.