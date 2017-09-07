package gov.fec.efapp.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.karsun.kic.tan.duke.Page;
import com.karsun.kic.tan.duke.util.ActionByLocator;
import com.paulhammant.ngwebdriver.NgWebDriver;

import gov.fec.efapp.util.LoadProperties;

public class Homepage extends Page {
	private static final int TIME_OUT_SECONDS = 5;

	public Homepage(WebDriver driver) {
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

	public boolean isImageDisplayed() {
		new NgWebDriver((JavascriptExecutor) driver).waitForAngularRequestsToFinish();
		String attr = ActionByLocator.getElement(driver, By.xpath("//body/app-root/div/img"), TIME_OUT_SECONDS)
				.getAttribute("src");
		return attr.contains("data:image/svg");
	}

}
