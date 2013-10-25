App.IndexController = Ember.ObjectController.extend({
	colors: [
		{color: "White", class: "btn-default"},
		{color: "Blue", class: "btn-info"},
		{color: "Orange", class: "btn-warning"},
		{color: "Red", class: "btn-danger"},
		{color: "Transparent", class: "btn-link"}
	],
	labelColor: { color: "White", class: "btn-danger" },

	selectedLabels:[],

	actions: {
		newLabel: function() {
			var store = this.get("store"),
				newLabel = this.get("newLabelName");

			if(newLabel.length > 0) {

				store.push("label", {
					name: newLabel,
					colorClass: this.get("labelColor")["class"]
				});
				this.set("newLabelName", "");
			}
		},

		newLink: function() {
			var store = this.get("store"),
				newLink = this.get("newLinkName"),
				linkUrl = this.get("linkUrl");

			if(this.selectedLabels.length > 0) {
				if(newLink.length > 0) {
					store.push("link", {
						name: newLink,
						url: linkUrl,
						labels: this.selectedLabels
					});
					this.set("newLinkName", "");
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