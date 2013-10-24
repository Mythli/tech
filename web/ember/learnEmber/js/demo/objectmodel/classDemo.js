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


App.FreeNigga.reopen({
	isNigga: true
});

var luther = App.FreeNigga.create({name: 'Martin Luther King'});
if(luther.get('isNigga')) {
	console.log('Luther is a nigga!');
}
luther.speakFree('all niggaz should be free!');