// load required packages
const fs = require('fs') // require fs
const redis_node = require('redis'); // in-memory database
rejson         = require('redis-rejson'); // manipulating json in redis

rejson(redis_node);

// read redis host and port from secrets
var host = process.env.DASHBOARD_API_REDIS_HOST;
var port = process.env.DASHBOARD_API_REDIS_PORT;

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