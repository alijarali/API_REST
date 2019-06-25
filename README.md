# API_REST

[![Gitter](https://badges.gitter.im/API_REST/community.svg)](https://gitter.im/API_REST/community?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

Esto es una API REST del censo de población de ciudades y países.
Permite:
 - Añadir entradas a una base de datos.
 - Modificar entradas.
 - Borrar entradas.
 - Hacer consultas a la base de datos.
 
 # Instalación
 
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
