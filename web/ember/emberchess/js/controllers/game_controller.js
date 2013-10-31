App.GameController = Ember.ArrayController.extend({
	init: function() {
		this._super();
		this.send('gameChanged');
	},
	actions: {
		gameChanged: function() {
			this.set('rows', App.chessEngine.json());
		}
	}
});