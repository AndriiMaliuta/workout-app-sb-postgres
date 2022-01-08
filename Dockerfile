FROM java:8-alpine
WORKDIR app
COPY ./pom.xml ./
RUN ["java", "-jar", "*.jar"]
