App.wife = Ember.Object.create({
	householdIncome: 80000
});

App.husband = Ember.Object.create({
	householdIncomeBinding: 'App.wife.householdIncome'
});

App.husband.get('householdIncome'); // 80000

// Someone gets raise.
App.husband.set('householdIncome', 90000);
App.wife.get('householdIncome'); // 90000

App.wife.addObserver('householdIncome', function() {
	console.log('Wife income changed: '+App.wife.get('householdIncome'));
});