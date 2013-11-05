App.CellView = Ember.View.extend({
	cellColor: function() {
		return App.checkerboardColor(this.get('x'), this.get('y'));
	}.property('x', 'y'),

	tagName: 'td',
	legalMove: false,
	attributeBindings: 'draggable',
	draggable: 'true',
	classNameBindings: ['color', 'piece', 'cellColor',
		'legalMove:highlight:default'],

	dragOver: function(event) {
		var to = this.get('x') + this.get('y');
		var from = event
			.originalEvent.dataTransfer
			.getData('text/text');
		isLegal = App.chessEngine.isMoveLegal(to, from);
		if (isLegal) {
			this.set('legalMove', true);
		}
		event.preventDefault();
	},
	dragLeave: function(event) {
		this.set('legalMove', false);
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
		this.set('legalMove', 'false');
		event.preventDefault();
	}
});