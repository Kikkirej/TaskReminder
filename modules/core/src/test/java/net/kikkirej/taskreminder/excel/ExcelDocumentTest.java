package net.kikkirej.taskreminder.excel;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.junit.Test;

public class ExcelDocumentTest {

	@Test
	public void ConstructorTest() throws Exception {
		try {
			URL resource = getClass().getResource("test.xlsx");
			InputStream inputStream = resource.openStream();
			ExcelDocument excelDocument = new ExcelDocument(inputStream);
			excelDocument.close();
		} catch (Exception e) {
			fail("The Creaton of the ExcelDocument has failed. Cause:"+ e.getMessage());
		}
	}
	
	@Test
	public void getRowValuesWithDateTest() throws Exception{
		URL resource = getClass().getResource("test.xlsx");
		InputStream inputStream = resource.openStream();
		ExcelDocument excelDocument = new ExcelDocument(inputStream);
		excelDocument.selectSheet("Table");
		excelDocument.setCheckingColumns(2, 8);
		String[] rowValuesWithDate = excelDocument.getRowValuesWithDate(1, new SimpleDateFormat("MM-DD-yyyy", Locale.ENGLISH).parse("5-27-2017"));
		String[] expected={"a","b","c","d","e","f","g"};
		assertArrayEquals(expected, rowValuesWithDate);
		excelDocument.close();
	}

}
