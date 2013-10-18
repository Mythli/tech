App.Nigga = Ember.Object.extend({
	init: function() {
		console.log('nigga base initialized.');
	}
});

App.FreeNigga = App.Nigga.extend({
	init: function() {
		this._super();
	},

	speakFree: function(freeSpeech) {
		console.log(this.get('name')+' says: '+freeSpeech);
	}
});


var luther = App.FreeNigga.create({name: 'Martin Luther King'});
luther.speakFree('all niggaz should be free!');