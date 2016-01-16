var app = angular.module('blog', [ ]);

app.controller('HomeController', function($scope,$http) {
  $scope.helloWorld = 'Aplicatii Web cu suport Java!';
  
  var url = "http://localhost:8080/jucatori.json";
  $http.get(url).success(function(response){
	
	$scope.jucatori = response;
	console.log($scope.jucatori);
  
  });
  
	var url="http://localhost:8080/teme.json";
  $http.get(url).success(function(response){
  
	$scope.teme= response;
	console.log($scope.teme);
  });
  var url="http://localhost:8080/masini.json";
  $http.get(url).success(function(response){
  
	$scope.masini= response;
	console.log($scope.masini);
  });
  
})