(function() {
    'use strict';
    angular.module('plunker')
        .service('vehicleService', vehicleService);

    vehicleService.$inject = ['$q', '$http', 'CONFIG'];

    function vehicleService($q, $http, CONFIG) {
        var self = this;

        self.get = getVehicles;
        self.getByVin = getVehicleByVin;

        function getVehicles() {
            return $http.get(CONFIG.API_HOST + '/vehicles')
                .then(successFn, errorFn);
        }

        function getVehicleByVin(id) {
            return $http.get(CONFIG.API_HOST + '/vehicles/' + id)
                .then(successFn, errorFn);
        }

        function successFn(response) {
            return response.data;
        }

        function errorFn(error) {
            return $q.reject(error);
        }
    }
})();
