package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Createorgphonenum {
public static void main(String[] args) throws IOException, InterruptedException{
			
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
	Cell	c= r.getCell(0);
	Cell c1 = r.getCell(3);
	String org = c.getStringCellValue().toString() + random;
	String phn = c1.getStringCellValue().toString() ;
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
		driver.findElement(By.id("phone")).sendKeys(phn);
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
	Thread.sleep(2000);
	String header =	driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(header.contains(org)) {
		System.out.println("organization created");
	}
	else {
		System.out.println("not created");
	}
	String mbl = driver.findElement(By.id("dtlview_Phone")).getText();
	if(mbl.equals(phn)) {
		System.out.println("Matched");
	}
	else {
		System.out.println("not matched");
	}
driver.quit();

	}

}
