package net.kikkirej.taskreminder.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FileReader {
	
	List<String> getLineArray() throws IOException;
	
	String getAllText() throws IOException;
	
	FileInputStream getFileInputStream() throws FileNotFoundException;
}
