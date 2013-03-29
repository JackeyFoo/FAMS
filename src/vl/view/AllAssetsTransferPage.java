package vl.view;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import vl.interfaces.MyTable;
import dal.dal.TransferDAO;
import dal.interfaces.ModelObject;

public class AllAssetsTransferPage extends MyTable{

	public AllAssetsTransferPage(JFrame j) {
		
		col = new String[] { "转移ID", "资产ID", "转移部门", "转移日期",
				"经办人", "备注", "转移情况", "记录状态"};
		
		this.jframe = j;

		Container pane = jframe.getContentPane();

		pane.setLayout(new BorderLayout());

		mo = (ModelObject[]) TransferDAO.getAllTransfer();

		initJTable(pane);

		jframe.validate();
	}



	public void initPopMenu(JPopupMenu popupmenu, final ModelObject o) {

		JMenuItem asset = new JMenuItem("资产 " + o.getFormatID() + " 详情");
		JMenuItem maintain = new JMenuItem("资产 " + o.getFormatID() + " 申请维修");
		JMenuItem discard = new JMenuItem("资产 " + o.getFormatID() + " 申请报废");
		JMenuItem returned = new JMenuItem("资产 " + o.getFormatID() + " 归还");

		popupmenu.add(asset);
		popupmenu.addSeparator();
		popupmenu.add(maintain);
		popupmenu.addSeparator();
		popupmenu.add(discard);
		popupmenu.addSeparator();
		popupmenu.add(returned);
		

	}
}
