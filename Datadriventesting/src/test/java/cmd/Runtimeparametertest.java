package cmd;

import org.testng.annotations.Test;

public class Runtimeparametertest {

@Test
	public void test() {
String url =	System.getProperty("url");
	System.out.println("Env Data==>URL===>"+url);
	
		

	}

}
