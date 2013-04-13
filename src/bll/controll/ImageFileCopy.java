package bll.controll;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import dal.interfaces.ModelObject;

public class ImageFileCopy {

	public ImageFileCopy() {

	}

	@SuppressWarnings("resource")
	public String copyFile(File f[], ModelObject o) {
		try {
			String resultpath = "";

			String path = getObjectName(o.getClass().getName());

			String parentpath = System.getProperty("user.dir") + File.separator
					+ "data" + File.separator + path + File.separator
					+ o.getFormatID();

			File outparentdir = new File(parentpath);
			outparentdir.mkdirs();

			if (f != null) {

				for (File file : f) {

					File outfile = new File(parentpath + File.separator
							+ file.getName());

					resultpath += (outfile.getAbsolutePath() + "<");

					if(outfile.exists()){					
						outfile.delete();
					}	
					
					FileChannel fcin = new FileInputStream(file).getChannel();

					FileChannel fcout = new FileOutputStream(outfile)
							.getChannel();
					
					fcin.transferTo(0, fcin.size(), fcout);

					fcin.close();
					fcout.close();

				}

			}

			return resultpath;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	private String getObjectName(String o) {
		return o.substring(10);
	}
}
