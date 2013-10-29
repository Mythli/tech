App.LabelController = Ember.ObjectController.extend({
	needs:["index"],
	active: false,
	cssClass: function() {
		if(this.get('active')) {
			return 'btn-primary';
		} else {
			return this.get('colorClass');
		}
	}.property('colorClass', 'active'),

	actions: {
		findLinks: function() {
			var selectedLabels = this.get('controllers.index.selectedLabels');

			this.toggleProperty('active');
			if(this.get('active')){
				selectedLabels.addObject(this.get('model'));
			}
			else
			{
				selectedLabels.removeObject(this.get('model'));
			}
			this.send('activeLabel');
		},

		remove: function() {
			var indexController = this.get('controllers.index'),
				label = this.get('model'),
				linksPromise = this.get('store').find('link');

			linksPromise.then(function(links){
				links.forEach(function(link){
					var linkLabels = link.get('labels'),
						linkLabelsIds = linkLabels.mapProperty('id');

						if(linkLabelsIds.contains(label.get("id"))) {
							if(linkLabelsIds.get("length") == 1) {
								console.log("delete link: "+link.get("name"));
								// TODO: this is probably wrong.
								indexController.get("links").removeObject(link);
								//link.deleteRecord();
								//link.save();
							}
						}
				});

				label.deleteRecord();
				label.save();
			});
		}
	}
});