package xcl;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class Readdata {

	public static void main(String[] args) throws EncryptedDocumentException, IOException   {
		FileInputStream fis = new FileInputStream("C:\\Users\\NEW\\OneDrive\\Desktop\\Selenium\\Fb credentials.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
  Sheet	 sh = wb.getSheet("Sheet1");
 int ir = sh.getLastRowNum();
 for(int i =1;i<=ir;i++) {
	 
	Row r= sh.getRow(i);
	int	ic=	 r.getLastCellNum();
	for(int j=0;j<ic;j++) {
Cell	c= r.getCell(j);
String cellValue;
switch (c.getCellType()) {
case STRING : cellValue =   c.getStringCellValue();
	
	break;
case NUMERIC: cellValue = String.valueOf(c.getNumericCellValue());

default: cellValue ="";
	
}
System.out.print(cellValue + "\t");
}
	System.out.println();
	}
 
 
}
}




