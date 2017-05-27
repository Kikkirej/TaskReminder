package net.kikkirej.taskreminder.excel;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.kikkirej.taskreminder.exceptions.DateNotFoundException;

public class ExcelDocument implements Closeable{

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	//Area 
	private Integer firstColumnIndex;
	private Integer lastColumnIndex;

	public ExcelDocument(InputStream inputStream) throws IOException {
		workbook = new XSSFWorkbook(inputStream);

		workbook.close();
	}

	public void close() throws IOException {
		workbook.close();
	}

	public void selectSheet(String name){
		sheet = workbook.getSheet(name);
	}

	public void setCheckingColumns(Integer firstColumnIndex, Integer lastColumnIndex){
		this.firstColumnIndex = firstColumnIndex;
		this.lastColumnIndex = lastColumnIndex;
	}

	public String getCell(Integer row, Integer cell){
		XSSFRow xssfRow = sheet.getRow(row);
		XSSFCell xssfCell = xssfRow.getCell(cell);
		if(xssfCell != null){
			String cellValue = xssfCell.getStringCellValue();
			return cellValue;
		}
		return "";
	}

	public String[] getRowValuesWithDate(Integer dateCol, Date date) throws Exception{
		Row row = getRowWithDate(dateCol, date);
		if(row == null){
			throw new DateNotFoundException("The date wasn't found:" + date);
		}
		String[] valuesOfRow = getValuesOfRow(row);
		return valuesOfRow;
	}

	private Row getRowWithDate(Integer dateCol, Date date) throws ParseException {
		date = migrateDate(date);
		Iterator<Row> iterator = sheet.iterator();
		while(iterator.hasNext()){
			Row row = iterator.next();
			Cell cell = row.getCell(dateCol);
			if(cellValid(date, cell)){
				return row;
			}
		}
		return null;
	}

	private boolean cellValid(Date date, Cell cell) {
		return cell != null && cell.getDateCellValue().equals(date);
	}

	private Date migrateDate(Date date) throws ParseException {
		DateFormat df = new SimpleDateFormat("DD.MM.yyyy");
		String format = df.format(date);
		date = df.parse(format);
		return date;
	}

	private String[] getValuesOfRow(Row row) {
		Integer integer = lastColumnIndex-firstColumnIndex+1;
		String[] array = new String[integer.intValue()];
		for (int i = 0; i < array.length; i++) {
			Cell cell = row.getCell(i+firstColumnIndex);
			if(cell!=null){
				array[i] = cell.getStringCellValue();
			}
		}
		return array;
	}

}
