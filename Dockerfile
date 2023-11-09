FROM openjdk:15-jdk-alpine
MAINTAINER Carlos Altamirano
# Configurar Zona Horaria - Inicio #
RUN apk add tzdata
RUN cp /usr/share/zoneinfo/America/Lima /etc/localtime
RUN echo "America/Lima" > /etc/timezone
RUN date
# Configurar Zona Horaria - Fin #

RUN addgroup -S spring && adduser -S spring -G spring
RUN apk --update add fontconfig ttf-dejavu 
USER spring:spring
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
