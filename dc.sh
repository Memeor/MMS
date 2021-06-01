#!/bin/bash
echo "Stopping and starting docker containers"
sudo docker-compose down
sudo docker rmi supernovabirth/memeor
sudo docker rmi postgres
sudo docker-compose run -d db
echo "Db created now starting spring boot"
sudo docker-compose run -d -p 8080:8080 app
echo "Done starting containers"
