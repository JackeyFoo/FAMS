package bll.controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import vl.interfaces.MyDialog;

public class ChooseImageActionListen implements ActionListener {

	private MyDialog dialog;

	public ChooseImageActionListen(MyDialog d) {
		dialog = d;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("ѡ��ͼƬ(�ɶ�ѡ)");
		chooser.setMultiSelectionEnabled(true);
		chooser.showOpenDialog(null);

		File[] files = chooser.getSelectedFiles();
		
		if (files.length != 0) {
			
			dialog.removeImgae();
			
			dialog.setImagePath(getFilePath(files));

			dialog.addImageToPanel(files);
		}

	}

	private String getFilePath(File[] files) {

		String result = "";

		if (files != null) {
			for (File f : files) {
				result += (f.getAbsolutePath() + ";");
			}
		} else {
			result = "����ѡ��ͼƬ(�ɶ�ѡ)";
		}

		return result;
	}

}
