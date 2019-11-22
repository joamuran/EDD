# Exercici. Realitzar les següents operacions amb rcs:

**Creeu un fitxer anomenat ```exercici.md```, i afegiu-li algun contingut en format Markdown**\

```bash
$ nano exercici.md

# Exercici
*Hola* en cursiva.\
**Hola** en negreta.
```

**Registreu el fitxer per a que el controle RCS.**\

```bash
$ ci - u exercici.md

exercici.md,v  <--  exercici.md
enter description, terminated with single '.' or end of file:
NOTE: This is NOT the log message!
>> Primera modificació
>> .
initial revision: 1.1
done
```

**Intenteu modificar el fitxer, per veure si teniu o no permís.**

```bash
$ echo "Hola" >> exercici.md
bash: exercici.md: Permiso denegado
```

**Feu un *checkout* del fitxer, ara sí, per afegir canvis.**

```bash
$ co -l ./exercici.md 
./exercici.md,v  -->  ./exercici.md
revision 1.1 (locked)
done
```

**Modifiqueu el fitxer i afegiu-li més contingut. Aquest serà la versió 1.2.**

```bash
$ echo "Afegir contingut" >> exercici.md
$ ci -u ./exercici.md 
./exercici.md,v  <--  ./exercici.md
new revision: 1.2; previous revision: 1.1
enter log message, terminated with single '.' or end of file:
>> Segona versió
>> .
done
```

**Amb un altre usuari, intenteu modificar el fitxer (fent el checkout abans).**

```bash
$ su alex2
alex2@fsociety:/home/alex/Escritorio/RCS$ echo "aaa" >> exercici.md
bash: exercici.md: Permiso denegado
```

**Com a l'usuari original, visualitzeu les diferències entre les versions i torneu a la versió 1.1**

```bash
$ rcsdiff -r1.1 -r 1.2 ./exercici.md 
rcsdiff: RCS/1.2,v: No such file or directory
===================================================================
RCS file: ./exercici.md,v
retrieving revision 1.1
retrieving revision 1.2
diff -r1.1 -r1.2
3c3,4
< **Hola** En negreta.
---
> **Hola** En negreta.\
> Nous canvis.

$ co -r1.1 exercici.md 
```

**Apliqueu més canvis i guardeu-los amb la versió 1.3**

```bash
$ ci -u ./exercici.md
./exercici.md,v  <--  ./exercici.md
new revision: 1.3; previous revision: 1.1
enter log message, terminated with single '.' or end of file:
>> Última versió
>> .
done
```
