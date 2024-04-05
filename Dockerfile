FROM debian
FROM openjdk
RUN mkdir /app ; mkdir /uploads
#WORKDIR /app
COPY target/*.jar /app/app.jar
#CMD ["mvn","compile"]
#CMD ["mvn","spring-boot:run"]
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]