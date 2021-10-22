## Putting new data into redis

We suppose that the environment and all needed docker images is ok.

Loading data from Postgres database and putting into redis, follow this:

 > Remove old appendonly.aof (my file is in /home/andre/Dados/tmp/redisdb because this is the local path defined as volume in docker-compose.yml)

 > Go to the /docker-compose/ directory into root of this project and run the docker-compose file;
  ```sh
  docker-compose up -d
  ```

 > Go to the /data-api/LOIS_geojson_for_map/ directory into root of this project and run the shell script;
  ```sh
 ./CURL_POST_by_loinames.sh
  ```

 > Waiting until the feeder is put all data into redisdb;
* To check this, looking on the feeder logs.

  ```sh
  docker logs feeder -f
  ```
When you see the message below, all data is in the redis, if no error occured, of course.

```
Started RedisFeederApplication in 629.995 seconds (JVM running for ...
```