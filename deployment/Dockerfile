FROM openjdk:11
VOLUME /tmp
COPY *.jar Clients.jar
ENV JAVA_OPTS=""
# Replace with a non-root user to avoid running the container with excessive privileges
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS  -jar Clients.jar" ]
