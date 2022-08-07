angular
    .module('CalcDish-front')
    .controller('mealController', function ($scope,$http){

        const contextPath = 'http://localhost:5555';

        $scope.loadMeals = function (pageIndex = 1) {
            $http.get(contextPath + '/core/api/v1/meals')
                .then(function (response) {
                    $scope.MealsPage = response.data;
                    $scope.paginationArray = $scope.generatePagesIndexes(1,$scope.MealsPage.totalPages);
                });
        };

        $scope.generatePagesIndexes = function (startPage, endPage){
            let arr = [];
            for (let i = startPage; i < endPage; i++){
                arr.push(i);
            }
            return arr;
        }

        $scope.loadMeals();
});