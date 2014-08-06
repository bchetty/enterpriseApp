'use strict';

var enterpriseApp = angular.module('enterpriseApp', []);

enterpriseApp.controller('HelloController', ['$scope', '$http', function($scope, $http) {
        $http.get('http://localhost:2020/enterpriseApp/rest/api/getCountries').
                success(function(data) {
            $scope.countries = data;
        });
    }]);