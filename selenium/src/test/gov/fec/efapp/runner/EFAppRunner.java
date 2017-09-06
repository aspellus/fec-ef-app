package gov.fec.efapp.runner;

import org.junit.runner.RunWith;

import com.karsun.kic.tan.duke.annotations.TestDataFiles;
import com.karsun.kic.tan.duke.cukes.MergedDataInjectedCucumber;

import cucumber.api.CucumberOptions;

@RunWith(MergedDataInjectedCucumber.class)
@CucumberOptions(plugin = { "json:build/efapp.json", "html:build/efapp" },
		tags = {"~@wip"},
		features = {
		"src/test/resources/features/"},
		glue={"com.karsun.kic.tan", "org.openqa", "gov.fec.efapp"})
@TestDataFiles(files = { "src/test/resources/data/data.json" })
public class EFAppRunner {
}