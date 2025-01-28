package dbc;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Updatedatanonselectquery {

	public static void main(String[] args) throws SQLException {
		Driver dref = new Driver();
		DriverManager.registerDriver(dref);
	Connection cn =	DriverManager.getConnection("jdbc:mysql://localhost:3306/stdnt", "root", "root");
	Statement s =  cn.createStatement();
    int  i   =   	s.executeUpdate("insert into Performance values(10,'Verybad','D');");
    System.out.println(i);
//     ResultSet r =  s.executeQuery("select * from Performance");
//    while( r.next()) {
//    	System.out.println(r.getString(1) + "\t" + r.getString(2) + "\t" + r.getString(3));
//    }
    cn.close();
		

	}

}
