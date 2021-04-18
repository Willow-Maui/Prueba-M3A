Buenos días,
En estos archivos adjunto los servidores backend y frontend ya exportados y el código del mismos.
Ha de tenerse instalada una base de datos MySQL con un usuario con perimso para crear y modificar tablas con username:"Willow"
y contraseña "García", lo cual es modificable en el proyeto (modificando el application.properties) pero en el jar está ya fijado así.
Para correr el servidor backend hay que tener instalado Java 1.8 y en la ruta: "spring-boot-backend-apirest-1\target" 
desde el cmd correr el comando: "java -jar spring-boot-backend-apirest-Prueba_M3A-0.0.1-SNAPSHOT.jar" o ejecutando el 
archivo run.cmd de la carpeta: "spring-boot-backend-apirest-1". Para detener el servidor hay que dar ctrl+c en la consola.
Para correr el servidor del front end se necesita tener instalado node.js, o modificar los archisvos para desplegarlo en otro servidor,
en el caso de tener node intalad hay que ejecutar el comand: "node .\server.js" en la carpeta "M3A-prueba\dist" o ejecutando el 
archivo run.cmd de la carpeta: "M3A-prueba\dist". Para detener el servidor hay que dar ctrl+c en la consola.
Para entrar en la interfaz gráfica conectarse a la dirección: "localhost:8089" y desde ahí se pueden realizar las distitnas funcionalidades
requeridas. Cada vez que se encienda el sever y se llame a cualquier función o se llame extresamente a cargar se cargarán todos los datos a
la base de datos, lo cual puede tardar hasta unos 10s. Para las siguientes operaciones el tiempo es casi instantaneo.
Es necesario encender el back end para que funcione correctamente el front end.