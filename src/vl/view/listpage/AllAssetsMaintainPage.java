package vl.view.listpage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import vl.interfaces.MyJFrame;
import vl.interfaces.MyTable;
import vl.view.newpage.NewAssetPage;
import vl.view.newpage.NewDiscardPage;
import vl.view.newpage.NewMaintainPage;
import vl.view.returnpage.MantainFinishedPage;
import dal.dal.AssetsDAO;
import dal.dal.MaintainDAO;
import dal.interfaces.ModelObject;
import dal.model.Assets;
import dal.model.Maintain;


public class AllAssetsMaintainPage extends MyTable {

	public AllAssetsMaintainPage(MyJFrame j, Maintain[] maintains) {

		col = new String[] { "ά��ID", "�ʲ�ID", "ά�޲���", "��������", "������", "�������",
				"��������", "ά�޹���", "�豸״��", "ά�޷���", "��¼״̬", "ά�����ʱ��" };

		this.jframe = j;

		mo = maintains;

		initJTable();

		jframe.validate();
	}

	public void initPopMenu(JPopupMenu popupmenu, final ModelObject o) {

		final Assets assets = AssetsDAO.getAsset(o.getAssetid());

		JMenuItem asset = new JMenuItem("�ʲ� " + o.getFormatID() + " ����");
		JMenuItem maintain = new JMenuItem("�ʲ� " + o.getFormatID() + " ά�ޱ༭");
		JMenuItem maintainhis = new JMenuItem("�ʲ� " + o.getFormatID()
				+ " ά����ʷ");
		JMenuItem maintained = new JMenuItem("�ʲ� " + o.getFormatID() + " ά�����");
		JMenuItem discard = new JMenuItem("�ʲ� " + o.getFormatID() + " ���뱨��");

		popupmenu.add(asset);
		popupmenu.addSeparator();
		popupmenu.add(maintain);
		popupmenu.addSeparator();
		popupmenu.add(maintainhis);
		popupmenu.addSeparator();
		popupmenu.add(maintained);
		popupmenu.add(discard);
		
		asset.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new NewAssetPage( jframe, assets ,false);
			}
			
		});
		
		discard.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new NewDiscardPage(jframe, assets, null, true);
			}
			
		});
		
		maintain.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new NewMaintainPage(jframe, assets, (Maintain) o, true);
			}
			
		});
		
		maintainhis.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new AllAssetsMaintainPage(jframe, MaintainDAO
						.getMaintainHistory(assets.getAssetid()));
			}

		});
		
		maintained.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new MantainFinishedPage(jframe, assets, (Maintain) o);
			}
			
		}); 
		
	}
}
