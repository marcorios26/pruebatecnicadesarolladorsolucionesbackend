FROM adoptopenjdk/openjdk11:alpine-jre
RUN mkdir -p /app/
WORKDIR /app
COPY "./build/libs/planning_poker-0.0.1-SNAPSHOT.jar" "planning_poker-0.0.1-SNAPSHOT.jar"
COPY "./build/resources/main/application.prod.properties" "application.properties"
EXPOSE 8763
ENTRYPOINT ["java", "-jar", "planning_poker-0.0.1-SNAPSHOT.jar"]
