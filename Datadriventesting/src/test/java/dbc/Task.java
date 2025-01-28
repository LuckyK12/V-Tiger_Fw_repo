package dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class Task {
	String Projectname = "Itemstracker_10";

	@Test
	public void ninja() throws SQLException
	
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://49.249.28.218:8091");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(Projectname);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Lucky");
		Select s = new Select(driver.findElement(By.xpath("(//select[@name='status'])[2]")));
		s.selectByVisibleText("Created");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
	
		
			boolean flag = false;
			Driver drivref = new Driver();   
			DriverManager.registerDriver(drivref);	
		Connection cnt = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
	Statement st =	cnt.createStatement();
	 ResultSet r =  st.executeQuery("select * from Project");
	 
	 while(r.next()) {
		 String actProjectName =r.getString(4);
	if(Projectname.equals(actProjectName)) {
			flag = true;
			 System.out.println("available");
			  }
	 }
		if(flag==false) {
		 
		 System.out.println("not available");
	 }
	 cnt.close();
		
		
		
		
		
		
		
	}

}
