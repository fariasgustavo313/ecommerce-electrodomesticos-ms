FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/ms-productos-0.0.1.jar
COPY ${JAR_FILE} app_productos.jar
ENTRYPOINT ["java", "-jar", "app_productos.jar"]