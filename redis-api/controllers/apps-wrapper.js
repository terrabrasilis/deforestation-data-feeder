var redis = require('../models/redis');

// get list of all applications identifier
exports.get_apps_ids = function(req, res, next) {

    // json get of rejson
    redis.json_get("appsIdentifier", function(err, payload){
  
        if (!payload) {
            //  response based on status - 404 not found
            res.status(404).send('{code: 404, message: "Not Found"}');
        } else {             
            // send json answer
            res.send(payload);
        }
  
    });
  
}

// post list of all applications identifier
exports.post_apps_ids = function(req, res, next) {
        
    // json set of rejson
    redis.json_set("appsIdentifier", '.', JSON.stringify(req.body), function(err) {
        if(err)
            res.status(400).send('{code: 400, message: "Bad Request"}');
        else
            res.status(200).send('{code: 200, message: "OK"}');  
      });
  
}

// delete list of all applications identifier
exports.del_apps_ids = function(req, res, next) {
    
    // json del of rejson
    redis.json_del("appsIdentifier", function(err) {
        if(err)
            res.status(400).send('{code: 400, message: "Bad Request"}');
        else
           res.status(200).send('{code: 200, message: "OK"}');  
      });

}