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

	selectedLabels: Ember.A(),
	filteredLinks: Ember.A(),

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
			var linkName = this.get("linkName"),
				linkUrl = this.get("linkUrl");

			if(this.selectedLabels.length > 0) {
				if(linkName.length > 0 && linkUrl.length > 0) {
					// TODO: this is probably wrong.
					/*this.get("links").addObject({
						name: linkName,
						url: linkUrl,
						labels: this.selectedLabels
					});*/
					this.store.push("link", {
						name: linkName,
						url: linkUrl,
						labels: this.get('selectedLabels').copy()
					});
					this.set("linkName", "");
					this.set("linkUrl", "");
					this.send("showLinks");
				}
			} else {
				alert("You have to select a label!");
			}
		},

		showLinks: function(){
			var labelsIds = this.get('selectedLabels').mapProperty('id'),
				linksPromise = this.get("store").find("link"),
				_this = this;

			linksPromise.then(
				function(links){
					_this.set("filteredLinks", Ember.A());
					links.forEach(function(link) {
						var linkLabels = link.get('labels'),
							linkLabelIds = linkLabels.mapProperty('id');
						if(!Ember.isEmpty(Ember.EnumerableUtils.intersection(labelsIds, linkLabelIds))){
							_this.get("filteredLinks").addObject(link);
						}
					});
				}
			);
		}
	}
});