FROM eclipse-temurin:17
WORKDIR /home
COPY ./target/coffee-order-0.0.1-SNAPSHOT.jar coffee-order-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "coffee-order-0.0.1-SNAPSHOT.jar"]