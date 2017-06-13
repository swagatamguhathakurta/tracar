(function() {
    'use strict';
    angular.module('plunker')
        .controller('AlertHistoryController', AlertHistoryController);

    AlertHistoryController.$inject = ['alertService'];
    var alertVm = this;
    function reset(){
        console.log("fun called");
    }
    function AlertHistoryController(alertService) {
        var alertHistoryVm = this;

        alertService.get()
            .then(function(alerts){
                // alertHistoryVm.alerts = alerts;
                alertHistoryVm.alerts = [
                    {id: 1, title: 'fuelVolume'},
                    {id: 2, title: 'speed'},
                    {id: 3, title: 'engineHp'},
                    {id: 4, title: 'engineRpm'}
                ];
            }, function (error){
                console.log(error);
            });

        alertService.his()
            .then(function () {
            console.log(alertHistoryVm);
            }, function (error){
                console.log(error);
            });

        alertService.master = {firstName:"John", lastName:"Doe"};
        alertService.reset = function() {
            alertService.user = angular.copy(alertService.master);
        };
        alertService.reset();
    }

})();