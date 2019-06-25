# API_REST

[![Gitter](https://badges.gitter.im/API_REST/community.svg)](https://gitter.im/API_REST/community?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
# Descripción 📋

Esto es una API REST para gestionar el censo de población de ciudades y países. Los atributos de las entradas son: el índice (indice), nombre de la ciudad (ciudad), nombre del país (pais) y la población de la ciudad (población).

Permite:
 - Añadir entradas a una base de datos (POST).
 - Modificar entradas (PUT).
 - Borrar entradas (DELETE).
 - Hacer consultas a la base de datos (GET).

Mediante GET vamos a poder obtener los censos de nuestra base de datos. Dependiendo de los parámentros que introduzcamos, obtendremos diferentes resultados: 
 - Ningún parámetro: Devuelve un array con todas las entradas.
 - Indice: Nos devuelve la entrada con ese índice
 - Alguno de los atributos de la clase: Devuelve aquellas instancias cuyos valores en sus atributos sean iguales a los indicados.
 - from: Devuelve todas las instancias con índice mayor o igual al valor indicado.
 - to: Devuelve todas las instancias con índice menor o igual al valor indicado. Si no encuentra ninguna coincidencia en los casos anteriores se devuelve un código 404.
  - sort: Devuelve todas las instancias ordenadas ascendentemente por el nombre del atributo indicado como valor. Si el nombre del atributo no es válido se devuelve un código 400.

 
 # Instalación 🔧
 
 - Tener eclipse instalado
 - Instalar MAMP+PhpMyAdmin
 - Instalar WildFly o TomCat
 - Copiar la carpeta en el disco C:
 - New server runtime environment
 - Instalar MAMP+PhpMyAdmin
 - Instalar jdk
 - Instalar PostMan


Si MAMP no lanza el servidor SQL, hay que hacer lo siguiente:

 Ir a la carpeta donde está instalado-> MAMP/db/mysql 
 
 Borrar los archivos con el nombre ib_logfile0 y ib_logfile1

Si aún así no funciona:
https://stackoverflow.com/questions/54296014/mysql-server-on-mamp-windows-will-not-start

# Enlaces a .jar que hay que incluir en el proyecto:
 - GSON: https://mvnrepository.com/artifact/com.google.code.gson/gson/2.8.5
