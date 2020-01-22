# Java amb Maven

## Instal.lació

Primer que tot comprovarem si tenim instal.lat l'eina `maven`

```console
maven:
  Instalados: 3.6.0-1~18.04.1
  Candidato:  3.6.0-1~18.04.1
  Tabla de versión:
 *** 3.6.0-1~18.04.1 500
        500 http://es.archive.ubuntu.com/ubuntu bionic-updates/universe amd64 Packages
        500 http://es.archive.ubuntu.com/ubuntu bionic-updates/universe i386 Packages
        500 http://security.ubuntu.com/ubuntu bionic-security/universe amd64 Packages
        500 http://security.ubuntu.com/ubuntu bionic-security/universe i386 Packages
        100 /var/lib/dpkg/status
     3.5.2-2 500
        500 http://es.archive.ubuntu.com/ubuntu bionic/universe amd64 Packages
        500 http://es.archive.ubuntu.com/ubuntu bionic/universe i386 Packages
```

En el meu cas sí, aixi que no cal fer res més. En cas de no tindre-lo instal.lat executarem l'odre `sudo apt install maven`

## Creació del projecte

Executarem el comandament 

```console
$ mvn archetype:generate -DgroupId=com.edd.alex -DartifactId=CalculadoraMVN -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

On l'indiquem el grup que serà `com.edd.alex` el nom del projecte que serà `CalculadoraMVN` i el tipus d'artifacte que és el per defecte que crearà un *Hello World*\

Una vegada acabada l'execució, apareixerà algo semblant a:

```console
[INFO] ----------------------------------------------------------------------------
[INFO] Using following parameters for creating project from Old (1.x) Archetype: maven-archetype-quickstart:1.0
[INFO] ----------------------------------------------------------------------------
[INFO] Parameter: basedir, Value: /home/alex/Escritorio/DAM/Entorn de desenvolupament/EDD/Tema 4/Java/maven/projecte
[INFO] Parameter: package, Value: com.edd.alex
[INFO] Parameter: groupId, Value: com.edd.alex
[INFO] Parameter: artifactId, Value: CalculadoraMVN
[INFO] Parameter: packageName, Value: com.edd.alex
[INFO] Parameter: version, Value: 1.0-SNAPSHOT
[INFO] project created from Old (1.x) Archetype in dir: /home/alex/Escritorio/DAM/Entorn de desenvolupament/EDD/Tema 4/Java/maven/projecte/CalculadoraMVN
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  02:35 min
[INFO] Finished at: 2020-01-22T17:07:01+01:00
[INFO] ------------------------------------------------------------------------
```

Per a observar que tot s'ha executat correctament executarem el comando `tree`

```console
$ tree
.
└── CalculadoraMVN
    ├── pom.xml
    └── src
        ├── main
        │   └── java
        │       └── com
        │           └── edd
        │               └── alex
        │                   └── App.java
        └── test
            └── java
                └── com
                    └── edd
                        └── alex
                            └── AppTest.java

12 directories, 3 files
```

Com veiem ens ha generat l'arxiu `pom.xml` el qual hi ha que introduïr algo més per a que quede de la següent forma:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.edd.alex</groupId>
  <artifactId>CalculadoraMVN</artifactId>
  <packaging>jar</packaging>
  <version>1.0-SNAPSHOT</version>
  <name>CalculadoraMVN</name>
  <url>http://maven.apache.org</url>

   <!-- Aço és el que afegim d'extra -->
  <properties>
    <maven.compiler.source>1.6</maven.compiler.source>
    <maven.compiler.target>1.6</maven.compiler.target>
  </properties>
   <!-- Fins açi -->

  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
</project>
```

Com hem vist abanç, també ens ha creat un arxiu que s'anomena `App.java`. Ahí està el *Hola Món* que hem creat, però l'editarem per a crear el nostre programa de la calculadora.\

Com que ja haviem creat els dos arxius java per a fer el mateix amb l'eina `ant` sols tindrem que copiar els `.java`\

**Hem de tindre molt en compter que hem de canviar el següent:**

```java
package com.edd.alex;

import com.edd.alex.Calculadora;
```

Al canviar l'estructura d'arxius, hem d'editar-ho en el codi font.\

Una vegada fet aço, hem de compilar-ho. Ens coloquem en l'arrel del projecte (on està el `pom.xml`) i executem la següent ordre per a compilar:

```console
$ mvn compile
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 2 source files to /home/alex/Escritorio/DAM/Entorn de desenvolupament/EDD/Tema 4/Java/maven/projecte/CalculadoraMVN/target/classes
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  01:14 min
[INFO] Finished at: 2020-01-22T17:22:45+01:00
[INFO] ------------------------------------------------------------------------
```

Ara per a veure que s'ha generat tot bé executarem `tree target`

```console
target
├── classes
│   └── com
│       └── edd
│           └── alex
│               ├── Calcula.class
│               └── Calculadora.class
├── generated-sources
│   └── annotations
└── maven-status
    └── maven-compiler-plugin
        └── compile
            └── default-compile
                ├── createdFiles.lst
                └── inputFiles.lst

10 directories, 4 files
```

Una vegada tenim aço creat i si seguim en el directori arrel del projecte, hem d'executar l'interpret de java però cal indicar-li el path també amb l'opció `-cp` de la següent manera:

```console
$ java -cp target/classes com.edd.alex.Calcula 2 3
La suma entre 2.0 i 3.0 és 5.0
La resta entre 2.0 i 3.0 és -1.0
La multiplicació entre 2.0 i 3.0 és 6.0
La divisió entre 2.0 i 3.0 és 0.6666667
¿És 2.0 major qué 3.0? false
La mitjana entre 2.0 i 3.0 és: 2.5
Última operació realitzada: Mitjana; Últim resultat: 2.5
```

Si ara el que volem és netejar el projecte, farem el següent:

```console
$ mvn clean
[INFO] Deleting /home/alex/Escritorio/DAM/Entorn de desenvolupament/EDD/Tema 4/Java/maven/projecte/CalculadoraMVN/target
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  4.510 s
[INFO] Finished at: 2020-01-22T17:28:52+01:00
[INFO] ------------------------------------------------------------------------
```
I si executem `tree` veurem que s'ha esborrat tot.

```console
$ tree
.
├── java
├── pom.xml
└── src
    ├── main
    │   └── java
    │       └── com
    │           └── edd
    │               └── alex
    │                   ├── Calculadora.java
    │                   └── Calcula.java
    └── test
        └── java
            └── com
                └── edd
                    └── alex
                        └── AppTest.java

11 directories, 5 files
```

Una vegada netejat, el que farem serà empaquetar el projecte.

```console
$ mvn package
[INFO] Building jar: /home/alex/Escritorio/DAM/Entorn de desenvolupament/EDD/Tema 4/Java/maven/projecte/CalculadoraMVN/target/CalculadoraMVN-1.0-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  15.196 s
[INFO] Finished at: 2020-01-22T17:51:28+01:00
[INFO] ------------------------------------------------------------------------
```

Ara estarà tot empaquetat en el jar `CalculadoraMVN-1.0-SNAPSHOT.jar` i per tal d'executar el programa sols caldrà fer el següent:

```console
$ java -cp target/CalculadoraMVN-1.0-SNAPSHOT.jar com.edd.alex.Calcula 1 4
La suma entre 1.0 i 4.0 és 5.0
La resta entre 1.0 i 4.0 és -3.0
La multiplicació entre 1.0 i 4.0 és 4.0
La divisió entre 1.0 i 4.0 és 0.25
¿És 1.0 major qué 4.0? false
La mitjana entre 1.0 i 4.0 és: 2.5
Última operació realitzada: Mitjana; Últim resultat: 2.5
```
