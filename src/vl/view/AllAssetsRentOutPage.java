package vl.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import dal.dal.AssetsDAO;
import dal.dal.RentOutDAO;
import dal.interfaces.ModelObject;
import dal.model.Assets;
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
		final Assets assets = AssetsDAO.getAsset(o.getAssetid());
		
		JMenuItem asset = new JMenuItem("�ʲ� " + o.getFormatID() + " ����");
		JMenuItem returned = new JMenuItem("�ʲ� " + o.getFormatID() + " �黹");

		popupmenu.add(asset);
		popupmenu.addSeparator();
		popupmenu.add(returned);
		
		asset.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new NewAssetPage( jframe, assets ,false);
			}
			
		});
	}

}
