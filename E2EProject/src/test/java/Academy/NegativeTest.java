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

public class NegativeTest extends base{
	public WebDriver driver;
	
	 public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
		 driver.get(prop.getProperty("url"));

	}
	@Test
	
	public void dividenumberbyzero() throws IOException
	{

		calculator P = new calculator(driver);
		for(int i=0;i<3;i++) P.operation("DEL").click();
		
		P.numbers(2).click();
		
		P.operation("DIV").click();
		
		P.numbers(0).click();
		
		P.operation("EQ").click();
		
		String output= (P.output().getText());
		System.out.println(output);
		Assert.assertEquals("Infinity", output);
		
		}
	@Test
	public void dividezerobynumber() throws IOException
	{

		calculator P = new calculator(driver);
		for(int i=0;i<3;i++) P.operation("DEL").click();
		
		P.numbers(0).click();
		
		P.operation("DIV").click();
		
		P.numbers(2).click();
		
		P.operation("EQ").click();
		
		int output= Integer.parseInt(P.output().getText());
		System.out.println(output);
		Assert.assertEquals(0, output);
		
		}
	@Test	public void dividezerobyzero() throws IOException
	{

		calculator P = new calculator(driver);
		for(int i=0;i<3;i++) P.operation("DEL").click();
		
		P.numbers(0).click();
		
		P.operation("DIV").click();
		
		P.numbers(0).click();
		
		P.operation("EQ").click();
		
		String output= P.output().getText();
		System.out.println(output);
		Assert.assertEquals("ERR", output);
		if(output=="ERR") log.info("Error message printed correctly");
		else log.info("Error message printed is incorrect");
		}
		

	@AfterTest
	public void teardown()
	{
			driver.close();
	}
	
}
