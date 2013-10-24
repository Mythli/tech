Person = Ember.Object.extend({
	// these will be supplied by `create`
	firstName: null,
	lastName: null,

	fullName: function() {
		var firstName = this.get('firstName');
		var lastName = this.get('lastName');

		return firstName + ' ' + lastName;
	}.property('firstName', 'lastName'),

	fullNameChanged: function() {
		console.log('Full name changed: '+this.get('fullName'));
	}.observes('fullName').on('init')
});

var person = Person.create({
	firstName: "Yehuda",
	lastName: "Katz"
});

person.reopen({
	firstNameChanged: Ember.observer(function() {
		console.log('First name changed: '+this.get('firstName'));
	}, 'firstName')
});

person.addObserver('lastName', function() {
	console.log('Last name changed: '+person.get('lastName'));
});

person.set('firstName', "Jenny");
person.set('lastName', "Trusyev");
person.set('firstName', "Makar");