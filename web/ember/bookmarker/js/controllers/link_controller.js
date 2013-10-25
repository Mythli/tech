App.LinkController = Ember.ObjectController.extend({
	actions: {
		delete: function() {
			//var indexController = this.get('controllers.index');
			//indexController.get("links").removeObject(this.get("model"));
			var link = this.get("model");
			link.deleteRecord();
			link.save();
		}
	}
});