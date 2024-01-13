package entrataTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import entrataDemo.EnterDataBaseclass;

public class demoTestClass extends EnterDataBaseclass {

	@FindBy(xpath = "(//a[@class='button-default solid-dark-button'])[1]")
	private WebElement watchDemoButton;
	@FindBy(xpath = "//input[@id='FirstName']")
	private WebElement firstName;
	@FindBy(xpath = "//input[@id='LastName']")
	private WebElement lastName;
	@FindBy(xpath = "//input[@id='Email']")
	private WebElement email;
	@FindBy(xpath = "//input[@name='Company']")
	private WebElement companyName;
	@FindBy(xpath = "//input[@id='Phone']")
	private WebElement phoneNumber;
	@FindBy(xpath = "//select[@id='Unit_Count__c']")
	private WebElement unitCount;
	@FindBy(xpath = "//input[@id='Title']")
	private WebElement title;
	@FindBy(xpath = "//a[@title='Entrata Home Page']")
	private WebElement getTitle;
	@FindBy(xpath = "//a[@class='main-header-logo']")
	private WebElement logo;
	@FindBy(xpath = "//div[@class='cookie-consent-form']")
	private WebElement getCoockiesBanner;
	@FindBy(xpath = "//button[@id='rcc-confirm-button']")
	private WebElement coockiesAcceptButton;
	@FindBy(xpath = "//div[@class='main-nav-link'][1]")
	private WebElement productMenuLink;
	@FindBy(xpath = "//a[@class='fat-nav-links' and @href='/products/residentpay']")
	private WebElement residentPayMenuLink;
	@FindBy(xpath = "//a[@href='https://go.entrata.com/demo']")
	private WebElement scheduleDemo;
	@FindBy(xpath = "//div[@class='header-nav-item'][2]")
	private WebElement solutionsMenuLink;
	@FindBy(xpath = "//a[@href='/multifamily']")
	private WebElement multiFamilyeMenuLink;
	@FindBy(xpath = "//div[@class=\"wistia_click_to_play\"]//a[text()='Why Entrata?']")
	private WebElement multifamilyVideoButtonWhyEntrata;
	@FindBy(xpath = "//button[@id='wistia-ioksvtvcv8-1_popover_popover_close_button']")
	private WebElement multifamilyVideoCloseButton;


	@BeforeClass
	public void setup() throws IOException {
		openbrowser(); // It opens the browser
		PageFactory.initElements(driver, this);
		if (getCoockiesBanner.isDisplayed()) {
			coockiesAcceptButton.click();
			// Check if cookies banner is displayed and accept it if present

		}
	}

	@Test(priority = 1)
	public void verifyPageTitle() {
	    // Get actual and expected page titles
		String actualtitle = driver.getTitle();
		String expectedtitle = "Property Management Software | Entrata";
		
	    // Verify page title using assertion
		Assert.assertEquals(expectedtitle, actualtitle);
		System.out.println("Page title is: " + expectedtitle);
	}

	@Test(priority = 2)
	public void verifyPageLogo() {
		boolean actuallogo = logo.isDisplayed();
		//verify that logo is display
		if (actuallogo) {
	        System.out.println("Logo is displayed on the page.");
	    } else {
	        System.out.println("Logo is not displayed on the page.");
	    }
		Assert.assertTrue(actuallogo);
	}

	@Test(priority = 3)
	public void watchDemo() {
		watchDemoButton.click();

		firstName.sendKeys("sayali");
		lastName.sendKeys("Khairnar");
		email.sendKeys("sayalikhairnar@gmail.com");
		companyName.sendKeys("entrata");
		phoneNumber.sendKeys("7854513698");
		Select s = new Select(unitCount);
		s.selectByVisibleText("1 - 10");
		title.sendKeys("SoftwareTester");
		// Verify that the form fields are filled correctly
		Assert.assertEquals(firstName.getAttribute("value"), "sayali");
		Assert.assertEquals(lastName.getAttribute("value"), "Khairnar");
		Assert.assertEquals(email.getAttribute("value"), "sayalikhairnar@gmail.com");
		Assert.assertEquals(companyName.getAttribute("value"), "entrata");
		Assert.assertEquals(phoneNumber.getAttribute("value"), "7854513698");
		Assert.assertEquals(title.getAttribute("value"), "SoftwareTester");

	}

	@Test(priority = 4)
	public void watchProductResidentPayDemo() {
		driver.get("https://www.entrata.com/");

		Actions act = new Actions(driver);
		act.moveToElement(productMenuLink).perform(); // to hover over a menu link, 
		residentPayMenuLink.click();
		scheduleDemo.click();

		firstName.sendKeys("sayali");
		lastName.sendKeys("Khairnar");
		email.sendKeys("sayalikhairnar@gmail.com");
		companyName.sendKeys("entrata");
		phoneNumber.sendKeys("7854513698");
		Select s = new Select(unitCount);
		s.selectByVisibleText("1 - 10");
		title.sendKeys("SoftwareTester");

		// Verify that the form fields are filled correctly
		Assert.assertEquals(firstName.getAttribute("value"), "sayali");
		Assert.assertEquals(lastName.getAttribute("value"), "Khairnar");
		Assert.assertEquals(email.getAttribute("value"), "sayalikhairnar@gmail.com");
		Assert.assertEquals(companyName.getAttribute("value"), "entrata");
		Assert.assertEquals(phoneNumber.getAttribute("value"), "7854513698");
		Assert.assertEquals(title.getAttribute("value"), "SoftwareTester");
		driver.get("https://www.entrata.com/");
	}

	@Test(priority = 5)
	public void solutionsMultiFamilyWatchWhyEntrataVideo() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(solutionsMenuLink).perform();
		multiFamilyeMenuLink.click();
		multifamilyVideoButtonWhyEntrata.click();
		Thread.sleep(3000);
		multifamilyVideoCloseButton.click(); //closed video after pause
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		driver.get("https://www.entrata.com/");  //back to main page
		Thread.sleep(5000);                      //wait for 5 seconds
		if (driver != null) {
			driver.quit();
		}
	}

}
