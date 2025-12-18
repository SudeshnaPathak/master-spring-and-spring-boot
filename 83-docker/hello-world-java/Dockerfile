#FROM ~ Sets base image to OpenJDK 25 slim version
FROM openjdk:26-ea-jdk-slim

#COPY ~ Copies the built jar files from target directory to the image and names it app.jar
COPY target/*.jar app.jar

#Informs Docker that the container listens on port 5000 at runtime
EXPOSE 5000

#ENTRYPOINT ~ Specifies the command to run the jar file at the container launch
ENTRYPOINT ["java","-jar","/app.jar"]

# docker build -t in28min/hello-world-docker:v1 . ~ Builds the Docker image with the specified tag
# docker run -d -p 5000:5000 in28min/hello-world-docker:v1 ~Runs the Docker container in detached mode, mapping port 5000 of the host to port 5000 of the container