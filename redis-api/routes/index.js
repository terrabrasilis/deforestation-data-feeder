// framework for web application
const express = require('express'); 

// create middleware for routing
var router = express.Router();

// Require controller modules
var data_wrapper = require('../controllers/data-wrapper');
var apps_wrapper = require('../controllers/apps-wrapper');
var config_wrapper = require('../controllers/config-wrapper');

// define api version
const version = "/v1";

// get healthy api
router.get('/', function(req, res, next) {
    
    // set response header
    res.setHeader('Content-Type', 'application/json; charset=utf-8');
    res.setHeader('Access-Control-Allow-Origin', '*');

    // send api healthy 
    res.send({"healthy": true}); 

});

// define api for data
router.use(version+'/redis-cli/data/', data_wrapper.get_apps_ids);

router.get(version+'/redis-cli/data/:dataId', data_wrapper.get_data_all);

router.post(version+'/redis-cli/data/:dataId', data_wrapper.post_data_all);

router.delete(version+'/redis-cli/data/:dataId', data_wrapper.del_data_all);

// define api for apps identifier
router.get(version+'/redis-cli/apps/identifier', apps_wrapper.get_apps_ids);

router.post(version+'/redis-cli/apps/identifier', apps_wrapper.post_apps_ids);

router.delete(version+'/redis-cli/apps/identifier', apps_wrapper.del_apps_ids);

// define api for config files
router.get(version+'/redis-cli/config/:configId', config_wrapper.get_config_ids);

router.post(version+'/redis-cli/config/:configId', config_wrapper.post_config_ids);

router.delete(version+'/redis-cli/config/:configId', config_wrapper.del_config_ids);

// TODO routes?start=...&end=...&class=

// export router
module.exports = router;