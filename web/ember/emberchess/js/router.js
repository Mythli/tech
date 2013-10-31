App.Router.map(function() {
	this.resource('game');
});

App.IndexRoute = Ember.Route.extend({
	redirect: function() {
		this.transitionTo('game');
	}
});