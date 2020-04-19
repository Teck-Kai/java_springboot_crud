FROM openjdk:8-jre-alpine
ADD /build/libs/java_springboot_crud-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]