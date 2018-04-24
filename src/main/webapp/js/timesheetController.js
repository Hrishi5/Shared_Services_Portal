var tsApp = angular.module('tsApp',['ui.bootstrap']) ;

tsApp.controller('tsAppCtrl',function($scope,$http,$filter) {
	$scope.burl = 'Shared_Services_Portal' ;
	$scope.dt = new Date() ;
	$scope.currentDay = $scope.dt.getDate() - 1 ;
	$scope.disableWeekends = function(data) {
	    var date = data.date,
	      mode = data.mode;
	    return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
	  }
	$scope.options = {maxDate:new Date()
	,minDate: new Date($scope.dt.getFullYear(), $scope.dt.getMonth(), 1),
	dateDisabled:$scope.disableWeekends
	}
	 
	
	$scope.days = [] ;
	$scope.createDaysArray = function() {
		for(var i=0 ; i<$scope.dt.getDate() ; i++) {
		$scope.days.push({
			date:new Date($scope.dt.getFullYear(), $scope.dt.getMonth(), i+1),
			tasks:[],
			hours:0,
			checkedDb:false
		  }) ;	
		}
	}
	$scope.createDaysArray() ;
	
	
	
	$scope.title = ["Sr.No","Task Name","Hours","Delete"] ;
	$scope.addTask = function(day) {
		var hrdiff = 1 ;
		hrdiff = 8 - day.hours ;
		if(hrdiff <= 0) {
			return ;
		}
		var task = {
				name:"",
				details:"",
				hours:1
					
		}
		
	$scope.days[$scope.currentDay].tasks.push(task)	;
	$scope.days[$scope.currentDay].hours+=1 ;
	}
	
	$scope.onDateChange = function(dt) {
		$scope.currentDay = dt.getDate() - 1 ;
		if($scope.days[$scope.currentDay].tasks.length === 0 
				&& $scope.days[$scope.currentDay].checkedDb === false) {
			$http.post('/Shared_Services_Portal/getTimesheet',
					{key:'1',value:$filter('date')(new Date($scope.dt),'yyyy-MM-dd')})
			.then(function(response){
				if(response.data.status === '1') {
					$scope.days[$scope.currentDay] = response.data.response ;
					$scope.days[$scope.currentDay].checkedDb === true ;
				}
			},function(response){
				
			}) ;
		}
	}
	
	$scope.onHoursChange = function(days,tasks,index,oldHours) {
		var sum = 0 ;
		oldHours = Number(oldHours)
		var t = days[$scope.currentDay].tasks ;
		
		for (var i=0 ; i<t.length ; i++) {
			
			sum+=t[i].hours ;
			if(sum > 8) {
				$scope.days[$scope.currentDay].tasks[index].hours = oldHours ;
				return ;
			}
		}
		$scope.days[$scope.currentDay].hours += $scope.days[$scope.currentDay].tasks[index].hours - oldHours
	}
	
	$scope.removeTask = function(taskList , index) {
		taskList.splice(index,1) ;
	}
	
	$scope.onClickOfSubmit = function(days) {
		var data = [] ;
		var updatedData = [] ;
		for(var i=0 ; i<days.length ; i++) {
			if(days[i].tasks.length > 0 && days[i].hours > 0 && days[i].checkedDb === false) {
			var tasks = days[i].tasks
			for(var j=0 ; j<tasks.length ; j++) {
			 if(tasks[j].name.trim() === '' || tasks[j].hours===0) {	
				 $scope.removeTask(days[i].tasks,j) ;
				 continue ;
			 }
			}
			if(days[i].checkedDb === false) {
			data.push(days[i]) ;
			}else{
				updatedData.push(days[i]) ;
			}
		}
		}
		console.log(JSON.stringify(data))
		$http.post('/Shared_Services_Portal/saveTimesheet',data).then(function(response){
			alert(response.data.response) ;
		},function(response){
			alert(response.data.response); 
		})
	}
	
	
}) ;