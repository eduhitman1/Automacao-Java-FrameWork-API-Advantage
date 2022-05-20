package steps;

import java.util.HashMap;

import org.junit.runner.RunWith;

import com.edsoft.framework.base.api.RestAssuredExtension;
import com.edsoft.framework.utilities.CucumberUtil;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.junit.Cucumber;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

@RunWith(Cucumber.class)
public class PutPostsSteps {

	public static ResponseOptions<Response> response;

	@Given("^I ensure to perform POST operation for \"([^\"]*)\" with body as$")
	public void i_ensure_to_perform_post_operation_for_something_with_body_as(String url, DataTable table)
			throws Throwable {
		CucumberUtil.convertDataTableToDisc(table);
		HashMap<String, String> body = new HashMap<>();
		body.put("id", CucumberUtil.GetCellValueWithRowIndex("id", 1));
		body.put("title", CucumberUtil.GetCellValueWithRowIndex("title", 1));
		body.put("author", CucumberUtil.GetCellValueWithRowIndex("author", 1));

		RestAssuredExtension.PostOpsWithBody(url, body);
	}

	/**
	 * PUTPosts.feature
	 */
	@Given("^que realizo a operação PUT para \"([^\"]*)\"$")
	public void que_realizo_a_operao_put_para_something(String url, DataTable table) throws Throwable {

		CucumberUtil.convertDataTableToDisc(table);
		HashMap<String, String> body = new HashMap<>();
		body.put("id", CucumberUtil.GetCellValueWithRowIndex("id", 1));
		body.put("title", CucumberUtil.GetCellValueWithRowIndex("title", 1));
		body.put("author", CucumberUtil.GetCellValueWithRowIndex("author", 1));

		HashMap<String, String> pathParams = new HashMap<>();
		pathParams.put("postid", CucumberUtil.GetCellValueWithRowIndex("id", 1));

		RestAssuredExtension.PUTOpsWithBodyAndPathParams(url, body, pathParams);
	}

}
