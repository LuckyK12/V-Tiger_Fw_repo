package dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Readdataqueryselector {

	public static void main(String[] args) throws SQLException {
		
		Driver drivref = new Driver();   //49.249.28.218:3333
		DriverManager.registerDriver(drivref);	
	Connection cnt = DriverManager.getConnection("jdbc:mysql://localhost:3306/stdnt", "root", "root");
Statement st =	cnt.createStatement();
 ResultSet r =  st.executeQuery("select * from Performance;");
        //  r.next();
      // System.out.println(r.getString(2));
 while(r.next()) {
	 System.out.println(r.getString(1) + "\t" +  r.getString(2) + "\t" + r.getString(3));
 }
 cnt.close();
		

	}

}
