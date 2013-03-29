package vl.view;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import vl.interfaces.MyTable;
import dal.dal.TransferDAO;
import dal.interfaces.ModelObject;

public class AllAssetsTransferPage extends MyTable{

	public AllAssetsTransferPage(JFrame j) {
		
		col = new String[] { "ת��ID", "�ʲ�ID", "ת�Ʋ���", "ת������",
				"������", "��ע", "ת�����", "��¼״̬"};
		
		this.jframe = j;

		Container pane = jframe.getContentPane();

		pane.setLayout(new BorderLayout());

		mo = (ModelObject[]) TransferDAO.getAllTransfer();

		initJTable(pane);

		jframe.validate();
	}



	public void initPopMenu(JPopupMenu popupmenu, final ModelObject o) {

		JMenuItem asset = new JMenuItem("�ʲ� " + o.getFormatID() + " ����");
		JMenuItem maintain = new JMenuItem("�ʲ� " + o.getFormatID() + " ����ά��");
		JMenuItem discard = new JMenuItem("�ʲ� " + o.getFormatID() + " ���뱨��");
		JMenuItem returned = new JMenuItem("�ʲ� " + o.getFormatID() + " �黹");

		popupmenu.add(asset);
		popupmenu.addSeparator();
		popupmenu.add(maintain);
		popupmenu.addSeparator();
		popupmenu.add(discard);
		popupmenu.addSeparator();
		popupmenu.add(returned);
		

	}
}
