package vl.view;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import vl.interfaces.MyTable;
import dal.dal.DeliverOutDAO;
import dal.interfaces.ModelObject;

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

		JMenuItem asset = new JMenuItem("资产 " + o.getFormatID() + " 详情");
		JMenuItem transfer = new JMenuItem("资产 " + o.getFormatID() + " 转移");
		JMenuItem maintain = new JMenuItem("资产 " + o.getFormatID() + " 申请维修");
		JMenuItem discard = new JMenuItem("资产 " + o.getFormatID() + " 申请报废");
		JMenuItem returned = new JMenuItem("资产 " + o.getFormatID() + " 归还");

		popupmenu.add(asset);
		popupmenu.addSeparator();
		popupmenu.add(transfer);
		popupmenu.addSeparator();
		popupmenu.add(maintain);
		popupmenu.addSeparator();
		popupmenu.add(discard);
		popupmenu.addSeparator();
		popupmenu.add(returned);
		

	}
}
