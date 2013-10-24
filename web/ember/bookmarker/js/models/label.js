App.Label = DS.Model.extend({
	links: DS.hasMany('link'),
	name: DS.attr('string'),
	color: DS.attr('string')
});

App.Label.FIXTURES = [
	{
		id: 1,
		name: 'Develop',
		color: 'blue'
	},
	{
		id: 2,
		name: 'Suche',
		color: 'green'
	},
	{
		id: 3,
		name: 'Anderes',
		color: 'red'
	},
];