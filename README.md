
Install the maven wrapper

>mvn -N io.takari:maven:wrapper


Run the application

>./mvnw spring-boot:run

Get the IP address of the postgres container in it's docker network

>docker ps
>docker inspect -f '{{range.NetworkSettings.Networks}}{{.IPAddress}}{{end}}' <ContainerID>
