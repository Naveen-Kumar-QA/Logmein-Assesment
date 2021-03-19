package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class calculator {

	public WebDriver driver;

	public WebElement numbers(int num) {

		By Num = By.xpath("//button[contains(text(),'" + num + "')]");

		return driver.findElement(Num);
	}
	
	public WebElement operation(String operation) {
		WebElement operand =null;
		if(operation=="EQ") {
			By EQ = By.xpath("//button[contains(text(),'EQ')]");
			operand= driver.findElement(EQ);
				}
		
		else if(operation=="PLUS") {
			By PLUS = By.xpath("//button[contains(text(),'PLUS')]");
			operand= driver.findElement(PLUS);
			
		}
		else if(operation=="MINUS") {
			By MINUS = By.xpath("//button[contains(text(),'MINUS')]");
			operand= driver.findElement(MINUS);
			
		}
		else if(operation=="MULT") {
			By MULT = By.xpath("//button[contains(text(),'MULT')]");
			operand= driver.findElement(MULT);
			
		}
		else if(operation=="DIV") {
			By DIV = By.xpath("//button[contains(text(),'DIV')]");
			operand= driver.findElement(DIV);
			
		}
		else if(operation=="DEL") {
			By DEL = By.xpath("//button[contains(text(),'DEL')]");
			operand= driver.findElement(DEL);
			
		}
		
		return operand;

	}
	public WebElement output() {
		
			By out = By.id("output");
			return driver.findElement(out);
				}
	public calculator(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}


	
}
