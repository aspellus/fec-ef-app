package com.salientcrgt.ezamendment.portalpage;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.springframework.stereotype.Component;

import com.karsun.kic.tan.duke.Steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@Component
public class PortalpageSteps extends Steps {
	private Portalpage homepage;
	
	private String committeeSelected = null;

	private void init() {
		if (homepage == null) {
			homepage = new Portalpage(executionContext.getDriver());
		}
		homepage.get();
	}

	@Given("^I am on the home page$")
	public void i_am_on_the_home_page() throws Throwable {
	    init();
	}

	@When("^I select a committee ID from the drop down$")
	public void i_select_a_committee_ID_from_the_drop_down() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		List<String> committees = homepage.getCommittees();
		
		Assert.assertTrue("At least one committee returned", committees.size() > 0);
		
		committeeSelected = committees.get(0);
		
		homepage.clickCommittee(0);
		
	    
	}
	
	@Then("^my custom portal page is displayed$")
	public void my_custom_portal_page_is_displayed() throws Throwable {
	    // ensure the committee ID is displayed on the screen along with the "About this Committee" section
		
		Assert.assertTrue("Committee ID displayed on page", homepage.findAppPortalTag());
	}

	@Then("^Under the page header my committee basic information should be displayed$")
	public void under_the_page_header_my_committee_basic_information_should_be_displayed() throws Throwable {
		Assert.assertTrue("Committee ID displayed on page", homepage.findCommitteeIDHeader());
	    
	}

	@Then("^the filings view is displayed by default$")
	public void the_filings_view_is_displayed_by_default() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue("Filings view is open", homepage.isFilingPanelOpen());
	}
	
	@Then("^I select the committee info tab$")
	public void i_select_the_committee_info_tab() throws Throwable {
	    try {
	    	homepage.openCommitteePanel();
	    } catch (NoSuchElementException nsme) {
	    	Assert.assertTrue("Committee tab found", false);
	    }
	}
	
	@Then("^Committee Basic Information will contain Committee Type, Address, Treasurer Name and Party Affiliation$")
	public void committee_Basic_Information_will_contain_Committee_Type_Address_Treasurer_Name_and_Party_Affiliation() throws Throwable {
		Map<String, String> committeeInfo = homepage.getCommitteeAboutInfo();
		
		Assert.assertTrue(committeeInfo.keySet().containsAll(Arrays.asList("Committee Type", "Treasurer", "Political Party")));
	    Assert.assertNotEquals("Committee Address returned", "None", committeeInfo.get("Mailing Address"));
	}

}