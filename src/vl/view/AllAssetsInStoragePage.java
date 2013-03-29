package vl.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import dal.dal.AssetsDAO;
import dal.interfaces.ModelObject;
import vl.interfaces.MyTable;


public class AllAssetsInStoragePage extends MyTable{
	

	public AllAssetsInStoragePage(JFrame j) {
		
		col = new String[] { "资产ID", "资产类型", "资产名称", "资产品牌",
				"资产型号", "资产机号", "资产购入日期", "资产生产商", "资产经销商", "资产库存状态", "资产运行状态" };
		
		this.jframe = j;

		Container pane = jframe.getContentPane();

		pane.setLayout(new BorderLayout());

		mo = (ModelObject[]) AssetsDAO.getAllInStorage();

		initJTable(pane);

		jframe.validate();
	}

	public void initPopMenu(JPopupMenu popupmenu, final ModelObject o) {

		JMenuItem deliverout = new JMenuItem("资产 " + o.getFormatID() + " 出库");
		JMenuItem rentout = new JMenuItem("资产 " + o.getFormatID() + " 借出");

		popupmenu.add(deliverout);
		popupmenu.addSeparator();
		popupmenu.add(rentout);
		
		deliverout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new NewDeliverOutPage(jframe, o);
			}
			
		});
		
		rentout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new NewRentOutPage(jframe, o);
			}
			
		});

	}

}
