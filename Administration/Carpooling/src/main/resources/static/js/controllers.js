var myApp = angular.module('myApp',[]);

myApp.controller('MyController',function MyController($scope ,$http){
$http.get('info.json').then (function(response)
{
$scope.team =response.data;
$scope.choice='name';

});

});

