FROM amazoncorretto:25-jdk
COPY target/*.jar app.jar
EXPOSE 3000
ENTRYPOINT ["java", "-jar", "app.jar"]