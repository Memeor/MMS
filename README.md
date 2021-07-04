<div align="center">
  <br>
  <h1>Memeor 🌠</h1>
  <strong>Membership Management Software</strong>
</div>
<br>


Welcome to the Memeor codebase. Memeor is an open source membership management
software made for organizations. We are still in a very early stage right now.


## Table of Contents


- [Contributing](#contributing)
- [Getting Started](#getting-started)
    - [How to build in docker](#how-to-build-in-docker)
    - [How to use docker hub images](#how-to-use-docker-hub-images)
    - [How to run spring boot locally with only db running in docker](#how-to-run-spring-boot-locally-with-only-db-running-in-docker)
- [Core team](#core-team)
- [License](#license)

## Contributing

Please contact us if you'd like to contribute to the project.

## Getting Started
- Coming soon

### How to build in docker
- Compile Spring Boot before running docker-compose:

` ./mvnw clean package -DskipTests`

- In Local, use docker-compose command (using docker-compose-local.yml):

`docker-compose -f docker-compose-local.yml up`

- In Local, to stop docker, use this command:

`docker-compose -f docker-compose-local.yml down`

- For production, creating spring boot image:

`docker build --target spring-boot -t supernovabirth/memeor:latest .`

`docker push supernovabirth/memeor:latest`

- For production, creating react image:

`docker build --target react -t memeor-react .`

`docker build --target nginx -t supernovabirth/memeor-web:latest .`

`docker push supernovabirth/memeor-web:latest`

Note: replace supernovabirth with your dockerhub username in docker-compose yaml files and in the commands.

### How to use docker hub images
- Run Docker containers using images from docker hub (use docker-compose.yml):

`sudo docker-compose up`

- Running separately:

`sudo docker-compose run -d -p 80:80 nginx`

`sudo docker-compose run -d db`

`sudo docker-compose run -d -p 8080:8080 app`


- Stopping docker containers

`sudo docker-compose down`

`sudo docker rmi supernovabirth/memeor`

`sudo docker rmi postgres`

`sudo docker rmi memeor-react`

### How to run spring boot locally with only db running in docker
- In Local, run database in docker and access it via Spring Boot:

`docker-compose -f docker-compose-local.yml run --service-ports db`

- Run this first if docker previously run to remove old instances:

`docker-compose -f docker-compose-local.yml down`

- Use this VM argument when running Spring Boot:

`-Dspring.profiles.active=local`

## Core team


## License

[LICENSE](./LICENSE.md) 

<br>


[⬆ Back to Top](#Table-of-contents)
