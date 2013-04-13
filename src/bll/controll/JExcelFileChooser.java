package bll.controll;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class JExcelFileChooser {
	
	private File file = null;
	private JFileChooser jfc;
	
	public JExcelFileChooser(){
		
		jfc = new JFileChooser();

		jfc.removeChoosableFileFilter(jfc.getFileFilter());

		jfc.addChoosableFileFilter(new FileFilter() {
			public boolean accept(File file) {
				
				if(file.getName().endsWith(".xls")){
					return true;
				}else if(file.isDirectory()){
					return true;
				}else{
					return false;
				}

			}

			public String getDescription() {
				return "Excel±í¸ñ(.xls)";
			}

		});
		
	}

	public File returnSaveFile() {

		int result = jfc.showSaveDialog(null);

		if (result == JFileChooser.APPROVE_OPTION) {

			File tempfile = jfc.getSelectedFile();

			if (tempfile.getName().endsWith(".xls")) {

				file = tempfile;
				
			} else {

				if(tempfile.exists()){
					tempfile.delete();
				}
				
				file = new File(tempfile.getAbsolutePath() + ".xls");				

			}

		}
		
		return file;
	}

}
