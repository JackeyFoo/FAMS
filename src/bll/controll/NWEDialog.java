package bll.controll;

import javax.swing.JOptionPane;


public class NWEDialog {

	public static void necessaryDataError(){
		
		JOptionPane.showMessageDialog(null, "����д��Ҫ������", "ERROR",
				JOptionPane.ERROR_MESSAGE);
		
	}
	
	public static void dataSaveSuccess(){
		
		JOptionPane.showMessageDialog(null, "���ݱ���ɹ�", "SUCCESS",
				JOptionPane.INFORMATION_MESSAGE);
			
	}
	
	public static void dataSaveFailed(){
		
		JOptionPane.showMessageDialog(null, "���ݱ���ʧ��", "FAILED",
				JOptionPane.ERROR_MESSAGE);
	}
	
	public static void dataUpdateSuccess(){
		JOptionPane.showMessageDialog(null, "���ݸ��³ɹ�", "SUCCESS",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void dataUpdateFailed(){
		JOptionPane.showMessageDialog(null, "���ݸ���ʧ��", "FAILED",
				JOptionPane.ERROR_MESSAGE);
	}
	
	public static void searchWarning(){
		JOptionPane.showMessageDialog(null, "δ�ҵ�����ѯ������", "FAILED",
				JOptionPane.WARNING_MESSAGE);
	}
}
