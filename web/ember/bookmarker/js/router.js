App.title = "Bookmarker";

App.Router.map(function() {
	this.route("about");
	this.route("faq");
});

App.IndexRoute = Ember.Route.extend({
	activate: function() {
		$(document).attr('title', App.title+" - Home");
	},
	model: function(params) {
		return {
			labels: this.get("store").find("label"),
			links: this.get("store").find("link").filter()
		};
	}
});

App.AboutRoute = Ember.Route.extend({
	activate: function() {
		$(document).attr('title', App.title+" - About");
	},
});

App.FaqRoute = Ember.Route.extend({
	activate: function() {
		$(document).attr('title', App.title+" - FAQ");
	},
});