package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Createcontact_test {
@Test(dataProvider="getData")
public void createContactDpTest(String firstName, String lastName, long phonenumber) {
	System.out.println("FistName :"+ firstName + ", LattName:" + lastName +", phonenNumber : "+phonenumber);
}
@DataProvider
public Object[][] getData(){
	Object[][] objArr = new Object[3][3];
	objArr[0][0] = "Lucky";
	objArr[0][1] = "TeamLead";
	objArr[0][2] = 8597456231l;
	
	objArr[1][0] = "Rahul";
	objArr[1][1] = "Manager";
	objArr[1][2] = 7845126355l;
	
	objArr[2][0] = "Lavanya";
	objArr[2][1] = "CEO";
	objArr[2][2] = 7845923641l;
	return objArr;
	
}
}
