FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dusername=$BOT_NAME","-Dtoken=$BOT_TOKEN","-Dspring.datasource.username=$BOT_DB_PASSWORD","spring.datasource.password=$BOT_DB_PASSWORD","-jar", "/app.jar"]