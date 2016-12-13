#!/bin/bash

if [ "$1" == "" ]; then
   exec java -jar rot-service.jar
fi

exec "$@"