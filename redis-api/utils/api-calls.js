exports.check_app_identifier = function(request, result) {

    // get header from app
    let appId = request.get('App-Identifier');

    if (!appId) {
        // response based on status - 401 Not Allowed
        result.status(400).send('{code: 400, message: "Bad Request"}');
        return;
    }

    // json parse appIds 
    var appIds = JSON.parse(result.locals.appIds);
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
        result.status(401).send('{code: 401, message: "Not Allowed"}');
        return;
    }          

    return appId;

}