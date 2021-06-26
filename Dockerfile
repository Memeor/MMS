FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=*.jar
COPY target/${JAR_FILE} memeor.jar
ENTRYPOINT ["java", "-jar", "memeor.jar"]