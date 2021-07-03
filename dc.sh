#!/bin/bash
echo "Stopping and starting docker containers"
sudo docker-compose down
sudo docker rmi supernovabirth/memeor-web
sudo docker rmi supernovabirth/memeor
sudo docker rmi postgres
echo "Starting DB"
sudo docker-compose run -d db
echo "Db created. Now starting spring boot"
sudo docker-compose run -d -p 8080:8080 app
echo "Spring Boot started. Now starting React App."
sudo docker-compose run -d -p 80:80 nginx
echo "Done starting containers"
