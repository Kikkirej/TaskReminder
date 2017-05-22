package net.kikkirej.taskreminder.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class FileReader {
	
	private File file;

	public FileReader(String path) {
		file = new File(path);
	}
	
	public FileReader(File file) {
		this.file = file;
	}
	
	/**
	 * 
	 * @return all lines in {@link List}
	 * @throws IOException is thrown if there is a error while reading
	 */
	public List<String> getLineArray() throws IOException {
		List<String> lines = FileUtils.readLines(file, Charset.defaultCharset());
		return lines;
	}
	
	/**
	 * @return all lines of text as one {@link String}
	 * @throws IOException is thrown if there is a error while reading
	 */
	public String getAllText() throws IOException{
		List<String> lines = getLineArray();
		String returnValue = "";
		for (String string : lines) {
			returnValue += string + "\n";
		}
		return returnValue;
	}
	
	@Override
	public String toString() {
		try {
			return getAllText();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
