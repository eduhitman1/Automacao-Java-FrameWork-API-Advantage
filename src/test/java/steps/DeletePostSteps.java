package steps;

import java.util.HashMap;

import org.junit.runner.RunWith;

import com.edsoft.framework.base.api.RestAssuredExtension;
import com.edsoft.framework.utilities.CucumberUtil;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

@RunWith(Cucumber.class)
public class DeletePostSteps {

	public static ResponseOptions<Response> response;

	/**
	 * DELETEPosts.feature
	 */
	@Given("^eu garanto realizar a operação POST para \"([^\"]*)\" com corpo como$")
	public void eu_garanto_realizar_a_operao_post_para_something_com_corpo_como(String url, DataTable table)
			throws Throwable {
		CucumberUtil.convertDataTableToDisc(table);
		HashMap<String, String> body = new HashMap<>();
		body.put("id", CucumberUtil.GetCellValueWithRowIndex("id", 1));
		body.put("title", CucumberUtil.GetCellValueWithRowIndex("title", 1));
		body.put("author", CucumberUtil.GetCellValueWithRowIndex("author", 1));

		RestAssuredExtension.PostOpsWithBody(url, body);
	}

	/**
	 * DELETEPosts.feature
	 */
	@And("^Eu executo a operação DELETE para \"([^\"]*)\"$")
	public void eu_executo_a_operao_delete_para_something(String url, DataTable table) throws Throwable {
		CucumberUtil.convertDataTableToDisc(table);
		HashMap<String, String> pathParams = new HashMap<>();
		pathParams.put("postid", CucumberUtil.GetCellValueWithRowIndex("postid", 1));
		
		RestAssuredExtension.DeleteOpsWithPathParams(url, pathParams);
	}

	/**
	 * DELETEPosts.feature
	 */
	@And("^eu realizo a operação GET com o parâmetro de caminho para \"([^\"]*)\"$")
	public void eu_realizo_a_operao_get_com_o_parmetro_de_caminho_para_something(String url, DataTable table)
			throws Throwable {
		CucumberUtil.convertDataTableToDisc(table);
		HashMap<String, String> pathParams = new HashMap<>();
		pathParams.put("postid", CucumberUtil.GetCellValueWithRowIndex("postid", 1));
		RestAssuredExtension.GetOpsWithPathParameter(url, pathParams);
	}

	/**
	 * DELETEPosts.feature
	 */
	@Then("^eu \"([^\"]*)\" ver o corpo com o título como \"([^\"]*)\"$")
	public void eu_something_ver_o_corpo_com_o_ttulo_como_something(String condition, String title) throws Throwable {

//		if (condition.equalsIgnoreCase("should not")) {
//			System.out.println("ERRO: " + response.getBody().jsonPath().get("title"));
//			assertThat(response.getBody().jsonPath().get("title"), IsNot.not(title));
//		} else {
//			assertThat(response.getBody().jsonPath().get("title"), is(title));
//		}
	}
}
