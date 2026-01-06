FROM amazoncorretto:25-jdk
COPY target/*.jar app.jar
EXPOSE 8091
ENTRYPOINT ["java", "-jar", "app.jar"]