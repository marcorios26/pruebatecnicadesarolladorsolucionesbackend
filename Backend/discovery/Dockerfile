FROM adoptopenjdk/openjdk11:alpine-jre
RUN mkdir -p /app/
WORKDIR /app
COPY "./build/libs/discovery-0.0.1-SNAPSHOT.jar" "discovery-0.0.1-SNAPSHOT.jar"
COPY "./build/resources/main/application.prod.properties" "application.properties"
EXPOSE 8761
ENTRYPOINT ["java","-jar","discovery-0.0.1-SNAPSHOT.jar"]
