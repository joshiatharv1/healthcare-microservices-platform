FROM ubuntu:latest
LABEL authors="Atharv Joshi"

FROM eclipse-temurin:21-jdk AS builder
WORKDIR /app

# Copy Maven config and install Maven
COPY pom.xml ./
RUN apt-get update && apt-get install -y maven
RUN mvn dependency:go-offline

# Copy source and build
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 9005
ENTRYPOINT ["java", "-jar", "app.jar"]
