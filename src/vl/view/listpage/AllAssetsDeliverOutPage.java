package vl.view.listpage;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import vl.interfaces.MyTable;
import vl.view.newpage.NewAssetPage;
import vl.view.newpage.NewDeliverOutPage;
import vl.view.newpage.NewDiscardPage;
import vl.view.newpage.NewMaintainPage;
import vl.view.newpage.NewTransferPage;
import dal.dal.AssetsDAO;
import dal.interfaces.ModelObject;
import dal.model.Assets;
import dal.model.DeliverOut;

public class AllAssetsDeliverOutPage extends MyTable{

	public AllAssetsDeliverOutPage(JFrame j, DeliverOut[] deliverouts) {
		
		col = new String[] { "����ID", "�ʲ�ID", "���ò���", "������",
				"��������", "���ڵ�ַ", "��ע", "��¼״̬", "�黹����", "�黹��Ա"};
		
		this.jframe = j;

		Container pane = jframe.getContentPane();

		pane.setLayout(new BorderLayout());

		mo = deliverouts;

		initJTable(pane);

		jframe.validate();
	}



	public void initPopMenu(JPopupMenu popupmenu, final ModelObject o) {
		
		final Assets assets = AssetsDAO.getAsset(o.getAssetid());

		JMenuItem asset = new JMenuItem("�ʲ� " + o.getFormatID() + " ����");
		JMenuItem deliverout = new JMenuItem("�ʲ� " + o.getFormatID() + " ����༭");
		JMenuItem transfer = new JMenuItem("�ʲ� " + o.getFormatID() + " ת��");
		JMenuItem returned = new JMenuItem("�ʲ� " + o.getFormatID() + " �黹");
		JMenuItem maintain = new JMenuItem("�ʲ� " + o.getFormatID() + " ����ά��");
		JMenuItem discard = new JMenuItem("�ʲ� " + o.getFormatID() + " ���뱨��");
		

		popupmenu.add(asset);
		popupmenu.addSeparator();
		popupmenu.add(deliverout);
		popupmenu.addSeparator();
		popupmenu.add(transfer);
		popupmenu.addSeparator();
		popupmenu.add(returned);
		popupmenu.addSeparator();
		popupmenu.add(maintain);
		popupmenu.addSeparator();
		popupmenu.add(discard);

		

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
				new NewDeliverOutPage( jframe, assets, (DeliverOut) o, true);
			}
			
		});		

		
		transfer.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new NewTransferPage(jframe, assets, null, true);
			}
			
		});
		
		maintain.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new NewMaintainPage(jframe, assets, null, true);
			}
			
		});
		
		discard.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new NewDiscardPage(jframe, assets, null, true);
			}
			
		});

	}
}