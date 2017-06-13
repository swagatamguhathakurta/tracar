(function() {
    'use strict';
    angular.module('plunker', ['ngRoute','angular.filter']);


    angular.module('plunker')
        .config(moduleConfig);

    moduleConfig.$inject = ['$routeProvider'];

    function moduleConfig($routeProvider) {
        $routeProvider
            .when('/vehicles', {
                templateUrl: 'app/views/vehicle-list.tmpl.html',
                controller: 'VehicleListController',
                controllerAs: 'vehicleListVm'
            })
            .when('/vehicles/:id', {
                templateUrl: 'app/views/vehicle-detail.tmpl.html',
                controller: 'VehicleDetailController',
                controllerAs: 'vehicleDetailVm'
            })
            .when('/readings', {
                templateUrl: 'app/views/alert-list.tmpl.html',
                controller: 'AlertListController',
                controllerAs: 'alertListVm'
            })
            .when('/readings/:id', {
                templateUrl: 'app/views/alert-detail.tmpl.html',
                controller: 'AlertDetailController',
                controllerAs: 'alertDetailVm'
            })
            .when('/filter', {
                templateUrl: 'app/views/alert-history.tmpl.html',
                controller: 'AlertHistoryController',
                controllerAs: 'alertHistoryVm'
            })
            .otherwise({
                redirectTo: '/vehicles'
            });
    }
})();