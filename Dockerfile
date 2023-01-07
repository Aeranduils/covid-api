FROM eclipse-temurin:17-jre
COPY build/libs/covid-api-0.0.1-SNAPSHOT.jar /app/app.jar
WORKDIR /app
CMD ["java", "-jar", "app.jar"]