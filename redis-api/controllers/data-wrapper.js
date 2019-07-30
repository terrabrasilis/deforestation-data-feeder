var redis = require('../models/redis');

// get list of applications id
exports.get_apps_ids = function(req, res, next) {
    
    redis.json_get("appsIdentifier", function(err, payload){
    
        if (!payload) {
            res.status(404).send('{code: 404, message: "Not Found"}');
        } else {
            res.locals.appIds = payload; 
            next();
        }

    });

}

// get list of all increase and rates data depending on the project
exports.get_data_all = function(req, res, next) {
       
    // get header from app
    let appId = req.get('App-Identifier');       

    if (!appId) { 
        // response based on status - 401 Not Allowed
        res.status(400).send('{code: 400, message: "Bad Request"}');
        return;
    }

    // json parse appIds 
    var appIds = JSON.parse(res.locals.appIds);
    var exists = false;

    // check app id exists
    for(var i = 0; i < appIds.length; i++) {
        if (appId === appIds[i].identifier) {
            exists = true;
            break;
        }
    }        
    
    if (!exists) { 
        // response based on status - 401 Not Allowed
        res.status(401).send('{code: 401, message: "Not Allowed"}');
        return;
    }            
        
    // get data identifier from request
    let dataId = req.params.dataId;
    
    if (!dataId) { 
        //  response based on status - 400 Bad Request or 402 Required id        
        res.status(400).send('{code: 400, message: "Bad Request"}');
        return;
    }

    // concat app and data identifier examplary id: "prodes_amazon_rates"
    let id = appId + "_" + dataId;
    
    // json get of rejson
    redis.json_get(id, function(err, payload){

        if (!payload) {
            //  response based on status - 404 not found
            res.status(404).send('{code: 404, message: "Not Found"}');
        } else {             
            // send json answer
            res.send(payload);
        }

    });
  
}

// post list of all increase and rates data depending on the project
exports.post_data_all = function(req, res, next) {
    
    // get header from app
    let appId = req.get('App-Identifier');
    
    if (!appId) { 
        // response based on status - 401 Not Allowed
        res.status(401).send('{code: 401, message: "Not Allowed"}');
        return;
    }

    // json parse appIds 
    var appIds = JSON.parse(res.locals.appIds);
    var exists = false;

    // check app id exists
    for(var i = 0; i < appIds.length; i++) {
        if (appId === appIds[i].identifier) {
            exists = true;
            break;
        }
    }        
    
    if (!exists) { 
        // response based on status - 401 Not Allowed
        res.status(404).send('{code: 404, message: "Not Found"}');
        return;
    }

    // get data identifier from request
    let dataId = req.params.dataId;
    
    if (!dataId) { 
        //  response based on status - 400 Bad Request or 402 Required id        
        res.status(400).send('{code: 400, message: "Bad Request"}');
        return;
    }

    // concat app and data identifier examplary id: "prodes_amazon_rates"
    let id = appId + "_" + dataId;
    
    // json set of rejson
    redis.json_set(id, '.', JSON.stringify(req.body), function(err) {
        if(err)
            res.status(400).send('{code: 400, message: "Bad Request"}');
        else
           res.status(200).send('{code: 200, message: "OK"}');  
      });

      
  
}

// delete list of all increase and rates data depending on the project
exports.del_data_all = function(req, res, next) {
    
    // get header from app
    let appId = req.get('App-Identifier');
    
    if (!appId || apps_ids.indexOf(appId) <= -1) { 
        // response based on status - 401 Not Allowed
        res.status(401).send('{code: 401, message: "Not Allowed"}');
        return;
    }

    // get data identifier from request
    let dataId = req.params.data_id;
    
    if (!dataId) { 
        //  response based on status - 400 Bad Request or 402 Required id        
        res.status(400).send('{code: 400, message: "Bad Request"}');
        return;
    }

    // concat app and data identifier examplary id: "prodes_amazon_rates"
    let id = appId + "_" + dataId;
    
    // json set of rejson
    redis.json_del(id, function(err) {
        if(err)
            res.status(400).send('{code: 400, message: "Bad Request"}');
        else
           res.status(200).send('{code: 200, message: "OK"}');  
      });

}