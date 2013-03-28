package vl.view;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import vl.interfaces.MyTable;
import dal.dal.DeliverOutDAO;
import dal.interfaces.ModelObject;

public class AllAssetsDeliverOutPage extends MyTable{

	public AllAssetsDeliverOutPage(JFrame j) {
		
		col = new String[] { "����ID", "�ʲ�ID", "���ò���", "������",
				"��������", "���ڵ�ַ", "��ע", "��¼״̬"};
		
		this.jframe = j;

		Container pane = jframe.getContentPane();

		pane.setLayout(new BorderLayout());

		mo = (ModelObject[]) DeliverOutDAO.getAllDeliverOut();

		initJTable(pane);

		jframe.validate();
	}



	public void initPopMenu(JPopupMenu popupmenu, final ModelObject o) {

		JMenuItem asset = new JMenuItem("�ʲ� " + o.getFormatID() + " ����");
		JMenuItem transfer = new JMenuItem("�ʲ� " + o.getFormatID() + " ת��");
		JMenuItem maintain = new JMenuItem("�ʲ� " + o.getFormatID() + " ����ά��");
		JMenuItem discard = new JMenuItem("�ʲ� " + o.getFormatID() + " ���뱨��");

		popupmenu.add(asset);
		popupmenu.addSeparator();
		popupmenu.add(transfer);
		popupmenu.addSeparator();
		popupmenu.add(maintain);
		popupmenu.addSeparator();
		popupmenu.add(discard);
		

	}
}
