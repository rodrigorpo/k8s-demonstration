FROM openjdk:11-jdk-slim
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT echo "java ${DATA_ENV} -jar app.jar";exec java ${DATA_ENV} -jar app.jar