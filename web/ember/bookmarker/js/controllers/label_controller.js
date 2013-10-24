App.LabelController = Ember.ObjectController.extend({
	needs:['application'],
	active: false,
	actions: {
		findLinks: function() {
			this.toggleProperty('active');
			var selectedLabels =   this.get('controllers.application.selectedLabels');
			if(this.get('active')){
				selectedLabels.addObject(this.get('model'));
			}
			else
			{
				selectedLabels.removeObject(this.get('model'));
			}
			this.send('activeLabel');
		}
	}
});