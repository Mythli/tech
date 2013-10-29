App.LinkController = Ember.ObjectController.extend({
	needs: "index",
	actions: {
		remove: function() {
			// TODO: this is probably wrong.
			var indexController = this.get('controllers.index');
			indexController.get("links").removeObject(this.get("model"));
			//var link = this.get("model");
			//link.deleteRecord();
			//link.save();
		}
	}
});