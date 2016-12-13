FROM openjdk:8
ENTRYPOINT [ "/entrypoint.sh" ]
#CMD [ "java", "-jar", "rot-service.jar" ]
EXPOSE 8080
STOPSIGNAL SIGINT
COPY rot-service.jar about.json entrypoint.sh /
RUN apt-get update && apt-get -y install vim