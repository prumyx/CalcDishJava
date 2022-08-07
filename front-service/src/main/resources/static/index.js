(function (){
    angular
        .module('CalcDish-front',['ngRoute', 'ngStorage'])
        .config(config)
        //.run(run)

    function config($routeProvider){
        $routeProvider
            /*.when('/', {
                templateUrl: 'welcome/welcome.html',
                controller: 'welcomeController'
            })*/
            .when('/dishes',{
                templateUrl: 'dish/dish.html',
                controller: 'dishController'
            })
            .when('/meal',{
                templateUrl: 'meal/meal.html',
                controller: 'mealController'
            })
            .otherwise({
                redirectTo: '/'
            });
    }
})();

angular
    .module('CalcDish-front')
    .controller('indexController', function ($rootScope, $scope, $http, $location, $localStorage){

    });