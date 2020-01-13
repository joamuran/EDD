# TO-DO Ant amb XML

Primer que tot crearem el noste `build.xml` estructurat de la següent forma:

```xml
<project>
    <target name="neteja">
        <delete dir="classes" />
    </target>

    <target name="compila" depends="neteja">
        <mkdir dir="classes" />
    <javac includeantruntime="false" srcdir="com/alex/edd/calc" destdir="classes" />
    </target>

    <target name="executa" depends="compila">
        <java classpath="classes" classname="com.alex.edd.calc.Calcula">
            <arg value="${arg0}"/>
            <arg value="${arg1}"/>
        </java>
    </target>
</project>
```

Despres sols tindrem que executar uns cuants comandaments per a q faça el que necessitem.

Utilitzarem `ant compila` per a que ens compile el codi i neteje el directori "classes"

```bash
$ ant compila

Buildfile: /home/alex/Escritorio/DAM/Entorn de desenvolupament/EDD/Tema 4/TO-DOs/TO-DOs Java - Ant/Codis font/build.xml

neteja:
   [delete] Deleting directory /home/alex/Escritorio/DAM/Entorn de desenvolupament/EDD/Tema 4/TO-DOs/TO-DOs Java - Ant/Codis font/classes

compila:
    [mkdir] Created dir: /home/alex/Escritorio/DAM/Entorn de desenvolupament/EDD/Tema 4/TO-DOs/TO-DOs Java - Ant/Codis font/classes
    [javac] Compiling 2 source files to /home/alex/Escritorio/DAM/Entorn de desenvolupament/EDD/Tema 4/TO-DOs/TO-DOs Java - Ant/Codis font/classes

BUILD SUCCESSFUL
Total time: 0 seconds
```

Ara utilitzarem `ant executa -Darg0=3 -Darg0=5` per a executar la nostra calculadora amb els dos numeros que enviarem que serà 3 i 5.

```bash
$ ant executa -Darg0=3 -Darg0=5

Buildfile: /home/alex/Escritorio/DAM/Entorn de desenvolupament/EDD/Tema 4/TO-DOs/TO-DOs Java - Ant/Codis font/build.xml

neteja:
   [delete] Deleting directory /home/alex/Escritorio/DAM/Entorn de desenvolupament/EDD/Tema 4/TO-DOs/TO-DOs Java - Ant/Codis font/classes

compila:
    [mkdir] Created dir: /home/alex/Escritorio/DAM/Entorn de desenvolupament/EDD/Tema 4/TO-DOs/TO-DOs Java - Ant/Codis font/classes
    [javac] Compiling 2 source files to /home/alex/Escritorio/DAM/Entorn de desenvolupament/EDD/Tema 4/TO-DOs/TO-DOs Java - Ant/Codis font/classes

executa:
     [java] La suma entre 3.0 i 5.0 és 8.0
     [java] La resta entre 3.0 i 5.0 és -2.0
     [java] La multiplicació entre 3.0 i 5.0 és 15.0
     [java] La divisió entre 3.0 i 5.0 és 0.6
     [java] ¿És 3.0 major qué 5.0? false
     [java] Última operació realitzada: Comparació major que; Últim resultat: 0.6

BUILD SUCCESSFUL
Total time: 0 seconds
```
