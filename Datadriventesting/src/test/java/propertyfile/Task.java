package propertyfile;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Task {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\NEW\\eclipse-workspace\\AutomationMaven\\Pp1.properties");
		Properties p = new Properties();
		p.load(fis);
	String browser =	p.getProperty("Browser");
	String url = p.getProperty("Url");
	String uname = p.getProperty("username");
	String psw = p.getProperty("password");
	String org = p.getProperty("orgname");
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
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(org);
	
	driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		

	}
	

}
