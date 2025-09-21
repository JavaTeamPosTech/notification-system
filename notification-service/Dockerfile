FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

COPY . .

# Build de todos os módulos de uma vez
RUN mvn clean package -DskipTests -Dfile.encoding=UTF-8

# Stage final
FROM eclipse-temurin:21
WORKDIR /app

COPY --from=build /app/notification-service/target/notification-service-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "notification-service-0.0.1-SNAPSHOT.jar"]
