# Usando a imagem base do OpenJDK 17
FROM openjdk:17-jdk-slim

# Definindo diretório de trabalho dentro do contêiner
WORKDIR /app

# Copiando o arquivo JAR gerado pelo Maven para o contêiner
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expondo a porta da aplicação (Spring Boot padrão usa 8080)
EXPOSE 8080

# Comando de entrada para rodar o aplicativo
ENTRYPOINT ["java", "-jar", "app.jar"]
