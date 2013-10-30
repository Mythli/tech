App.LinkController = Ember.ObjectController.extend({
	needs: "index",
	actions: {
		remove: function() {
			// TODO: this is probably wrong.
			var indexController = this.get('controllers.index');
			//indexController.get("links").removeObject(this.get("model"));
			//this.get("model").save();
			var link = this.get("model");
			link.deleteRecord();
			link.save();
			indexController.send("showLinks");
		}
	}
});