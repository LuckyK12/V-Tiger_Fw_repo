package testng;

import org.testng.annotations.Test;



public class Dataprovider1 {
	@Test(dataProvider = "Logindata",
			dataProviderClass = Dataprovider_betweenclass.class)
			public void loginTest(String un,String pwd) {
				System.out.println(un+" "+pwd);
			}


}
