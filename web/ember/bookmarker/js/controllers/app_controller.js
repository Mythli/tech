App.ApplicationController = Ember.ArrayController.extend({
	selectedLabels:[],
	actions: {
		newLabel: function() {
			var store = this.get("store");
			store.push("label", {
				name: this.get("newLabelName"),
				color: "yellow"
			});
			this.set("newLabelName", "");
		}
	}
});