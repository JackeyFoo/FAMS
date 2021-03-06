package vl.view.listpage;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import bll.controll.BarcodeCreator;
import dal.dal.AssetsDAO;
import dal.interfaces.ModelObject;
import dal.model.Assets;
import vl.interfaces.MyJFrame;
import vl.interfaces.MyTable;
import vl.view.newpage.NewAssetPage;
import vl.view.newpage.NewDeliverOutPage;
import vl.view.newpage.NewRentOutPage;


public class AllAssetsInStoragePage extends MyTable{
	

	public AllAssetsInStoragePage(MyJFrame j) {
		
		col = new String[] { "资产ID", "资产类型", "资产名称", "资产品牌",
				"资产型号", "资产机号", "资产购入日期", "资产生产商", "资产经销商", "资产库存状态", "资产运行状态" };
		
		this.jframe = j;

		mo = (ModelObject[]) AssetsDAO.getAllInStorage();

		initJTable();

		jframe.validate();
	}



	
	public void initPopMenu(JPopupMenu popupmenu, final ModelObject o) {
		
		final Assets assets = AssetsDAO.getAsset(o.getAssetid());

		JMenuItem barcode = new JMenuItem("生成资产 " + o.getFormatID() + " 条码");
		JMenuItem asset = new JMenuItem("资产 " + o.getFormatID() + " 详情");
		JMenuItem deliverout = new JMenuItem("资产 " + o.getFormatID() + " 出库");
		JMenuItem rentout = new JMenuItem("资产 " + o.getFormatID() + " 借出");

		
		popupmenu.add(barcode);
		popupmenu.addSeparator();
		popupmenu.add(asset);
		popupmenu.addSeparator();
		popupmenu.add(deliverout);
		popupmenu.addSeparator();
		popupmenu.add(rentout);
		
		barcode.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				BarcodeCreator.barcodeCreate(o.getFormatAssetid());
			}
			
		});
		
		asset.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new NewAssetPage( jframe, assets ,false);
			}
			
		});
		
		
		deliverout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new NewDeliverOutPage(jframe, assets, null, true);
			}
			
		});
		
		rentout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new NewRentOutPage(jframe, assets, null, true);
			}
			
		});

	}

}
