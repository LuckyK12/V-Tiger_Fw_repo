package testng;

import org.testng.annotations.DataProvider;

public class Dataprovider_betweenclass {
	@DataProvider(name = "Logindata")
	public Object[][] getData()
	{
		Object[][] data = {{"lavanya@gmail.com","456"},
				{"lakshmi@gmail.com","894"},
				{"lohithakshi@gmail.com","564"}};
		return data;
		}
}
