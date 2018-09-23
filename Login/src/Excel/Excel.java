
package Excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;




public class Excel {

    public  static String [][] getData (){
        
        
            try {

            FileInputStream excelFile = new FileInputStream(new File("data.xlsx"));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            
            int numberOfRows = datatypeSheet.getLastRowNum() + 1;
            int numberOfColoms = datatypeSheet.getRow(0).getLastCellNum();
            String values [][]  = new String[numberOfRows-1][numberOfColoms];
            
            boolean isHeader = true;
            int row = 0;
            int col = 0;
            while (iterator.hasNext()) {
                
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                
                if (isHeader == true){
                    isHeader = false;
                    continue;
                }
                
                col = 0;
                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();
                    values [row][col++] = currentCell.getStringCellValue();                    
                }
                
                row++;
            }
            
             return values;
             
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
            
      return null;
    }
}
