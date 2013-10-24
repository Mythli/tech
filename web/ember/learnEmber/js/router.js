App.Router.reopen({
	rootURL: '/web/ember/learnEmber/'
});

App.Router.map(function() {
	this.resource('favorites', function() {
		this.route('new');
	});
});

App.IndexRoute = Ember.Route.extend({
	setupController: function(controller) {
		controller.set('title', 'Swagger');
	}
});

App.FavoritesIndexRoute = Ember.Route.extend({
	model: function() {
		return [
			{name: 'Google', title: 'Search Engine', url: 'http://google.de'},
			{name: 'Heise', title: 'IT News', url: 'http://heise.de'}
		];
	}
});