# Use Eclipse Temurin JDK 24 as base image
FROM eclipse-temurin:24-jre

WORKDIR /app

# Copy built jar from build context
COPY build/libs/practice-0.0.1-SNAPSHOT.jar app.jar

# Expose default Spring Boot port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
