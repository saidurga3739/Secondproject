package Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NewExcelLibrary {

	File f;
	FileOutputStream fos;
	FileInputStream fis;
	Sheet sh;
	Row row;
	Cell cell;
	Workbook wb;
	String path = null;

	public NewExcelLibrary(String path) {
		this.path = path;

	}

	public int getRowCount(String SheetName) throws IOException {
		f = new File(path);
		fis = new FileInputStream(f);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(SheetName);
		int rowCount = sh.getLastRowNum();
		//
		wb.close();
		fis.close();
		return rowCount;
	}

	public int getCellCount(String SheetName, int rowNum) throws IOException {
		f = new File(path);
		fis = new FileInputStream(f);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(SheetName);
		row = sh.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		//
		wb.close();
		fis.close();
		return cellCount;
	}

	public String getCellData(String SheetName, int rowNum, int cellNum) throws IOException {
		f = new File(path);
		fis = new FileInputStream(f);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(SheetName);
		row = sh.getRow(rowNum);
		cell = row.getCell(cellNum);
		// String cellvalue=cell.getStringCellValue();

		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data = formatter.formatCellValue(cell); // returns the formatted cell value as string regardless of value.
		} catch (Exception e) {
			data = "";
		}
		//
		wb.close();
		fis.close();
		return data;
	}
//		public void setCellData(String SheetName, int rowNum, int cellNum,String data ) throws InvalidFormatException, IOException {
//			f= new File(path);
//		    fis= new FileInputStream(f);
//			wb= new XSSFWorkbook(fis);
//			sh=wb.getSheet(SheetName);
//			row=sh.getRow(rowNum);
//			cell=row.getCell(cellNum);
//			Cell cell1=row.createCell(cellNum+1);
//			
//			cell1.setCellValue(data);
//			//
//			fos = new FileOutputStream(f);
//	        wb.write(fos);
//	        fos.flush();
//	        fos.close();
//			
//		}

}
