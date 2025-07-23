FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/ms-auditoria-0.0.1.jar
COPY ${JAR_FILE} app_auditoria.jar
ENTRYPOINT ["java", "-jar", "app_auditoria.jar"]