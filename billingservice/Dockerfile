FROM ubuntu:latest
LABEL authors="Atharv Joshi"

# Stage 1: Build the app
FROM eclipse-temurin:21-jdk AS builder
WORKDIR /app

# Copy Maven files first for layer caching
COPY pom.xml ./
RUN apt-get update && apt-get install -y maven
RUN mvn dependency:go-offline

# Copy the full source and build
COPY . ./
RUN mvn clean package -DskipTests

# Stage 2: Run the app
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copy the JAR from builder
COPY --from=builder /app/target/*.jar app.jar

# Expose Spring Boot and gRPC ports
EXPOSE 8091
EXPOSE 9001

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]