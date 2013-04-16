package vl.view.returnpage;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bll.controll.Controller;
import dal.model.Assets;
import dal.model.DeliverOut;
import dal.model.RentOut;
import vl.interfaces.MyDialog;
import vl.interfaces.MyJFrame;
import vl.util.NWEDialog;
import dal.dal.DeliverOutDAO;
import dal.dal.RentOutDAO;
import dal.dal.TransferDAO;
import dal.interfaces.ModelObject;

public class NewReturnPage extends MyDialog {

	private static final long serialVersionUID = 1L;

	private ModelObject mo;

	private JLabel assetsid;
	private JLabel modelobjectid;
	private JTextField returnstaff;
	private JTextField returndate;
	private JLabel modelobjectidlabel;

	String status;

	public NewReturnPage(MyJFrame jframe, Assets asset, ModelObject mo) {

		super(jframe, false);

		this.jframe = jframe;
		this.asset = asset;
		this.mo = mo;

		setResizable(false);
		setSize(400, 200);
		setLocation(400, 150);
		setVisible(true);
		setLayout(new BorderLayout());
		initDialog();

		setVisible(true);
	}

	public void initDialog() {

		contentpanel = new JPanel();
		contentpanel.setBorder(BorderFactory.createTitledBorder("归还信息"));

		add(contentpanel, BorderLayout.CENTER);

		controlpanel = new JPanel();

		add(controlpanel, BorderLayout.PAGE_END);

		initContentPanel();

		status = setTitle();

		initControlPanel();

	}

	public void initControlPanel() {

		save = new JButton("保存");
		cancel = new JButton("取消");

		controlpanel.add(save);
		controlpanel.add(cancel);

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				NewReturnPage.this.dispose();
			}

		});

		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (isFull()) {

					packData();

					if (status.equals("DeliverOut")) {

						((DeliverOut) mo).setReturndate(returndate.getText());
						((DeliverOut) mo).setReturnstaff(returnstaff.getText());

						Controller.deliveroutReturn(jframe, (DeliverOut) mo,
								NewReturnPage.this);

					} else if (status.equals("RentOut")) {

						((RentOut) mo).setReturndate(returndate.getText());
						((RentOut) mo).setReturnstaff(returnstaff.getText());

						Controller.rentoutReturn(jframe, (RentOut) mo,
								NewReturnPage.this);

					} else if (status.equals("Transfer")) {

						DeliverOut temp = DeliverOutDAO.getDeliverOut(asset
								.getAssetid());

						temp.setReturndate(returndate.getText());
						temp.setReturnstaff(returnstaff.getText());

						Controller.deliveroutReturn(jframe, temp, NewReturnPage.this);

					}

				} else {
					NWEDialog.necessaryDataError(NewReturnPage.this);
				}
			}

		});

	}

	public void initContentPanel() {
		contentpanel.setLayout(new BoxLayout(contentpanel, BoxLayout.X_AXIS));

		JPanel leftpanel = new JPanel();
		leftpanel.setLayout(new BoxLayout(leftpanel, BoxLayout.Y_AXIS));

		contentpanel.add(leftpanel);

		// 资产ID
		JPanel leftpanel01 = new JPanel();
		leftpanel.add(leftpanel01);

		JLabel assetsidlabel = new JLabel("资产ID:  ");
		assetsid = new JLabel(asset.getFormatID());

		leftpanel01.add(assetsidlabel);
		leftpanel01.add(assetsid);

		// 对象ID
		JPanel leftpanel02 = new JPanel();
		leftpanel.add(leftpanel02);

		modelobjectidlabel = new JLabel();
		modelobjectid = new JLabel();

		leftpanel02.add(modelobjectidlabel);
		leftpanel02.add(modelobjectid);

		// 归还人员（必填)
		JPanel leftpanel03 = new JPanel();
		leftpanel.add(leftpanel03);

		JLabel returnstafflabel = new JLabel("归还人员(必填):  ");
		returnstaff = new JTextField();
		returnstaff.setColumns(30);

		leftpanel03.add(returnstafflabel);
		leftpanel03.add(returnstaff);

		// 归还日期(必填)

		JPanel leftpanel04 = new JPanel();
		leftpanel.add(leftpanel04);

		JLabel returndatelabel = new JLabel("归还日期(必填):  ");
		returndate = new JTextField();
		returndate.setColumns(30);

		leftpanel04.add(returndatelabel);
		leftpanel04.add(returndate);
	}

	public String setTitle() {

		if (mo != null) {

			modelobjectid.setText(mo.getFormatID());

			if (mo.getClass().getName().endsWith("DeliverOut")) {

				this.setTitle("资产出库归还");
				modelobjectidlabel.setText("资产出库ID:  ");

				return "DeliverOut";

			} else if (mo.getClass().getName().endsWith("RentOut")) {

				this.setTitle("资产借出归还");
				modelobjectidlabel.setText("资产借出ID:  ");

				return "RentOut";

			} else if (mo.getClass().getName().endsWith("Transfer")) {

				this.setTitle("资产转移归还");
				modelobjectidlabel.setText("资产转移ID:  ");

				return "Transfer";

			} else {

				return "null";
			}

		} else {

			if (asset.getAssetindeliverstatus().equals("出库")) {

				mo = DeliverOutDAO.getDeliverOut(asset.getAssetid());

			} else if (asset.getAssetindeliverstatus().equals("借出")) {

				mo = RentOutDAO.getRentOut(asset.getAssetid());

			} else if (asset.getAssetindeliverstatus().equals("转移")) {

				mo = TransferDAO.getTransfer(asset.getAssetid());

			}
			return setTitle();
		}
	}

	public void packData() {
	}

	public boolean isFull() {
		if (returnstaff.getText().equals("")) {
			return false;
		} else if (returndate.getText().equals("")) {
			return false;
		} else {
			return true;
		}
	}

	public void setImagePath(String txt) {
		// TODO Auto-generated method stub

	}

	public void isEditable(boolean editable) {

	}
}
