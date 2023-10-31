#!/bin/bash

#Ensure, that docker-compose stopped
docker-compose stop

#Ensure, that the old app will not deployed again
mvn clean