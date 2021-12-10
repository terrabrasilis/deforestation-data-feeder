# sets the Base Image (redis, rejson) for subsequent instructions
FROM redislabs/rejson:latest AS rejson
FROM redis:latest as redis

# adds maintainer metadata as a key-value pair
LABEL author="Luiz Fernando Assis <luizffga@dpi.inpe.br>"
LABEL mantainer="Andre Carvalho <andre.carvalho@inpe.br>"

# sets the environment variable LIBDIR
ENV LIBDIR /usr/lib/redis/modules

# sets the working directory for any instructions that follow it in the Dockerfile
WORKDIR /data

# executes setting of shell exit in case of any subcommand or pipeline returns a non-zero status
RUN set -ex;\
    mkdir -p ${LIBDIR};

# copies rejson and adds them to the filesystem of the container at the defined path
COPY --from=rejson ${LIBDIR}/rejson.so ${LIBDIR}

# creates a mount point in /data 
VOLUME ["/data"]

# listens on the specified network port at runtime
EXPOSE 6379

# allows container to run as an executable using redis-server
ENTRYPOINT ["redis-server"]

# defines parameters to ENTRYPOINT (append data and load rejson)
CMD ["--appendonly", "yes", "--loadmodule", "/usr/lib/redis/modules/rejson.so"]