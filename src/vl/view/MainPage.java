package vl.view;

import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import util.Utility;
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

	public void initMenuBar() {

		menubar = new Jmenubar();

		menubar.setJmenu(this, "�ʲ�����", new String[] { "����ʲ�", "ȫ���ʲ�����", "������", "�������",
				"�������", "ת�ƹ���", "ά�޹���", "���Ϲ���" }, new int[] { 1 , 2}, "menuitem");

		menubar.setJmenu(this, "�ʲ�����", new String[] { "�ʲ�ID����", "�߼�����" }, null,
				"menuitem");

		menubar.setJmenu(this, "�ʲ�ͳ��", new String[] { "�ʲ�ͳ�Ʒ���" }, null,
				"menuitem");

		menubar.setJmenu(this, "���ݲ���", new String[] { "�ʲ����ݵ���", "�ʲ����ݵ���" },
				null, "menuitem");

		menubar.setJmenu(this, "ϵͳ����", new String[] { "ϵͳ����"},
				null, "menuitem");

		menubar.setJmenu(this, "����", new String[] { "�ն˹�����" }, null,
				"checkboxitem");

		menubar.setJmenu(this, "����", new String[] { "��������" }, null, "menuitem");

		MainPage.this.setJMenuBar(menubar);

	}
}
