FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/ms-inventario-0.0.1.jar
COPY ${JAR_FILE} app_inventario.jar
ENTRYPOINT ["java", "-jar", "app_inventario.jar"]