# Exercicis d'evaluació unitat 1

## Activitat 1. Llenguatges de programació.

 **1. Investiga sobre els deu llenguatges més utilitzats segons Octoverse, i feu una xicoteta descripció d'ells, indicant en quines de les categories esmentades a l'unitat es classificarien cadascun.**
 
 Cada llenguatge està ordenat de més utilitzat a menys

| Característica | Descripció del primer llenguatge | Descripció del segon llenguatge| Descripció del tercer llenguatge | Descripció del cuart lleguantge | Descripció del quint llenguatge | Descripció del sext llenguatge | Descripció del séptim llenguatge | Descripció del octau llenguatge | Descripció del nové llenguatge | Descripció del décim llenguatge |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| Llenguatge | Javascript | Java | Python | PHP | C++ | C# | TypeScript | Shell | C | Ruby | 
|Nivell d'abstracció | Alt | Alt | Alt | Alt | Alt | Alt | Alt | Alt | Alt i mitjà | Alit
| Propòsit | Script | General | General | General | General | General | Script | Script | General | General | General
| Generació | 3GL | 3GL | 3GL | 3GL | 3GL | 3GL | 3GL | 3GL | 3GL | 3GL
|Forma d'execució | Interpretat | Compilat i interpretat | Interpretat | Interpretat | Compilat | Compilat | Compilat | Interpretat | Compilat | Compilat
|Com planteja els problemes | Imperatiu | Imperatiu | Imperatiu | Imperatiu | Imperatiu | Imperatiu | Imperatiu | Imperatiu | Imperatiu | Imperatiu
| Paradigma | Orientat a objectes | Orientat a objectes | Orientat a objectes i Funcional | Procedural, Orientat a objectes i Funcional | Orientada a objectes i Procedural | Orientat a objectes i  Funcional | Orientat a objectes i Funcional | Funcional | Procedural | Procedural, funcional i orientat a objectes |
|Lloc habitual d'execució | Client | Client | Client | Servidor | Client | Client | Client | Client i servidor | Client | Client

## Exercici 2. Aplicacions multiplataforma

**Investigeu sobre algunes de les següents aplicacions multiplataforma, feu una xicoteta descripció i esbrineu en quin llenguatge de programació están desenvolupades.**

* LibreOffice

    LibreOffice és un paquet ofimàtic lliure i de codi obert.
    Disposa d'un processador de text, un editor de fulls de càlcul, un creador de presentacions, un gestor de base de dades, un editor de gràfics vectorials i un editor de fórmules matemàtiques.

    Està escrit en els llenguatges **C++, XML i Java**

* Mozilla Firefox

    És un navegador web lliure amb l'objectiu de ser un navegador més petit, lleuger i ràpid mitjançant l'extracció i redisseny del component de navegador de la suite de programari Mozilla. Utilitza el motor Gecko per a renderitzar pàgines web.
    
    Està escrit en **C, C++, JavaScript, CSS, XML Rust i XUL**.

* GIMP

    És una aplicació per al tractament d'imatges creat per voluntaris i distribuît sota la llicència GPL. La primera versió es va desenvolupar en sistemes Unix i va ser pensada especialment per GNU/Linux. 
    
    Està escrit unicament amb **C**

* Plucker

    És un lector de documents multiplataforma lliure, sota llicència GNU. També inclou una sèrie d'eines per a transferir i comprimir pàgines web i altres documents de text o de marca a un dispositiu Palm per a la seva lectura.
    
    Està escriut unicament amb **Python**

* Skype

	És una xarxa de telefonía per internet. El codi i protocol de Skype són tancats i protegits.

	Està escrit en **Delphi, Objective-C, C++, Object Pascal i JavaScript**

* Opera

	És un navegador d'internet. Es distribueix gratuïtament des de la versió 8.50 tot i que anteriorment havia estat de pagament.

	Està escrit unicament en **C++**

## Exercici 3. Compilació i execució de codi.

```python
# Hola mon des de Python

print("Hola a tots! Em diuen Àlex Vidal i estudie 1r de DAM!")
```

Per a executar aquest codi el que hem de fer es tindre qualsevol versió de Python instalada, obrir la terminal i executar ```python hola.py```.

```javascript
// Hola mon des de nodejs/javascript

console.log("Hola a tots! Em diuen Àlex Vidal i estudie 1r de DAM!")
```

Per a executar aquest codi hem de fer el mateix que amb python però aquesta vegada necesitem tindre instalat nodejs i executar ```nodejs hola.js```.

```C
/* Hola mon des de C */

#include <stdio.h>

int main(void)
{
	printf("Hola a tots! Em diuen Àlex Vidal i estudie 1r de DAM!");
}
```

Per a executar aquest codi necessitem compilar-lo, per a aço, instalarem el compilador de C que s'anomena gcc. Una vegada instalat executarem ```gcc hola.c -o hola``` (El -o hola no es necessari, sols es per a indicar-li el nom que volem, però podem deixar-lo en blanc i ens genera un arxiu que s'anomeraría hola.out.). Una vegada compilat tindrem un arxiu executable anomenat "hola". Escrivim ```./hola``` i s'executarà.

```java
// Hola mon des de Java

class HolaMon {
	static public void main ( String args [] ) {
		System.out.println( "Hola a tots! Em diuen Àlex Vidal i estudie 1r de DAM!" );
}
}
```

Este codi es mes difícil d'executar ja que java ha de ser compilat i interpretat. Per a aço necessitarem el compilador de Java. Una vegada el tingam executarem ```javac hola.java```. Al compilar-lo ens generarà un arxiu anomenat ```HolaMon.class``` este arxiu no es executable sino que ha de ser interpretat per java. Per a aço escriurem ```java HolaMon``` i s'executarà.
