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
		
		col = new String[] { "出库ID", "资产ID", "领用部门", "领用人",
				"领用日期", "存在地址", "备注", "记录状态", "归还日期", "归还人员"};
		
		this.jframe = j;

		Container pane = jframe.getContentPane();

		pane.setLayout(new BorderLayout());

		mo = (ModelObject[]) DeliverOutDAO.getAllDeliverOut();

		initJTable(pane);

		jframe.validate();
	}



	public void initPopMenu(JPopupMenu popupmenu, final ModelObject o) {
		
		final Assets assets = AssetsDAO.getAsset(o.getAssetid());

		JMenuItem asset = new JMenuItem("资产 " + o.getFormatID() + " 详情");
		JMenuItem transfer = new JMenuItem("资产 " + o.getFormatID() + " 转移");
		JMenuItem returned = new JMenuItem("资产 " + o.getFormatID() + " 归还");
		JMenuItem maintain = new JMenuItem("资产 " + o.getFormatID() + " 申请维修");
		JMenuItem discard = new JMenuItem("资产 " + o.getFormatID() + " 申请报废");
		

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
