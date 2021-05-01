package cwru.databite.databite.Implementation;

import java.io.File;

public class FileHandler {

	Object file;

	public void checkFileType(File file) {
		String fileName = file.getName();

		String extension = getExtension(fileName);
		if (extension.equals("CSV") == false && extension.equals("TSV") == false && extension.equals("txt") == false
				&& extension.equals("dat") == false && extension.equals("sql") == false
				&& extension.equals("xml") == false) {
			System.out.println("Error. Incorrect file format.");
		}

	}

	public void convertToFile(Object dataSet, Object fileType) {

	}

	private String getExtension(String name) {
		int position = getExtensionPosition(name);
		return name.substring(position, name.length());
	}

	private int getExtensionPosition(String name) {
		int returnVal = 0;
		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) == '.') {
				returnVal = i;
			}
		}
		return returnVal;
	}
}
