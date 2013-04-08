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
import dal.interfaces.ModelObject;
import dal.model.Assets;

public class AllAssetsPage  extends MyTable{

	public AllAssetsPage(JFrame j) {
		
		col = new String[] { "�ʲ�ID", "�ʲ�����", "�ʲ�����", "�ʲ�Ʒ��",
				"�ʲ��ͺ�", "�ʲ�����", "�ʲ���������", "�ʲ�������", "�ʲ�������", "�ʲ����״̬", "�ʲ�����״̬" };
		
		this.jframe = j;

		Container pane = jframe.getContentPane();

		pane.setLayout(new BorderLayout());

		mo = (ModelObject[]) AssetsDAO.getAll();

		initJTable(pane);

		jframe.validate();
	}

	public AllAssetsPage(JFrame j,int id) {
		
		col = new String[] { "�ʲ�ID", "�ʲ�����", "�ʲ�����", "�ʲ�Ʒ��",
				"�ʲ��ͺ�", "�ʲ�����", "�ʲ���������", "�ʲ�������", "�ʲ�������", "�ʲ����״̬", "�ʲ�����״̬" };
		
		this.jframe = j;

		Container pane = jframe.getContentPane();

		pane.setLayout(new BorderLayout());

		mo = (ModelObject[]) new Assets []{AssetsDAO.getAsset( id)};

		initJTable(pane);

		jframe.validate();
	}


	public void initPopMenu(JPopupMenu popupmenu, final ModelObject o) {

		JMenuItem asset = new JMenuItem("�ʲ� " + o.getFormatID() + " �༭");
		
		final Assets assets = AssetsDAO.getAsset(o.getAssetid());

		popupmenu.add(asset);
		
		asset.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			 new NewAssetPage( jframe, assets ,true);
				
			}
			
		});

	}
}
