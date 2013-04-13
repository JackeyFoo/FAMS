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

		col = new String[] { "�ʲ�ID", "�ʲ�����", "�ʲ�����", "�ʲ�Ʒ��", "�ʲ��ͺ�", "�ʲ�����",
				"�ʲ���������", "�ʲ�������", "�ʲ�������", "�ʲ����״̬", "�ʲ�����״̬" };

		this.jframe = j;

		mo = (ModelObject[]) AssetsDAO.getAll();
		
		if(mo == null){
			
		}

		initJTable();

		jframe.validate();
	}

	public AllAssetsPage(MyJFrame j, int id) {

		col = new String[] { "�ʲ�ID", "�ʲ�����", "�ʲ�����", "�ʲ�Ʒ��", "�ʲ��ͺ�", "�ʲ�����",
				"�ʲ���������", "�ʲ�������", "�ʲ�������", "�ʲ����״̬", "�ʲ�����״̬" };

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

		JMenuItem barcode = new JMenuItem("�����ʲ� " + o.getFormatID() + " ����");
		JMenuItem asset = new JMenuItem("�ʲ� " + o.getFormatID() + " �༭");

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

		if (assets.getAssetindeliverstatus().equals("����")) {

			JMenuItem deliverout = new JMenuItem("�ʲ� " + o.getFormatID()
					+ " ����");
			JMenuItem rentout = new JMenuItem("�ʲ� " + o.getFormatID() + " ���");

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

			if (assets.getAssetindeliverstatus().equals("����")) {

				JMenuItem deliverout = new JMenuItem("�ʲ� " + o.getFormatID()
						+ " ������ʷ");
				JMenuItem returned = new JMenuItem("�ʲ� " + o.getFormatID()
						+ " ����黹");
				JMenuItem transfer = new JMenuItem("�ʲ� " + o.getFormatID()
						+ " ת��");
				
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

			else if (assets.getAssetindeliverstatus().equals("���")) {

				JMenuItem rentout = new JMenuItem("�ʲ� " + o.getFormatID()
						+ " �����ʷ");
				JMenuItem returned = new JMenuItem("�ʲ� " + o.getFormatID()
						+ " ����黹");

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

			} else if (assets.getAssetindeliverstatus().equals("ת��")) {

				JMenuItem transfer = new JMenuItem("�ʲ� " + o.getFormatID()
						+ " ת��");
				JMenuItem transferhis = new JMenuItem("�ʲ� " + o.getFormatID()
						+ " ת����ʷ");
				JMenuItem returned = new JMenuItem("�ʲ� " + o.getFormatID()
						+ " ת�ƹ黹");

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

			if (assets.getAssetrunningstatus().equals("����")) {

				JMenuItem maintain = new JMenuItem("�ʲ� " + o.getFormatID()
						+ " ����ά��");
				JMenuItem discard = new JMenuItem("�ʲ� " + o.getFormatID()
						+ " ���뱨��");

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

			} else if (assets.getAssetrunningstatus().equals("ά��")) {

				JMenuItem maintain = new JMenuItem("�ʲ� " + o.getFormatID()
						+ " ά����ʷ");
				JMenuItem maintained = new JMenuItem("�ʲ� " + o.getFormatID()
						+ " ά�����");
				JMenuItem discard = new JMenuItem("�ʲ� " + o.getFormatID()
						+ " ���뱨��");

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
