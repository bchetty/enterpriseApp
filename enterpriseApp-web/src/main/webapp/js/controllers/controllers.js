angular.module('enterpriseApp1.controllers', []).
    /* Driver controller */
    controller('HelloController', function($scope) {
        $scope.greeting = {text: 'Hello'};
    }
);