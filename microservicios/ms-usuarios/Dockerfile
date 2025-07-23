FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/ms-usuarios-0.0.1.jar
COPY ${JAR_FILE} app_usuarios.jar
ENTRYPOINT ["java", "-jar", "app_usuarios.jar"]