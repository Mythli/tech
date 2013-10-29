App.AboutController = Ember.ObjectController.extend({
	needs: "application",
	init: function() {
		this.set("controllers.application.title", "About");
	},
});