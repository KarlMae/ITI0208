FROM openjdk:8-jdk-alpine
ADD build/libs/spring-app.jar spring-app.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","spring-app.jar"]