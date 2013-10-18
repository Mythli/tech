App.Favorites = DS.Model.extend({
	title: DS.attr('string')
});

App.Favorites.FIXTURES = [
	{
		id: 1,
		title: 'Learn Ember.js'
	},
	{
		id: 2,
		title: '...'
	},
	{
		id: 3,
		title: 'Profit!'
	}
];