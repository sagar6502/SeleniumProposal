package edu.Factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData {
	String dataFile = System.getProperty("user.dir")+ File.separatorChar+"src"+File.separatorChar+"main"+File.separatorChar+"resources"+
					File.separatorChar+"TestData.xlsx";
	public void readData() throws IOException {
		FileInputStream fis = new FileInputStream(new File(dataFile));
		XSSFWorkbook workbook = new XSSFWorkbook(fis); 
		
		Sheet sheet = workbook.getSheet("Test");
		
		for(Row row : sheet) {
			for(Cell cell : row) {
				String cellValue = cell.getStringCellValue();
				System.out.println(cellValue +"\t");
			}
			System.out.println();
		}
		workbook.close();
	}
	public void readData_Specific() throws IOException {
		FileInputStream fis = new FileInputStream(new File(dataFile));
		XSSFWorkbook workbook = new XSSFWorkbook(fis); 
		
		Sheet sheet = workbook.getSheet("Test");
		
		 String searchValue = "INB_001"; // The value you want to search for
	        int searchColumn = 1; // The index of the column to search in (0 for the first column)

	        for (Row row : sheet) {
	            Cell cell = row.getCell(searchColumn);
	            if (cell != null && cell.getCellType() == CellType.STRING) {
	                String cellValue = cell.getStringCellValue();
	                if (cellValue.equals(searchValue)) {
	                    // Print or process the data from other columns in the same row
	                    Cell otherCell = row.getCell(1); // Accessing data from the second column
	                    String otherCellValue = otherCell.getStringCellValue();
	                    System.out.println("Found: " + cellValue + ", Other Value: " + otherCellValue);
	                }
	            }
	        }

	        workbook.close();
	}
	public void readData_Yes() throws IOException {
		FileInputStream fis = new FileInputStream(new File(dataFile));
		XSSFWorkbook workbook = new XSSFWorkbook(fis); 
		
		Sheet sheet = workbook.getSheet("Test");
		String dataValue  = null;
		
		int yesColumnIndex = 4; // Assuming "Yes" is in the third column (index 2)
        int dataColumnIndex = 1;
        int moduleColumnIndex = 0;// Assuming you want data from the second column (index 1)
        for(int i=0; i< readModule_Yes().split(",").length;i++) {
        	String moduleName = readModule_Yes().split(",")[i];
        	for (Row row : sheet) {
                Cell yesCell = row.getCell(yesColumnIndex);
                Cell moduleCell = row.getCell(moduleColumnIndex);
                //System.out.println(row.getPhysicalNumberOfCells());
                boolean moduleCase = moduleCell.toString().equals(moduleName);
                boolean testCase = yesCell != null && yesCell.getCellType() == CellType.STRING && yesCell.getStringCellValue().equals("Yes");
                if (testCase && moduleCase ) {
                    Cell dataCell = row.getCell(dataColumnIndex);
                   
                    if (dataCell != null) {
                    	if(dataValue == null) {
                    		dataValue = dataCell.getStringCellValue();
                    	}else {
                    		dataValue = dataValue + ","+dataCell.getStringCellValue();
                    	}
                    	
                        
                    }
                }
            }
        }
        System.out.println("SS2 :Value for 'Yes' row: " + dataValue);

	    workbook.close();
	}
	
	public String readModule_Yes() throws IOException {
		FileInputStream fis = new FileInputStream(new File(dataFile));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		String dataValue = null;
		
		Sheet sheet = workbook.getSheet("Configuration");
		
		int yesColumnIndex = 2; // Assuming "Yes" is in the third column (index 2)
        int dataColumnIndex = 0; // Assuming you want data from the second column (index 1)

        for (Row row : sheet) {
            Cell yesCell = row.getCell(yesColumnIndex);
            if (yesCell != null && yesCell.getCellType() == CellType.STRING && yesCell.getStringCellValue().equals("Yes")) {
                Cell dataCell = row.getCell(dataColumnIndex);
                if (dataCell != null) {
                   if(dataValue == null) {
                	   dataValue = dataCell.getStringCellValue();
                   }else {
                	   dataValue = dataValue + ","+dataCell.getStringCellValue();
                   }
                                      //String data = dataCell.getStringCellValue().replace("id :",setValue);
                }
            }
        }
	    workbook.close();
	    return dataValue;
	}
	
}
