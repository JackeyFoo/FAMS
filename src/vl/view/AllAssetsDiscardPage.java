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
import dal.dal.DiscardDAO;
import dal.interfaces.ModelObject;
import dal.model.Assets;
import dal.model.Discard;

public class AllAssetsDiscardPage extends MyTable{

	public AllAssetsDiscardPage(JFrame j) {
		
		col = new String[] { "报废ID", "资产ID", "报废部门", "报废时间",
				"报废原因"};
		
		this.jframe = j;

		Container pane = jframe.getContentPane();

		pane.setLayout(new BorderLayout());

		mo = (ModelObject[]) DiscardDAO.getAllDiscard();

		initJTable(pane);

		jframe.validate();
	}

	@Override
	public void initPopMenu(JPopupMenu popupmenu, final ModelObject o) {
		// TODO Auto-generated method stub
		final Assets assets = AssetsDAO.getAsset(o.getAssetid());
		
		JMenuItem asset = new JMenuItem("资产 " + o.getFormatID() + " 详情");
		JMenuItem discard = new JMenuItem("资产 " + o.getFormatID() + " 报废详情");

		popupmenu.add(asset);
		popupmenu.addSeparator();
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
				new NewDiscardPage(jframe, assets, (Discard) o, false);
			}
			
		});
	}
	


}
