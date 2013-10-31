App.CellView = Ember.View.extend({
	attributeBindings: 'draggable',
	tagName: 'td',
	draggable: 'true',
	classNameBindings: ['color', 'piece'],

	dragOver: function(event) {
		event.preventDefault();
	},
	dragLeave: function(event) {
		event.preventDefault();
	},
	dragStart: function(event) {
		var xy = this.get('x') + this.get('y');
		event.dataTransfer.setData('text/text', xy);
	},
	drop: function(event) {
		var to = this.get('x') + this.get('y');
		var from = event
			.originalEvent.dataTransfer
			.getData('text/text');
		App.chessEngine.move({'from': from, 'to': to});
		this.get('controller').send('gameChanged');
		event.preventDefault();
	}
});