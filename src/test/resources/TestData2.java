package edu.Factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData2 {
	String dataFile = System.getProperty("user.dir")+ File.separatorChar+"src"+File.separatorChar+"main"+File.separatorChar+"resources"+
					File.separatorChar+"TestData.xlsx";
	String dataFile1 = System.getProperty("user.dir")+ File.separatorChar+"src"+File.separatorChar+"main"+File.separatorChar+"resources"+
			File.separatorChar+"TestData2.xlsx";
	
		
	public String readModule_CopyDataToAnother() throws IOException {
		FileInputStream fis = new FileInputStream(new File(dataFile));
		FileOutputStream fis1 = new FileOutputStream(new File(dataFile1));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		//XSSFWorkbook workbook1 = new XSSFWorkbook(fis1);
//		String dataValue = null;
//		String dataValue1 = null;
		
		Sheet sheet = workbook.getSheet("Configuration");
		//Sheet sheet1 = workbook1.getSheet("Configuration");
		
        int dataColumnIndex = 1; // Assuming you want data from the second column (index 1)

        
         
         
        for(int i=0; i<=sheet.getLastRowNum();i++)
        {
        	/*
        	Row row = sheet.getRow(i);
        	Cell cell = row.createCell(5);

        	cell.setCellValue("WriteintoExcel");
        	*/
        	
        	Row row = sheet.getRow(i);
//        	if (row == null) {
//                // If the row doesn't exist, create it
//                row = sheet.createRow(5);
//            }
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
