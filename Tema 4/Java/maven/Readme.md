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

## Generació del projecte