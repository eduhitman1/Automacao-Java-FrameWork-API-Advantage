package steps;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasItem;

import java.util.HashMap;

import org.junit.runner.RunWith;

import com.edsoft.framework.base.api.APIConstant;
import com.edsoft.framework.base.api.RestAssuredExtensionV3;
import com.edsoft.framework.base.api.RestAssuredExtension;
import com.edsoft.framework.base.api.RestAssuredExtensionV2;
import com.edsoft.framework.utilities.CucumberUtil;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import model.Posts;
import pojos.Address;
import pojos.Location;
import pojos.LoginBody;

@RunWith(Cucumber.class)
public class GetPostSteps {

	public static ResponseOptions<Response> response;
	public static String token;

	/**
	 * GETPost.feature
	 */
	@Given("^que eu realizo a operação GET para \"([^\"]*)\"$")
	public void que_eu_realizo_a_operao_get_para_something(String url) throws Throwable {
//		response = RestAssuredExtension.GetOps(url);
		response = RestAssuredExtension.GetOpsWithToken(url, token);
	}

	/**
	 * GETPost.feature //With builder pattern
	 */
	@Then("^devo ver o nome do autor como \"([^\"]*)\"$")
	public void devo_ver_o_nome_do_autor_como_something(String authorName) throws Throwable {
		Posts posts = response.getBody().as(Posts.class);
		assertThat(posts.getAuthor(), equalTo(authorName));
//	    	assertThat(response.getBody().jsonPath().get("author"), hasItem("Eduardo"));
	}

	/**
	 * GETPost.feature
	 */
	@Then("^devo ver os nomes dos autores$")
	public void devo_ver_os_nomes_dos_autores() throws Throwable {
//		BDDStyledMethod.PerformContainsCollection();
//		BDDStyledMethod.simpleGETPost("1");
		assertThat(response.getBody().jsonPath().get("author"), hasItem("Eduardo"));
//		assertThat(response.getBody().jsonPath().get("author"), containsInAnyOrder("Eduardo", "Henrique", null));
	}

	/**
	 * GETPost.feature
	 */
	@Then("^devo verificar o parâmetro GET$")
	public void devo_verificar_o_parmetro_get() throws Throwable {
		BDDStyledMethod.PerformPathParameter();
		BDDStyledMethod.PerformQueryParameter();
	}

	/**
	 * GETPost.feature
	 */
	@Given("^que eu realizo a operação de autenticação para \"([^\"]*)\" com o corpo$")
	public void que_eu_realizo_a_operao_de_autenticao_para_something_com_o_corpo(String uri, DataTable table)
			throws Throwable {
		CucumberUtil.convertDataTableToDisc(table);

//		  HashMap<String, String> body = new HashMap<>();
//	      body.put("email", CucumberUtil.GetCellValueWithRowIndex("email", 1));
//	      body.put("password", CucumberUtil.GetCellValueWithRowIndex("password", 1));

//	      response = RestAssuredExtension.PostOpsWithBody(uri, body);

	      
		LoginBody loginBody = new LoginBody();
		loginBody.setEmail(CucumberUtil.GetCellValueWithRowIndex("email", 1));
		loginBody.setPassword(CucumberUtil.GetCellValueWithRowIndex("password", 1));

		RestAssuredExtensionV2 restAssuredExtensionV2 = new RestAssuredExtensionV2(uri, APIConstant.ApiMethods.POST, null);
		token = restAssuredExtensionV2.Authenticate(loginBody);
	}

	/**
	 * GETPosts.feature
	 */
	@Then("^devo ver o nome do autor como \"([^\"]*)\" com validação json$")
	public void devo_ver_o_nome_do_autor_como_something_com_validao_json(String strArg1) throws Throwable {
//			String responseBody = response.getBody().asString();
//			assertThat(responseBody, matchesJsonSchemaInClasspath(".src/post.json"));
	}

	/**
	 * ComplexDataGET.feature
	 */
	@Then("^I should see the author name as \"([^\"]*)\" with json validation$")
	public void i_should_see_the_author_name_as_something_with_json_validation(String strArg1) throws Throwable {
//		String responseBody = response.getBody().asString();
//		assertThat(responseBody, matchesJsonSchemaInClasspath(".src/post.json"));
	}

	@And("^eu executo a operação GET com o parâmetro de caminho para o endereço \"([^\"]*)\"$")
	public void eu_executo_a_operao_get_com_o_parmetro_de_caminho_para_o_endereo_something(String uri, DataTable table)
			throws Throwable {
		CucumberUtil.convertDataTableToDisc(table);
		HashMap<String, String> queryParams = new HashMap<>();
		queryParams.put("id", CucumberUtil.GetCellValueWithRowIndex("id", 1));
//		response = RestAssuredExtension.GetWithQueryWithToken(url, queryParams, response.getBody().jsonPath().get("acess_token"));
		RestAssuredExtensionV2 restAssuredExtensionV2 = new RestAssuredExtensionV2(uri, "GET", token);
		response = restAssuredExtensionV2.ExecuteWithQueryParams(queryParams);
	}
	
	@Then("^Devo ver o nome da rua como \"([^\"]*)\"$")
    public void devo_ver_o_nome_da_rua_como_something(String streetName) throws Throwable {
//		Location[] a = response.getBody().as(Location[].class);
//        Address address = a[0].getAddress().stream().filter(x -> x.getType().equalsIgnoreCase("primary")).findFirst().orElse(null);
//        assertThat(address.getStreet(), equalTo(streetName));
    }
}

