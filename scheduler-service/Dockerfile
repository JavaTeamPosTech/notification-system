# Stage 1: Build
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests -Dfile.encoding=UTF-8

# Stage 2: Run
FROM eclipse-temurin:21
WORKDIR /app

# Copia o JAR gerado no build, com o nome real
COPY --from=build /app/target/scheduler-service-0.0.1-SNAPSHOT.jar .

# Comando para rodar o JAR
CMD ["java", "-jar", "scheduler-service-0.0.1-SNAPSHOT.jar"]


