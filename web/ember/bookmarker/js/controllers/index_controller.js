App.IndexController = Ember.ObjectController.extend({
	colors: [
		{color: "White", cssClass: "btn-default"},
		{color: "Blue", cssClass: "btn-info"},
		{color: "Orange", cssClass: "btn-warning"},
		{color: "Red", cssClass: "btn-danger"},
		{color: "Transparent", cssClass: "btn-link"}
	],

	labelColor: {
		cssClass: "btn-default"
	},

	selectedLabels:[],

	actions: {
		newLabel: function() {
			var store = this.get("store"),
				newLabel = this.get("labelName");

			if(newLabel.length > 0) {
				store.push("label", {
					name: newLabel,
					colorClass: this.get("labelColor").cssClass
				});
				this.set("labelName", "");
			}
		},

		newLink: function() {
			var store = this.get("store"),
				linkName = this.get("linkName"),
				linkUrl = this.get("linkUrl");

			if(this.selectedLabels.length > 0) {
				if(linkName.length > 0 && linkUrl.length > 0) {
					// TODO: this is probably wrong.
					this.get("links").addObject({
						name: linkName,
						url: linkUrl,
						labels: this.selectedLabels
					});
					/*store.push("link", {
						name: newLink,
						url: linkUrl,
						labels: this.selectedLabels
					});*/
					this.set("linkName", "");
					this.set("linkUrl", "");
				}
			} else {
				alert("You have to select a label!");
			}
		},

		activeLabel: function(){
			var labelsIds = this.get('selectedLabels').mapProperty('id'),
				linksPromise = this.get('store').find('link'),
				_this = this;

			linksPromise.then(
				function(links){
					links.forEach(function(link) {
						var linkLabels = link.get('labels'),
							linkLabelsIds = linkLabels.mapProperty('id');
						if(!Ember.isEmpty(Ember.EnumerableUtils.intersection(labelsIds,linkLabelsIds))){
							_this.get("links").addObject(link);
						} else {
							_this.get("links").removeObject(link);
						}
					});
				}
			);
		}
	}
});