FROM openjdk:17-alpine

EXPOSE 8080

COPY .adaptable /.adaptable

RUN mkdir /app

COPY --from=build build/libs/*.jar /app/oleo.jar

ENTRYPOINT ["java","-jar","/app/oleo.jar"]


#ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/spring-boot-application.jar"]