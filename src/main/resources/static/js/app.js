var calendarApp = angular.module('calendarApp', []);

calendarApp.controller('calendarAppCtrl', function ($scope) {
  
	$scope.constants = {
		days: ['Sunday','Monday','Tuesday','Wednesday','Thursday','Friday','Saturday'],
		months: ['January','February','March','April','May','June','July','August','September','October','November','December']
	}
	
	function daysInMonth(month,year) {
	    return new Date(year, month + 1, 0).getDate();
	}
	
	var today = new Date();
	
	$scope.calendar = {
		currentMonth: $scope.constants.months[today.getMonth()],
		currentYear: today.getFullYear()
	};
	
	$scope.calendar.days = [];
	
	var numberOfDaysInCurrentMonth = daysInMonth(today.getMonth(), today.getFullYear());
	for(var i = 1; i <= numberOfDaysInCurrentMonth; i++) {
		$scope.calendar.days.push({
			number: i,
			events: []
		});
	}
	
	{
		var firstDateOfMonth = new Date(today);
		firstDateOfMonth.setDate(1);
		var lastDateOfFormerMonth = daysInMonth(today.getMonth() - 1, today.getFullYear());
		var days = [];
		for(var i = 0; i < firstDateOfMonth.getDay(); i++) {
			days.push({
				number: lastDateOfFormerMonth - i,
				events: []
			});
		}
		$scope.calendar.formerMonthDays = days;
	}
	
	{
		var lastDateOfMonth = new Date(today.getFullYear(), today.getMonth() + 1, 0);
		var days = [];
		for(var i = 1; i < (7 - lastDateOfMonth.getDay()); i++) {
			days.push({
				number: i,
				events: []
			});
		}
		$scope.calendar.subsequentMonthDays = days;
	}
	
});