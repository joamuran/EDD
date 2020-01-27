# Java amb Gradle

## Instal.lació

Per a instal.lar-lo farem un `apt-get update && apt-get install gradle` i ja està. Una vegada descarregat podem mostrar la versió amb l'ordre `gradle -v`

```console
$ gradle -v
------------------------------------------------------------
Gradle 5.1
------------------------------------------------------------

Build time:   2019-01-02 18:57:47 UTC
Revision:     d09c2e354576ac41078c322815cc6db2b66d976e

Kotlin DSL:   1.1.0
Kotlin:       1.3.11
Groovy:       2.5.4
Ant:          Apache Ant(TM) version 1.9.13 compiled on July 10 2018
JVM:          11.0.5 (Private Build 11.0.5+10-post-Ubuntu-0ubuntu1.118.04)
OS:           Linux 5.3.0-26-generic amd64
```

## Creació del projecte

Per a crear el projecte anirem al directori on volem començar el projecte i escriurem l'ordre `gradle init`. Aquest ordre el que farà serà d'interpret i nosaltres anirem ficant les opciones que volem.

```console
$ gradle init
Starting a Gradle Daemon (subsequent builds will be faster)

Select type of project to generate:
  1: basic
  2: groovy-application
  3: groovy-library
  4: java-application
  5: java-library
  6: kotlin-application
  7: kotlin-library
  8: scala-library
Enter selection (default: basic) [1..8] 4

Select build script DSL:
  1: groovy
  2: kotlin
Enter selection (default: groovy) [1..2] 1

Select test framework:
  1: junit
  2: testng
  3: spock
Enter selection (default: junit) [1..3] 1

Project name (default: projecte): calculadora
Source package (default: calculadora): com.alex.edd

BUILD SUCCESSFUL in 2m 25s
2 actionable tasks: 2 executed
```

Ara executem l'ordre `tree` i comprovarem l'estructura de directoris que s'han creat.

```console
.
├── build.gradle
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── settings.gradle
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── alex
    │   │           └── edd
    │   │               └── App.java
    │   └── resources
    └── test
        ├── java
        │   └── com
        │       └── alex
        │           └── edd
        │               └── AppTest.java
        └── resources

15 directories, 8 files
```

Ara el que farem serà eliminar l'arxiu `App.java` i afegir els nostres codis font. (o editar-lo). Al final quedarà el següent:

```console
projecte$ tree
.
...
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── alex
    │   │           └── edd
    │   │               ├── Calculadora.java
    │   │               └── Calcula.java
    │   └── resources
...
```

Una vegada fet aço, accedirem al fitxer `build.gradle` per a canviar alguna coseta de la configuració, aixi com incloure una nova dependència.

```gradle
plugins {
    id 'java'
    id 'application'
}

repositories {
    jcenter()
}

dependencies {
    implementation 'com.google.guava:guava:26.0-jre'
    testImplementation 'junit:junit:4.12'
}

mainClassName = 'com.alex.edd.Calcula'
```

Com veiem, ja de primeres, hem editat el `mainClassName` ja que abans ficava `com.alex.edd.App` i ara la nostra classe amb el main és el de Calcula.\

### Afegir repositoris

Una vegada hem editat la `mainClassName` també volem afegir algún repositori que després implementarem en el nostre codi font. Per a aço, hem d'anar a la linia on fica `repositories` i hem d'afegir també el repositori de Maven Central que és d'ona agafarem la dependencia de matemàtiques.\
Al final ens ha de quedar de la següent forma:

```gradle
...
repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation 'com.google.guava:guava:26.0-jre'
    testImplementation 'junit:junit:4.12'
    // https://mvnrepository.com/artifact/org.apache.commons/commons-math3
    compile group: 'org.apache.commons', name: 'commons-math3', version: '3.6.1'
}
...
```

Una vegada fet aço, afegirem les noves funcions de la nova llibreria de matemàtiques que es descarregarà gradle per a l'execució de la nostra calculadora.\
Al fitxer de `Calculadora.java` li afegirem les següents linies:

```java
...
import org.apache.commons.math3.primes.Primes;
...
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
...
```

I al nostre main li afegirem aquestes altres línies:

```java
...
        System.out.println("El número "+operand1+(myCalc.esPrim(operand1) ? " " : " NO ")+"és prim");
        System.out.println("El número prim següent de "+operand1+" és "+myCalc.proximPrim(operand1));
...
```

Una vegada tingam completada la nostra calculadora i hem afegit els nous métodes, es hora de construir el projecte. Per a això utilitzarem `gradle build`

```console
$ gradle build
BUILD SUCCESSFUL in 1s
5 actionable tasks: 5 executed
```

Ara que ja tenim el projecte construït, veurem si tot lo nou creat amb `tree`

```console
$ tree
.
├── build
│   ├── classes
│   │   └── java
│   │       └── main
│   │           └── com
│   │               └── alex
│   │                   └── edd
│   │                       ├── Calcula.class
│   │                       └── Calculadora.class
│   ├── distributions
│   │   ├── calculadora.tar
│   │   └── calculadora.zip
│   ├── libs
│   │   └── calculadora.jar
│   ├── scripts
│   │   ├── calculadora
│   │   └── calculadora.bat
│   └── tmp
│       ├── compileJava
│       └── jar
│           └── MANIFEST.MF
├── build.gradle
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── settings.gradle
└── src
    └── main
        ├── java
        │   └── com
        │       └── alex
        │           └── edd
        │               ├── Calculadora.java
        │               └── Calcula.java
        └── resources

22 directories, 16 files
```

I aixi tenim tot el nostre directori de treball.\
Per tal d'executar el nostre programa és tan fàcil com escriure l'ordre `gradle run` però com necessitem 2 arguments, ho farem de la següent forma:

```console
$ gradle run --args "7 10"
> Task :run
La suma entre 7.0 i 10.0 és 17.0
La resta entre 7.0 i 10.0 és -3.0
La multiplicació entre 7.0 i 10.0 és 70.0
La divisió entre 7.0 i 10.0 és 0.7
¿És 7.0 major qué 10.0? false
La mitjana entre 7.0 i 10.0 és: 8.5
El número 7.0 és prim
El número prim següent de 7.0 és 7
Última operació realitzada: Proxim número primer; Últim resultat: 7.0

BUILD SUCCESSFUL in 0s
2 actionable tasks: 1 executed, 1 up-to-date
```

Per últim, per a netejar tots els directoris que s'han creat per a executar el nostre projecte, es tan fàcil com execturar l'ordre `gradle clean`

```console
$ gradle clean
BUILD SUCCESSFUL in 0s
1 actionable task: 1 executed

$ tree
.
├── build.gradle
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── settings.gradle
└── src
    └── main
        ├── java
        │   └── com
        │       └── alex
        │           └── edd
        │               ├── Calculadora.java
        │               └── Calcula.java
        └── resources

9 directories, 8 files
```

I com veiem, tot ha tornat a com estava al crear el projecte.
