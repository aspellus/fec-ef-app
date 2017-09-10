package com.salientcrgt.ezamendment.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class Util {
	public static WebDriver getDriver() {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();

		ChromeDriverManager.getInstance().setup();

		return new ChromeDriver(capabilities);

	}
}