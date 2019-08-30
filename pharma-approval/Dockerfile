FROM maven:3.5.2-jdk-8-alpine as builder
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package

# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine as runtime

# Add Maintainer Info
LABEL maintainer="dheepakrd@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=target/pharma-approval.jar

# Add the application's jar to the container
ADD ${JAR_FILE} pharma-approval.jar

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/pharma-approval.jar"]