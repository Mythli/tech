window.App = Ember.Application.create();

App.Person = Ember.Object.extend({
	say: function(thing) {
		alert(thing);
	}
});

App.Person = Ember.Object.extend({
	say: function(thing) {
		var name = this.get('name');

		alert(name + " says: " + thing);
	}
});

App.Soldier = App.Person.extend({
	say: function(thing) {
		this._super(thing + ", sir!");
	}
});

var yehuda = App.Soldier.create({
	name: "Yehuda Katz"
});

yehuda.say("Yes");
