package vl.view.listpage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import bll.controll.BarcodeCreator;
import bll.controll.NWEDialog;
import vl.interfaces.MyJFrame;
import vl.interfaces.MyTable;
import vl.view.newpage.NewAssetPage;
import vl.view.newpage.NewDeliverOutPage;
import vl.view.newpage.NewDiscardPage;
import vl.view.newpage.NewMaintainPage;
import vl.view.newpage.NewRentOutPage;
import vl.view.newpage.NewTransferPage;
import dal.dal.AssetsDAO;
import dal.dal.DeliverOutDAO;
import dal.dal.MaintainDAO;
import dal.dal.RentOutDAO;
import dal.dal.TransferDAO;
import dal.interfaces.ModelObject;
import dal.model.Assets;

public class AllAssetsPage extends MyTable {

	public AllAssetsPage(MyJFrame j) {

		col = new String[] { "资产ID", "资产类型", "资产名称", "资产品牌", "资产型号", "资产机号",
				"资产购入日期", "资产生产商", "资产经销商", "资产库存状态", "资产运行状态" };

		this.jframe = j;

		mo = (ModelObject[]) AssetsDAO.getAll();
		
		if(mo == null){
			
		}

		initJTable();

		jframe.validate();
	}

	public AllAssetsPage(MyJFrame j, int id) {

		col = new String[] { "资产ID", "资产类型", "资产名称", "资产品牌", "资产型号", "资产机号",
				"资产购入日期", "资产生产商", "资产经销商", "资产库存状态", "资产运行状态" };

		this.jframe = j;
		
		Assets asset = AssetsDAO.getAsset(id);
		
		if(asset == null){
			NWEDialog.searchWarning();
		}
				
		mo = (ModelObject[]) new Assets[] { asset };

		initJTable();

		jframe.validate();
	}

	public void initPopMenu(JPopupMenu popupmenu, final ModelObject o) {

		JMenuItem barcode = new JMenuItem("生成资产 " + o.getFormatID() + " 条码");
		JMenuItem asset = new JMenuItem("资产 " + o.getFormatID() + " 编辑");

		final Assets assets = AssetsDAO.getAsset(o.getAssetid());

		popupmenu.add(barcode);
		popupmenu.addSeparator();
		popupmenu.add(asset);

		barcode.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				BarcodeCreator.barcodeCreate(o.getFormatAssetid());
			}
			
		});
		
		asset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new NewAssetPage(jframe, assets, true);

			}

		});

		if (assets.getAssetindeliverstatus().equals("库中")) {

			JMenuItem deliverout = new JMenuItem("资产 " + o.getFormatID()
					+ " 出库");
			JMenuItem rentout = new JMenuItem("资产 " + o.getFormatID() + " 借出");

			popupmenu.addSeparator();
			popupmenu.add(deliverout);
			popupmenu.addSeparator();
			popupmenu.add(rentout);

			deliverout.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					new NewDeliverOutPage(jframe, assets, null, true);
				}

			});

			rentout.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					new NewRentOutPage(jframe, assets, null, true);
				}

			});

		} else {

			if (assets.getAssetindeliverstatus().equals("出库")) {

				JMenuItem deliverout = new JMenuItem("资产 " + o.getFormatID()
						+ " 出库历史");
				JMenuItem returned = new JMenuItem("资产 " + o.getFormatID()
						+ " 出库归还");
				JMenuItem transfer = new JMenuItem("资产 " + o.getFormatID()
						+ " 转移");
				
				popupmenu.addSeparator();
				popupmenu.add(deliverout);
				popupmenu.addSeparator();
				popupmenu.add(returned);
				popupmenu.addSeparator();
				popupmenu.add(transfer);

				transfer.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						new NewTransferPage(jframe, assets, null, true);
					}

				});

				deliverout.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						new AllAssetsDeliverOutPage(jframe, DeliverOutDAO
								.getDeliverOutHistory(assets.getAssetid()));
					}

				});

			}

			else if (assets.getAssetindeliverstatus().equals("借出")) {

				JMenuItem rentout = new JMenuItem("资产 " + o.getFormatID()
						+ " 借出历史");
				JMenuItem returned = new JMenuItem("资产 " + o.getFormatID()
						+ " 借出归还");

				popupmenu.addSeparator();
				popupmenu.add(rentout);
				popupmenu.addSeparator();
				popupmenu.add(returned);

				rentout.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						new AllAssetsRentOutPage(jframe, RentOutDAO
								.getRentOutHistory(assets.getAssetid()));
					}

				});

			} else if (assets.getAssetindeliverstatus().equals("转移")) {

				JMenuItem transfer = new JMenuItem("资产 " + o.getFormatID()
						+ " 转移");
				JMenuItem transferhis = new JMenuItem("资产 " + o.getFormatID()
						+ " 转移历史");
				JMenuItem returned = new JMenuItem("资产 " + o.getFormatID()
						+ " 转移归还");

				popupmenu.addSeparator();
				popupmenu.add(transfer);
				popupmenu.addSeparator();
				popupmenu.add(transferhis);
				popupmenu.addSeparator();
				popupmenu.add(returned);
				
				transfer.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						new NewTransferPage(jframe, assets, null, true);
					}

				});

				transferhis.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						new AllAssetsTransferPage(jframe, TransferDAO
								.getTransferHistory(assets.getAssetid()));
					}

				});

			}

			if (assets.getAssetrunningstatus().equals("正常")) {

				JMenuItem maintain = new JMenuItem("资产 " + o.getFormatID()
						+ " 申请维修");
				JMenuItem discard = new JMenuItem("资产 " + o.getFormatID()
						+ " 申请报废");

				popupmenu.addSeparator();
				popupmenu.add(maintain);
				popupmenu.addSeparator();
				popupmenu.add(discard);

				maintain.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						new NewMaintainPage(jframe, assets, null, true);
					}

				});

				discard.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						new NewDiscardPage(jframe, assets, null, true);
					}

				});

			} else if (assets.getAssetrunningstatus().equals("维修")) {

				JMenuItem maintain = new JMenuItem("资产 " + o.getFormatID()
						+ " 维修历史");
				JMenuItem maintained = new JMenuItem("资产 " + o.getFormatID()
						+ " 维修完毕");
				JMenuItem discard = new JMenuItem("资产 " + o.getFormatID()
						+ " 申请报废");

				popupmenu.addSeparator();
				popupmenu.add(maintain);
				popupmenu.addSeparator();
				popupmenu.add(maintained);
				popupmenu.addSeparator();
				popupmenu.add(discard);

				maintain.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						new AllAssetsMaintainPage(jframe, MaintainDAO
								.getMaintainHistory(assets.getAssetid()));
					}

				});

				discard.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						new NewDiscardPage(jframe, assets, null, true);
					}

				});
			}
		}
	}
}
