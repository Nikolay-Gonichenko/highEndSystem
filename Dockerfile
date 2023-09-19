FROM maven:3.8.4-openjdk-17 as build
COPY src src
COPY pom.xml .
RUN mvn clean package -Dmaven.test.skip=true

FROM openjdk:17
COPY --from=build /target/highEndSystem-0.0.1-SNAPSHOT.jar /target/highEndSystem-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/target/highEndSystem-0.0.1-SNAPSHOT.jar"]