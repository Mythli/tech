App.LabelController = Ember.ObjectController.extend({
	needs: ["list"],
	active: false,

	actions: {
		findLinks: function() {
			var listController = this.get('controllers.list');

			this.toggleProperty('active');

			listController.set('model', this.get('store').find('link'));
		}
	}
});