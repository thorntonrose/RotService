FROM openjdk:8
ENTRYPOINT [ "/entrypoint.sh" ]
EXPOSE 8080
STOPSIGNAL SIGINT
COPY *.jar entrypoint.sh about.json /
RUN chmod +x entrypoint.sh && apt-get update && apt-get install -y vim