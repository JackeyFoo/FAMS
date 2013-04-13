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
import vl.view.newpage.NewTransferPage;
import vl.view.returnpage.NewReturnPage;
import dal.dal.AssetsDAO;
import dal.interfaces.ModelObject;
import dal.model.Assets;
import dal.model.Transfer;;

public class AllAssetsTransferPage extends MyTable{

	public AllAssetsTransferPage(MyJFrame j, Transfer[] transfers) {
		
		col = new String[] { "转移ID", "资产ID", "转移部门", "转移日期",
				"经办人", "备注", "转移情况", "记录状态"};
		
		this.jframe = j;

		mo = transfers;

		initJTable();

		jframe.validate();
	}



	public void initPopMenu(JPopupMenu popupmenu, final ModelObject o) {
		
		final Assets assets = AssetsDAO.getAsset(o.getAssetid());

		JMenuItem asset = new JMenuItem("资产 " + o.getFormatID() + " 详情");
		JMenuItem transferedit = new JMenuItem("资产 " + o.getFormatID() + " 转移编辑");
		JMenuItem transfer = new JMenuItem("资产 " + o.getFormatID() + " 转移");
		JMenuItem returned = new JMenuItem("资产 " + o.getFormatID() + " 归还");
		JMenuItem maintain = new JMenuItem("资产 " + o.getFormatID() + " 申请维修");
		JMenuItem discard = new JMenuItem("资产 " + o.getFormatID() + " 申请报废");
		

		popupmenu.add(asset);
		popupmenu.addSeparator();
		popupmenu.add(transferedit);
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
		

		transferedit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new NewTransferPage(jframe, assets, (Transfer) o, true);
			}
			
		});

		returned.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new NewReturnPage(jframe, assets, null);
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
