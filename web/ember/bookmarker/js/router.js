App.Router.map(function() {
	this.route('link', { path: '/' });
});

App.ApplicationRoute = Ember.Route.extend({
	model: function() {
		return this.get('store').findAll('label');
	},
	actions:{
		activeLabel: function(){
			var linkController = this.controllerFor('link'),
				appController = this.controllerFor('application'),
				labelsIds = appController.get('selectedLabels').mapProperty('id');

			this.get('store').find('link').then(
				function(links){
					links.forEach(function(link){
						var linkLabels = link.get('labels'),
							linkLabelsIds = linkLabels.mapProperty('id');
						if(!Ember.isEmpty(Ember.EnumerableUtils.intersection(labelsIds,linkLabelsIds))){
							linkController.addObject(link);
						}
						else {
							linkController.removeObject(link);
						}
					});
				}
			);
		}
	}
});

App.LinkRoute = Ember.Route.extend({
	model: function(params) {
		return Ember.A();
	}
});