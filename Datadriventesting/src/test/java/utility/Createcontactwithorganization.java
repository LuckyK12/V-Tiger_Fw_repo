package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;


public class Createcontactwithorganization {
@Test
public void vtgr() throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream("C:\\Users\\NEW\\eclipse-workspace\\AutomationMaven\\Pp1.properties");
		Properties p = new Properties();
		p.load(fis);
	String browser =	p.getProperty("Browser");
	String url = p.getProperty("Url");
	String uname = p.getProperty("username");
	String psw = p.getProperty("password");
	Random rdm = new Random();
	int random = rdm.nextInt(1000);
	FileInputStream fis1 = new FileInputStream("C:\\Users\\NEW\\OneDrive\\Desktop\\Selenium\\Fb credentials.xlsx");
    Workbook wb = WorkbookFactory.create(fis1);
Sheet	 sh = wb.getSheet("Sheet1");
 Row r= sh.getRow(1);
Cell	c= r.getCell(4);
String ln = c.getStringCellValue().toString() + random;
Cell	c1= r.getCell(0);
String org = c1.getStringCellValue().toString() + random;
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
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
driver.findElement(By.name("user_name")).sendKeys(uname);
	driver.findElement(By.name("user_password")).sendKeys(psw);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.xpath("//a[.='Organizations']")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(org);
	driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(ln);
	driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
    Set<String> cw = driver.getWindowHandles();
    Iterator<String> it = cw.iterator();
    while(it.hasNext()) {
    String wd=	it.next();
    driver.switchTo().window(wd);
  String curl =  driver.getCurrentUrl();
  if(curl.contains("module=Accounts")) {
	  break;
  }
    }
	driver.findElement(By.name("search_text")).sendKeys(org);
	driver.findElement(By.name("search")).click();
	driver.findElement(By.xpath("//a[.='"+org+"']")).click();
	 Set<String> pw = driver.getWindowHandles();
	    Iterator<String> it1 = pw.iterator();
	    while(it1.hasNext()) {
	    String pwd=	it1.next();
	    driver.switchTo().window(pwd);
	  String curl =  driver.getCurrentUrl();
	  if(curl.contains("module=Contacts")) {
		  break;
	  }
	    }
	driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
String header =	driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
if(header.contains(ln)) {
	System.out.println("Contact created");
}
else {
	System.out.println("contact not created");
}
String last =        driver.findElement(By.id("dtlview_Last Name")).getText();
if(last.equals(ln)) {
 System.out.println("added");
}
else {
 System.out.println("not added");
}
driver.quit();


	}

}
