App.GameController = Ember.ArrayController.extend({
	init: function() {
		this._super();
		this.send('gameChanged');
	},
	gameOver: function() {
		return App.chessEngine.game_over();
	}.property('rows'),
	actions: {
		gameChanged: function() {
			this.set('rows', App.chessEngine.toEmber());
		}
	}
});