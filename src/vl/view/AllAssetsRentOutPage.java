package vl.view;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import dal.dal.RentOutDAO;
import dal.interfaces.ModelObject;
import vl.interfaces.MyTable;

public class AllAssetsRentOutPage extends MyTable {

	public AllAssetsRentOutPage(JFrame j) {

		col = new String[] { "借出ID", "资产ID", "租用部门", "租用人", "租用日期", "预归还日期",
				"经办人", "备注", "记录状态", "归还日期", "归还人员" };

		this.jframe = j;

		Container pane = jframe.getContentPane();

		pane.setLayout(new BorderLayout());

		mo = (ModelObject[]) RentOutDAO.getAllRentOut();

		initJTable(pane);

		jframe.validate();
	}

	@Override
	public void initPopMenu(JPopupMenu popupmenu, ModelObject o) {
		// TODO Auto-generated method stub
		JMenuItem asset = new JMenuItem("资产 " + o.getFormatID() + " 详情");
		JMenuItem returned = new JMenuItem("资产 " + o.getFormatID() + " 归还");

		popupmenu.add(asset);
		popupmenu.addSeparator();
		popupmenu.add(returned);
	}

}
