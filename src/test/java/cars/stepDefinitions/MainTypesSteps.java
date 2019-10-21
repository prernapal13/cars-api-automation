package cars.stepDefinitions;

import static cars.utilities.Constants.BASE_URL;
import static cars.utilities.Constants.INVALID_MAIN_TYPES;
import static cars.utilities.Constants.MAIN_TYPES;
import static cars.utilities.Constants.WA_KEY;
import static cars.utilities.ReadTestData.getCarResponseFromTestData;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import cars.utilities.CarResponse;
import cars.utilities.Context;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class MainTypesSteps {

	private Context context;

	public MainTypesSteps(Context context) {
		this.context = context;
	}

	@When("^User request car main-types based on \"([^\"]*)\" code \"([^\"]*)\"$")
	public void user_request_car_main_types_based_on_manufacturer_code(String param, String code) {
		//@formatter:off
        context.response =  given()
                            .queryParam("wa_key", WA_KEY)
                            .queryParam(param, code)
                            .when()
                            .get(BASE_URL + MAIN_TYPES);
        //@formatter:on
	}

	@And("^Response should contain expected main types for manufacturer code \"([^\"]*)\"$")
	public void response_should_contain_expected_main_types_for_manufacturer_code(String code) {

		CarResponse expectedMainTypes = getCarResponseFromTestData("main-type-" + code);
		assertEquals("Actual response should be same as expected response", expectedMainTypes, context.carResponse);
	}

	@When("^User request car main-types based on manufacturer code \"([^\"]*)\" with invalid wa_key$")
	public void user_request_car_main_types_based_on_manufacturer_code_with_invalid_wa_key(String code) {
		//@formatter:off
        context.response = 	given()
                            .queryParam("wa_key", "INVALID KEY")
                            .queryParam("manufacturer", code)
                            .when()
                            .get(BASE_URL + MAIN_TYPES);
        //@formatter:on
	}

	@When("^User request car main-types based on manufacturer code \"([^\"]*)\" without wa_key$")
	public void user_request_car_main_types_based_on_manufacturer_code_without_wa_key(String code) {
		//@formatter:off
        context.response =  given()
                            .queryParam("manufacturer", code)
                            .when()
                            .get(BASE_URL + MAIN_TYPES);
        //@formatter:on
	}

	@When("^User request car main-types without manufacturer code$")
	public void user_request_car_main_types_without_manufacturer_code() throws Throwable {
		//@formatter:off
        context.response =  given()
                            .queryParam("wa_key", WA_KEY)
                            .when()
                            .get(BASE_URL + MAIN_TYPES);
        //@formatter:on
	}

	@When("^User request car main-types based on \"([^\"]*)\" code \"([^\"]*)\" with invalid serviceendpoint$")
	public void user_request_car_main_types_based_on_code_with_invalid_serviceendpoint(String param, String code)
			throws Throwable {
		//@formatter:off
        context.response =  given()
                            .queryParam("wa_key", WA_KEY)
                            .queryParam(param, code)
                            .when()
                            .get(BASE_URL + INVALID_MAIN_TYPES);
        //@formatter:on
	}
}