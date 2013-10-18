App.Song = Ember.Object.extend({
	title: null,
	rating: null

	review: function() {
		return this.get('title')+' is '+this.get('rating');
	}.property('title', 'rating');
});

var willstDu = App.Song.create({
	title: 'Willst du',
	rating: 5
});