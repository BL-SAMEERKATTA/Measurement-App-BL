# Stage 1: Build the application
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app

# Copy pom.xml and download dependencies first (for caching)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code and package the application
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the built JAR from the first stage
COPY --from=build /app/target/eureka-server-0.0.1-SNAPSHOT.jar app.jar

# Expose the default Eureka port
EXPOSE 8761

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]
