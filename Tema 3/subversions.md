# SISTEMES DE CONTROL DE VERSIONS

## Subversions amb RCS

L'exemple pràctic que es va a documentar va a ser sobre **sistemes de control de versió** en local amb *RCS*.\
\
En primer lloc, cal instal.lar els paquets `rcs` i `rcs-blame`

```bash
sudo apt-get install rcs rcs-blame
```

Una vegada instal.lat crearem un fitxer de treball amb l'ordre `mkdir directori` i un fitxer que anomenarem `prova.txt`\
Dinst d'aquest fitxer ficarem el següent contingut:

```bash
Fitxer, versió 1
```

Ho guardem i eixim. Una vegada fet aço, comprovarem els permisos del fixter amb

```bash
$ ls -la | grep prova | cut -d" " -f1
    -rw-rw-r--
```

El que fica baix de l'ordre serà el que ens ha de mostrar; que son els permisos predeterminats amb umask 117.\
\
Ara que ja tenim el sistema de control de verions instal.lat i un fitxer creat, el que voldrem serà portar un contro lde versions sobre aquest fitxer, per tal hi ha que fer-li un check-in de la següent forma:

```bash
$ ci -u prova.txt
    prova.txt,v <-- prova.txt
    enter description, terminated with single '.' or end of file:
    NOTE: This is NOT the log message!
>> Versió 1
>> .
initial revision 1.1
done
```

Al utilitzar el "ci" el que hem fet ha sigut fer el *check-in* que el que fa es dir que el fitxer estarà ara en la control de versions.\
\
Per a comprovar que està sota el control de versions farem un `ls -l` i ens trovarem el següent:

```bash
$ ls -la
    total 16
	drwxr-xr-x 2 alex alex 4096 nov 12 18:12 .
	drwxr-xr-x 3 alex alex 4096 nov 12 18:09 ..
	-r--r--r-- 1 alex alex   18 nov 12 18:08 prova.txt
	-r--r--r-- 1 alex alex  205 nov 12 18:12 prova.txt,v
```

Com podem observar, el fitxer original ja no té permís de escriptura i s'ha creat un nou fitxer anomenat `prova.txt,v` amb els mateixos permisos.\
Aixi que per a modificar el fitxer, li hem de fer un check out.

```bash
$ co -l ./prova.txt
	./prova.txt,v --> ./prova.txt
	revision 1.1 (locked)
	done
```

Si ara tornem a execultar l'ordre `ls -la` veurem que els permisos han tornat a canviar en el fitxer `prova.txt` i ara sí que tindrem permis d'escriptura però sols com a usuari, no com a grup o altres. \
Ara afegirem més text.

```bash
$ nano prova.txt
	Fitxer, versió 1
	Afegim més text al fitxer, per veure com ho gestiona el RCS.
```

Ara hem afegit una línea extra, per lo tant, tenim que tornar a fer un check-out per a indicar que hem acabat d'editar el document.

```bash
$ ci -u ./prova.txt
	./fitxer.txt,v <-- ./prova.txt
	new revision: 1.2; previous revision: 1.1
	enter log message, terminated with single '.' or end of file.
	>> Versió 2
	>> .
	done
```

Amb aço ja tindrem el nostre arxiu novament sense permis d'escriptura, per lo tant per a la pròxima vegada que tingam que editar-lo també tindrem que fer un check-in, per a mostrar que anem a tornar a treballar sobre aquest fitxer i al acabar tenim que fer un check-out per indicar que hem acabat, d'aquesta forma, cada vegada que fem un check-out opcionalment afegirem un comentari en el que podrem introduir qué és el que hem modificat a mode de comentari.
\
\
Ara per a veure les diferències entre els dos arxius podem fer us de:

```bash
$ rcsdiff -r1.1 -r 1.2 ./prova.txt
	===================================================================
	RCS file: ./prova.txt,v
	retrieving revision 1.1
	retrieving revision 1.2
	diff -r1.1 -r1.2
	1a2,3
	>
	> Afegim més text al fitxer, per veure com ho gestiona el RCS.

```

I ara si volem podem revertir a la versió 1.1:

```bash
$ co -r1.1 ./prova.txt
	./provatxt,v --> ./prova.txt
	revision 1.1
	done

$ cat prova.txt
Fitxer, versió 1
```

I ja estaría.
