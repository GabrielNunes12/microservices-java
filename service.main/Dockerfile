FROM maven:3.9.6-amazoncorretto-21-debian as build
COPY src /app/src
COPY pom.xml /app

WORKDIR /app
RUN mvn clean install
LABEL authors="Gabriel Nunes"


FROM amazoncorretto:21
COPY --from=build /app/target/service.main-0.0.1-SNAPSHOT.jar /app/app.jar

WORKDIR /app

EXPOSE 8181

CMD ["java", "-jar", "app.jar"]
LABEL authors="Gabriel Nunes"
