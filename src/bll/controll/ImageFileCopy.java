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
	public static void copyFile(File f[], ModelObject o) {
		try {

			String path = o.getClass().getName();
			
			String parentpath = System.getProperty("user.dir")+ File.separator
					+ path + File.separator + o.getID();

			if (f != null) {

				for (File file : f) {

					File outparentdir = new File(parentpath);
					outparentdir.mkdirs();

					File outfile = new File(parentpath + File.separator
							+ file.getName());

					FileChannel fcin = new FileInputStream(file).getChannel();

					FileChannel fcout = new FileOutputStream(outfile)
							.getChannel();
					fcin.transferTo(0, fcin.size(), fcout);

					fcin.close();
					fcout.close();
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
