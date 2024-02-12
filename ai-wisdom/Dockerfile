#
# Build stage
#
FROM maven:3.8.6-eclipse-temurin-17-focal AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM eclipse-temurin:17-jre-focal
EXPOSE 8080
COPY --from=build /home/app/target/wisdom-0.0.1-SNAPSHOT.jar app/app.jar
ENTRYPOINT ["java", "-jar","/app/app.jar"]
