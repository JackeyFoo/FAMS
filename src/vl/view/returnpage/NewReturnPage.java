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
		contentpanel.setBorder(BorderFactory.createTitledBorder("�黹��Ϣ"));

		add(contentpanel, BorderLayout.CENTER);

		controlpanel = new JPanel();

		add(controlpanel, BorderLayout.PAGE_END);

		initContentPanel();

		status = setTitle();

		initControlPanel();

	}

	public void initControlPanel() {

		save = new JButton("����");
		cancel = new JButton("ȡ��");

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

		// �ʲ�ID
		JPanel leftpanel01 = new JPanel();
		leftpanel.add(leftpanel01);

		JLabel assetsidlabel = new JLabel("�ʲ�ID:  ");
		assetsid = new JLabel(asset.getFormatID());

		leftpanel01.add(assetsidlabel);
		leftpanel01.add(assetsid);

		// ����ID
		JPanel leftpanel02 = new JPanel();
		leftpanel.add(leftpanel02);

		modelobjectidlabel = new JLabel();
		modelobjectid = new JLabel();

		leftpanel02.add(modelobjectidlabel);
		leftpanel02.add(modelobjectid);

		// �黹��Ա������)
		JPanel leftpanel03 = new JPanel();
		leftpanel.add(leftpanel03);

		JLabel returnstafflabel = new JLabel("�黹��Ա(����):  ");
		returnstaff = new JTextField();
		returnstaff.setColumns(30);

		leftpanel03.add(returnstafflabel);
		leftpanel03.add(returnstaff);

		// �黹����(����)

		JPanel leftpanel04 = new JPanel();
		leftpanel.add(leftpanel04);

		JLabel returndatelabel = new JLabel("�黹����(����):  ");
		returndate = new JTextField();
		returndate.setColumns(30);

		leftpanel04.add(returndatelabel);
		leftpanel04.add(returndate);
	}

	public String setTitle() {

		if (mo != null) {

			modelobjectid.setText(mo.getFormatID());

			if (mo.getClass().getName().endsWith("DeliverOut")) {

				this.setTitle("�ʲ�����黹");
				modelobjectidlabel.setText("�ʲ�����ID:  ");

				return "DeliverOut";

			} else if (mo.getClass().getName().endsWith("RentOut")) {

				this.setTitle("�ʲ�����黹");
				modelobjectidlabel.setText("�ʲ����ID:  ");

				return "RentOut";

			} else if (mo.getClass().getName().endsWith("Transfer")) {

				this.setTitle("�ʲ�ת�ƹ黹");
				modelobjectidlabel.setText("�ʲ�ת��ID:  ");

				return "Transfer";

			} else {

				return "null";
			}

		} else {

			if (asset.getAssetindeliverstatus().equals("����")) {

				mo = DeliverOutDAO.getDeliverOut(asset.getAssetid());

			} else if (asset.getAssetindeliverstatus().equals("���")) {

				mo = RentOutDAO.getRentOut(asset.getAssetid());

			} else if (asset.getAssetindeliverstatus().equals("ת��")) {

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
