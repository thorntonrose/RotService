#!/bin/bash

if [ "$1" == "" ]; then
   exec java -jar rot-service-1.0.0.jar
fi

exec "$@"