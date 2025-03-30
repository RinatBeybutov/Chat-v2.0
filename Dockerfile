FROM openjdk:21-jdk-slim

WORKDIR /app

COPY chat-0.0.1-SNAPSHOT.jar /app/chat.jar

#EXPOSE 8080

ENTRYPOINT ["java", "-jar", "chat.jar"]