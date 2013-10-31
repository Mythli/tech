window.App = Ember.Application.create();
App.chessEngine = new Chess();

App.chessEngine.yConvert = function(wrongY) {
	return 9 - wrongY;
}

App.chessEngine.xConvert = function(wrongX) {
	if (3 == wrongX) {
		return 'a';
	}
	if (5 == wrongX) {
		return 'b';
	}
	if (7 == wrongX) {
		return 'c';
	}
	if (9 == wrongX) {
		return 'd';
	}
	if (11 == wrongX) {
		return 'e';
	}
	if (13 == wrongX) {
		return 'f';
	}
	if (15 == wrongX) {
		return 'g';
	}
	if (17 == wrongX) {
		return 'h';
	}
}

// fixme: better method name for this.
App.chessEngine.json = function() {

	var jsonRows = Ember.A();
	var asciiLines = this.ascii().split("\n");

	for(var i = 0; i < asciiLines.length; i++) {

		var line = asciiLines[i];
		var jsonRow = Ember.A();

		if (line.match(/^ \d /)) {

			var squares = line.split(" ");

			for (var j = 0; j < squares.length; j++) {

				var square = squares[j];

				if (square.match(/\./)) {
					squareObject = {
						'color': 'empty',
						'piece': 'empty',
						'x': this.xConvert(j),
						'y': this.yConvert(i)
					};
					jsonRow.pushObject(squareObject);
				}

				if (square.match(/p/)) {
					squareObject = {
						'color': 'black',
						'piece': 'pawn',
						'x': this.xConvert(j),
						'y': this.yConvert(i)
					};
					jsonRow.pushObject(squareObject);
				}

				if (square.match(/r/)) {
					squareObject = {
						'color': 'black',
						'piece': 'rook',
						'x': this.xConvert(j),
						'y': this.yConvert(i)
					};
					jsonRow.pushObject(squareObject);
				}

				if (square.match(/n/)) {
					squareObject = {
						'color': 'black',
						'piece': 'knight',
						'x': this.xConvert(j),
						'y': this.yConvert(i)
					};
					jsonRow.pushObject(squareObject);
				}

				if (square.match(/b/)) {
					squareObject = {
						'color': 'black',
						'piece': 'bishop',
						'x': this.xConvert(j),
						'y': this.yConvert(i)
					};
					jsonRow.pushObject(squareObject);
				}

				if (square.match(/q/)) {
					squareObject = {
						'color': 'black',
						'piece': 'queen',
						'x': this.xConvert(j),
						'y': this.yConvert(i)
					};
					jsonRow.pushObject(squareObject);
				}

				if (square.match(/k/)) {
					squareObject = {
						'color': 'black',
						'piece': 'king',
						'x': this.xConvert(j),
						'y': this.yConvert(i)
					};
					jsonRow.pushObject(squareObject);
				}

				if (square.match(/P/)) {
					squareObject = {
						'color': 'white',
						'piece': 'pawn',
						'x': this.xConvert(j),
						'y': this.yConvert(i)
					};
					jsonRow.pushObject(squareObject);
				}

				if (square.match(/R/)) {
					squareObject = {
						'color': 'white',
						'piece': 'rook',
						'x': this.xConvert(j),
						'y': this.yConvert(i)
					};
					jsonRow.pushObject(squareObject);
				}

				if (square.match(/N/)) {
					squareObject = {
						'color': 'white',
						'piece': 'knight',
						'x': this.xConvert(j),
						'y': this.yConvert(i)
					};
					jsonRow.pushObject(squareObject);
				}

				if (square.match(/B/)) {
					squareObject = {
						'color': 'white',
						'piece': 'bishop',
						'x': this.xConvert(j),
						'y': this.yConvert(i)
					};
					jsonRow.pushObject(squareObject);
				}

				if (square.match(/Q/)) {
					squareObject = {
						'color': 'white',
						'piece': 'queen',
						'x': this.xConvert(j),
						'y': this.yConvert(i)
					};
					jsonRow.pushObject(squareObject);
				}

				if (square.match(/K/)) {
					squareObject = {
						'color': 'white',
						'piece': 'king',
						'x': this.xConvert(j),
						'y': this.yConvert(i)
					};
					jsonRow.pushObject(squareObject);
				}

			}

		}

		if (jsonRow.length > 0) {
			jsonRows.pushObject(jsonRow);
		}

	}

	return jsonRows;
};