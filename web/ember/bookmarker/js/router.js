App.Router.map(function() {
	this.route("about");
	this.route("faq");
});

App.ApplicationController = Ember.Route.extend({
});

App.IndexRoute = Ember.Route.extend({
	activate: function() {
		$(document).attr('title', App.title+" - Home");
	},
	model: function(params) {
		return {
			labels: this.get("store").find("label"),
			// TODO: this is probably wrong.
			links: this.get("store").find("link")
		};
	}
});

App.AboutRoute = Ember.Route.extend({
	activate: function() {
		$(document).attr("title", App.title+" - About");
	}
});

App.FaqRoute = Ember.Route.extend({
	activate: function() {
		$(document).attr('title', App.title+" - FAQ");
	}
});