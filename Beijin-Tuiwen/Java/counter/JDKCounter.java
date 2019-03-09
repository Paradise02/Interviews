package counter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipException;

public class JDKCounter {
	/**
	 * 
	 * created 19.3.9
	 * 
	 * counter .class and .xml in JDK
	 */
	
	private static final String JDK_PATH;
	
	static {
		// put JDK path here
		JDK_PATH = "C:\\Program Files\\Java\\jdk1.8.0_144\\lib\\";
	}
	
	public static void count() throws ZipException, IOException {
		int classNo = 0, xmlNo = 0;
		
		ArrayList<String> filePaths = new BFS(JDK_PATH).getFileNames();
		
		for (String path : filePaths) {
			if (isClass(path)) {
				classNo ++;
			}
			else if (isXml(path)) {
				xmlNo ++;
			}
			else if (isJar(path)) {
				ArrayList<String> jarFiles = new JARReader(new File(path)).getZipEntries();
				
				for (String jarFilePath : jarFiles) {
					if (isClass(jarFilePath)) {
						classNo ++;
					}
					else if (isXml(jarFilePath)) {
						xmlNo ++;
					}
				}
			}
		}
		
		System.out.println(String.format("# .java %d, # .xml %d in JDK", classNo, xmlNo));
	}
	
	public static boolean isJar(String path) {
		return path.matches("(.*)\\.jar$");
	}
	
	public static boolean isClass(String path) {
		return path.matches("(.*)\\.class$");
	}
	
	public static boolean isXml(String path) {
		return path.matches("(.*)\\.xml$");
	}
	
	public static void main(String[] args) {
		try {
			count();
		} catch (ZipException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

