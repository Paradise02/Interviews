package counter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

public class JARReader extends ZipFile{

	public JARReader(File file) throws ZipException, IOException {
		super(file);
	}
	
	public ArrayList<String> getZipEntries() {
		ArrayList<String> entryList = new ArrayList<>();
		Enumeration<?> zipEntries = this.entries();
		while (zipEntries.hasMoreElements()) {
			entryList.add(((ZipEntry)zipEntries.nextElement()).getName());
		}
		return entryList;
	}
	
	public static void main(String[] args) throws ZipException, IOException {
		File file = new File("C:\\Program Files\\Java\\jre1.8.0_181\\lib\\charsets.jar");
		JARReader reader = new JARReader(file);
		System.out.println(reader.getZipEntries());
	}

}
