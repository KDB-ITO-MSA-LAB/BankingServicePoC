FROM openjdk:18-jdk-alpine AS builder
COPY gradlew .
COPY build.gradle .
COPY settings.gradle .
COPY gradle gradle
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew build

FROM openjdk:18-jdk-alpine
COPY --from=builder build/libs/banking-service-*-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
