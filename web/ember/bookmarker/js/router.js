App.Router.map(function() {
	this.route('list', { path: '/' });
});

App.ApplicationRoute = Ember.Route.extend({
	model: function () {
		return this.store.findAll('label');
	}
});

App.LabelRoute = Ember.Route.extend({
	model: function(params) {
		return this.get('store').find('link');
	}
})