# Docker i subversions

## Instalació de Docker

En primer lloc, hem de fer un update

```bash
$ sudo apt-get update
```

I després instalarem els següents packets.

```bash
sudo apt-get install \
    apt-transport-https \
    ca-certificates \
    curl \
    software-properties-common
```

Una vegada hem fet aço tenim que descarregar la clau amb la següent instrucció

```bash
curl-fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
```

Si volem, podem comrpovar-ho. Però no és necessari. Per a a comprovar-ho farem el següent:

```bash
 sudo apt-key fingerprint 0EBFCD88
```

Tant si ho hem comprovat com si no, el següent pas serà el de afegir el repositori de docker, de la següent forma:

```bash
sudo add-apt-repository \
"deb[arch=amd64]https://download.docker.com/linux/ubuntu \
$(lsb_release-cs) \
stable"
```

Per a asegurar-nos farem un

```bash
sudo apt-get update
```

Ara continuem en l'instalació de Docker-CE.  
Com que ja tenim els repositoris configurats, serà tan fàcil com escriure el següent:

```bash
sudo apt-get install docker-cde
```

Una vegada ho tenim, sí que es convenient comprovar que docker funciona bé, per tal de aconseguir saber si està funcionant correctament, sols tenim que llançar el contenidor de hello-world d'aquesta forma:

```bash
sudo docker run hello-world
```

I deuria mostrar algo com

```bash
...
Hello from Docker!
...
```

Evindentment, serà molt més llarg el que mostre.  
  
Com a detall extra, podrem activar o desactivar el servici de docker de dos formes:

```bash
sudo systemctl enable docker

sudo systemctl disable docker
```

i també:

```bash
sudo service start docker

sudo service stop docker
```

## Busybox

Ara el que farem serà descarregar el contenidor de Busybox de Docker de la següent forma:

```bash
sudo docker pull busybox
```

Una vegada instalat, podem coprovar si reialment s'ha instalat comprovant les imatges amb la següent instrucció:

```bash
sudo docker images
```

Una vegada fet aço, hem de llançar el contenidor de busybox desde docker de la següent forma:

```bash
sudo docker run busybox
```

El que hem fet ha sigut instalar un petit linux en el nostre sistema gràcies a Docker. Com podràs comprovar a continuació, podem executar qualsevol instrucció de Linux de la següent forma:

```bash
$ sudo docker run busybox echo "ola k ase"
    ola k ase
```
\
\
Una vegada executem tants processos, per molt q cregam que els hem tancat una vegada apagat l'oridnador o tancada la terminal, els processos reialment continuen ahi.\
Per a veure reialment els processos que continuen, hem d'executar la següent instrucció:

```bash
sudo docker ps -a
```

Per a eliminar-los deuriem fer un ``sudo docker rm (numero)`` i això sería massa feina quan en tenim molts oberts, per això el més fàcil és:

```bash
sudo docker rm $(docker ps -a -q -f status=exited)
```

El que estem diguent es que termine tots els processos que tenen d'estat "exited".
\
\
\
## Servidor de subversion amb busybox i docker.  

Primer deuriem descarregar la imatge de subversion edge. Per tal de fer aço, executarem el següent:

```bash
sudo docker run -d mamohr/subversion-edge
```

Veierem que ``run`` s'utilitzava per a executar algo en docker, bé, pues si el que executem no ho tenim descarregat i ho provem a executar, ho descarregarà de forma automàtica i ho executarà.\
\
Però reialment sols voliem descarregar-lo, ja que al executar-lo d'eixa forma no farà el que necessitem i volem, aixi que tindrem que eliminar el contenidor.\
Una vegada eliminat, el tornarem a llançar de la següent forma:

```bash
sudo docker run -d -p 3343:3343 -p 4434:4434 -p 18080:18080 -v /srv/svn-data:/opt/csvn/data --name svn-server mamohr/subversion-edge
```

En aquesta instrucció tan llarga el que estem fent es executar el contenidor i dir-li en quin o quins ports. També estem dient ON s'ha de guardar tota la informació i canvis que fem en el contenidor.\
\
Una vegada fet aço, accedirem a [http://localhost:3343](http://localhost:3343) o [http://127.0.0.1:3343](http://127.0.0.1:3343). Al principi tardarà un rato en entrar, però en un màxim de 5 minuts deuria funcionar.\
Després ens loguearem amb l'usuari `admin` i contrasenya `admin`.\
\
I ja tindriem accés al nostre servidor de subverions, on podrem crear repositoris i administrar els nostres usuaris.

## Accés als repositoris a través de línia d'ordres.
Per a accedir per linia d'ordres als nostres repositoris, executarem el següent per terminal:
```bash
svn co http://127.0.0.1:18080/svn/test test
```

Ens demanarà l'usuari i contrasenya, que serà el que ens hem creat o el que teniem amb admin.