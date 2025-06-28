# Stage 1: build with Maven (includes JDK + Maven)
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app

# Copy only pom.xml first so we cache dependency download
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of the source and build the JAR
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: runtime
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copy the built JAR (whatever its exact name is) into app.jar
COPY --from=builder /app/target/*.jar app.jar

# Expose the gateway port
EXPOSE 4004

# Launch the gateway
ENTRYPOINT ["java","-jar","app.jar"]
