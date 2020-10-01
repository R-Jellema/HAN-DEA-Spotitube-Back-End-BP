#!/bin/sh
mvn clean package && docker build -t nl.han.oose.jellema.rick/Spotitube .
docker rm -f Spotitube || true && docker run -d -p 8080:8080 -p 4848:4848 --name Spotitube nl.han.oose.jellema.rick/Spotitube 
