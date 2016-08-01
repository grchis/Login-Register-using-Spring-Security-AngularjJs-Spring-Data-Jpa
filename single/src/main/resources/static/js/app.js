angular.module('SchoolTrip', [ 'SchoolTrip.controllers','ngRoute' ]).config(function($routeProvider, $httpProvider) {

	$routeProvider.when('/', {
		templateUrl : 'partials/public/home.html',
		controller : 'home',
		controllerAs: 'controller'
	}).when('/login', {
		templateUrl : 'partials/public/login.html',
		controller : 'navigation',
		controllerAs: 'controller'
	}).when('/register',{
		templateUrl:'partials/public/register.html',
		controller:'register',
		controllerAs:'controller'
	}).when('/complete',{
		templateUrl:'partials/private/step_by_step_form.html',
		controller:'location',
	}).otherwise('/');
	$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
});