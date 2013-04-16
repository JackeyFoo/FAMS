package vl.view.hispage;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import dal.dal.DeliverOutDAO;
import dal.dal.MaintainDAO;
import dal.dal.RentOutDAO;
import dal.dal.TransferDAO;
import dal.model.Assets;
import dal.model.DeliverOut;
import dal.model.Maintain;
import dal.model.RentOut;
import dal.model.Transfer;
import vl.interfaces.MyDialog;
import vl.interfaces.MyJFrame;
import vl.view.newpage.NewDeliverOutPage;
import vl.view.newpage.NewMaintainPage;
import vl.view.newpage.NewRentOutPage;
import vl.view.newpage.NewTransferPage;

public class AssetsHistoryPage extends MyDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AssetsHistoryPage(MyJFrame jframe, Assets asset) {

		super(jframe, "资产历史动态", false);

		this.jframe = jframe;
		this.asset = asset;

		setResizable(false);
		setSize(400, 500);
		setLocation(400, 100);
		setVisible(true);
		setLayout(new BorderLayout());
		initDialog();

		setVisible(true);
	}

	@Override
	public void initDialog() {
		// TODO Auto-generated method stub

		contentpanel = new JPanel();

		add(contentpanel, BorderLayout.CENTER);

		controlpanel = new JPanel();

		add(controlpanel, BorderLayout.PAGE_END);

		initContentPanel();
		initControlPanel();

	}

	@Override
	public void initControlPanel() {
		// TODO Auto-generated method stub
		cancel = new JButton("确定");

		controlpanel.add(cancel);

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				AssetsHistoryPage.this.dispose();
			}

		});

	}

	@Override
	public void initContentPanel() {
		// TODO Auto-generated method stub
		contentpanel.setLayout(new BoxLayout(contentpanel, BoxLayout.X_AXIS));

		JPanel leftpanel = new JPanel();
		leftpanel.setLayout(new BoxLayout(leftpanel, BoxLayout.PAGE_AXIS));

		contentpanel.add(leftpanel);

		/***************** 出库历史 **************/

		initDeliverOutHis(leftpanel);

		/***************** 借出历史 **************/

		initRentOutHis(leftpanel);

		/***************** 转移历史 **************/

		initTransferHis(leftpanel);

		/***************** 维修历史 **************/

		initMaintainHis(leftpanel);

	}

	private void initMaintainHis(JPanel jp) {
		// TODO Auto-generated method stub
		Maintain[] maintains = MaintainDAO.getMaintainHistory(asset
				.getAssetid());

		if (maintains != null && maintains.length != 0) {

			JPanel maintainpanel = new JPanel();

			maintainpanel.setLayout(new BorderLayout());

			maintainpanel.setBorder(BorderFactory.createTitledBorder("资产 "
					+ asset.getFormatAssetid() + " 维修历史信息"));

			jp.add(maintainpanel);

			JScrollPane scrollpane = new JScrollPane(
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

			JPanel panel = new JPanel();

			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			scrollpane.setViewportView(panel);

			maintainpanel.add(scrollpane, BorderLayout.CENTER);

			for (final Maintain maintain : maintains) {

				JPanel outpanel = new JPanel();

				JLabel outid = new JLabel("时间:    " + maintain.getFormatID()
						+ "        ");
				JLabel outdate = new JLabel("经办人：    " + maintain.getDowndate()
						+ "        ");
				JLabel space = new JLabel(
						"                                    ");

				JButton detail = new JButton("详情");

				outpanel.add(outid);
				outpanel.add(outdate);
				outpanel.add(detail);
				outpanel.add(space);

				detail.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						new NewMaintainPage(jframe, asset, maintain, false);
					}

				});

				panel.add(outpanel);

			}

		}
	}

	private void initTransferHis(JPanel jp) {
		// TODO Auto-generated method stub
		Transfer[] transfers = TransferDAO.getTransferHistory(asset
				.getAssetid());

		if (transfers != null && transfers.length != 0) {

			JPanel transferpanel = new JPanel();

			transferpanel.setLayout(new BorderLayout());

			transferpanel.setBorder(BorderFactory.createTitledBorder("资产 "
					+ asset.getFormatAssetid() + " 转移历史信息"));

			jp.add(transferpanel);

			JScrollPane scrollpane = new JScrollPane(
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

			JPanel panel = new JPanel();

			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			scrollpane.setViewportView(panel);

			transferpanel.add(scrollpane, BorderLayout.CENTER);

			for (final Transfer transfer : transfers) {

				JPanel outpanel = new JPanel();

				JLabel outid = new JLabel("时间:    " + transfer.getFormatID()
						+ "        ");
				JLabel outdate = new JLabel("经办人：    "
						+ transfer.getTransferdate() + "        ");
				JLabel space = new JLabel(
						"                                    ");

				JButton detail = new JButton("详情");

				outpanel.add(outid);
				outpanel.add(outdate);
				outpanel.add(detail);
				outpanel.add(space);

				detail.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						new NewTransferPage(jframe, asset, transfer, false);
					}

				});

				panel.add(outpanel);

			}

		}

	}

	private void initRentOutHis(JPanel jp) {
		// TODO Auto-generated method stub
		RentOut[] rentouts = RentOutDAO.getRentOutHistory(asset.getAssetid());

		if (rentouts != null && rentouts.length != 0) {

			JPanel rentoutpanel = new JPanel();

			rentoutpanel.setLayout(new BorderLayout());

			rentoutpanel.setBorder(BorderFactory.createTitledBorder("资产 "
					+ asset.getFormatAssetid() + " 借出历史信息"));

			jp.add(rentoutpanel);

			JScrollPane scrollpane = new JScrollPane(
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

			JPanel panel = new JPanel();

			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			scrollpane.setViewportView(panel);

			rentoutpanel.add(scrollpane, BorderLayout.CENTER);

			for (final RentOut out : rentouts) {

				JPanel outpanel = new JPanel();

				JLabel outid = new JLabel("时间:    " + out.getFormatID()
						+ "        ");
				JLabel outdate = new JLabel("经办人：    " + out.getRentdate()
						+ "        ");
				JLabel space = new JLabel(
						"                                    ");

				JButton detail = new JButton("详情");

				outpanel.add(outid);
				outpanel.add(outdate);
				outpanel.add(detail);
				outpanel.add(space);

				detail.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						new NewRentOutPage(jframe, asset, out, false);
					}

				});
				
				panel.add(outpanel);

			}

		}

	}

	public void initDeliverOutHis(JPanel jp) {

		DeliverOut[] deliverouts = DeliverOutDAO.getDeliverOutHistory(asset
				.getAssetid());

		if (deliverouts != null && deliverouts.length != 0) {

			JPanel deliveroutpanel = new JPanel();

			deliveroutpanel.setLayout(new BorderLayout());

			deliveroutpanel.setBorder(BorderFactory.createTitledBorder("资产 "
					+ asset.getFormatAssetid() + " 出库历史信息"));

			jp.add(deliveroutpanel);

			JScrollPane scrollpane = new JScrollPane(
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

			JPanel panel = new JPanel();

			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			scrollpane.setViewportView(panel);

			deliveroutpanel.add(scrollpane, BorderLayout.CENTER);

			for (final DeliverOut out : deliverouts) {

				JPanel outpanel = new JPanel();

				JLabel outid = new JLabel("时间:    " + out.getFormatID()
						+ "        ");
				JLabel outdate = new JLabel("经办人：    " + out.getDeliverdate()
						+ "        ");
				JLabel space = new JLabel(
						"                                    ");

				JButton detail = new JButton("详情");

				outpanel.add(outid);
				outpanel.add(outdate);
				outpanel.add(detail);
				outpanel.add(space);

				detail.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						new NewDeliverOutPage(jframe, asset, out, false);
					}

				});

				panel.add(outpanel);

			}

		}
	}

	@Override
	public void packData() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setImagePath(String txt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void isEditable(boolean editable) {
		// TODO Auto-generated method stub

	}

}
