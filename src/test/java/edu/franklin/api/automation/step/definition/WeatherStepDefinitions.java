package edu.franklin.api.automation.step.definition;

import java.util.List;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class WeatherStepDefinitions {

	String uri;
	int status;
	@Given("^I want to perform get operation for \"([^\"]*)\"$")
	public void given(String url) throws Throwable {

		uri = url;
	}

	@Given("^I query for city \"([^\"]*)\"$")
	public void queryForCity(String city) {
		RestAssured.when().get(uri + city).then().assertThat().statusCode(200);
	}

	
	@When("I complete action")
	public void complete_action() {
	   
	}

	@Then("I should get the {string} as {string}")
	public void i_should_get_the_as(String columnName, String city) {
		List<String> values=RestAssured.when().get(uri + city).then().extract().jsonPath().getList("title");
		Assert.assertTrue(values.contains(city));
	}

}
