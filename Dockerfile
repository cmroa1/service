FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY . .
RUN mvn clean package -DskipTests

# Etapa final: usar una imagen más liviana
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

# Expone el puerto
EXPOSE 8080

# Define una variable de entorno con valor por defecto
ENV SPRING_PROFILES_ACTIVE=default

# Comando para ejecutar la aplicación con el perfil que se pase por entorno
ENTRYPOINT ["sh", "-c", "java -jar app.jar --spring.profiles.active=${SPRING_PROFILES_ACTIVE}"]