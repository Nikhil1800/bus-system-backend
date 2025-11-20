# 1. Use a small Java 17 image
FROM eclipse-temurin:17-jdk-alpine

# 2. Set working directory inside container
WORKDIR /app

# 3. Copy the built jar from target/ to container
#    CHANGE the jar name if yours is different
COPY target/Shopping-Website-0.0.1-SNAPSHOT.jar app.jar

# 4. Expose port used by Spring Boot
EXPOSE 8080

# 5. Start the app
ENTRYPOINT ["java", "-jar", "app.jar"]
