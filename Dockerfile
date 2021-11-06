FROM maven:3.8.3-jdk-11-slim AS build
#RUN addgroup -S springdocker && adduser -S springdocker -G springdocker
#USER springdocker:springdocker
RUN mkdir -p /app-backend
#WORKDIR /app-backend
COPY src /app-backend/src
COPY pom.xml /app-backend
RUN mvn -f /app-backend/pom.xml clean package -DskipTests

FROM openjdk:11-jre-slim
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]
COPY --from=build /app-backend/target/miejscowka.jar /usr/local/lib/miejscowka.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/miejscowka.jar"]
#EXPOSE 8080