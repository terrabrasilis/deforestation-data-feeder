var redis = require('../models/redis');

// get list of all applications identifier
exports.is_connected = function(req, res, next) {

    if(redis.connected){
      res.status(200).send('{message: "ok"}');
    }else{
      res.status(404).send('{code: 404, message: "no"}');
    }
};