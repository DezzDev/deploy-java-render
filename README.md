# java api rest auth jwt
API REST con autenticación JWT
Utilizando:
- spring boot
- spring security
- jwt
- postgresql

# docker
- una vez configurado el docker-compose, se debe tener abierta la app de docker-desktop y se ejecuta el siguiente código, el cual levanta el contenedor de la base de datos
docker-compose up -d

# deploy

- dejamos que el puero lo defina la plataforma, asi que lo eliminamos de application.properties
- agregamos una linea en application.properties para definir el dialecto de postgresql
- agregamos una linea para especificar como cargar las variables de entorno de la plataforma de donde se levante la app (spring.profiles.active=(MYENV))
- se puede necesitar bajar algunas versiones de spring boot, spring security y java
- creamos un archivo docker build para que se cree la imagen de la app dentro de la plataforma de despliegue


# videos 
## login con jwt 
https://www.youtube.com/watch?v=nwqQYCM4YT8


## sergicode
https://www.youtube.com/watch?v=BdNqW63ZaB0

# comandos
mvn clean install
mvn spring-boot:run
docker-compose up -d