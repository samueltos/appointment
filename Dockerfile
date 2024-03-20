FROM gradle:8.6.0-jdk17-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:17-alpine

EXPOSE 8080

RUN mkdir /app

COPY .adaptable /.adaptable

COPY --from=build /home/gradle/src/build/libs/*.jar /app/oleo.jar

ENTRYPOINT ["java","-jar","/app/oleo.jar"]


#ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/spring-boot-application.jar"]