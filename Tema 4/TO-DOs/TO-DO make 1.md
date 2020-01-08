# TO-DO make. Activitat 1.

## Proveu a llançar les ordres anteriors sobre el fitxer `hola.c`

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

int main(){
    int a=15;
    int b=5;

    printf("La suma de %d i %d és %d\n", a, b, suma(a,b));
    printf("La resta de %d i %d és %d\n", a, b, resta(a,b));
    printf("La multiplicació de %d i %d és %d\n", a, b, multiplica(a,b));
    printf("La divisió de %d i %d és %d\n", a, b, divideix(a,b));
}
```
## Comproveu el resultat executant els fitxers compilats

```bash
$ make hola

cc hola.c -o hola

$ ./hola

La suma de 15 i 5 és 20
La resta de 15 i 5 és 10
La multiplicació de 15 i 5 és 75
La divisió de 15 i 5 és 3
```
