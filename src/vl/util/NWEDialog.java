package vl.util;

import javax.swing.JOptionPane;

import vl.interfaces.MyDialog;
import vl.interfaces.MyJFrame;
import vl.main.Main;

public class NWEDialog {
	
	public static void serverStartSuccess(MyJFrame jframe) {
		JOptionPane.showMessageDialog(Main.mainpage, "服务器启动成功!", "SUCCESS",
				JOptionPane.INFORMATION_MESSAGE);

	}
	
	public static void notImageError(MyDialog dialog) {
		JOptionPane.showMessageDialog(dialog, "请正确的数图片!", "ERROR",
				JOptionPane.ERROR_MESSAGE);
	}
	

	public static void necessaryDataError(MyDialog dialog) {
		JOptionPane.showMessageDialog(dialog, "请填写必要的数据!", "ERROR",
				JOptionPane.ERROR_MESSAGE);
	}

	public static void dataSaveSuccess(MyDialog dialog) {
		JOptionPane.showMessageDialog(dialog, "数据保存成功!", "SUCCESS",
				JOptionPane.INFORMATION_MESSAGE);

	}

	public static void dataSaveFailed(MyDialog dialog) {
		JOptionPane.showMessageDialog(dialog, "数据保存失败!", "FAILED",
				JOptionPane.ERROR_MESSAGE);
	}

	public static void dataUpdateSuccess(MyDialog dialog) {
		JOptionPane.showMessageDialog(dialog, "数据更新成功!", "SUCCESS",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static void dataUpdateFailed(MyDialog dialog) {
		JOptionPane.showMessageDialog(dialog, "数据更新失败!", "FAILED",
				JOptionPane.ERROR_MESSAGE);
	}

	public static void searchWarning(MyJFrame jframe) {
		JOptionPane.showMessageDialog(jframe, "未找到所查询的数据!", "FAILED",
				JOptionPane.WARNING_MESSAGE);
	}

	public static void inputError(MyDialog dialog) {
		JOptionPane.showMessageDialog(dialog, "请输入正确数据!", "ERROR",
				JOptionPane.ERROR_MESSAGE);
	}

	public static void exportSuccess(MyJFrame jframe) {
		JOptionPane.showMessageDialog(jframe, "数据导出成功!", "ERROR",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static void exportFailed() {
		JOptionPane.showMessageDialog(Main.mainpage, "数据导出失败,文件不存在或正被使用!",
				"ERROR", JOptionPane.ERROR_MESSAGE);
	}

	public static void fileNotFound(MyJFrame jframe) {
		JOptionPane.showMessageDialog(jframe, "文件不存在!", "ERROR",
				JOptionPane.ERROR_MESSAGE);
	}

	public static void dataNotFound(MyJFrame jframe) {
		JOptionPane.showMessageDialog(jframe, "数据不存在!", "ERROR",
				JOptionPane.ERROR_MESSAGE);
	}

	public static void noDataFound(MyJFrame jframe) {
		JOptionPane.showMessageDialog(jframe, "数据不存在, 添加新的数据!", "ERROR",
				JOptionPane.ERROR_MESSAGE);
	}

	public static boolean showScan(String id) {

		int result = JOptionPane.showConfirmDialog(Main.mainpage,
				"是否展示客户端扫描结果？", "QUESTION", JOptionPane.YES_NO_OPTION);

		if (result == JOptionPane.YES_OPTION) {
			return true;
		} else {
			return false;
		}

	}

	public static void returnSuccess(MyDialog dialog) {

		JOptionPane.showMessageDialog(dialog, "资产归还成功!", "SUCCESS",
				JOptionPane.INFORMATION_MESSAGE);

	}

	public static void returnFailed(MyDialog dialog) {
		JOptionPane.showMessageDialog(dialog, "资产归还失败!", "ERROR",
				JOptionPane.ERROR_MESSAGE);
	}
	
}
