App.Router.map(function() {
	this.route('favorites');
});

App.Router.map(function() {
	this.resource("photos", function(){
		this.route("edit", { path: "/:photo_id" });
	});
});