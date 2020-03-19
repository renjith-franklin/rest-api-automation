package edu.franklin.api.automation.step.definition;

import com.google.gson.JsonObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class AccountStepDefinitions {

	String uri;
	int status;
	JsonObject jsonpObject;

	@Given("^the account API as \"([^\"]*)\"$")
	public void set_the_account_api(String url) throws Throwable {

		uri = url;
	}

	@When("I create a user using user name  {string} , password  {string},first name {string},last name {string} and gender {string}")
	public void set_create_account_fields(String userName, String password, String firstName, String lastName,
			String gender) {
		jsonpObject = new JsonObject();
		jsonpObject.addProperty("email", userName);
		jsonpObject.addProperty("password", password);
		jsonpObject.addProperty("firstName", firstName);
		jsonpObject.addProperty("lastName", lastName);
		jsonpObject.addProperty("gender", gender);

	}

	@Then("I should get {string} http response for http post")
	public void validate_http_response_post(String httpcode) {
		RestAssured.given().header("Content-Type", "application/json").body(jsonpObject.toString()).post(uri).then()
				.assertThat().statusCode(Integer.parseInt(httpcode));
	}

	@When("I get a user using user name  {string}")
	public void set_get_account_fields(String userName) {
		jsonpObject = new JsonObject();
		jsonpObject.addProperty("email", userName);

	}

	@Then("I should get {string} http response for http get")
	public void validate_http_response_get(String httpcode) {
		RestAssured.given().header("Content-Type", "application/json")
				.get(uri + "/" + jsonpObject.get("email").toString()).then().assertThat()
				.statusCode(Integer.parseInt(httpcode));
	}

	@When("I update a user using user name  {string} ,first name {string},last name {string} and gender {string}")
	public void set_account_account_fields(String userName, String firstName, String lastName, String gender) {
		jsonpObject = new JsonObject();
		jsonpObject.addProperty("email", userName);
		jsonpObject.addProperty("firstName", firstName);
		jsonpObject.addProperty("lastName", lastName);
		jsonpObject.addProperty("gender", gender);

	}

	@Then("I should get {string} http response for http put")
	public void validate_http_response_put(String httpcode) {
		RestAssured.given().header("Content-Type", "application/json").body(jsonpObject.toString()).put(uri).then()
				.assertThat().statusCode(Integer.parseInt(httpcode));
	}

	@When("I delete a user using user name  {string}")
	public void set_get_account_fields_for_delete(String userName) {
		jsonpObject = new JsonObject();
		jsonpObject.addProperty("email", userName);

	}

	@Then("I should get {string} http response for http delete")
	public void validate_http_response_delete(String httpcode) {
		RestAssured.given().header("Content-Type", "application/json")
				.delete(uri + "/" + jsonpObject.get("email").toString()).then().assertThat()
				.statusCode(Integer.parseInt(httpcode));
	}

}
