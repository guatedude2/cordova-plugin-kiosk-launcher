
var exec = require('cordova/exec');

var Kiosk = {

    exitKiosk: function () {
        exec(null, null, "Kiosk", "exitKiosk", []);
    },

    isInKiosk: function (callback) {
        exec(function(out){
            callback(out == "true");
        }, function(error){
            alert("Kiosk.isInKiosk failed: " + error);
        }, "Kiosk", "isInKiosk", []);
    },

    isSetAsLauncher: function (callback) {
        exec(function(out){
            callback(out == "true");
        }, function(error){
            alert("Kiosk.isSetAsLauncher failed: " + error);
        }, "Kiosk", "isSetAsLauncher", []);
    }

}

module.exports = Kiosk;

