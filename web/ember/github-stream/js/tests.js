mocha.setup('bdd');
var expect = chai.expect;
onload = function() {
	var runner = mocha.run();
};
var client = setupTesting();
client.startAtRoute("index");

describe("hello world", function() {
	it("says hello world", function() {
		expect("asdfasdf").to.equal("hello world");
	});
});

describe("hello world", function() {
	it("says hello world", function() {
		expect(client.$('div:contains("hello world!")').length).to.equal(0);
		client.$("a:first").click();
		expect(client.$('div:contains("hello world!")').length).to.equal(1);
	});
});