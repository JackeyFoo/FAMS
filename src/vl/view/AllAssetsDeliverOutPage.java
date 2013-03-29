package vl.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import vl.interfaces.MyTable;
import dal.dal.AssetsDAO;
import dal.dal.DeliverOutDAO;
import dal.interfaces.ModelObject;
import dal.model.Assets;

public class AllAssetsDeliverOutPage extends MyTable{

	public AllAssetsDeliverOutPage(JFrame j) {
		
		col = new String[] { "����ID", "�ʲ�ID", "���ò���", "������",
				"��������", "���ڵ�ַ", "��ע", "��¼״̬", "�黹����", "�黹��Ա"};
		
		this.jframe = j;

		Container pane = jframe.getContentPane();

		pane.setLayout(new BorderLayout());

		mo = (ModelObject[]) DeliverOutDAO.getAllDeliverOut();

		initJTable(pane);

		jframe.validate();
	}



	public void initPopMenu(JPopupMenu popupmenu, final ModelObject o) {
		
		final Assets assets = AssetsDAO.getAsset(o.getAssetid());

		JMenuItem asset = new JMenuItem("�ʲ� " + o.getFormatID() + " ����");
		JMenuItem transfer = new JMenuItem("�ʲ� " + o.getFormatID() + " ת��");
		JMenuItem returned = new JMenuItem("�ʲ� " + o.getFormatID() + " �黹");
		JMenuItem maintain = new JMenuItem("�ʲ� " + o.getFormatID() + " ����ά��");
		JMenuItem discard = new JMenuItem("�ʲ� " + o.getFormatID() + " ���뱨��");
		

		popupmenu.add(asset);
		popupmenu.addSeparator();
		popupmenu.add(transfer);
		popupmenu.add(returned);
		popupmenu.addSeparator();
		popupmenu.add(maintain);
		popupmenu.add(discard);

		
		
		transfer.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new NewTransferPage(jframe, assets);
			}
			
		});
		
		maintain.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new NewMaintainPage(jframe, assets);
			}
			
		});

	}
}
