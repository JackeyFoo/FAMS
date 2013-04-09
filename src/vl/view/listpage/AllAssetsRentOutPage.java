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
import dal.model.RentOut;
import vl.interfaces.MyTable;
import vl.view.newpage.NewAssetPage;
import vl.view.newpage.NewRentOutPage;

public class AllAssetsRentOutPage extends MyTable {

	public AllAssetsRentOutPage(JFrame j, RentOut[] rentouts) {

		col = new String[] { "���ID", "�ʲ�ID", "���ò���", "������", "��������", "Ԥ�黹����",
				"������", "��ע", "��¼״̬", "�黹����", "�黹��Ա" };

		this.jframe = j;

		Container pane = jframe.getContentPane();

		pane.setLayout(new BorderLayout());

		mo = rentouts;
		//(ModelObject[]) ;

		initJTable(pane);

		jframe.validate();
	}

	@Override
	public void initPopMenu(JPopupMenu popupmenu, final ModelObject o) {
		// TODO Auto-generated method stub
		final Assets assets = AssetsDAO.getAsset(o.getAssetid());
		
		JMenuItem asset = new JMenuItem("�ʲ� " + o.getFormatID() + " ����");
		JMenuItem rentout = new JMenuItem("�ʲ� " + o.getFormatID() + " ����༭");
		JMenuItem returned = new JMenuItem("�ʲ� " + o.getFormatID() + " �黹");

		popupmenu.add(asset);
		popupmenu.addSeparator();
		popupmenu.add(rentout);
		popupmenu.addSeparator();
		popupmenu.add(returned);
		
		asset.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new NewAssetPage( jframe, assets ,false);
			}
			
		});
		
		rentout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new NewRentOutPage( jframe, assets, (RentOut) o, true);
			}
			
		});
	}

}
