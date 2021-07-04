# stage 1 - build react app first 
FROM node:12.16.1-alpine3.9 as react
WORKDIR /app
ENV PATH /app/node_modules/.bin:$PATH
COPY mms-frontend/package.json /app/
COPY mms-frontend/package-lock.json /app/
RUN npm install --silent
COPY mms-frontend /app
RUN npm run build

# stage 2 - build the final image and copy the react build files
FROM nginx:alpine as nginx
COPY --from=react /app/build /usr/share/nginx/html
RUN rm /etc/nginx/conf.d/default.conf
COPY mms-frontend/nginx/nginx.conf /etc/nginx/conf.d
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]

# stage 3 - build spring boot image
FROM adoptopenjdk:11-jre-hotspot as spring-boot
ARG JAR_FILE=*.jar
COPY target/${JAR_FILE} memeor.jar
ENTRYPOINT ["java", "-jar", "memeor.jar"]
