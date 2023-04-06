
FROM maven:3.8.1-openjdk-11-slim

COPY target/my-veterinary-ms-1.0-SNAPSHOT.jar my-veterinary-ms-1.0-SNAPSHOT.jar

EXPOSE 8092

CMD ["java", "-jar", "my-veterinary-ms-1.0-SNAPSHOT.jar"]