package testng;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Typesofassert {
	@Test
	public void homePageTest(Method mtd) {
		System.out.println(mtd.getName()+ "TestStart");
		Reporter.log("true",true);
		SoftAssert sA = new SoftAssert();
		System.out.println("Step1");
		System.out.println( "Step2");
		//Assert.assertEquals("home","home");
		//Assert.assertEquals("home","homep");
		sA.assertEquals("home","homep");
		System.out.println("step3");
		sA.assertEquals("login","login");
		System.out.println("step4");	
		sA.assertAll();
	System.out.println(mtd.getName()+ "TestEnd");
	}
	@Test
	public void logoVerify(Method mtd) {
		System.out.println(mtd.getName()+ "TestStart");
		SoftAssert sa = new SoftAssert();
		System.out.println("Step1");
		System.out.println( "Step2");
		
		sa.assertTrue(true);
		System.out.println("step3");
		System.out.println("step4");	
		sa.assertAll();
	System.out.println(mtd.getName()+ "TestEnd");
	}
}
