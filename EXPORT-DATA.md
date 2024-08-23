## Writing new data into directory

We suppose that the environment and all needed docker images is ok.

The default output directory is inside the ~/docker-compose/ from root directory of this repository.

Loading data from Postgres database and writing into output directory, follow this:

Ensure that the directory structure is created.
To do this, run the script to create the empty directory structure.
This same script will copy lois to the output directory structure as well.

 > Go to the /data-lois/geojson_for_map/ directory into root of this project and run the shell script;

```sh
# In some cases you will need to use root with sudo
./cp_lois_to_feeder.sh
```

 > Go to the /docker-compose/ directory into root of this project and run the docker-compose file;

```sh
docker-compose up -d
```

 > Wait until the feeder places all the data in the respective directories;
* To check this, looking on the feeder logs.

```sh
docker logs feeder -f
```
When you see the message below, all data is in the redis, if no error occured, of course.

```
Started RedisFeederApplication in 629.995 seconds (JVM running for ...
```

## How to publish

Copy the output directory to the server and place it in the location that NGINX uses as the root directory. Ensuring that the path is set correctly as required by the deforestation dashboard.

