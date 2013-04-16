package vl.view.listpage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import dal.dal.AssetsDAO;
import dal.dal.RentOutDAO;
import dal.interfaces.ModelObject;
import dal.model.Assets;
import dal.model.RentOut;
import vl.interfaces.MyJFrame;
import vl.interfaces.MyTable;
import vl.view.newpage.NewAssetPage;
import vl.view.newpage.NewRentOutPage;
import vl.view.returnpage.NewReturnPage;

public class AllAssetsRentOutPage extends MyTable {

	public AllAssetsRentOutPage(MyJFrame j, RentOut[] rentouts) {

		col = new String[] { "借出ID", "资产ID", "租用部门", "租用人", "租用日期", "预归还日期",
				"经办人", "备注", "记录状态", "归还日期", "归还人员" };

		this.jframe = j;

		mo = rentouts;

		initJTable();

		jframe.validate();
	}

	@Override
	public void initPopMenu(JPopupMenu popupmenu, final ModelObject o) {
		// TODO Auto-generated method stub
		final Assets assets = AssetsDAO.getAsset(o.getAssetid());
		
		JMenuItem asset = new JMenuItem("资产 " + o.getFormatID() + " 详情");
		JMenuItem rentout = new JMenuItem("资产 " + o.getFormatID() + " 借出编辑");
		JMenuItem rentouthis = new JMenuItem("资产 " + o.getFormatID()
				+ " 借出历史");
		JMenuItem returned = new JMenuItem("资产 " + o.getFormatID() + " 归还");

		popupmenu.add(asset);
		popupmenu.addSeparator();
		popupmenu.add(rentout);
		popupmenu.addSeparator();
		popupmenu.add(rentouthis);
		popupmenu.addSeparator();
		popupmenu.add(returned);
		
		asset.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new NewAssetPage( jframe, assets ,false);
			}
			
		});
		
		rentout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new NewRentOutPage( jframe, assets, (RentOut) o, true);
			}
			
		});
		
		rentouthis.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new AllAssetsRentOutPage(jframe, RentOutDAO
						.getRentOutHistory(assets.getAssetid()));
			}

		});
		
		returned.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new NewReturnPage(jframe, assets, o);
			}
			
		});

	}

}
