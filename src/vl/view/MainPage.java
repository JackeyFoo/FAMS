package vl.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import util.Utility;
import vl.component.Jmenubar;
import vl.interfaces.MyJFrame;
import vl.view.terminalpage.TerminalPage;

public class MainPage extends MyJFrame {

	/**
	 * 
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

			initSplitPane();

			Utility.initDataDir();

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

	private void initMenuBar() {

		menubar = new Jmenubar();

		menubar.setJmenu(this, "资产操作", new String[] { "添加资产", "全部资产管理", "库存管理",
				"出库管理", "借出管理", "转移管理", "维修管理", "报废管理" }, new int[] { 1, 2 },
				"menuitem");

		// menubar.setJmenu(this, "资产搜索", new String[] { "资产ID搜索", "高级搜索" },
		// null,
		// "menuitem");

		// menubar.setJmenu(this, "资产统计", new String[] { "资产统计分析" }, null,
		// "menuitem");

		// menubar.setJmenu(this, "数据操作", new String[] { "资产数据导入", "资产数据导出" },
		// null, "menuitem");

		// menubar.setJmenu(this, "系统", new String[] { "系统设置", "启动服务器"},
		// null, "menuitem");
		menubar.setJmenu(this, "资产搜索", new String[] { "资产ID搜索" }, null,
				"menuitem");

		menubar.setJmenu(this, "数据操作", new String[] { "资产数据导出" }, null,
				"menuitem");

		menubar.setJmenu(this, "系统", new String[] { "启动服务器" }, null, "menuitem");

		menubar.setJmenu(this, "窗口", new String[] { "终端管理窗口" }, null,
				"checkboxitem");

		// menubar.setJmenu(this, "帮助", new String[] { "关于我们" }, null,
		// "menuitem");

		MainPage.this.setJMenuBar(menubar);

	}

	private void initSplitPane() {

		Container pane = this.getContentPane();

		pane.setLayout(new BorderLayout());

		splitpane = new JSplitPane();

		pane.add(splitpane);

		splitpane.setResizeWeight(0.8);

		splitpane.setLeftComponent(null);
		splitpane.setRightComponent(null);

		initTerminalPage();
	}

	private void initTerminalPage() {

		terminalpane = new TerminalPage("终端管理", new ImageIcon(
				".\\src\\img\\terminal.png"));

	}

}
