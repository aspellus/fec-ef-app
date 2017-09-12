package com.salientcrgt.ezamendment.portalpage;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.salientcrgt.ezamendment.util.Util;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TransactionspageSteps {

	private Portalpage portalPage;
	private WebDriver driver;

	public TransactionspageSteps() {

	}

	@Before()
	public void init() {
		driver = Util.getDriver();
		portalPage = new Portalpage(driver);

	}

	@After()
	public void cleanup() {
		portalPage = null;
		driver.quit();
	}

	@Given("^I am on the transaction page$")
	public void i_am_on_the_transaction_page() throws Throwable {
		portalPage.get();

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
	public void basic_information_should_be_displayed_in_a_table_including_Line_Number_Date_Name_and_Amount()
			throws Throwable {
		Assert.assertTrue(
				portalPage.getTransactionPageFields().containsAll(Arrays.asList("Line", "Date", "Name", "Amount")));

	}

	@When("^I click New Receipt$")
	public void i_click_New_Receipt() throws Throwable {

	}

	@Then("^I should see a form to enter the receipt information$")
	public void i_should_see_a_form_to_enter_the_receipt_information() throws Throwable {

	}

	@Then("^the form should contain Line Number, First Name, Last Name, Prefix, Suffix, Date, Amount, Memo Indicator, Employer, Occupation and Description$")
	public void the_form_should_contain_Line_Number_First_Name_Last_Name_Prefix_Suffix_Date_Amount_Memo_Indicator_Employer_Occupation_and_Description()
			throws Throwable {

	}

	@Then("^actions to Save or Delete$")
	public void actions_to_Save_or_Delete() throws Throwable {

	}

	@Given("^I am on the transaction page and filled the form$")
	public void i_am_on_the_transaction_page_and_filled_the_form() throws Throwable {

	}

	@When("^I click save button$")
	public void i_click_save_button() throws Throwable {

	}

	@Then("^the transactions should be saved in sched_a database table$")
	public void the_transactions_should_be_saved_in_sched_a_database_table() throws Throwable {

	}

	@Then("^I should be able to find the just added transactions in receipts tab$")
	public void i_should_be_able_to_find_the_just_added_transactions_in_receipts_tab() throws Throwable {

	}

	@Given("^I am on the transaction page and selected a receipt$")
	public void i_am_on_the_transaction_page_and_selected_a_receipt() throws Throwable {

	}

	@When("^I update the Name and click save$")
	public void i_update_the_Name_and_click_save() throws Throwable {

	}

	@Then("^the detailed receipt information should collapse$")
	public void the_detailed_receipt_information_should_collapse() throws Throwable {

	}

	@Then("^the Name should be updated in the data base$")
	public void the_Name_should_be_updated_in_the_data_base() throws Throwable {

	}

	@Then("^the Updated Name should be displayed in the Receipts Tab$")
	public void the_Updated_Name_should_be_displayed_in_the_Receipts_Tab() throws Throwable {

	}

	@When("^I click delete$")
	public void i_click_delete() throws Throwable {

	}

	@Then("^alert me with a message \"([^\"]*)\"$")
	public void alert_me_with_a_message(String arg1) throws Throwable {

	}

	@Then("^if YES is selected then delete the receipt from the database$")
	public void if_YES_is_selected_then_delete_the_receipt_from_the_database() throws Throwable {

	}

	@Then("^remove the report from the Receipt Tab$")
	public void remove_the_report_from_the_Receipt_Tab() throws Throwable {

	}
}