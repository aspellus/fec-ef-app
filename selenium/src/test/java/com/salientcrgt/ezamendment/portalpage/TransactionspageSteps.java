package com.salientcrgt.ezamendment.portalpage;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.stereotype.Component;

import com.karsun.kic.tan.duke.Steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@Component
public class TransactionspageSteps extends Steps { 

	private Portalpage portalPage;

	private void init() {
		if (portalPage == null) {
			portalPage = new Portalpage(executionContext.getDriver());
		}
		portalPage.get();
	}

	@Given("^I am on the transaction page$")
	public void i_am_on_the_transaction_page() throws Throwable {
		init();
		
		List<String> committees = portalPage.getCommittees();

		Assert.assertTrue("At least one committee returned", committees.size() > 0);

		portalPage.clickCommittee("C00634634");
		
		String amendReport = null;
		Map<String, String> actions = portalPage.getFilingActions();
	    
		for (String filing : actions.keySet()) {
			
			if ("View/Amend".equals(actions.get(filing))) {
				if (amendReport == null)
					amendReport = filing;
			}
		}
		
		Assert.assertTrue("At least one filing found to amend", amendReport != null);
		
		portalPage.amendReport(amendReport);
		
	} 
	
	@When("^I select Receipts tab$")
	public void i_select_Receipts_tab() throws Throwable {
	    portalPage.clickReceipts();
	}
	
	@Then("^Basic information should be displayed in a table including Line Number, Date, Name and Amount$")
	public void basic_information_should_be_displayed_in_a_table_including_Line_Number_Date_Name_and_Amount() throws Throwable {
		Assert.assertTrue(portalPage.getTransactionPageFields().containsAll(
				Arrays.asList("Line", "Date", "Name", "Amount")));
		
	}
}