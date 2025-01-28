package testng;

import org.testng.annotations.Test;

public class Practicetest {
	@Test(priority=4)
	public void CreateTest() {
		System.out.println("Created");
	}
@Test(priority = 1)
public void modifyTest() {
	System.out.println("modified");
}
@Test(priority=3)
public void deleteTest() {
	System.out.println("deleted");
}
@Test(priority =-1)
public void recreateTest() {
	System.out.println("recreated");
}

}