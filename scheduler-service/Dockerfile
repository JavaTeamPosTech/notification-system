FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copia tudo de uma vez (pai + módulos)
COPY . .

# Build de todos os módulos
RUN mvn clean package -DskipTests -Dfile.encoding=UTF-8

# Stage final
FROM eclipse-temurin:21
WORKDIR /app

# Copia apenas o JAR do serviço que vai rodar
COPY --from=build /app/scheduler-service/target/scheduler-service-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "scheduler-service-0.0.1-SNAPSHOT.jar"]
