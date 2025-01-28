package exml;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class Sampletest {
	@Test
	public void param(XmlTest test)
	{
		String browser = test.getParameter("Browser");
		String url = test.getParameter("url");
		String uname = test.getParameter("Username");
		String psw = test.getParameter("Password");
		//String org = p.getProperty("orgname");
		WebDriver driver = null;
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(uname);
		driver.findElement(By.name("user_password")).sendKeys(psw);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		//driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(org);
		
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
	System.out.println(test.getParameter("Browser"));
	System.out.println(test.getParameter("url"));
	System.out.println(test.getParameter("Username"));
	}

}
