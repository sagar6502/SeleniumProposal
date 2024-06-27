package org.bayone.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData2 {
	String dataFile = System.getProperty("user.dir")+ File.separatorChar+"src"+File.separatorChar+"test"+File.separatorChar+"resources"+
					File.separatorChar+"TestData.xlsx";
	String dataFile1 = System.getProperty("user.dir")+ File.separatorChar+"src"+File.separatorChar+"test"+File.separatorChar+"resources"+
			File.separatorChar+"TestData2.xlsx";
	
		
	public String readModule_CopyDataToAnother() throws IOException {
		FileInputStream fis = new FileInputStream(new File(dataFile));
		FileOutputStream fis1 = new FileOutputStream(new File(dataFile1));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		Sheet sheet = workbook.getSheet("Configuration");
		
        int dataColumnIndex = 1; // Assuming you want data from the second column (index 1)

        
         
         
        for(int i=0; i<=sheet.getLastRowNum();i++)
        {
        	Row row = sheet.getRow(i);
        	 Cell dataCell = row.getCell(dataColumnIndex);
        	 if(dataCell == null) {
        		 dataCell = row.createCell(dataColumnIndex);
        	 }
        		 dataCell.setCellValue("New Row");
 
        	 
        	 
        }
        workbook.write(fis1);
	    workbook.close();
	    //workbook1.close();
	    return null;
	}
	
}
