package edu.franklin.api.automation.step.definition;

import com.google.gson.JsonObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class AuthStepDefinitions {
	String uri;
	int status;
	JsonObject jsonpObject;

	@Given("^the login API as \"([^\"]*)\"$")
	public void set_the_login_api(String url) throws Throwable {

		uri = url;
	}

	
	@When("I login using user name  {string} and password  {string}")
	public void set_username_password(String userName, String password) {
		jsonpObject = new JsonObject();
		jsonpObject.addProperty("email", userName);
		jsonpObject.addProperty("password", password);

	}

	@Then("I should get {string} http response")
	public void validate_http_response(String httpcode) {
		RestAssured.given().header("Content-Type", "application/json").body(jsonpObject.toString()).post(uri).then()
				.assertThat().statusCode(Integer.parseInt(httpcode));
	}

	@Then("I should get error {string} http response")
	public void validate_http_response_for_error(String httpcode) {
		RestAssured.given().header("Content-Type", "application/json").body(jsonpObject.toString()).post(uri).then()
				.assertThat().statusCode(Integer.parseInt(httpcode));
	}

	@Given("^the logout API as \"([^\"]*)\"$")
	public void set_the_logout_api(String url) throws Throwable {

		uri = url;
	}

	@When("I logout using user name  {string}")
	public void set_username_for_logout(String userName) {
		jsonpObject = new JsonObject();
		jsonpObject.addProperty("email", userName);

	}
}
