package vl.view.newpage;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import bll.controll.Controller;
import bll.controll.NWEDialog;
import dal.model.Assets;
import dal.model.Maintain;

import vl.interfaces.MyDialog;

public class NewMaintainPage extends MyDialog {

	/**
	 * Launch the application.
	 */

	private static final long serialVersionUID = 1L;

	private Maintain maintain;

	private JPanel contentpanel;
	private JPanel controlpanel;

	private JLabel assetid;
	private JLabel maintainid;
	private JTextField maintaindepartment;
	private JTextField downdate;
	private JTextField maintainhandler;
	private JTextField downremark;
	private JTextField downphenomenon;
	private JTextField maintainprocess;
	private JTextField devicestatus;
	private JTextField maintaincost;
	private JLabel maintainrecordisnew;

	/**
	 * /** Create the dialog.
	 */
	public NewMaintainPage(JFrame jframe, Assets asset, Maintain maintain,
			boolean editable) {

		super(jframe, "资产维护", false);

		this.jframe = jframe;
		this.asset = asset;

		if (maintain == null) {

			this.setTitle("资产维修");
			this.maintain = new Maintain();

		} else {

			if (editable) {
				this.setTitle("资产维修编辑");
			} else {
				this.setTitle("资产维修详情");
			}

			this.maintain = maintain;
			;
		}

		setResizable(false);
		setSize(400, 500);
		setLocation(400, 150);
		setVisible(true);
		setLayout(new BorderLayout());
		initDialog();

		setVisible(true);
	}

	public void initDialog() {

		contentpanel = new JPanel();
		contentpanel.setBorder(BorderFactory.createTitledBorder("维护信息"));

		add(contentpanel, BorderLayout.CENTER);

		controlpanel = new JPanel();

		add(controlpanel, BorderLayout.PAGE_END);

		initContentPanel();
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
				NewMaintainPage.this.dispose();
			}

		});

		if (this.getTitle().equals("资产维修")) {
			save.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if (isFull()) {

						packData();

						Controller.saveNewMaintainInfo(jframe, maintain,
								NewMaintainPage.this);

					} else {
						NWEDialog.necessaryDataError();
					}
				}

			});
		} else if (this.getTitle().equals("资产维修编辑")) {
			save.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if (isFull()) {

						packData();

						Controller.updateMaintainInfo(jframe, maintain,
								NewMaintainPage.this);

					} else {
						NWEDialog.necessaryDataError();
					}
				}

			});
		}

	}

	// initContengpanel
	public void initContentPanel() {

		contentpanel.setLayout(new BoxLayout(contentpanel, BoxLayout.X_AXIS));

		JPanel leftpanel = new JPanel();
		leftpanel.setLayout(new BoxLayout(leftpanel, BoxLayout.Y_AXIS));

		contentpanel.add(leftpanel);

		/**************** 资产ID: *************/
		JPanel leftpanel01 = new JPanel();
		leftpanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		leftpanel.add(leftpanel01);

		JLabel assetidlabel = new JLabel("资产ID:  ");
		assetidlabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		assetid = new JLabel(asset.getFormatID());

		leftpanel01.add(assetidlabel);
		leftpanel01.add(assetid);

		/**************** 维修ID *************/
		JPanel leftpanel02 = new JPanel();
		leftpanel.add(leftpanel02);

		JLabel maintainidlabel = new JLabel("出库ID(系统自动生成):  ");
		maintainid = new JLabel(maintain.getFormatID());

		leftpanel02.add(maintainidlabel);
		leftpanel02.add(maintainid);

		/*************** 维修部门 **************/
		JPanel leftpanel03 = new JPanel();
		leftpanel.add(leftpanel03);

		JLabel maintaindepartmentlabel = new JLabel("维修部门(必填):  ");
		maintaindepartment = new JTextField(maintain.getMaintaindepartment());
		maintaindepartment.setColumns(30);

		leftpanel03.add(maintaindepartmentlabel);
		leftpanel03.add(maintaindepartment);

		/************** 故障日期 ***************/
		JPanel leftpanel04 = new JPanel();
		leftpanel.add(leftpanel04);

		JLabel downdatelabel = new JLabel("故障日期(必填):  ");
		downdate = new JTextField(maintain.getDowndate());
		downdate.setColumns(30);

		leftpanel04.add(downdatelabel);
		leftpanel04.add(downdate);

		/**************** 经办人 *************/
		JPanel leftpanel05 = new JPanel();
		leftpanel.add(leftpanel05);

		JLabel maintainhandlerlabel = new JLabel("经办人(必填):  ");
		maintainhandler = new JTextField(maintain.getMaintainhandler());
		maintainhandler.setColumns(30);

		leftpanel05.add(maintainhandlerlabel);
		leftpanel05.add(maintainhandler);

		/************** 故障情况 ***************/
		JPanel leftpanel06 = new JPanel();
		leftpanel.add(leftpanel06);

		JLabel downremarklabel = new JLabel("故障情况:  ");
		downremark = new JTextField(maintain.getDownremark());
		downremark.setColumns(30);

		leftpanel06.add(downremarklabel);
		leftpanel06.add(downremark);

		/************** 故障现象 ***************/
		JPanel leftpanel07 = new JPanel();
		leftpanel.add(leftpanel07);

		JLabel downphenomenonlabel = new JLabel("故障现象:  ");
		downphenomenon = new JTextField(maintain.getDownphenomenon());
		downphenomenon.setColumns(30);

		leftpanel07.add(downphenomenonlabel);
		leftpanel07.add(downphenomenon);

		/************** 维修过程 ***************/
		JPanel leftpanel08 = new JPanel();
		leftpanel.add(leftpanel08);

		JLabel maintainprocesslabel = new JLabel("维修过程:  ");
		maintainprocess = new JTextField(maintain.getMaintainprocess());
		maintainprocess.setColumns(30);

		leftpanel08.add(maintainprocesslabel);
		leftpanel08.add(maintainprocess);

		/************** 设备状况 ***************/
		JPanel leftpanel09 = new JPanel();
		leftpanel.add(leftpanel09);

		JLabel devicestatuslabel = new JLabel("设备状况:  ");
		devicestatus = new JTextField(maintain.getDevicestatus());
		devicestatus.setColumns(30);

		leftpanel09.add(devicestatuslabel);
		leftpanel09.add(devicestatus);

		/************** 维修费用 ***************/
		leftpanel10 = new JPanel();
		leftpanel.add(leftpanel10);

		JLabel maintaincostlabel = new JLabel("维修费用(RMB):  ");
		maintaincost = new JTextField(maintain.getMaintaincost() + "");
		maintaincost.setColumns(30);

		leftpanel10.add(maintaincostlabel);
		leftpanel10.add(maintaincost);

		/************** 记录状态 ***************/
		JPanel leftpanel11 = new JPanel();
		leftpanel.add(leftpanel11);

		JLabel maintainrecordisnewlabel = new JLabel("记录状态:  ");
		maintainrecordisnew = new JLabel(maintain.getMaintainrecordisnew());

		leftpanel11.add(maintainrecordisnewlabel);
		leftpanel11.add(maintainrecordisnew);

	}

	@Override
	public void packData() {
		// TODO Auto-generated method stub
		maintain = new Maintain();

		maintain.setAssetid(asset.getAssetid());
		maintain.setMaintainid(Integer.parseInt(maintainid.getText()));
		maintain.setMaintaindepartment(maintaindepartment.getText());
		maintain.setDowndate(downdate.getText());
		maintain.setMaintainhandler(maintainhandler.getText());
		maintain.setDownremark(downremark.getText());
		maintain.setDownphenomenon(downphenomenon.getText());
		maintain.setMaintainprocess(maintainprocess.getText());
		maintain.setDevicestatus(devicestatus.getText());
		maintain.setMaintaincost(Double.parseDouble(maintaincost.getText()));
		maintain.setMaintainrecordisnew(maintainrecordisnew.getText());

	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		if (maintaindepartment.getText().equals("")) {
			return false;
		} else if (downdate.getText().equals("")) {
			return false;
		} else if (maintainhandler.getText().equals("")) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void setImagePath(String txt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void isEditable(boolean editable) {
		// TODO Auto-generated method stub
		if (editable) {

		} else {

			maintaindepartment.setEditable(false);
			downdate.setEditable(false);
			maintainhandler.setEditable(false);
			downremark.setEditable(false);
			downphenomenon.setEditable(false);
			maintainprocess.setEditable(false);
			devicestatus.setEditable(false);
			maintaincost.setEditable(false);

			cancel.setText("确定");
			save.setVisible(false);

		}

	}

}
