angular.module('enterpriseApp1.services', [])
        .factory('restService', function($http) {

    var restAPI = {};

    restAPI.getDrivers = function() {
        return $http({
            method: 'JSONP',
            url: 'http://localhost:2020/rest/api/getCountries'
        });
    }

    return restAPI;
});