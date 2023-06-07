FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENV TZ=Asia/Seoul
ENTRYPOINT ["java","-jar","-Djasypt.encryptor.password=myteamisthebest","-Dspring.profiles.active=${USE_PROFILE}","/app.jar"]
