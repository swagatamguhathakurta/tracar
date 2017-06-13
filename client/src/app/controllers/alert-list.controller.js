(function() {
    'use strict';
    angular.module('plunker')
        .controller('AlertListController', AlertListController);

    AlertListController.$inject = ['alertService'];

    function AlertListController(alertService) {
        var alertListVm = this;

        alertService.get()
            .then(function(alerts){
                alertListVm.alerts = alerts;
            }, function (error){
                console.log(error);
            });
    }

})();