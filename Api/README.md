# Installation API

## Création de la VM

### Os

la doc a été écrite en testant sur une vm : OracleLinux-R8-U8-x86_64-dvd.iso disponible [ici](https://yum.oracle.com/oracle-linux-isos.html)

### Configuration

- keyboard -> french
- language -> support
- software selection -> minimal install 
- network -> On 
- definir un mot de passe admin
- créer un utilisateur
  
## Installation

``` bash
su - 
yum update
yum install git

git config --global user.name "albandvd"
git config --global user.email "alban.david06@gmail.com" #mail associé au compte github ayant accès au repo

ssh-keygen -t rsa -b 4096 -C "alban.david06@gmail.com"

cat ~/.ssh/id_rsa.pub
```

Copier la clé ssh créé 
Aller sur le liens suivant : https://github.com/settings/keys
Et rentrer la clé ssh 

``` bash
git clone git@github.com:Exarven15/SAE302.git
cd SAE302/
git checkout Api
./install.sh
npm install
```

## Configuration 

### Mongodb

Pour utiliser l'api il configurer la base mongodb installé précedement. 

``` bash
mongosh
use SAE302
db.createUser({user: "test",pwd: "test",roles: ["readWrite", "dbAdmin"]})
```

### Api

Pour pouvoir utiliser l'api il faut créer un fichier .env qui contient la configuration des différents 

créer un fichier .env et ajouter les chaamps suivant :

- SHA256 sha utilisé pour le cryptage des mots de passe
- URI uri de la base mongodb
- IP ip de la vm
  
exemple de .env

``` js
SHA256=928adb212d325e10e8360cae95e9a3718e84b628a98fc77a61c4538f6b53b78e
URI="mongodb://test:test@localhost:27017/SAE302"
IP=127.0.0.1
```

l'exemple est utilisable si le User a bien été definit comme test:test

## Lancement 

Pour lancer l'api on a deux choix: utiliser npm, ou pm2. 

### NPM 

npm est le gestionnaire de paquets par défaut pour js. Ce dernier permet de lancer les applications en avant plan uniquement. Pour un simple test ce dernier est très pratique mais n'est pas viable pour une utilisation de programmes sur un serveur. 

pour lancer avec npm on execute la commande : 

``` bash
npm run start
```

### PM2 

PM2 est un gestionnaire de processus pour le runtime js. Ce dernier permet de lancer en arrière plan les applications. 

pour utiliser pm2 :

``` bash
npm install pm2 -g
pm2 start server.js
```

## Test system 

La procédure de test système est détaillé dans le Read.me du dossier test_API