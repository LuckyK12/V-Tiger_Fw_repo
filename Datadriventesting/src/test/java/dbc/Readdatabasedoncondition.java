package dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class Readdatabasedoncondition {
	String exepectedDescription = "Good";
	@Test
	public void exep() throws SQLException {
		boolean flag = false;
		Driver drivref = new Driver();   //49.249.28.218:3333
		DriverManager.registerDriver(drivref);	
	Connection cnt = DriverManager.getConnection("jdbc:mysql://localhost:3306/stdnt", "root", "root");
Statement st =	cnt.createStatement();
 ResultSet r =  st.executeQuery("select * from Performance;");
        //  r.next();
      // System.out.println(r.getString(2));
 while(r.next()) {
	 String actualDescrip =r.getString(2);
	if(exepectedDescription.equals(actualDescrip)) {
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



