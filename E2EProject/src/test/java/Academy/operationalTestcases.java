package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.calculator;
import resources.base;

public class operationalTestcases extends base {

	public WebDriver driver;

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

	}

	@Test(priority=1)

	public void deletekeycheck() throws IOException {
		calculator P = new calculator(driver);
		P.numbers(2).click();
		P.operation("EQ").click();
		
		int output = Integer.parseInt(P.output().getText());
		Assert.assertEquals(2, output);
		
		P.operation("DEL").click();
		String outputafter = (P.output().getText());
		Assert.assertEquals("", outputafter);
		log.info(" DEL button is operational");
	}

	@Test(priority=2)

	public void checknumbersworking() throws IOException {

		calculator P = new calculator(driver);
		for (int i = 0; i < 3; i++)
			P.operation("DEL").click();

		for (int j = 1; j < 10; j++)
			P.numbers(j).click();
		P.operation("EQ").click();

		int output = Integer.parseInt(P.output().getText());
		System.out.println(output);
		Assert.assertEquals(123456789, output);

		log.info("All the individual number buttons and equals button are operational");
	}
	
	@AfterTest
	public void teardown()
	{
			driver.close();
	}
	

}
