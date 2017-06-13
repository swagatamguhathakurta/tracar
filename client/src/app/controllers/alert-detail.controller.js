(function() {
    'use strict';
    angular.module('plunker')
        .controller('AlertDetailController', AlertDetailController);

    AlertDetailController.$inject = ['alertService', '$routeParams'];

    function AlertDetailController(alertService, $routeParams) {
        var alertDetailVm = this;

        alertService.getByVin($routeParams.id)
            .then(function (alerts){
                alertDetailVm.alerts = alerts;
            }, function (error){
                console.log(error);
            });
    }

})();