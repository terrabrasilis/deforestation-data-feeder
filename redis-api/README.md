# Redis API

An API to read and write deforestation data to the REDIS database instance.

# Create a docker image

Use redis-api.dockerfile and build-redis-api.sh to build a docker image for deployment.

The docker image tag version is read from package.json, so to avoid overwriting images, change the project version before building a new image using npm and semantic versioning.

Step by step example:
```sh
# access the redis-api directory
cd redis-api/
# example to upgrade the minor version
npm version minor
# return to root project directory
cd ../
# and build the new image
./build-redis-api.sh
```

# Deploy in swarm

Use the REDIS_HOSTNAME and REDIS_PORT environment variables to configure the host and port to connect to the REDIS database.

Optionally use the API_PORT environment variable to set the API port to expose the service.

```yaml
    environment:
      - REDIS_HOSTNAME=redisdb
      - REDIS_PORT=6379
      - API_PORT=3000
```