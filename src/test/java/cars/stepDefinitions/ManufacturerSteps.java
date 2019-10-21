package cars.stepDefinitions;

import static cars.utilities.Constants.BASE_URL;
import static cars.utilities.Constants.INVALID_MANUFACTURER;
import static cars.utilities.Constants.MANUFACTURER;
import static cars.utilities.Constants.WA_KEY;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cars.utilities.Context;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class ManufacturerSteps {

	private Context context;

	public ManufacturerSteps(Context context) {
		this.context = context;
	}

	@When("^User request for car manufacturers$")
	public void user_request_for_car_manufacturers() {
		//@formatter:off
        context.response =  given()
                            .queryParam("wa_key", WA_KEY)
                            .when()
                            .get(BASE_URL + MANUFACTURER);
        //@formatter:on
	}

	@And("^Manufacturer map should contain manufacturer code \"([^\"]*)\" with manufacturer name \"([^\"]*)\"$")
	public void manufacturer_map_should_contain_manufacturer_code_with_manufacturer_name(String code, String name) {

		assertTrue("Manufacturer map should should contain code: " + code,
				context.carResponse.getWkda().containsKey(code));

		assertEquals("Manufacturer name against code " + code + " should be " + name, name,
				context.carResponse.getWkda().get(code));
	}

	@When("^User request for car manufacturers with invalid wa_key$")
	public void user_request_for_car_manufacturers_with_invalid_wa_key() {
		//@formatter:off
        context.response =  given()
                            .queryParam("wa_key", "INVALID KEY")
                            .when()
                            .get(BASE_URL + MANUFACTURER);
        //@formatter:on
	}

	@When("^User request for car manufacturers without wa_key$")
	public void user_request_for_car_manufacturers_without_wa_key() {
		//@formatter:off
        context.response =  given()
                            .when()
                            .get(BASE_URL + MANUFACTURER);
        //@formatter:on
	}

	@When("^User request for car manufacturers with invalid query parameter \"([^\"]*)\"$")
	public void user_request_for_car_manufacturers_with_invalid_query_parameter(String param) throws Throwable {
		//@formatter:off
        context.response =  given()
                            .queryParam(param, WA_KEY)
                            .when()
                            .get(BASE_URL + MANUFACTURER);
        //@formatter:on

	}

	@When("^User request for car manufacturers with invalid serviceendpoint$")
	public void user_request_for_car_manufacturers_with_invalid_serviceendpoint() throws Throwable {
		//@formatter:off
        context.response =  given()
                            .queryParam("wa_key", WA_KEY)
                            .when()
                            .get(BASE_URL + INVALID_MANUFACTURER);
        //@formatter:on

	}

}