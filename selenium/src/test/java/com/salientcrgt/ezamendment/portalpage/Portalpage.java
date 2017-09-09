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

import com.karsun.kic.tan.duke.Page;
import com.karsun.kic.tan.duke.util.ActionByLocator;
import com.paulhammant.ngwebdriver.NgWebDriver;
import com.salientcrgt.ezamendment.util.LoadProperties;

public class Portalpage extends Page {
	private static final int TIME_OUT_SECONDS = 5;

	private boolean committeesVisible = false;

	public Portalpage(WebDriver driver) {
		super(driver);
	}

	@Override
	protected boolean isLoaded() {
		return driver.getTitle().contains("Client");
	}

	@Override
	protected void load() {
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
		new NgWebDriver((JavascriptExecutor) driver).waitForAngularRequestsToFinish();
		List<String> committees = new ArrayList<String>();

		WebElement committeePanel = driver.findElement(By.id("committee-select-group"));

		WebElement committeeButton = committeePanel.findElement(By.tagName("button"));

		if (!committeesVisible) {
			System.out.println("Clicking committee dropdown");
			committeeButton.click();
			committeesVisible = true;
		}

		List<WebElement> elements = committeePanel.findElements(By.className("dropdown-item"));

		for (WebElement element : elements) {

			committees.add(element.findElement(By.xpath(".//b")).getText());
		}
		return committees;

	}

	public boolean isImageDisplayed() {
		new NgWebDriver((JavascriptExecutor) driver).waitForAngularRequestsToFinish();
		String attr = ActionByLocator.getElement(driver, By.xpath("//body/app-root/div/img"), TIME_OUT_SECONDS)
				.getAttribute("src");
		return attr.contains("data:image/svg");
	}

	public void clickCommittee(int i) {
		new NgWebDriver((JavascriptExecutor) driver).waitForAngularRequestsToFinish();

		WebElement committeeButton = driver.findElement(By.id("committee-select-group"));
		if (!committeesVisible) {
			committeeButton.click();
			committeesVisible = true;
		}

		new NgWebDriver((JavascriptExecutor) driver).waitForAngularRequestsToFinish();

		committeeButton.findElements(By.className("dropdown-item")).get(i).click();

	}

	public boolean findCommitteeIDHeader() {

		new NgWebDriver((JavascriptExecutor) driver).waitForAngularRequestsToFinish();

		String header = driver.findElement(By.tagName("app-committee")).findElement(By.xpath(".//h2/small")).getText();
		System.out.println(header);

		Pattern p = Pattern.compile("ID: [A-Z0-9]+$");

		if (p.matcher(header).find())
			return true;

		return false;
	}

	public Map<String, String> getCommitteeAboutInfo() {

		new NgWebDriver((JavascriptExecutor) driver).waitForAngularRequestsToFinish();

		Map<String, String> committeeInfo = new HashMap<String, String>();

		WebElement infoElement = driver.findElement(By.xpath("//div[contains(@class, 'jumbotron')]/div/div"));

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
		new NgWebDriver((JavascriptExecutor) driver).waitForAngularRequestsToFinish();

		try {
			driver.findElement(By.tagName("app-committee"));
		} catch (NoSuchElementException nsee) {
			return false;
		}
		return true;
	}

	public boolean isFilingPanelOpen() {
		new NgWebDriver((JavascriptExecutor) driver).waitForAngularRequestsToFinish();

		try {

			driver.findElement(By.xpath("//div[contains(@class, 'report-content')]"));
		} catch (NoSuchElementException nsee) {
			System.out.println("Not found");
			return false;
		}
		return true;
	}

	public void openCommitteePanel() {
		new NgWebDriver((JavascriptExecutor) driver).waitForAngularRequestsToFinish();

		WebElement committeeButton = driver.findElement(By.id("committee-info-btn"));

		committeeButton.click();

	}

	public boolean findAppFilingTag() {
		new NgWebDriver((JavascriptExecutor) driver).waitForAngularRequestsToFinish();

		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.className("report-content")));
		} catch (NoSuchElementException nsee) {
			return false;
		}
		return true;
	}

	public int getFilingCount() {
		new NgWebDriver((JavascriptExecutor) driver).waitForAngularRequestsToFinish();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		// wait for element to be clickable, then click

		WebElement filingTableBody = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'report-content')]/table")));

		// WebElement filingTableBody = driver.findElement(

		return filingTableBody.findElements(By.tagName("tr")).size();

	}

	public List<String> getFilingFields() {

		new NgWebDriver((JavascriptExecutor) driver).waitForAngularRequestsToFinish();

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
		new NgWebDriver((JavascriptExecutor) driver).waitForAngularRequestsToFinish();

		Map<String, String> actions = new HashMap<String, String>();

		WebElement filingTableHead = driver
				.findElement(By.xpath("//div[contains(@class, 'report-content')]/table/tbody"));

		for (WebElement filingElement : filingTableHead.findElements(By.tagName("tr"))) {

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

}
