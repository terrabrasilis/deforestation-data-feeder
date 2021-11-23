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

exports.get_data_queryable = function(req, res, next) {

    // get header from app
    let appId = api_calls.check_app_identifier(req, res, next);
    if (!appId) {
        res.status(404).send('{code: 404, message: "Not Found"}');
        return;
    }

    const loiname = req.query.loiname;
    if (!loiname) { 
        // response based on status - 401 Not Allowed
        res.status(400).send('{code: 400, message: "Bad Request"}');
        return;
    }
    
    const startdate = req.query.startdate;    
    if (!startdate) { 
        // response based on status - 401 Not Allowed
        res.status(400).send('{code: 400, message: "Bad Request"}');
        return;
    } else {
        parseStartDate = new Date(startdate); //moment.ISO_8601
        if (!(parseStartDate instanceof Date && !isNaN(parseStartDate))) { // check valid date        
            res.status(400).send('{code: 400, message: "Bad Request"}');
            return;
        }
    }
    
    const enddate = req.query.enddate;
    if (!enddate) { 
        // response based on status - 401 Not Allowed
        res.status(400).send('{code: 400, message: "Bad Request"}');
        return;
    } else {
        parseEndDate = new Date(enddate); //moment.ISO_8601
        if (!(parseEndDate instanceof Date && !isNaN(parseEndDate))) { // check valid date        
            res.status(400).send('{code: 400, message: "Bad Request"}');
            return;
        }
    }
    
    // get data identifier from request
    let clazz = req.query.class;
    if (!clazz) { 
        //  response based on status - 400 Bad Request or 402 Required id        
        res.status(400).send('{code: 400, message: "Bad Request"}');
        return;
    }

    // concat app and data identifier examplary id: "prodes_amazon_rates"
    let id = appId + "_" + clazz;
    
    // json get of rejson
    redis.json_get(id, 'NOESCAPE', function(err, payload){

        if (!payload) {
            //  response based on status - 404 not found
            res.status(404).send('{code: 404, message: "Not Found"}');
        } else {             
            // send json answer for all
            aux = JSON.parse(payload);     
            periods = new Array();                                        
            for (i in aux.periods) { // for each period
                var init = new Date(aux.periods[i].startDate["year"]+"-"+aux.periods[i].startDate["month"]+"-"+aux.periods[i].startDate["day"]);                
                var end = new Date(aux.periods[i].endDate["year"]+"-"+aux.periods[i].endDate["month"]+"-"+aux.periods[i].endDate["day"]);
                if (parseStartDate <= init && parseEndDate >= end) { // temporal filter
                    for (j in aux.periods[i].features) { // assign each of the features to auxiliary variable
                        if (aux.periods[i].features[j]["loiname"] == loiname) {
                            periods.push(aux.periods[i]);
                            periods[periods.length-1].features = new Array(aux.periods[i].features[j]); // array features 
                            break;
                        }
                    }                                        
                } 
            }            
            aux.periods = periods;
            res.send(aux);
        }

    });

    
}

// get list of all increase and rates data depending on the project
exports.get_data_all = function(req, res, next) {
       
    // get header from app
    let appId = api_calls.check_app_identifier(req, res, next);
    if (!appId) {
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
    
    // json get of rejson
    redis.json_get(id, 'NOESCAPE', function(err, payload){

        if (!payload) {
            //  response based on status - 404 not found
            res.status(404).send('{code: 404, message: "Not Found"}');
        } else {             
            // send json answer for all
            if (req.params.loinameId == "all")
                res.send(payload);
            else {                
                aux = JSON.parse(payload);                                            
                for (i in aux.periods) { // for each period
                    var area = null;            
                    aux2 = new Array(); 
                    for (j in aux.periods[i].features) { // assign each of the features to auxiliary variable
                        if (aux.periods[i].features[j]["loiname"] == req.params.loinameId) {
                            aux2.push(aux.periods[i].features[j]);
                            break;
                        }
                    }
                    aux.periods[i].features = aux2; // replace features for the loinameId features
                }
                res.send(aux);
            }
            
        }

    });
  
}

// post list of all increase and rates data depending on the project
exports.post_data_all = function(req, res, next) {
    
    // get header from app
    let appId = api_calls.check_app_identifier(req, res, next);
    if (!appId)
        return; 

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
    let appId = api_calls.check_app_identifier(req, res, next);
    if (!appId)
        return; 

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