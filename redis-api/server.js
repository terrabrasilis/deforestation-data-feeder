// import all the required packages
const compression = require('compression');
const express = require('express');

// import routes
var routes = require('./routes/index');

// creates an express application
var app = express();

// define parameters for api
app.use(express.json({limit: '100mb'}));
app.use(compression());

// add headers
app.use(function(req, res, next) {    
    
    // set response header
    res.setHeader('Content-Type', 'application/json');
    res.setHeader('Access-Control-Allow-Origin', '*');
    res.setHeader('Access-Control-Allow-Headers', 'Content-Type, App-Identifier');

    // pass to next layer of middleware
    next();

});

// define routes with the mount path (\dashboard)
app.use('/dashboard/api', routes);

// export app
module.exports = app;