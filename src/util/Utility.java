package util;

import java.io.File;
import java.io.IOException;

public class Utility {
	
	public static void initDataDir(){

		try {
			
			String path = System.getProperty("user.dir")
					+ File.separator + "data";
			new File(path).mkdirs();
			
			Runtime.getRuntime().exec(
					"attrib +H " + "\"" + path + "\"" + " /S /D");
			
			Runtime.getRuntime().exec(
					"attrib +H " + "\"" + path + File.separator +  "*\"" + " /S /D");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
