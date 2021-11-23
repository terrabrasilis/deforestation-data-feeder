var redis = require('../models/redis');
var api_calls = require('../utils/api-calls');

// get list of applications id
exports.get_apps_ids = function(req, res, next) {
    
    redis.json_get("appsIdentifier", 'NOESCAPE', function(err, payload){
    
        if (!payload) {
            res.status(404).send('{code: 404, message: "Not Found"}');
        } else {
            res.locals.appIds = payload; 
            next();
        }

    });

}

exports.get_loinames_queryable = function(req, res, next) {
    
        // get header from app
        let appId = api_calls.check_app_identifier(req, res, next);
        if (!appId) {
            res.status(404).send('{code: 404, message: "Not Found"}');
            
        }
    
        const loi = req.query.loi;
        if (!loi) { 
            // response based on status - 401 Not Allowed
            res.status(400).send('{code: 400, message: "Bad Request"}');
            
        }
                
        // concat app and data identifier examplary id: "prodes_amazon_rates"
        let id = appId + "_loinames";
        
        // json get of rejson
        redis.json_get(id, 'NOESCAPE', function(err, payload){
    
            if (!payload) {
                //  response based on status - 404 not found
                res.status(404).send('{code: 404, message: "Not Found"}');
            } else {             
                // send json answer for all
                aux = JSON.parse(payload);
                lois = new Array();     
                for (i in aux.lois) { // for each lois
                    if (aux.lois[i]["gid"] == loi) {
                        lois.push(aux.lois[i]);
                        break;
                    }                    
                }
                aux.lois = lois;
                res.send(aux);
            }      
        });
    }

// get configuration data
exports.get_config_ids = function(req, res, next) {

    // get header from app
    let appId = api_calls.check_app_identifier(req, res, next);
    if (!appId) {
        res.status(404).send('{code: 404, message: "Not Found"}');
        
    }

    // get data identifier from request
    let configId = req.params.configId;
    
    if (!configId) { 
        //  response based on status - 400 Bad Request or 402 Required id        
        res.status(400).send('{code: 400, message: "Bad Request"}');
        
    }

    // concat app and data identifier examplary id: "prodes_amazon_rates"
    let id = appId + "_" + configId;

    // json get of rejson
    redis.json_get(id, 'NOESCAPE', function(err, payload){
  
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
        
    // get header from app
    let appId = api_calls.check_app_identifier(req, res, next);
    if (!appId) {
        res.status(404).send('{code: 404, message: "Not Found"}');
        
    }

    // get config identifier from request
    let configId = req.params.configId;
    
    if (!configId) { 
        //  response based on status - 400 Bad Request or 402 Required id        
        res.status(400).send('{code: 400, message: "Bad Request"}');
        
    }

    // concat app and data identifier examplary id: "prodes_amazon_rates"
    let id = appId + "_" + configId;

    // json set of rejson
    redis.json_set(id, '.', JSON.stringify(req.body), function(err) {
        if(err)
            res.status(400).send('{code: 400, message: "Bad Request"}');
        else
           res.status(200).send('{code: 200, message: "OK"}');  
      });
  
}

// delete configuration data
exports.del_config_ids = function(req, res, next) {

    // get header from app
    let appId = api_calls.check_app_identifier(req, res, next);
    if (!appId) {
        res.status(404).send('{code: 404, message: "Not Found"}');
        
    }

    // get data identifier from request
    let configId = req.params.configId;
    
    if (!configId) { 
        //  response based on status - 400 Bad Request or 402 Required id        
        res.status(400).send('{code: 400, message: "Bad Request"}');
        
    }

    // concat app and data identifier examplary id: "prodes_amazon_rates"
    let id = appId + "_" + configId;
    
    // json del of rejson
    redis.json_del(id, function(err) {
        if(err)
            res.status(400).send('{code: 400, message: "Bad Request"}');
        else
           res.status(200).send('{code: 200, message: "OK"}');  
      });

}