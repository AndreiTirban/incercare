FROM adoptopenjdk/openjdk11:alpine-jre

COPY ./whiteboard-app/build/libs/whiteboard-app-0.0.1-SNAPSHOT.jar backend.jar

ENTRYPOINT ["java", "-jar", "backend.jar"]