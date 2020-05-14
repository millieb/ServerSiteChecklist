/**
* Updates Excel file. 
*
* @author Mildred Brito
*/
package net.codejava.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
 
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
 
/**
 * This program illustrates how to update an existing Microsoft Excel document.
 * Append new rows to an existing sheet.
 *
 * @author www.codejava.net
 *
 */
public class Update{
 
 
    public void updateExcel(String date, String servers, String temperature, 
    		String physicalGround, String UPS, String network, String signatures, String comments) {
    	String dt = date;
    	String srvs = servers;
    	String temp = temperature;
    	String phygrnd = physicalGround;
    	String ups = physicalGround;
    	String ntwrk = physicalGround;
    	String sign = signatures;
    	String cmnts = comments;
    	
    	
        String excelFilePath = "C:\\servercheck\\update.xlsx";
         
        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);
 
            Sheet sheet = workbook.getSheetAt(0);
 
            Object[][] bookData = {
                    {dt, srvs, temp, phygrnd, ups, ntwrk, sign, cmnts},
                    
            };
 
            int rowCount = sheet.getLastRowNum();
 
            for (Object[] aBook : bookData) {
                Row row = sheet.createRow(++rowCount);
 
                int columnCount = 0;
                 
                Cell cell = row.createCell(columnCount);
                cell.setCellValue(rowCount);
                 
                for (Object field : aBook) {
                    cell = row.createCell(++columnCount);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    } else if (field instanceof Integer) {
                        cell.setCellValue((Integer) field);
                    }
                }
 
            }
 
            inputStream.close();
 
            FileOutputStream outputStream = new FileOutputStream("C:\\servercheck\\update.xlsx");
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
             
        } catch (IOException | EncryptedDocumentException ex) {
            ex.printStackTrace();
        }
    }
 
}