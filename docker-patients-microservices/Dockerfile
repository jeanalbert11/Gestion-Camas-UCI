FROM openjdk:8-jdk-alpine
# Los procesos no se deben ejecutar con permisos raíz. En su lugar,
# la imagen debe contener un usuario no root que ejecute la aplicación.
RUN addgroup -S dockeradmin && adduser -S admin -G dockeradmin

#Cuando se ejecuta el contenedor se ejecuta con el usuario creado
USER admin:dockeradmin

#Para que sea mas rapido todo el manejo de archivos del contenedor
VOLUME /tmp

#busca e indica donde esta el archivo .jar
ARG JAR_FILE=target/*.jar

#renombra el .jar con el nombre de app.jar
ADD target/${JAR_FILE} app.jar

#var de entorno
ENV JAVA_OPTS=""

#definimos los comandos que debe ejecutarse cuando se levante el contenedor
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
