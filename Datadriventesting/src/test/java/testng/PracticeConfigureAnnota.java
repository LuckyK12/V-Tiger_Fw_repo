package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PracticeConfigureAnnota {
	@BeforeSuite
	public void bs() {
		System.out.println("bs");
	}
	@BeforeClass
	public void bc() {
		System.out.println("bc");
	}
	@BeforeMethod
	public void bm()
	{
		System.out.println("bm");
	}
	@Test
	public void mm() {
		System.out.println("mm");
	}
	@Test
	public void amm()
	{
		System.out.println("amm");
	}
	@AfterMethod
	public void am() {
		System.out.println("am");
	}
	@AfterClass
	public void ac() {
		System.out.println("ac");
	}
	@AfterSuite
	public void as() {
		System.out.println("as");
	}

}
