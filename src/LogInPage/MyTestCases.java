package LogInPage;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {
	WebDriver driver = new ChromeDriver();
	String theUrl = "https://automationteststore.com/";
	String signUpPage = "https://automationteststore.com/index.php?rt=account/create";
	Random rand = new Random();

	@BeforeTest
	public void mySetup() {
		driver.get(theUrl);
		driver.manage().window().maximize();

	}

	@Test(priority = 1, enabled = true)
	public void signUp() throws InterruptedException {

		driver.navigate().to(signUpPage);
//		Elements
		WebElement firstNameInput = driver.findElement(By.name("firstname"));
		WebElement lastNameInput = driver.findElement(By.name("lastname"));
		WebElement emailInput = driver.findElement(By.name("email"));
		WebElement telepohneInput = driver.findElement(By.name("telephone"));
		WebElement faxInput = driver.findElement(By.name("fax"));
		WebElement companyInput = driver.findElement(By.name("company"));
		WebElement address1Input = driver.findElement(By.name("address_1"));
		WebElement address2Input = driver.findElement(By.name("address_2"));
		WebElement cityInput = driver.findElement(By.name("city"));
		WebElement postalCodeInput = driver.findElement(By.name("postcode"));
		WebElement loginNameInput = driver.findElement(By.name("loginname"));
		WebElement passwordInput = driver.findElement(By.name("password"));
		WebElement passwordConfirmInput = driver.findElement(By.name("confirm"));
		WebElement agreeBox = driver.findElement(By.id("AccountFrm_agree"));
		WebElement newsletter = driver.findElement(By.id("AccountFrm_newsletter1"));
		WebElement continueButton = driver.findElement(By.cssSelector("button[title='Continue']"));
		WebElement countrySelect = driver.findElement(By.id("AccountFrm_country_id"));
		WebElement stateSelect = driver.findElement(By.id("AccountFrm_zone_id"));

//		Data
		String[] firstNames = { "ahmad", "sara", "mohmmad", "leen" };
		int randomIndexForFirstName = rand.nextInt(firstNames.length);
//		
		String randomFirstName = firstNames[randomIndexForFirstName];

		String[] lastNames = { "essa", "yahya", "osama" };
		int randomIndexForLastName = rand.nextInt(lastNames.length);
		String randomLastName = lastNames[randomIndexForLastName];

		int randomNumberTheEmail = rand.nextInt(6000);
		String email = randomFirstName + randomLastName + randomNumberTheEmail + "@gmail.com";

		String telepohns = "962777626481";
		String faxs = "962777626481";
		String companies = "TwinTurbo";
		String address1 = "30th Street";
		String address2 = "North Irbid";
		String city = "Amman";
		String postalCode = "21111";
		String loginName = (randomFirstName + randomLastName + randomNumberTheEmail);
		String password = "Test@54321";

//		Actions

		firstNameInput.sendKeys(randomFirstName);
		lastNameInput.sendKeys(randomLastName);
		emailInput.sendKeys(email);
		telepohneInput.sendKeys(telepohns);
		faxInput.sendKeys(faxs);
		companyInput.sendKeys(companies);
		address1Input.sendKeys(address1);
		address2Input.sendKeys(address2);
		cityInput.sendKeys(city);
		
		
		
		int namberOfOptionsForCountry = countrySelect.findElements(By.tagName("option")).size();
		System.out.println(namberOfOptionsForCountry);

		Select mySelectForTheCountry = new Select(countrySelect);
		int randomCountryIndex = rand.nextInt(namberOfOptionsForCountry);
		mySelectForTheCountry.selectByIndex(randomCountryIndex);
		
		Thread.sleep(1000);
		
		
		int namberOfOptions = stateSelect.findElements(By.tagName("option")).size();
		System.out.println(namberOfOptions);
		
		
		
		Select mySelectForTheState = new Select(stateSelect);
		int randomStateIndex = rand.nextInt(1,namberOfOptions);
		mySelectForTheState.selectByIndex(randomStateIndex);
		
		
//		Select mySelectForTheState = new Select(stateSelect);
//		int randomStateIndex = rand.nextInt(1,namberOfOptions);
//		mySelectForTheState.selectByValue("1706");


		postalCodeInput.sendKeys(postalCode);
		loginNameInput.sendKeys(loginName);
		passwordInput.sendKeys(password);
		passwordConfirmInput.sendKeys(password);
		agreeBox.click();
		newsletter.click();
		continueButton.click();


		
//		Policy Agreement Check	
		WebElement privcayPolicy = driver.findElement(By.id("AccountFrm_agree"));
		privcayPolicy.click();
		
//		Continue button
		WebElement Continue = driver.findElement(By.xpath("//*[@id=\"AccountFrm\"]/div[5]/div/div/button"));
		Continue.click();
		

	}
}
