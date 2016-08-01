angular.module('SchoolTrip.controllers', []).controller('navigation',

		function($rootScope, $http, $location, $route) {
			
			var self = this;

			self.tab = function(route) {
				return $route.current && route === $route.current.controller;
			};

			var authenticate = function(credentials, callback) {

				var headers = credentials ? {
					authorization : "Basic "
							+ btoa(credentials.username + ":"
									+ credentials.password)
				} : {};

				$http.get('user', {
					headers : headers
				}).then(function(response) {
					if (response.data.name) {
						$rootScope.authenticated = true;
					} else {
						$rootScope.authenticated = false;
					}
					callback && callback($rootScope.authenticated);
				}, function() {
					$rootScope.authenticated = false;
					callback && callback(false);
				});

			}

			authenticate();
			self.credentials = {};
			self.login = function() {
				authenticate(self.credentials, function(authenticated) {
					if (authenticated) {
						console.log("Login succeeded")
						$location.path("/complete");
						$rootScope.error = false;
						$rootScope.authenticated = true;
					} else {
						console.log("Login failed")
						$location.path("/login");
						$rootScope.error = true;
						$rootScope.authenticated = false;
				}
				})
			};
			
			self.logout = function() {
				$http.post('logout', {}).finally(function() {
					$rootScope.authenticated = false;
					$location.path("/");
				});
			}
			

}).controller('home', function($http) {
	var self = this;
	$http.get('/resource/').then(function(response) {
		self.greeting = response.data;
	})
}).controller('register', function($rootScope, $http, $location, $route){
	var self=this;
	self.errorMsg="";
	self.register = function() {		
		var data = {
				"username" : self.credentials.username,
				"password" : self.credentials.password,
					};
			var json = JSON.stringify(data);
			// sends request to server
			$http.post("register", json).success(function(response) {
				$rootScope.regError = false;
				$rootScope.authenticated = true;
				$location.path("/form");
			}).error(function(response){
				console.log("REGISTER failed")
				$location.path("/register");
				$rootScope.regError = true;
				$rootScope.errorMsg=response.message;
				$rootScope.authenticated = false;			
			});	
	};
}).controller('location',function($scope, $http, $location, $route){
	$http.get("http://ipinfo.io").then(function(response) {
		$scope.location = response.data;
		debugger;
})
});
