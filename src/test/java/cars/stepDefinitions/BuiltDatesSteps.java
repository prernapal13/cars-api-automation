package cars.stepDefinitions;

import static cars.utilities.Constants.BASE_URL;
import static cars.utilities.Constants.BUILT_DATES;
import static cars.utilities.Constants.INVALID_BUILT_DATES;
import static cars.utilities.Constants.WA_KEY;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import cars.utilities.CarResponse;
import cars.utilities.Context;
import cars.utilities.ReadTestData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class BuiltDatesSteps {

	private Context context;

	public BuiltDatesSteps(Context context) {
		this.context = context;
	}

	@When("^User request for built-dates based on \"([^\"]*)\" code \"([^\"]*)\" and \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_request_for_built_date_based_on_code_and(String param, String code, String param2,
			String mainType) {
		//@formatter:off
        context.response =  given()
                            .queryParam("wa_key", WA_KEY)
                            .queryParam(param, code)
                            .queryParam(param2, mainType)
                            .when()
                            .get(BASE_URL + BUILT_DATES);
        //@formatter:on
	}

	@And("^Response should contain expected built-dates for manufacturer code \"([^\"]*)\" and main-type \"([^\"]*)\"$")
	public void response_should_contain_expected_built_dates_for_manufacturer_code_and_main_type(String code,
			String mainType) {
		CarResponse expectedMainTypes = ReadTestData
				.getCarResponseFromTestData("built-dates-" + code + "-" + mainType.replace("/", ""));

		assertEquals("Actual response should be same as expected response", expectedMainTypes, context.carResponse);

	}

	@When("^User request for built-dates based on manufacturer code \"([^\"]*)\" and main-type \"([^\"]*)\" with invalid wa_key$")
	public void user_request_for_built_date_based_on_manufacturer_code_and_main_type_with_invalid_wa_key(String code,
			String mainType) {
		//@formatter:off
        context.response =  given()
                            .queryParam("wa_key", "INVALID KEY")
                            .queryParam("manufacturer", code)
                            .queryParam("main-type", mainType)
                            .when()
                            .get(BASE_URL + BUILT_DATES);
        //@formatter:on
	}

	@When("^User request for built-dates based on manufacturer code \"([^\"]*)\" and main-type \"([^\"]*)\" without wa_key$")
	public void user_request_for_built_date_based_on_manufacturer_code_and_main_type_without_wa_key(String code,
			String mainType) {
		//@formatter:off
        context.response = given()
                            .queryParam("manufacturer", code)
                            .queryParam("main-type", mainType)
                            .when()
                            .get(BASE_URL + BUILT_DATES);
        //@formatter:on
	}

	@When("^User request for built-dates based on manufacturer code \"([^\"]*)\" and without main-type$")
	public void user_request_for_built_date_based_on_manufacturer_code_and_without_main_type(String code) {
		//@formatter:off
        context.response =  given()
                            .queryParam("wa_key", WA_KEY)
                            .queryParam("manufacturer", code)
                            .when()
                            .get(BASE_URL + BUILT_DATES);
        //@formatter:on
	}

	@When("^User request for built-dates based on without manufacturer code and main-type \"([^\"]*)\"$")
	public void user_request_for_built_date_based_on_without_manufacturer_code_and_main_type(String mainType) {
		//@formatter:off
        context.response =  given()
                            .queryParam("wa_key", WA_KEY)
                            .queryParam("main-type", mainType)
                            .when()
                            .get(BASE_URL + BUILT_DATES);
        //@formatter:on
	}

	@When("^User request for built-dates based on without manufacturer code and without main-type$")
	public void user_request_for_built_date_based_on_without_manufacturer_code_and_without_main_type() {
		//@formatter:off
        context.response =  given()
                            .queryParam("wa_key", WA_KEY)
                            .when()
                            .get(BASE_URL + BUILT_DATES);
        //@formatter:on
	}

	@When("^User request for built-dates based on \"([^\"]*)\" code \"([^\"]*)\" and \"([^\"]*)\" \"([^\"]*)\" with invalid serviceendpoint$")
	public void user_request_for_built_date_based_on_code_and_with_invalid_serviceendpoint(String param, String code,
			String param2, String mainType) {
		//@formatter:off
        context.response =  given()
                            .queryParam("wa_key", WA_KEY)
                            .queryParam(param, code)
                            .queryParam(param2, mainType)
                            .when()
                            .get(BASE_URL + INVALID_BUILT_DATES);
        //@formatter:on

	}
}