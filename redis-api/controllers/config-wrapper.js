var redis = require('../models/redis');

// get configuration data
exports.get_config_ids = function(req, res, next) {

    // get config identifier from request
    let configId = req.params.configId;

    // json get of rejson
    redis.json_get(configId, function(err, payload){
  
        if (!payload) {
            //  response based on status - 404 not found
            res.status(404).send('{code: 404, message: "Not Found"}');
        } else {             
            // send json answer
            res.send(payload);
        }
  
    });
  
}

// post configuration data
exports.post_config_ids = function(req, res, next) {
        
    // get config identifier from request
    let configId = req.params.configId;

    // json set of rejson
    redis.json_set(configId, '.', JSON.stringify(req.body), function(err) {
        if(err)
            res.status(400).send('{code: 400, message: "Bad Request"}');
        else
           res.status(200).send('{code: 200, message: "OK"}');  
      });
  
}

// delete configuration data
exports.del_config_ids = function(req, res, next) {
    
    // json del of rejson
    redis.json_del(configId, function(err) {
        if(err)
            res.status(400).send('{code: 400, message: "Bad Request"}');
        else
           res.status(200).send('{code: 200, message: "OK"}');  
      });

}