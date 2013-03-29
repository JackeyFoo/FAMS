package vl.view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import vl.interfaces.MyTable;
import dal.dal.DiscardDAO;
import dal.interfaces.ModelObject;

public class AllAssetsDiscardPage extends MyTable{

	public AllAssetsDiscardPage(JFrame j) {
		
		col = new String[] { "����ID", "�ʲ�ID", "���ϲ���", "����ʱ��",
				"����ԭ��"};
		
		this.jframe = j;

		Container pane = jframe.getContentPane();

		pane.setLayout(new BorderLayout());

		mo = (ModelObject[]) DiscardDAO.getAllDiscard();

		initJTable(pane);

		jframe.validate();
	}

	@Override
	public void initPopMenu(JPopupMenu popupmenu, ModelObject o) {
		// TODO Auto-generated method stub

		JMenuItem asset = new JMenuItem("�ʲ� " + o.getFormatID() + " ����");

		popupmenu.add(asset);
	}

}
