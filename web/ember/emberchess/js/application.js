window.App = Ember.Application.create();
App.chessEngine = new Chess();

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

App.chessEngine.toEmber = function() {

	var rows = Ember.A();
	var asciiLines = this.ascii().split("\n");

	for(var i = 0; i < asciiLines.length; i++) {

		var line = asciiLines[i];
		var row = Ember.A();

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
					row.pushObject(squareObject);
				}

				if (square.match(/p/)) {
					squareObject = {
						'color': 'black',
						'piece': 'pawn',
						'x': this.xConvert(j),
						'y': this.yConvert(i)
					};
					row.pushObject(squareObject);
				}

				if (square.match(/r/)) {
					squareObject = {
						'color': 'black',
						'piece': 'rook',
						'x': this.xConvert(j),
						'y': this.yConvert(i)
					};
					row.pushObject(squareObject);
				}

				if (square.match(/n/)) {
					squareObject = {
						'color': 'black',
						'piece': 'knight',
						'x': this.xConvert(j),
						'y': this.yConvert(i)
					};
					row.pushObject(squareObject);
				}

				if (square.match(/b/)) {
					squareObject = {
						'color': 'black',
						'piece': 'bishop',
						'x': this.xConvert(j),
						'y': this.yConvert(i)
					};
					row.pushObject(squareObject);
				}

				if (square.match(/q/)) {
					squareObject = {
						'color': 'black',
						'piece': 'queen',
						'x': this.xConvert(j),
						'y': this.yConvert(i)
					};
					row.pushObject(squareObject);
				}

				if (square.match(/k/)) {
					squareObject = {
						'color': 'black',
						'piece': 'king',
						'x': this.xConvert(j),
						'y': this.yConvert(i)
					};
					row.pushObject(squareObject);
				}

				if (square.match(/P/)) {
					squareObject = {
						'color': 'white',
						'piece': 'pawn',
						'x': this.xConvert(j),
						'y': this.yConvert(i)
					};
					row.pushObject(squareObject);
				}

				if (square.match(/R/)) {
					squareObject = {
						'color': 'white',
						'piece': 'rook',
						'x': this.xConvert(j),
						'y': this.yConvert(i)
					};
					row.pushObject(squareObject);
				}

				if (square.match(/N/)) {
					squareObject = {
						'color': 'white',
						'piece': 'knight',
						'x': this.xConvert(j),
						'y': this.yConvert(i)
					};
					row.pushObject(squareObject);
				}

				if (square.match(/B/)) {
					squareObject = {
						'color': 'white',
						'piece': 'bishop',
						'x': this.xConvert(j),
						'y': this.yConvert(i)
					};
					row.pushObject(squareObject);
				}

				if (square.match(/Q/)) {
					squareObject = {
						'color': 'white',
						'piece': 'queen',
						'x': this.xConvert(j),
						'y': this.yConvert(i)
					};
					row.pushObject(squareObject);
				}

				if (square.match(/K/)) {
					squareObject = {
						'color': 'white',
						'piece': 'king',
						'x': this.xConvert(j),
						'y': this.yConvert(i)
					};
					row.pushObject(squareObject);
				}

			}

		}

		if (row.length > 0) {
			rows.pushObject(row);
		}

	}

	return rows;

};

App.chessEngine.randomMove = function() {
	var moves = App.chessEngine.moves();
	var random = moves[Math.floor(Math.random() * moves.length)];
	App.chessEngine.move(random);
};

App.Router.map(function() {
	this.resource('game');
});

App.IndexRoute = Ember.Route.extend({
	redirect: function() {
		this.transitionTo('game');
	}
});

App.GameController = Ember.ArrayController.extend({

	init: function() {
		this._super();
		this.gameChanged();
	},

	gameChanged: function() {
		this.set('rows', App.chessEngine.toEmber());
	},

	randomMove: function() {
		App.chessEngine.randomMove();
		this.gameChanged();
	},

	gameOver: function() {
		return App.chessEngine.game_over();
	}.property('rows')
});

App.RowView = Ember.View.extend({
	templateName: 'row',
	tagName: 'tr',
	classNames: ['board-row']
});

App.checkerboardColor = function(x, y) {
	var columns = [
		'a', 'b', 'c', 'd',
		'e', 'f', 'g', 'h'
	];
	var columnNumber = function(letter) {
		return columns.indexOf(letter) + 1;
	};

	var yEven = false;
	if (0 == y % 2) {
		yEven = true;
	}
	var xEven = false;
	if (0 == columnNumber(x) % 2) {
		xEven = true;
	}

	var color = null;

	if (xEven && yEven) {
		color = 'silver';
	} else if (!(xEven) && !(yEven)) {
		color = 'silver';
	} else {
		color = 'white';
	}

	return color;
}

App.chessEngine.isMoveLegal = function(to, from) {

	// underlying chess engine provides very convenient
	// move-validation functionality, wrapped inside an
	// insane, archaic format created in the 1700s and
	// popularized in the 1800s (not even kidding).

	var index = 0;
	var verifyMove = function(to, from) {
		return App.chessEngine.moves({square: from}).indexOf(to)
	}
	var legitMove = false;

	// coordinates get prefixes specifying piece names, unless
	// the piece in motion is a pawn.
	['', 'R', 'N', 'B', 'Q', 'K'].forEach(function(prefix) {
		index = verifyMove(prefix + to, from);
		if (0 <= index) {
			legitMove = true;
		}
	});

	// most captures get prefixes specifying piece name plus
	// capture status plus destination, e.g. 'Nxe4'
	['Rx', 'Nx', 'Bx', 'Qx', 'Kx'].forEach(function(prefix) {
		index = verifyMove(prefix + to, from);
		if (0 <= index) {
			legitMove = true;
		}
	});

	// pawn captures get prefixes specifying piece column
	// plus capture status plus destination, e.g. 'gxf4'
	var pawnCapture = from.replace(/\d/, 'x') + to;
	index = verifyMove(pawnCapture, from);
	if (0 <= index) {
		legitMove = true;
	}

	// TLDR: one big edge case.
	// arcane castling notation: http://bit.ly/10Zxi0s
	// kingside castles are returned from the moves() function as
	// "O-O", while queenside castles are returned as "O-O-O".

	this.whiteKingSideCastle = function() {
		if ("e1" == from &&
			"g1" == to &&
			0 <= verifyMove("O-O", from)) {
			return true;
		} else {
			return false;
		}
	};

	this.whiteQueenSideCastle = function() {
		if ("e1" == from &&
			"c1" == to &&
			0 <= verifyMove("O-O-O", from)) {
			return true;
		} else {
			return false;
		}
	};

	this.blackKingSideCastle = function() {
		if ("e8" == from &&
			"g8" == to &&
			0 <= verifyMove("O-O", from)) {
			return true;
		} else {
			return false;
		}
	};

	this.blackQueenSideCastle = function() {
		if ("e8" == from &&
			"c8" == to &&
			0 <= verifyMove("O-O-O", from)) {
			return true;
		} else {
			return false;
		}
	};

	if (this.whiteKingSideCastle() ||
		this.whiteQueenSideCastle() ||
		this.blackKingSideCastle() ||
		this.blackQueenSideCastle()) {
		legitMove = true;
	}

	// TODO: corner cases
	//
	// 1) pawn promotion
	//      http://en.wikipedia.org/wiki/Algebraic_notation_(chess)#Pawn_promotion
	//
	// pawns about to promote themselves (become
	// queens/knights/etc) can get valid move options that
	// look like this:
	// "gxf8=Q+", "gxf8=R+", "gxf8=B", "gxf8=N", "gxh8=Q",
	// "gxh8=R", "gxh8=B", "gxh8=N".
	//
	// 2) putting a king in check
	//
	// like this: "cxd7+". "+" seems to indicate putting the
	// king in check, and can apparently be attached to any
	// move (or at least any move which puts the king in
	// check.
	//
	// apologies but I'm not going to implement these -- if I
	// went that far, I'd basically be buildng an entire move
	// parser! but if you want to give it a whirl, please do!

	return legitMove;
};