App.Link = DS.Model.extend({
	labels: DS.hasMany('label'),
	name: DS.attr(),
	url: DS.attr()
});

App.Link.FIXTURES = [
	{
		id: 1,
		name: 'Google',
		url: 'http://google.com',
		labels: [2]
	},
	{
		id: 2,
		name: 'Bing',
		url: 'http://bing.com',
		labels: [2]
	},
	{
		id: 3,
		name: 'Heise',
		url: 'http://heise.de',
		labels: [1]
	},
	{
		id: 4,
		name: 'Ember',
		url: 'http:/emberjs.com',
		labels: [1]
	},
	{
		id: 5,
		name: 'Feedly',
		url: 'http://feedly.com',
		labels: [3,1]
	},
	{
		id: 6,
		name: 'Space',
		url: 'http://space.com',
		labels: [3]
	}
];