package steps;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;

import org.junit.runner.RunWith;

import com.edsoft.framework.base.api.RestAssuredExtension;
import com.edsoft.framework.utilities.CucumberUtil;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

@RunWith(Cucumber.class)
public class PostPostSteps {

	public static ResponseOptions<Response> response;

	/**
	 * POSTPosts.feature
	 */
	@Given("^eu realizo a operação POST para \"([^\"]*)\"$")
	public void eu_realizo_a_operao_post_para_something(String strArg1) throws Throwable {
		BDDStyledMethod.PerformPOSTWithBodyParameter();
	}

	/**
	 * POSTPosts.feature
	 */
	@Given("^que realizo a operação POST para \"([^\"]*)\" com corpo$")
	public void que_realizo_a_operao_post_para_something_com_corpo(String url, DataTable table) throws Throwable {
		CucumberUtil.convertDataTableToDisc(table);

		HashMap<String, String> body = new HashMap<>();
		body.put("name", CucumberUtil.GetCellValueWithRowIndex("name", 1));

		HashMap<String, String> pathParams = new HashMap<>();
		pathParams.put("profileNo", CucumberUtil.GetCellValueWithRowIndex("profile", 1));

		response = RestAssuredExtension.PostOpsWithBodyAndPathParams(url, pathParams, body);
	}

	/**
	 * POSTPosts.feature
	 */
	@Then("^devo ver que o corpo tem o nome \"([^\"]*)\"$")
	public void devo_ver_que_o_corpo_tem_o_nome_something(String name) throws Throwable {
		assertThat(response.getBody().jsonPath().get("name"), equalTo(name));
	}

}
