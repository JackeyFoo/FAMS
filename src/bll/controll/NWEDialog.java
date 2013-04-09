package bll.controll;

import javax.swing.JOptionPane;


public class NWEDialog {

	public static void necessaryDataError(){
		
		JOptionPane.showMessageDialog(null, "请填写必要的数据", "ERROR",
				JOptionPane.ERROR_MESSAGE);
		
	}
	
	public static void dataSaveSuccess(){
		
		JOptionPane.showMessageDialog(null, "数据保存成功", "SUCCESS",
				JOptionPane.INFORMATION_MESSAGE);
			
	}
	
	public static void dataSaveFailed(){
		
		JOptionPane.showMessageDialog(null, "数据保存失败", "FAILED",
				JOptionPane.ERROR_MESSAGE);
	}
	
	public static void dataUpdateSuccess(){
		JOptionPane.showMessageDialog(null, "数据更新成功", "SUCCESS",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void dataUpdateFailed(){
		JOptionPane.showMessageDialog(null, "数据更新失败", "FAILED",
				JOptionPane.ERROR_MESSAGE);
	}
	
	public static void searchWarning(){
		JOptionPane.showMessageDialog(null, "未找到所查询的数据", "FAILED",
				JOptionPane.WARNING_MESSAGE);
	}
}
