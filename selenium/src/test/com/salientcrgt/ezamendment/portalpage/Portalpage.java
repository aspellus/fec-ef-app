package com.salientcrgt.ezamendment.portalpage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

		WebElement committeeButton = driver.findElement(By.id("committee-select-group"));

		if (!committeesVisible) {
			committeeButton.click();
			committeesVisible = true;
		}

		List<WebElement> elements = committeeButton.findElements(By.className("dropdown-item"));

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

		committeeButton.findElements(By.className("dropdown-item")).get(i).click();

	}

	public boolean findCommitteeIDHeader() {

		new NgWebDriver((JavascriptExecutor) driver).waitForAngularRequestsToFinish();

		String header = driver.findElement(By.tagName("app-committee")).findElement(By.xpath(".//h2/small"))
				.getText();
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
			driver.findElement(By.tagName("app-portal"));
		} catch (NoSuchElementException nsee) {
			return false;
		}
		return true;
	}

}
