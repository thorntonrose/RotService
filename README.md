# Rot Service

## Docker Commands

build -- `docker build --tag rot-service .`

run (foreground) -- `docker run -it -p 8080:8080 --name rot-service rot-service`

run (background) -- `docker run -d -p 8080:8080 --name rot-service rot-service`

stop -- `docker stop rot-service`

stop and remove -- `docker rm -f rot-service`

list running containers -- `docker ps`

list all containers -- `docker ps -a`

list images -- `docker images`