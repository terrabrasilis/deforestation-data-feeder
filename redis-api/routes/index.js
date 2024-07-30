// framework for web application
const express = require('express'); 

// create middleware for routing
var router = express.Router();

// Require controller modules
var data_wrapper = require('../controllers/data-wrapper');
var apps_wrapper = require('../controllers/apps-wrapper');
var config_wrapper = require('../controllers/config-wrapper');
var status_wrapper = require('../controllers/status-wrapper');

// define api version
const version = "/v1";

// read only configuration
var readOnly = process.env.READ_ONLY || 'yes';

// api endpoint for health test
router.use('/health', status_wrapper.is_connected);

// set api for apps identifier endpoint
router.get(version+'/redis-cli/apps/identifier', apps_wrapper.get_apps_ids);

// set api for data endpoint
router.use(version+'/redis-cli/data/', data_wrapper.get_apps_ids);
router.use(version+'/redis-cli/data/query', data_wrapper.get_data_queryable);
router.get(version+'/redis-cli/data/:dataId/:loinameId', data_wrapper.get_data_all);

// set api for config files endpoint
router.use(version+'/redis-cli/config/', config_wrapper.get_apps_ids);
router.use(version+'/redis-cli/config/query/loinames', config_wrapper.get_loinames_queryable);
router.get(version+'/redis-cli/config/:configId', config_wrapper.get_config_ids);


if (readOnly === 'no') {
    // endpoints for input data. Used only to prepare the new data file for publishing.
    router.post(version+'/redis-cli/apps/identifier', apps_wrapper.post_apps_ids);
    router.delete(version+'/redis-cli/apps/identifier', apps_wrapper.del_apps_ids);
    router.post(version+'/redis-cli/data/:dataId', data_wrapper.post_data_all);
    router.delete(version+'/redis-cli/data/:dataId', data_wrapper.del_data_all);
    router.post(version+'/redis-cli/config/:configId', config_wrapper.post_config_ids);
    router.delete(version+'/redis-cli/config/:configId', config_wrapper.del_config_ids);
}

// export router
module.exports = router;