package LogInPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class MyTestCases {
	WebDriver driver = new ChromeDriver();
	String theUrl ="https://automationteststore.com/";
	String signUpPage = "https://automationteststore.com/index.php?rt=account/create";
	
	@BeforeTest
	public void mySetup() {
		driver.get(theUrl);
		driver.manage().window().maximize();
		
		
		
	}
	@Test(priority = 1 , enabled = true)
	public void signUp() {
		
		driver.navigate().to(signUpPage);
		
		WebElement firstName =driver.findElement(By.name("firstname"));
		WebElement lastName = driver.findElement(By.name("lastname"));
		WebElement email = driver.findElement(By.name("email"));
		WebElement telepohne = driver.findElement(By.name("telephone"));
		WebElement fax = driver.findElement(By.name("fax"));


		firstName.sendKeys("ahmad");
		lastName.sendKeys("albetar");
		email.sendKeys("ahmadalbetar@gmail.com");
		telepohne.sendKeys("0777626481");
		fax.sendKeys("0777626481");
	 
		//Address
		WebElement company = driver.findElement(By.name("company"));
		WebElement address1 = driver.findElement(By.name("address_1"));
		WebElement address2 = driver.findElement(By.name("address_2"));
		WebElement city = driver.findElement(By.name("city"));
		WebElement region = driver.findElement(By.name("zone_id"));
		WebElement zipCode = driver.findElement(By.name("postcode"));
		WebElement country = driver.findElement(By.name("country_id"));
		
		
		
		
		company.sendKeys("TwinTurbo");
		address1.sendKeys("30th Street");
		address2.sendKeys("North Irbid");
		city.sendKeys("Irbid");
		region.sendKeys("");
		zipCode.sendKeys("21111");
		country.sendKeys("");
        
//		LogIn Details
		WebElement loginName = driver.findElement(By.name("loginname"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement passwordConfirm = driver.findElement(By.name("confirm"));
        loginName.sendKeys("ahmad22");
        password.sendKeys("Ahmad.12345");
        passwordConfirm.sendKeys("Ahmad.12345");
        
//      Newsletter
		WebElement newsletter = driver.findElement(By.id("AccountFrm_newsletter1"));
		newsletter.click();

//		Policy Agreement Check	
		WebElement privcayPolicy = driver.findElement(By.id("AccountFrm_agree"));
		privcayPolicy.click();
		
//		Continue button
		WebElement Continue = driver.findElement(By.xpath("//*[@id=\"AccountFrm\"]/div[5]/div/div/button"));
		Continue.click();
		
		

        
		
		
	}
}
