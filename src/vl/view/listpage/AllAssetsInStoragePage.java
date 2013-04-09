package vl.view.listpage;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import dal.dal.AssetsDAO;
import dal.interfaces.ModelObject;
import dal.model.Assets;
import vl.interfaces.MyTable;
import vl.view.newpage.NewAssetPage;
import vl.view.newpage.NewDeliverOutPage;
import vl.view.newpage.NewRentOutPage;


public class AllAssetsInStoragePage extends MyTable{
	

	public AllAssetsInStoragePage(JFrame j) {
		
		col = new String[] { "�ʲ�ID", "�ʲ�����", "�ʲ�����", "�ʲ�Ʒ��",
				"�ʲ��ͺ�", "�ʲ�����", "�ʲ���������", "�ʲ�������", "�ʲ�������", "�ʲ����״̬", "�ʲ�����״̬" };
		
		this.jframe = j;

		Container pane = jframe.getContentPane();

		pane.setLayout(new BorderLayout());

		mo = (ModelObject[]) AssetsDAO.getAllInStorage();

		initJTable(pane);

		jframe.validate();
	}



	
	public void initPopMenu(JPopupMenu popupmenu, final ModelObject o) {
		
		final Assets assets = AssetsDAO.getAsset(o.getAssetid());

		JMenuItem asset = new JMenuItem("�ʲ� " + o.getFormatID() + " ����");
		JMenuItem deliverout = new JMenuItem("�ʲ� " + o.getFormatID() + " ����");
		JMenuItem rentout = new JMenuItem("�ʲ� " + o.getFormatID() + " ���");

		popupmenu.add(asset);
		popupmenu.addSeparator();
		popupmenu.add(deliverout);
		popupmenu.addSeparator();
		popupmenu.add(rentout);
		
		
		asset.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new NewAssetPage( jframe, assets ,false);
			}
			
		});
		
		
		deliverout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new NewDeliverOutPage(jframe, assets, null, true);
			}
			
		});
		
		rentout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new NewRentOutPage(jframe, assets, null, true);
			}
			
		});

	}

}