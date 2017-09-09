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

	private void init() {
		if (homepage == null) {
			homepage = new Portalpage(executionContext.getDriver());
		}
		homepage.get();
	}

	@Given("^I am on the portal page$")
	public void i_am_on_the_portal_page() throws Throwable {
		init();
	}

	@When("^I select a committee ID from the drop down$")
	public void i_select_a_committee_ID_from_the_drop_down() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		List<String> committees = homepage.getCommittees();

		Assert.assertTrue("At least one committee returned", committees.size() > 0);

		homepage.clickCommittee(0);

	}

	@Then("^my custom portal page is displayed$")
	public void my_custom_portal_page_is_displayed() throws Throwable {
		// ensure the committee ID is displayed on the screen along with the
		// "About this Committee" section

		Assert.assertTrue("Committee panel is displayed on page", homepage.findAppPortalTag());
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
	public void committee_Basic_Information_will_contain_Committee_Type_Address_Treasurer_Name_and_Party_Affiliation()
			throws Throwable {
		Map<String, String> committeeInfo = homepage.getCommitteeAboutInfo();

		Assert.assertTrue(
				committeeInfo.keySet().containsAll(Arrays.asList("Committee Type", "Treasurer", "Political Party")));
		Assert.assertNotEquals("Committee Address returned", "None", committeeInfo.get("Mailing Address"));
	}

	@Then("^all my previously filed reports should show up in tabular Form$")
	public void all_my_previously_filed_reports_should_show_up_in_tabular_Form() throws Throwable {
		//Assert.assertTrue("Filings view is open", homepage.isFilingPanelOpen());
		Assert.assertTrue("Filing table is displayed on page", homepage.findAppFilingTag());
		Assert.assertTrue("At least one filing discovered", homepage.getFilingCount() > 0);

	}

	@Then("^Table will contain Report_ID, Report_Type, Coverage_Start_Date, Coverage_End_Date, Receipt_date and Last_Uploaded_Date$")
	public void table_will_contain_Report_ID_Report_Type_Coverage_Start_Date_Coverage_End_Date_Receipt_date_and_Last_Uploaded_Date()
			throws Throwable {
		List<String> filingFields = homepage.getFilingFields();

		Assert.assertTrue(filingFields.containsAll(
				Arrays.asList("Filing Description (ID)", "Coverage Period", "Last Update", "Receipt Date", "Action")));

	}
	
	@Then("^Show actions to AMEND the filing$")
	public void show_actions_to_AMEND_the_filing() throws Throwable {
	    // make sure at least one filing has an amend option..
		boolean amendActionFound = false;
		Map<String, String> actions = homepage.getFilingActions();
	    
		for (String filing : actions.keySet()) {
			// Amend is currently mispelled in app, this will break when that is fixed
			if ("View/Ammend".equals(actions.get(filing))) {
				amendActionFound = true;
			}
		}
		
		Assert.assertTrue("At least one filing found to amend", amendActionFound);
	}
	
	@Then("^I search for (\\d+) using Report Year Filter$")
	public void i_search_for_using_Report_Year_Filter(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^my results should be the reports filed for year (\\d+) coverage dates only$")
	public void my_results_should_be_the_reports_filed_for_year_coverage_dates_only(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^I select Statement of Organization \\(F(\\d+)\\) from the Form Type Filter$")
	public void i_select_Statement_of_Organization_F_from_the_Form_Type_Filter(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^my results should only contain Statement of Organizations \\(F(\\d+)\\)$")
	public void my_results_should_only_contain_Statement_of_Organizations_F(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}


}