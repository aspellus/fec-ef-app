package com.salientcrgt.ezamendment.portalpage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paulhammant.ngwebdriver.NgWebDriver;
import com.salientcrgt.ezamendment.util.LoadProperties;

public class Portalpage {

	private boolean committeesVisible = false;

	protected WebDriverWait wait = null;
protected WebDriver driver = null;

	public Portalpage(WebDriver driver) {
		
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}

	
	protected boolean isLoaded() {
		return driver.getTitle().contains("Client");
	}

	
	protected void get() {
		waitForAngular();

		committeesVisible = false;
		driver.get(LoadProperties.getApplicationURL());

		new WebDriverWait(driver, 10)
				.until(ExpectedConditions.invisibilityOfElementLocated(By.className("please-wait-spinner")));
	}

	private void waitForAngular() {
		new NgWebDriver((JavascriptExecutor) driver).waitForAngularRequestsToFinish();
	}

	public List<String> getCommittees() {

		waitForAngular();

		List<String> committees = new ArrayList<String>();

		WebElement committeePanel = driver.findElement(By.id("committee-select-group"));

		WebElement committeeButton = committeePanel.findElement(By.tagName("button"));

		if (!committeesVisible) {
			System.out.println("Clicking committee dropdown");
			committeeButton.click();
			committeesVisible = true;
		}

		waitForAngular();

		List<WebElement> elements = committeePanel.findElements(By.className("dropdown-item"));

		for (WebElement element : elements) {

			committees.add(element.findElement(By.xpath(".//b")).getText());
		}
		return committees;

	}

	public void clickCommittee(int i) {

		waitForAngular();

		WebElement committeeButton = driver.findElement(By.id("committee-select-group"));
		if (!committeesVisible) {
			committeeButton.click();
			committeesVisible = true;
		}

		waitForAngular();

		committeeButton.findElements(By.className("dropdown-item")).get(i).click();

	}

	public boolean findCommitteeIDHeader() {

		waitForAngular();

		String header = driver.findElement(By.tagName("app-committee")).findElement(By.xpath(".//h2/small")).getText();
		System.out.println(header);

		Pattern p = Pattern.compile("ID: [A-Z0-9]+$");

		if (p.matcher(header).find())
			return true;

		return false;
	}

	public Map<String, String> getCommitteeAboutInfo() {

		waitForAngular();

		Map<String, String> committeeInfo = new HashMap<String, String>();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement infoElement = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'jumbotron')]/div/div")));

		for (WebElement rowElement : infoElement.findElements(By.className("row"))) {
			List<WebElement> cols = rowElement.findElements(By.xpath(".//div"));

			for (int i = 0; i < cols.size(); i = i + 2) {

				System.out.println(cols.get(i).getText());
				// remove the trailing colon because we're good people
				String name = cols.get(i).findElement(By.tagName("strong")).getText();
				committeeInfo.put(name.substring(0, name.length() - 1), cols.get(i + 1).getText());

			}
		}
		System.out.println(committeeInfo);

		return committeeInfo;
	}

	public boolean findAppPortalTag() {

		waitForAngular();

		try {
			driver.findElement(By.tagName("app-committee"));
		} catch (NoSuchElementException nsee) {
			return false;
		}
		return true;
	}

	public boolean isFilingPanelOpen() {

		waitForAngular();

		try {

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'report-content')]")));
		} catch (NoSuchElementException nsee) {
			System.out.println("Not found");
			return false;
		}
		return true;
	}

	public void openCommitteePanel() {

		waitForAngular();

		WebElement committeeButton = driver.findElement(By.id("committee-info-btn"));

		committeeButton.click();

	}

	public boolean findAppFilingTag() {

		waitForAngular();

		try {

			wait.until(ExpectedConditions.elementToBeClickable(By.className("report-content")));
		} catch (NoSuchElementException nsee) {
			return false;
		}
		return true;
	}

	public int getFilingCount() {

		waitForAngular();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		// wait for element to be clickable, then click

		WebElement filingTableBody = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'report-content')]/table")));

		// WebElement filingTableBody = driver.findElement(

		return filingTableBody.findElements(By.tagName("tr")).size();

	}

	public List<String> getFilingFields() {

		waitForAngular();

		List<String> fieldList = new ArrayList<String>();

		WebElement filingTableHead = driver
				.findElement(By.xpath("//div[contains(@class, 'report-content')]/table/thead"));

		for (WebElement fieldElement : filingTableHead.findElements(By.tagName("th"))) {

			System.out.println(fieldElement.getText());

			fieldList.add(fieldElement.getText());

		}

		return fieldList;
	}

	public Map<String, String> getFilingActions() {

		waitForAngular();

		Map<String, String> actions = new HashMap<String, String>();

		// wait for element to be clickable, then click

		WebElement filingTableHead = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[contains(@class, 'report-content')]/table/tbody")));

		for (WebElement filingElement : filingTableHead.findElements(By.tagName("tr"))) {

			wait.until(ExpectedConditions.elementToBeClickable(filingElement));

			System.out.println(filingElement.getText());

			// get filing
			String filingDesc = filingElement.findElement(By.tagName("td")).getText();
			System.out.println("Action: " + filingDesc);
			Pattern p = Pattern.compile("(FEC-[0-9]+)");
			Matcher m = p.matcher(filingDesc);

			// for now some edge cases will not have a FEC ID, until they are
			// excluded from the report we make sure there's a match
			if (m.find()) {

				String filingId = m.group();

				// get actions for row
				WebElement filingActionElement = filingElement.findElement(By.tagName("button"));

				actions.put(filingId, filingActionElement.getText());

			}
		}

		return actions;
	}

	// TODO refactor clickCommittee methods to avoid duplicated logic
	public void clickCommittee(String selectedCommittee) throws Exception {
		waitForAngular();

		WebElement committeeButton = driver.findElement(By.id("committee-select-group"));
		if (!committeesVisible) {
			committeeButton.click();
			committeesVisible = true;
		}

		waitForAngular();

		for (WebElement committeeElement : committeeButton.findElements(By.className("dropdown-item"))) {

			wait.until(ExpectedConditions.elementToBeClickable(committeeElement));
			System.out.println(committeeElement.getText());

			if (selectedCommittee.equals(committeeElement.findElement(By.xpath(".//b")).getText())) {
				committeeElement.click();
				return;
			}

		}
		throw new Exception("Committee not found");

	}

	public void amendReport(String amendReport) throws Exception {
		waitForAngular();

		WebElement filingTableHead = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[contains(@class, 'report-content')]/table/tbody")));

		for (WebElement filingElement : filingTableHead.findElements(By.tagName("tr"))) {

			wait.until(ExpectedConditions.elementToBeClickable(filingElement));

			System.out.println(filingElement.getText());

			// get filing
			String filingDesc = filingElement.findElement(By.tagName("td")).getText();
			System.out.println("Action: " + filingDesc);
			Pattern p = Pattern.compile("(FEC-[0-9]+)");
			Matcher m = p.matcher(filingDesc);

			// for now some edge cases will not have a FEC ID, until they
			// are
			// excluded from the report we make sure there's a match
			if (m.find()) {

				String filingId = m.group();

				if (filingId.equals(amendReport)) {
					wait.until(ExpectedConditions.elementToBeClickable(filingElement.findElement(By.tagName("button"))))
							.click();
					return;

				}

			}

		}

		throw new Exception("Report not found");

	}

	public void clickReceipts() {

		// TODO only receipts are supported at this time so this is a noop step
		// implement test when other transaction types are supported
	}

	public List<String> getTransactionPageFields() {
		waitForAngular();

		List<String> fields = new ArrayList<String>();

		WebElement receiptsFieldListElement = driver.findElement(By.xpath("//ngb-tabset/div/div/div"));

		for (WebElement fieldElement : receiptsFieldListElement.findElements(By.tagName("div"))) {

			wait.until(ExpectedConditions.elementToBeClickable(fieldElement));

			System.out.println(fieldElement.getText());

			fields.add(fieldElement.getText());
		}

		return fields;
	}
}
