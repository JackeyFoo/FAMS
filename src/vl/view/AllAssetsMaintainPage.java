package vl.view;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import vl.interfaces.MyTable;
import dal.dal.MaintainDAO;
import dal.interfaces.ModelObject;


public class AllAssetsMaintainPage extends MyTable {

	public AllAssetsMaintainPage(JFrame j) {

		col = new String[] { "ά��ID", "�ʲ�ID", "ά�޲���", "��������", "������", "�������",
				"��������", "ά�޹���", "�豸״��", "ά�޷���", "��¼״̬" };

		this.jframe = j;

		Container pane = jframe.getContentPane();

		pane.setLayout(new BorderLayout());

		mo = (ModelObject[]) MaintainDAO.getAllMaintain();

		initJTable(pane);

		jframe.validate();
	}

	public void initPopMenu(JPopupMenu popupmenu, final ModelObject o) {

		//final Assets assets = AssetsDAO.getAsset(o.getAssetid());

		JMenuItem asset = new JMenuItem("�ʲ� " + o.getFormatID() + " ����");
		JMenuItem maintain = new JMenuItem("�ʲ� " + o.getFormatID() + " ά�����");
		JMenuItem discard = new JMenuItem("�ʲ� " + o.getFormatID() + " ���뱨��");

		popupmenu.add(asset);
		popupmenu.addSeparator();
		popupmenu.add(maintain);
		popupmenu.add(discard);
	}
}
