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
		labels: [1]
	},
	{
		id: 2,
		name: 'Heise',
		url: 'http://heise.de',
		labels: [1]
	},
	{
		id: 3,
		name: 'Feedly',
		url: 'http://feedly.com',
		labels: [3,1]
	},
];