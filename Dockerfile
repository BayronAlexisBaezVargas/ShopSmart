# ==========================================
# Etapa 1: Construcción (Build)
# Usamos una imagen que tiene Maven y el JDK 21
# ==========================================
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copiamos el pom.xml y descargamos las dependencias
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiamos el código fuente y compilamos el .jar
COPY src ./src
RUN mvn clean package -DskipTests

# ==========================================
# Etapa 2: Ejecución (Run)
# Usamos una imagen más ligera solo con el JRE 21
# ==========================================
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copiamos el .jar generado desde la etapa anterior
COPY --from=build /app/target/ShopSmart-0.0.1-SNAPSHOT.jar app.jar

# Exponemos el puerto
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]