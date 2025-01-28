package xcl;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Readdataoncondition {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String expected = "SearchProduct";
		boolean flag = false;
		FileInputStream fis = new FileInputStream("C:\\Users\\NEW\\Downloads\\Sales_Inventory_TestCases.xlsx");
         Workbook   wb =   WorkbookFactory.create(fis);
     Sheet  sh =  wb.getSheet("Sheet1");
  int r =   sh.getLastRowNum();
  
 
  for(int i =1;i<=r;i++) {
	  if(flag) {
		  break;
	  }
	  String d = sh.getRow(i).getCell(0).toString();
	  if(d.equals(expected)) {
		 //c1 = sh.getRow(i).getCell(0).toString();
	String	c2 = sh.getRow(i).getCell(1).toString();
	String	 c3 = sh.getRow(i).getCell(2).toString();
	String	 c4 = sh.getRow(i).getCell(3).toString();
	String	 c5 = sh.getRow(i).getCell(4).toString();
	// System.out.println(c1);
	 System.out.println(c2);
	System.out.println(c3);
	System.out.println(c4);
	System.out.println(c5);
	flag =true;
	  
	  
  }
     
	}

	}
}
