package testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class Ss {
	@Test
	public void screenshotTest() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/"); 
		driver.manage().window().maximize();
		//EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src =	ts.getScreenshotAs(OutputType.FILE);
		//File src =	edriver.getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(src,new File("./path to store" ));
		File dst = new File("./Screenshots/Amazonss.png");
		FileHandler.copy(src, dst);
		driver.quit();
	
		
		
	}

}
