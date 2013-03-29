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
import dal.dal.MaintainDAO;
import dal.interfaces.ModelObject;
import dal.model.Assets;


public class AllAssetsMaintainPage extends MyTable {

	public AllAssetsMaintainPage(JFrame j) {

		col = new String[] { "维修ID", "资产ID", "维修部门", "故障日期", "经办人", "故障情况",
				"故障现象", "维修过程", "设备状况", "维修费用", "记录状态" };

		this.jframe = j;

		Container pane = jframe.getContentPane();

		pane.setLayout(new BorderLayout());

		mo = (ModelObject[]) MaintainDAO.getAllMaintain();

		initJTable(pane);

		jframe.validate();
	}

	public void initPopMenu(JPopupMenu popupmenu, final ModelObject o) {

		final Assets assets = AssetsDAO.getAsset(o.getAssetid());

		JMenuItem asset = new JMenuItem("资产 " + o.getFormatID() + " 详情");
		JMenuItem maintain = new JMenuItem("资产 " + o.getFormatID() + " 维修完毕");
		JMenuItem discard = new JMenuItem("资产 " + o.getFormatID() + " 申请报废");

		popupmenu.add(asset);
		popupmenu.addSeparator();
		popupmenu.add(maintain);
		popupmenu.add(discard);
		
		discard.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new NewDiscardPage(jframe, assets);
			}
			
		});
	}
}
