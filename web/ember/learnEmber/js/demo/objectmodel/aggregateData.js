App.AlbumsController = Ember.Controller.extend({
	albums: null,

	released: function() {
		var albums = this.get('albums');
		return albums.filterBy('isReleased', true).get('length');
	}.property('todos.@each.isReleased')
});

App.albumsController = App.AlbumsController.create({
	albums: [
		Ember.Object.create({ isReleased: false }),
		Ember.Object.create({ isReleased: false }),
		Ember.Object.create({ isReleased: false })
	]
});

var albums = App.albumsController.get('albums');
var album = albums.objectAt(0);

album = Ember.Object.create({isReleased: true});
albums.pushObject(album);

console.log('Number of released albums: '+App.albumsController.get('released'));