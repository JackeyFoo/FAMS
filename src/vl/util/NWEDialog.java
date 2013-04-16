package vl.util;

import javax.swing.JOptionPane;

import vl.interfaces.MyDialog;
import vl.interfaces.MyJFrame;
import vl.main.Main;

public class NWEDialog {
	
	public static void serverStartSuccess(MyJFrame jframe) {
		JOptionPane.showMessageDialog(Main.mainpage, "�����������ɹ�!", "SUCCESS",
				JOptionPane.INFORMATION_MESSAGE);

	}
	
	public static void notImageError(MyDialog dialog) {
		JOptionPane.showMessageDialog(dialog, "����ȷ����ͼƬ!", "ERROR",
				JOptionPane.ERROR_MESSAGE);
	}
	

	public static void necessaryDataError(MyDialog dialog) {
		JOptionPane.showMessageDialog(dialog, "����д��Ҫ������!", "ERROR",
				JOptionPane.ERROR_MESSAGE);
	}

	public static void dataSaveSuccess(MyDialog dialog) {
		JOptionPane.showMessageDialog(dialog, "���ݱ���ɹ�!", "SUCCESS",
				JOptionPane.INFORMATION_MESSAGE);

	}

	public static void dataSaveFailed(MyDialog dialog) {
		JOptionPane.showMessageDialog(dialog, "���ݱ���ʧ��!", "FAILED",
				JOptionPane.ERROR_MESSAGE);
	}

	public static void dataUpdateSuccess(MyDialog dialog) {
		JOptionPane.showMessageDialog(dialog, "���ݸ��³ɹ�!", "SUCCESS",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static void dataUpdateFailed(MyDialog dialog) {
		JOptionPane.showMessageDialog(dialog, "���ݸ���ʧ��!", "FAILED",
				JOptionPane.ERROR_MESSAGE);
	}

	public static void searchWarning(MyJFrame jframe) {
		JOptionPane.showMessageDialog(jframe, "δ�ҵ�����ѯ������!", "FAILED",
				JOptionPane.WARNING_MESSAGE);
	}

	public static void inputError(MyDialog dialog) {
		JOptionPane.showMessageDialog(dialog, "��������ȷ����!", "ERROR",
				JOptionPane.ERROR_MESSAGE);
	}

	public static void exportSuccess(MyJFrame jframe) {
		JOptionPane.showMessageDialog(jframe, "���ݵ����ɹ�!", "ERROR",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static void exportFailed() {
		JOptionPane.showMessageDialog(Main.mainpage, "���ݵ���ʧ��,�ļ������ڻ�����ʹ��!",
				"ERROR", JOptionPane.ERROR_MESSAGE);
	}

	public static void fileNotFound(MyJFrame jframe) {
		JOptionPane.showMessageDialog(jframe, "�ļ�������!", "ERROR",
				JOptionPane.ERROR_MESSAGE);
	}

	public static void dataNotFound(MyJFrame jframe) {
		JOptionPane.showMessageDialog(jframe, "���ݲ�����!", "ERROR",
				JOptionPane.ERROR_MESSAGE);
	}

	public static void noDataFound(MyJFrame jframe) {
		JOptionPane.showMessageDialog(jframe, "���ݲ�����, ����µ�����!", "ERROR",
				JOptionPane.ERROR_MESSAGE);
	}

	public static boolean showScan(String id) {

		int result = JOptionPane.showConfirmDialog(Main.mainpage,
				"�Ƿ�չʾ�ͻ���ɨ������", "QUESTION", JOptionPane.YES_NO_OPTION);

		if (result == JOptionPane.YES_OPTION) {
			return true;
		} else {
			return false;
		}

	}

	public static void returnSuccess(MyDialog dialog) {

		JOptionPane.showMessageDialog(dialog, "�ʲ��黹�ɹ�!", "SUCCESS",
				JOptionPane.INFORMATION_MESSAGE);

	}

	public static void returnFailed(MyDialog dialog) {
		JOptionPane.showMessageDialog(dialog, "�ʲ��黹ʧ��!", "ERROR",
				JOptionPane.ERROR_MESSAGE);
	}
	
}
