package vl.view;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import dal.dal.RentOutDAO;
import dal.interfaces.ModelObject;
import vl.interfaces.MyTable;

public class AllAssetsRentOutPage extends MyTable {

	public AllAssetsRentOutPage(JFrame j) {

		col = new String[] { "���ID", "�ʲ�ID", "���ò���", "������", "��������", "Ԥ�黹����",
				"������", "��ע", "��¼״̬", "�黹����", "�黹��Ա" };

		this.jframe = j;

		Container pane = jframe.getContentPane();

		pane.setLayout(new BorderLayout());

		mo = (ModelObject[]) RentOutDAO.getAllRentOut();

		initJTable(pane);

		jframe.validate();
	}

	@Override
	public void initPopMenu(JPopupMenu popupmenu, ModelObject o) {
		// TODO Auto-generated method stub
		JMenuItem asset = new JMenuItem("�ʲ� " + o.getFormatID() + " ����");
		JMenuItem returned = new JMenuItem("�ʲ� " + o.getFormatID() + " �黹");

		popupmenu.add(asset);
		popupmenu.addSeparator();
		popupmenu.add(returned);
	}

}
