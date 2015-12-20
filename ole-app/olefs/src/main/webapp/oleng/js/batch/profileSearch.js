/**
 * Created by SheikS on 12/16/2015.
 */

var batchProfileSearchApp = angular.module('batchProfileSearchApp', []);

batchProfileSearchApp.controller('batchProfileSearchController', ['$scope','searchProfile', function($scope,searchProfile){

    $scope.profiles = [];

    var url = "../../batchProfile/batchProfileRestController/search";
    $scope.search = function(){
        $scope.profiles = [];
        var profileName = $scope.profileName;
        searchProfile.searchProfile($scope,profileName, url);
    };

    $scope.showModal = false;
    $scope.profileInquiry = function(profileId){
        $scope.showModal = !$scope.showModal;
    };
    $scope.closeModal = function(){
        $scope.showModal = false;
    };

}]);



batchProfileSearchApp.service('searchProfile', ['$http', function ($http) {
    this.searchProfile = function($scope,profileName,uploadUrl){
        var data = {};
        data["profileName"] = profileName;
        $http.post(uploadUrl, JSON.stringify(data), {
                transformRequest: angular.identity,
                headers: {'Content-Type': undefined}
            })
            .success(function(response){
                var profiles = JSON.stringify(response) ;
                var log = [];
                angular.forEach(response, function(value, key) {
                    $scope.profiles.push(value);
                }, log);
            })
            .error(function(){
                console.log("Failed");
            });
    }
}]);

batchProfileSearchApp.directive('modal', function () {
    return {
        template: '<div class="modal fade">' +
        '<div class="modal-dialog">' +
        '<div class="modal-content">' +
        '<div class="modal-header">' +
        '<button type="button" class="close" data-dismiss="modal" aria-hidden="true" ng-click="closeModal()">&times;</button>' +
        '<h4 class="modal-title">{{ title }}</h4>' +
        '</div>' +
        '<div class="modal-body" ng-transclude></div>' +
        '</div>' +
        '</div>' +
        '</div>',
        restrict: 'E',
        transclude: true,
        replace:true,
        scope:true,
        link: function postLink(scope, element, attrs) {
            scope.title = attrs.title;

            scope.$watch(attrs.visible, function(value){
                if(value == true)
                    $(element).modal('show');
                else
                    $(element).modal('hide');
            });

            $(element).on('shown.bs.modal', function(){
                scope.$apply(function(){
                    scope.$parent[attrs.visible] = true;
                });
            });

            $(element).on('hidden.bs.modal', function(){
                scope.$apply(function(){
                    scope.$parent[attrs.visible] = false;
                });
            });
        }
    };
});