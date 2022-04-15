package pageObjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistrationPage {

	WebDriver driver;
	
	public AccountRegistrationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
     //Finding element if popup comes up
	@FindBy(xpath="//span[text()='Continue with phone']")
	List<WebElement> alert;

	//If popup cameup , finding element to dismiss it
	@FindBy(xpath="//div[@class='css-hu2d8y']")
	WebElement exitalert;
	
	//to get heading of page
	@FindBy(xpath="//h2[@class='css-yrjayn']")
	WebElement heading;
	
	@FindBy(xpath="//ul[@class='css-1mtoayx']")
	WebElement listtitle;
	
	//to get list of all stores with deleivery time
	@FindBy(xpath="//ul[@class='css-1mtoayx']/li")
	List<WebElement> storenames;

	

	public void checkifalertpresent() throws InterruptedException
	{
		//waiting to check if the alert is present
	Thread.sleep(5000);
	            if(alert.size()>0)
	            {
	              
	               exitalert.click();
	               String a=heading.getText();
	               
	               System.out.println(a);
	            }
	                    
	                
	           else
	                {
	        	   String a=heading.getText();
	                   System.out.println(a);
	                  
	                }
	            
	        
	}
	
	public void storenames() throws InterruptedException
	{
		Thread.sleep(1000);
		String a=heading.getText();
        
        System.out.println(a);
      
    
        // iterate over list
        for(int i = 0; i< storenames.size(); i++) {
           //obtain text
           String s = storenames.get(i).getText();
           System.out.println("Text is: " + s);
        }
	}
	
	
	
	
}





