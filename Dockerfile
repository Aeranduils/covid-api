FROM gradle:7.5.1-jdk17-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon 

FROM eclipse-temurin:17-jre
COPY build/libs/covid-api-0.0.1-SNAPSHOT.jar /app/app.jar
WORKDIR /app
EXPOSE 8080
CMD ["java", "-jar", "app.jar", "-XX:+UnlockExperimentalVMOptions","-Djava.security.egd=file:/dev/./urandom"]



