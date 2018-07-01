
var app = angular.module("app", [ "ngRoute" ]);

app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/home', {
		templateUrl : 'home.html'
	});
	$routeProvider.when('/restaurants', {
		templateUrl : 'restaurant.html',
		controller : 'restaurantCtrl'
	});
	$routeProvider.when('/items', {
		templateUrl : 'items.html',
		controller : 'itemsCtrl'
	});
	$routeProvider.when('/login', {
		templateUrl : 'login.html',
		controller : 'loginCtrl'
	});
	$routeProvider.otherwise({
		redirectTo : '/home'
	});
} ]);

app.controller("restaurantCtrl", function($scope, $http) {

	$scope.fetchRestaurant = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:8080/restaurant/getAll'
		}).success(function(data, status) {
			console.log(data);
			$scope.status = status;
			$scope.restaurants = data;
		}).error(function(data, status) {
			$scope.status = status;
			$scope.data = "Request failed";
		});
	};
	
	
	$scope.saveRestaurant = function() {
		$http({
			method : 'POST',
			url : 'http://localhost:8080/restaurant/add',
			headers: { 'Content-Type': 'application/json' },
			data:$scope.restaurant
		}).success(function(data, status) {
			console.log(data);
			$scope.fetchRestaurant();
			$scope.restaurants = data;
		}).error(function(data, status) {
			$scope.status = status;
			$scope.data = "Request failed";
		});
	};

});

app.controller("itemsCtrl", function($scope, $http) {

	$scope.fetchItem = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:8080/restaurant/getAllItem'
		}).success(function(data, status) {
			console.log(data);
			$scope.status = status;
			$scope.items = data;
		}).error(function(data, status) {
			$scope.status = status;
			$scope.data = "Request failed";
		});
	};
	
	$scope.saveItem = function() {
		$http({
			method : 'POST',
			url : 'http://localhost:8080/restaurant/addItem',
			headers : {'Content-Type' : 'application/json' },
			data : $scope.item
		}).success(function(data, status) {
			console.log(data);
			$scope.fetchItem();
			$scope.items = data;
		}).error(function(data, status){
			$scope.status = status;
			$scope.data = "Request failed";
		});
		
	};
	

});


app.controller("loginCtrl", function($scope, $http){
	
	$scope.loginUser = function(){
	
		$http({
			method : 'POST',
			url : 'http://localhost:8080/user/login',
			headers: { 'Content-Type': 'application/json' },
			data:$scope.user
		}).success(function(data, status) {
			console.log(data);
			if(data){
				$scope.message = "Welcome Back:" + data.name;
				console.log($scope.lgText);
				lgNam =  "Welcome Back:" + data.name;
				console.log(lgNam);
				window.location = "/#/items"
			}else{
				$scope.message = "Login Failed";
			}
		}).error(function(data, status) {
			$scope.status = status;
			console.log(data);
			$scope.message = "Request failed";
		});
	};

});