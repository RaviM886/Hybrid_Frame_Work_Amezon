package com.learnautomation.utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.stream.FileImageInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelDataReaderAndWriter {
	XSSFWorkbook wb;	
    public ExcelDataReaderAndWriter() {    	
    	  File src =new File("E:\\ravi3\\Hybrid_Frame_Work_Amezon\\TestData\\DataPU.xlsx");    	
    	  try {
    		  FileInputStream fis =new FileInputStream(src);
	          wb=new XSSFWorkbook(fis);
		} catch (Exception e) {
		   System.out.println("unable to read excel file - "+e.getMessage());
		}    	 
    }    
     public String getStringData(int sheetIndex , int row , int column)
     {
    	 return wb.getSheetAt(sheetIndex).getRow(0).getCell(0).getStringCellValue();
     }
     public String getStringData(String sheetName , int row ,int column)
     {
    	 return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
    	 
     }
     public String getNumericData(String sheetname,int row,int column)
     {
    	 long userid=(long) wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
    	 return String.valueOf(userid);
     }
}
