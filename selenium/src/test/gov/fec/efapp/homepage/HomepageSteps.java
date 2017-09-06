package gov.fec.efapp.homepage;

import org.junit.Assert;
import org.springframework.stereotype.Component;

import com.karsun.kic.tan.duke.Steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

@Component
public class HomepageSteps extends Steps {
	private Homepage homepage;

	private void init() {
		if (homepage == null) {
			homepage = new Homepage(executionContext.getDriver());
		}
		homepage.get();
	}

	@Given("^I am on the homepage$")
	public void i_am_on_the_homepage() {
		init();
	}

	@When("^the logo is clearly visible$")
	public void the_logo_is_clearly_visible() {
		init();
		Assert.assertTrue("Image is not displayed", homepage.isImageDisplayed());
	}

}