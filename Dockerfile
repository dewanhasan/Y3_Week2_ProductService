FROM openjdk:19-jdk-slim

WORKDIR /app

COPY target/ProductService-0.0.1-SNAPSHOT.jar /app

EXPOSE 8081

CMD ["java","-jar","ProductService-0.0.1-SNAPSHOT.jar"]