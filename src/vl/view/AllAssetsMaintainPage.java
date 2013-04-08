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
import dal.model.Maintain;


public class AllAssetsMaintainPage extends MyTable {

	public AllAssetsMaintainPage(JFrame j, Maintain[] maintains) {

		col = new String[] { "维修ID", "资产ID", "维修部门", "故障日期", "经办人", "故障情况",
				"故障现象", "维修过程", "设备状况", "维修费用", "记录状态" };

		this.jframe = j;

		Container pane = jframe.getContentPane();

		pane.setLayout(new BorderLayout());

		mo = maintains;

		initJTable(pane);

		jframe.validate();
	}

	public void initPopMenu(JPopupMenu popupmenu, final ModelObject o) {

		final Assets assets = AssetsDAO.getAsset(o.getAssetid());

		JMenuItem asset = new JMenuItem("资产 " + o.getFormatID() + " 详情");
		JMenuItem maintain = new JMenuItem("资产 " + o.getFormatID() + " 维修编辑");
		JMenuItem maintained = new JMenuItem("资产 " + o.getFormatID() + " 维修完毕");
		JMenuItem discard = new JMenuItem("资产 " + o.getFormatID() + " 申请报废");

		popupmenu.add(asset);
		popupmenu.addSeparator();
		popupmenu.add(maintain);
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
	}
}
