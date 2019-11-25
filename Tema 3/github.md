
## Subversions amb git

Primer començarem actualitzant els repositoris amb l'ordre `sudo apt update` i despres instal.lem el repositori amb la següent ordre:

```bash
sudo apt install git
```

Una vegada tinga git instalat, començarem configurant-lo amb les següents ordres\
\
Primer, introduim el nostre nom:

```bash
git config --global user.name "Àlex"
```

Despres, el email:

```bash
git config --global user.email ladiv12@pm.me
```

També cal especificar quin és el nostre editor favorit:

```bash
git config --global core.editor nano
```

A continuació activarem els colors en la user interface.

```bash
git config --global color.ui true
```

Ara que faça conversions de final de linea per a treballar en sistemes híbrids.

```bash
git config --global core.autocrlf true
```

I per ultim mostrarem el llistat per a comprovar-ho tot:

```bash
$ git config --list
	user.name=Àlex
	user.email=ladiv12@pm.me
	core.editor=nano
	core.autocrlf=true
	color.ui=true
```

Ara crearem un espai de treball per a treballar amb git. 

```bash
$ mkdir proves_git
$ cd proves_git/
```

Una vegada dins de la carpeta, li comunicarem a git que s'incialitze en eixa carpeta.

```bash
$ git init
	Inicializado repositorio Git vacío en /home/alex/Escritorio/proves_git/.git/
```

I ara farem un `git status` per a saber quin és l'estat de git.

```bash
$ git status
	En la rama master

	No hay commits todavía

	no hay nada para confirmar (crea/copia archivos y usa "git add" para hacerles seguimiento)
```

Ara anem a crear un arxiu:

```bash
touch fitxer_1.md
```

I tornem a mirar l'estat de git:

```bash
$ git status

	En la rama master

	No hay commits todavía

	Archivos sin seguimiento:
	  (usa "git add <archivo>..." para incluirlo a lo que se será confirmado)

	fitxer_1.md

	no hay nada agregado al commit pero hay archivos sin seguimiento presentes (usa "git add" para hacerles seguimiento)

```

Com podem observar ens ha detectat el document però no ha començat el seguiment. Per a que començe amb el seguiment cal indicar-ho amb un ordre:

```bash
$ git add fitxer_1.md
$ git status
En la rama master

No hay commits todavía

Cambios a ser confirmados:
  (usa "git rm --cached <archivo>..." para sacar del área de stage)

	nuevo archivo:  fitxer_1.md
```

Ara ja tenim el fitxer en seguiment, sols falta fer el Commit per a que torne al primer estat.

```bash
git commit -a -m "Primer Commit"
[master (commit-raíz) c5c106a] Primer Commit
 1 file changed, 0 insertions(+), 0 deletions(-)
 create mode 100644 fitxer_1.md
```

I últim faltarà fer un commit per a comprovar que tot està funcionant.

```bash
$ git commit
En la rama master
nada para hacer commit, el árbol de trabajo esta limpio
```
