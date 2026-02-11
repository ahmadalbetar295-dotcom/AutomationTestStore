package LogInPage;

import java.util.List;
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
//	Data
	String TheUserName;
	String ThePassword = "Test@54321";

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

	//	Data
		String[] firstNames = { "ahmad", "sara", "mohmmad", "leen" };
		int randomIndexForFirstName = rand.nextInt(firstNames.length);	
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
		
	

//		Actions
		TheUserName = randomFirstName + randomLastName + randomNumberTheEmail;
		

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
		int randomStateIndex = rand.nextInt(1, namberOfOptions);
		mySelectForTheState.selectByIndex(randomStateIndex);

//		Select mySelectForTheState = new Select(stateSelect);
//		int randomStateIndex = rand.nextInt(1,namberOfOptions);
//		mySelectForTheState.selectByValue("1706");

		postalCodeInput.sendKeys(postalCode);
		loginNameInput.sendKeys(TheUserName);
		passwordInput.sendKeys(ThePassword);
		passwordConfirmInput.sendKeys(ThePassword);
		agreeBox.click();
		newsletter.click();
		continueButton.click();

		Thread.sleep(3000);

	}

	@Test(priority = 2,enabled=true)
	public void logOut() throws InterruptedException {
		WebElement logOut = driver.findElement(By.linkText("Logoff"));
		logOut.click();

		Thread.sleep(1000);
		WebElement continueLogOut = driver.findElement(By.linkText("Continue"));
		continueLogOut.click();

	}

	@Test(priority = 3,enabled=true)
	public void logIn() {
		WebElement logInAndregister = driver.findElement(By.partialLinkText("Login or"));
		logInAndregister.click();
		
		WebElement logInInput = driver.findElement(By.id("loginFrm_loginname"));
		WebElement psswordInput = driver.findElement(By.id("loginFrm_password"));
		WebElement logInButton = driver.findElement(By.cssSelector("button[title='Login']"));
		
		logInInput.sendKeys(TheUserName);
		psswordInput.sendKeys(ThePassword);
		
		logInButton.click();
	}
	@Test (priority = 4,invocationCount = 1)
	public void addToCart() throws InterruptedException {
		driver.navigate().to(theUrl);
		
		Thread.sleep(1000);
		List<WebElement> theListOfItems = driver.findElements(By.className("prdocutname"));
		
		int totalOfItems = theListOfItems.size();
		System.out.println(totalOfItems);
		int randomItemIndex = rand.nextInt(totalOfItems);
		theListOfItems.get(randomItemIndex).click();
		if (driver.getPageSource().contains("Out Of Stock")){
			driver.navigate().back();
			System.out.println("sorry the item out of stock");
		
		}else {
				System.out.println("the item is available");
			
		}
	}
}
