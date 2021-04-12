FROM openjdk:11

ADD ./build/libs/spring-assignment*.jar spring-assignment-ac.jar

ENTRYPOINT ["java", "-jar", "spring-assignment-ac.jar"]

EXPOSE 8080
EXPOSE 5005

