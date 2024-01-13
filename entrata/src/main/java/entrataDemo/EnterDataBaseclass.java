package entrataDemo;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnterDataBaseclass {
	public WebDriver driver = new ChromeDriver();  //This line initializes a ChromeDriver instance as driver

	public void openbrowser() throws IOException {  //To open browser
		driver.manage().window().maximize();        //To maximize the window
		driver.get(EnterDataUtilityClass.getpfdata("url"));  //Navigating to the url"https://www.entrata.com/"
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000)); 
	}
}
