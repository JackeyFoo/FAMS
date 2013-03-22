package vl.view;

import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import vl.component.Jmenubar;


public class MainPage extends JFrame {

	private Jmenubar menubar;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainPage(int x, int y, int width, int height) {
		try {

			// set current system style
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);

			// set main page
			/* set the logo of main page */
			setIconImage(Toolkit.getDefaultToolkit().getImage(
					".\\src\\img\\cmmicon.png"));
			setTitle("FAMS");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(x, y, width, height);
			setVisible(true);

			initMenuBar();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void initMenuBar() {

		menubar = new Jmenubar();

		menubar.setJmenu("资产操作", new String[] { "添加资产", "出库管理", "借出管理", "转移管理",
				"维修管理", "报废管理" }, new int[] { 1 }, "menuitem");

		menubar.setJmenu("资产搜索", new String[] { "资产ID搜索", "高级搜索" }, null,
				"menuitem");

		menubar.setJmenu("资产统计", new String[] { "资产统计分析" }, null, "menuitem");

		menubar.setJmenu("数据操作", new String[] { "资产数据导入", "资产数据导出" }, null,
				"menuitem");

		menubar.setJmenu("系统设置", new String[] { "资产数据导入", "资产数据导出" }, null,
				"menuitem");

		menubar.setJmenu("窗口", new String[] { "终端管理窗口" }, null, "checkboxitem");

		menubar.setJmenu("帮助", new String[] { "关于我们" }, null, "menuitem");

		MainPage.this.setJMenuBar(menubar);

	}
}
