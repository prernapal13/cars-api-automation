package cars.stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cars.utilities.CarResponse;
import cars.utilities.Context;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import gherkin.deps.com.google.gson.Gson;

public class CommonSteps {

	private Context context;

	public CommonSteps(Context context) {
		this.context = context;
	}

	@Then("^\"([^\"]*)\" request should return response code (\\d+)$")
	public void request_should_return_response_code(String reqType, int expectedStatusCode) {
		assertEquals(reqType + " should return Response code " + expectedStatusCode, expectedStatusCode,
				context.response.statusCode());
	}

	@And("^Response wkda should not be empty$")
	public void response_wkda_should_not_be_empty() {
		context.carResponse = new Gson().fromJson(context.response.asString(), CarResponse.class);
		assertTrue("Manufacturer map should not be empty.", context.carResponse.getWkda().size() > 0);

	}

	@And("^Response wkda should be empty$")
	public void response_wkda_should_be_empty() throws Throwable {
		context.carResponse = new Gson().fromJson(context.response.asString(), CarResponse.class);
		assertTrue("Manufacturer map should not be empty", context.carResponse.getWkda().size() == 0);
	}

}