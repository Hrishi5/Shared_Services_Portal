var indexApp = angular.module('iApp',[]) ;

indexApp.controller('iCtrl',function($scope,$window){
	$scope.onLeaveClick = function() {
		//console.log($window.location.href) ;
	document.getElementById('viewsrc').src = 'leave.html'
	}
	
	$scope.onClaimsClick = function(){
		document.getElementById('viewsrc').src = 'claims.html'
	}
	
	$scope.onTimesheetClick = function(){
		document.getElementById('viewsrc').src = 'timesheet.html'
	}
	
	
})

