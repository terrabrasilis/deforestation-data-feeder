# sets the Base Image (node) for subsequent instructions - default: latest
FROM node:latest

# adds maintainer metadata as a key-value pair
LABEL mantainer="Luiz Fernando Assis <luizffga@dpi.inpe.br>"

# sets the environment variable REDIS_HOST and REDIS_PORT
ENV REDIS_HOST=
ENV REDIS_PORT=6379

# executes create directory of the src in a new layer on top of the current image and commit the results
RUN mkdir -p /usr/src/

# sets the working directory for any instructions that follow it in the Dockerfile
WORKDIR /usr/src

# copies redis-api javascript code and adds them to the filesystem of the image at the path defined
ADD redis-api ./

# executes installation in production as well as of nodemon using npm in a new layer on top of the current image and commit the results
RUN npm install --only=production
RUN npm install -g nodemon

# listens on the specified network port at runtime
EXPOSE 3000

# exec form of CMD that allows container to run as an executable using nodemon and the path of public api code
CMD ["nodemon", "-L", "bin/www"]