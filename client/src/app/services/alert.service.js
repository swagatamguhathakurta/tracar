(function() {
    'use strict';
    angular.module('plunker')
        .service('alertService', alertService);

    alertService.$inject = ['$q', '$http', 'CONFIG'];

    function alertService($q, $http, CONFIG) {
        var self = this;

        self.get = getAlerts;
        self.getByVin = getAlertsByVin;
        self.his = history;

        function getAlerts() {
            return $http.get(CONFIG.API_HOST + '/readings')
                .then(successFn, errorFn);
        }

        function getAlertsByVin(vin) {
            return $http.get(CONFIG.API_HOST + '/readings/' + vin)
                .then(successFn, errorFn);
        }

        function history() {
            return $http.get(CONFIG.API_HOST + '/readings')
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
