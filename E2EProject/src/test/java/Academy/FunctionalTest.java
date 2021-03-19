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

public class FunctionalTest extends base{
	public WebDriver driver;
	
	 public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
		 driver.get(prop.getProperty("url"));

	}
	@Test(priority=1)
	public void BODMAStest() {
		calculator P = new calculator(driver);
		for(int i=0;i<3;i++) P.operation("DEL").click();
		
		//7-1*0+3/3=?
		P.numbers(7).click(); P.operation("MINUS").click(); P.numbers(1).click(); P.operation("MULT").click();
		P.numbers(0).click(); P.operation("PLUS").click(); P.numbers(3).click(); P.operation("DIV").click(); P.numbers(3).click();
		
		P.operation("EQ").click();
		
		int output= Integer.parseInt(P.output().getText());
		System.out.println(output);
		Assert.assertEquals(7-1*0+3/3, output);
		if(output==(7-1*0+3/3))
		log.info("BODMAS rule Passed");
		else log.info("BODMAS rule failed");
	}
	
	@Test(priority=2)
	
	public void addtest() throws IOException
	{

		calculator P = new calculator(driver);
		for(int i=0;i<9;i++) P.operation("DEL").click();
		
		P.numbers(1).click();
		
		P.operation("PLUS").click();
		
		P.numbers(2).click();
		
		P.operation("EQ").click();
		
		int output= Integer.parseInt(P.output().getText());
		System.out.println(output);
		Assert.assertEquals(1+2, output);
		if(output==1+2)
		log.info("Addition test passed ");
		else log.info("Addition tets failed");
		}
	
@Test(priority=3)
	
	public void subtest() throws IOException
	{

		calculator P = new calculator(driver);
		for(int i=0;i<8;i++) P.operation("DEL").click();
		
		P.numbers(5).click();
		
		P.operation("MINUS").click();
		
		P.numbers(1).click();
		
		P.operation("EQ").click();
				
		
		int output= Integer.parseInt(P.output().getText());
		System.out.println(output);
		Assert.assertEquals(5-1, output);
		if(output==5-1) 
		log.info("Subtraction test passed");
		else log.info("Subtraction test failed");
		}

@Test(priority=4)

public void MultiplicationTest() throws IOException
{
	calculator P = new calculator(driver);
	for(int i=0;i<5;i++) P.operation("DEL").click();
	P.numbers(5).click();
	P.operation("MULT").click();
	P.numbers(2).click();
	
	P.operation("EQ").click();
	
	int output= Integer.parseInt(P.output().getText());
	System.out.println(output);
	Assert.assertEquals(5*2, output);
	if(output==5*2) 
		log.info("Multiplication test passed");
		else log.info("Multiplication test failed");
		
}

@Test(priority=5)

public void DIVTest() throws IOException
{
	calculator P = new calculator(driver);
	for(int i=0;i<5;i++) P.operation("DEL").click();
	P.numbers(7).click();
	P.operation("DIV").click();
	P.numbers(2).click();
	
	P.operation("EQ").click();
	
	String output= P.output().getText();
	output.toString();
	System.out.println(output);
	
	Assert.assertEquals("3.5", output);
	
}


	@AfterTest
	public void teardown()
	{
			driver.close();
	}
	
}
