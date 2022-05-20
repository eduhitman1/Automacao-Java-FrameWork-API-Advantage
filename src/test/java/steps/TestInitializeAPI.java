package steps;

import com.edsoft.framework.base.api.RestAssuredExtension;

import cucumber.api.java.Before;

public class TestInitializeAPI {

	@Before
	public void TestSetup() {
		RestAssuredExtension restAssuredExtension = new RestAssuredExtension();
		RestAssuredExtension restAssuredExtensionV2 = new RestAssuredExtension();
	}
}