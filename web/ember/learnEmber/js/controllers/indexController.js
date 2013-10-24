App.IndexController = Ember.Controller.extend({
	name: 'Oberswagger',
	person: {
		firstName: 'Tobias',
		lastName: 'Anhalt',
		hasPaid: true,
		total: 20
	},

	people: [
		{name: 'Tobias Anhalt'},
		{name: 'Makar Trusyev'},
		{name: 'Jenny Schreiber'}
	],
	actions: {
		swag: function() {
			alert('maximum swag!');
		}
	}
});