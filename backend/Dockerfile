FROM gradle:7.6-jdk17 AS build

WORKDIR /app
COPY . .

RUN gradle build

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/build/libs/*.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]