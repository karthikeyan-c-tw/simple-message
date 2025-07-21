FROM gradle:jdk21-corretto AS build
WORKDIR /app
COPY . /app
RUN gradle clean build

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 7000
ENTRYPOINT ["java", "-jar", "app.jar"]