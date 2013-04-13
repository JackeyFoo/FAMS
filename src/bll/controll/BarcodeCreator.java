package bll.controll;

import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jbarcode.JBarcode;
import org.jbarcode.encode.CodabarEncoder;
import org.jbarcode.encode.InvalidAtributeException;
import org.jbarcode.paint.BaseLineTextPainter;
import org.jbarcode.paint.WideRatioCodedPainter;
import org.jbarcode.util.ImageUtil;

public class BarcodeCreator {

	public static void barcodeCreate(String str) {

		try {

			BufferedImage localBufferedImage = MyJBarcode.getInstance()
					.createBarcode(str);

			String filepath = System.getProperty("user.dir") + File.separator
					+ "data" + File.separator + "Assets" + File.separator + str
					+ File.separator + str + ".jpg";
			
			saveImageFile(localBufferedImage, filepath);
			
			Desktop.getDesktop().open(new File(filepath));

		} catch (InvalidAtributeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void saveImageFile(BufferedImage image, String filepath) {

		try {
			
			removeFile(filepath);
			
			FileOutputStream localFileOutputStream = new FileOutputStream(
					filepath);

			ImageUtil.encodeAndWrite(image, "jpeg", localFileOutputStream, 200,
					200);

			localFileOutputStream.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static void removeFile(String path){
		
		File file = new File(path);
		
		if(file.exists()){
			file.delete();
		}
	}

}

class MyJBarcode {

	private static JBarcode localJBarcode;

	public static JBarcode getInstance() {

		localJBarcode = new JBarcode(CodabarEncoder.getInstance(),
				WideRatioCodedPainter.getInstance(),
				BaseLineTextPainter.getInstance());

		try {

			localJBarcode.setBarHeight(30);
			localJBarcode.setXDimension(0.5);
			localJBarcode.setWideRatio(2.0);
			localJBarcode.setShowCheckDigit(false);
			localJBarcode.setCheckDigit(false);

		} catch (InvalidAtributeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return localJBarcode;
	}

}