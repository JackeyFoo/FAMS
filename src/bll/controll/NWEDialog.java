package bll.controll;

import javax.swing.JOptionPane;


public class NWEDialog {

	public static void necessaryDataError(){		
		JOptionPane.showMessageDialog(null, "请填写必要的数据!", "ERROR",
				JOptionPane.ERROR_MESSAGE);	
	}
	
	public static void dataSaveSuccess(){		
		JOptionPane.showMessageDialog(null, "数据保存成功!", "SUCCESS",
				JOptionPane.INFORMATION_MESSAGE);
			
	}
	
	public static void dataSaveFailed(){		
		JOptionPane.showMessageDialog(null, "数据保存失败!", "FAILED",
				JOptionPane.ERROR_MESSAGE);
	}
	
	public static void dataUpdateSuccess(){
		JOptionPane.showMessageDialog(null, "数据更新成功!", "SUCCESS",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void dataUpdateFailed(){
		JOptionPane.showMessageDialog(null, "数据更新失败!", "FAILED",
				JOptionPane.ERROR_MESSAGE);
	}
	
	public static void searchWarning(){
		JOptionPane.showMessageDialog(null, "未找到所查询的数据!", "FAILED",
				JOptionPane.WARNING_MESSAGE);
	}
	
	public static void inputError(){		
		JOptionPane.showMessageDialog(null, "请输入正确数据!", "ERROR",
				JOptionPane.ERROR_MESSAGE);	
	}
	
	public static void exportSuccess(){		
		JOptionPane.showMessageDialog(null, "数据导出成功!", "ERROR",
				JOptionPane.INFORMATION_MESSAGE);	
	}
	
	public static void exportFailed(){		
		JOptionPane.showMessageDialog(null, "数据导出失败,文件不存在或正被使用!", "ERROR",
				JOptionPane.ERROR_MESSAGE);	
	}	
	
	public static void fileNotFound(){		
		JOptionPane.showMessageDialog(null, "文件不存在!", "ERROR",
				JOptionPane.ERROR_MESSAGE);	
	}
	
	public static void dataNotFound(){		
		JOptionPane.showMessageDialog(null, "数据不存在!", "ERROR",
				JOptionPane.ERROR_MESSAGE);	
	}
}
