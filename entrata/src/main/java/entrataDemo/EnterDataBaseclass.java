package entrataDemo;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnterDataBaseclass {
	//This line initializes a ChromeDriver instance as driver
	public WebDriver driver = new ChromeDriver();

	public void openbrowser() throws IOException {
		//To maximize the window
		driver.manage().window().maximize();
		//Navigating to the url"https://www.entrata.com/"
		driver.get("https://www.entrata.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000)); 
	}
	
	//explicit wait common method
    public WebElement waitForElementToBeVisible(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

}
