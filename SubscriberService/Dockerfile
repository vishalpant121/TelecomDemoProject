FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

ARG JARFILE='build/libs/*.jar'

COPY $JARFILE app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "app.jar"]