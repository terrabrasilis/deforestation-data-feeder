// load required packages
const redis_node = require('redis'); // in-memory database
rejson         = require('redis-rejson'); // manipulating json in redis
rejson(redis_node);

// redis host and port from env or default
var host = process.env.REDIS_HOSTNAME || 'redisdb';
var port = process.env.REDIS_PORT || 6379;

// redis_node
var client = redis_node.createClient(port, host); 

// redis instance url connection
client.on('connect', function(){
  console.log('Connected to Redis...');
});

// client on error
client.on("error", function (err) {
    console.log("Error " + err);
});

// export client
module.exports = client;