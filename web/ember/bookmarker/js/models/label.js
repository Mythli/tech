App.Label = DS.Model.extend({
	links: DS.hasMany('link'),
	name: DS.attr('string'),
	colorClass: DS.attr('string')
});

App.Label.FIXTURES = [
	{
		id: 1,
		name: 'Develop',
		colorClass: 'btn-default'
	},
	{
		id: 2,
		name: 'Suche',
		colorClass: 'btn-success'
	},
	{
		id: 3,
		name: 'Anderes',
		colorClass: 'btn-success'
	},
];