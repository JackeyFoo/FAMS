package vl.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import bll.controll.ChooseImageActionListen;
import bll.controll.Controller;
import vl.interfaces.MyDialog;
import dal.model.Assets;
import dal.model.Transfer;

public class NewTransferPage extends MyDialog {

	/**
	 * Launch the application.
	 */

	private static final long serialVersionUID = 1L;
	
	private Transfer transfer;

	private JPanel contentpanel;
	private JPanel controlpanel;

	private JLabel assetid;
	private JLabel transferid;
	private JTextField transferdepartment;
	private JTextField transferdate;
	private JTextField transferhandler;
	private JTextField transferremark;
	private JTextField transferstatus;
	private JLabel transferrecordisnew;
	private JTextField transfercertificate;

	/**
	 * Create the dialog.
	 */
	public NewTransferPage(JFrame jframe, Assets asset, Transfer transfer, boolean editable) {

		super(jframe, "设备转移", false);

		this.jframe = jframe;
		this.asset = asset;
		
		if(transfer == null){
			this.transfer = new Transfer();
		}else{
			this.transfer = transfer;;
		}

		setResizable(false);
		setSize(800, 500);
		setLocation(200, 150);
		setVisible(true);
		setLayout(new BorderLayout());
		initDialog();

		setVisible(true);

	}

	public void initDialog() {

		contentpanel = new JPanel();
		contentpanel.setBorder(BorderFactory.createTitledBorder("转移信息"));

		add(contentpanel, BorderLayout.CENTER);

		controlpanel = new JPanel();

		add(controlpanel, BorderLayout.PAGE_END);

		initContentPanel();
		initControlPanel();
	}

	public void initControlPanel() {

		JButton save = new JButton("保存");
		JButton cancel = new JButton("取消");

		controlpanel.add(save);
		controlpanel.add(cancel);

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				NewTransferPage.this.dispose();
			}

		});

		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (isFull()) {

					packData();

					 Controller.saveNewTransferInfo(jframe, transfer, files,
					 NewTransferPage.this);

				} else {
					JOptionPane.showMessageDialog(null, "请填写必要的数据", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		});
	}

	public void initContentPanel() {

		contentpanel.setLayout(new BoxLayout(contentpanel, BoxLayout.X_AXIS));

		JPanel leftpanel = new JPanel();
		leftpanel.setLayout(new BoxLayout(leftpanel, BoxLayout.Y_AXIS));

		JPanel rightpanel = new JPanel();
		rightpanel.setBorder(BorderFactory.createTitledBorder("转移凭证"));
		rightpanel.setLayout(new BorderLayout());

		contentpanel.add(leftpanel);
		contentpanel.add(rightpanel);

		/****************资产ID:*************/
		JPanel leftpanel01 = new JPanel();	
		leftpanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		leftpanel.add(leftpanel01);
		
		JLabel assetidlabel = new JLabel("资产ID:  ");
		assetidlabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		assetid = new JLabel(asset.getFormatID());
		
		leftpanel01.add(assetidlabel);
		leftpanel01.add(assetid);
		
		/****************转移ID*************/
		JPanel leftpanel02 = new JPanel();	
		leftpanel.add(leftpanel02);
		
		JLabel transferidlabel = new JLabel("出库ID(系统自动生成):  ");	
		transferid = new JLabel(transfer.getFormatID());
		
		leftpanel02.add(transferidlabel);
		leftpanel02.add(transferid);
		
		/***************转移部门**************/
		JPanel leftpanel03 = new JPanel();	
		leftpanel.add(leftpanel03);
		
		JLabel transferdepartmentlabel = new JLabel("转移部门(必填):  ");	
		transferdepartment = new JTextField(transfer.getTransferdepartment());
		transferdepartment.setColumns(30);
		
		leftpanel03.add(transferdepartmentlabel);
		leftpanel03.add(transferdepartment);
		
		/**************转移日期***************/
		JPanel leftpanel04 = new JPanel();	
		leftpanel.add(leftpanel04);
		
		JLabel transferdatelabel = new JLabel("转移日期(必填):  ");	
		transferdate = new JTextField(transfer.getTransferdate());
		transferdate.setColumns(30);
		
		leftpanel04.add(transferdatelabel);
		leftpanel04.add(transferdate);
		
		/****************经办人*************/
		JPanel leftpanel05 = new JPanel();	
		leftpanel.add(leftpanel05);
		
		JLabel transferhandlerlabel = new JLabel("经办人(必填):  ");	
		transferhandler = new JTextField(transfer.getTransferhandler());
		transferhandler.setColumns(30);
		
		leftpanel05.add(transferhandlerlabel);
		leftpanel05.add(transferhandler);
		
		
		/**************备注***************/
		JPanel leftpanel06 = new JPanel();	
		leftpanel.add(leftpanel06);
		
		JLabel transferremarklabel = new JLabel("备注:  ");	
		transferremark = new JTextField(transfer.getTransferremark());
		transferremark.setColumns(30);
		
		leftpanel06.add(transferremarklabel);
		leftpanel06.add(transferremark);
		
		
		/**************转移情况***************/
		JPanel leftpanel07 = new JPanel();	
		leftpanel.add(leftpanel07);
		
		JLabel transferstatuslabel = new JLabel("转移情况(必填):  ");	
		transferstatus = new JTextField(transfer.getTransferstatus());
		transferstatus.setColumns(30);
		
		leftpanel07.add(transferstatuslabel);
		leftpanel07.add(transferstatus);

		
		
		/**************记录状态***************/
		JPanel leftpanel08 = new JPanel();	
		leftpanel.add(leftpanel08);
		
		JLabel transferrecordisnewlabel = new JLabel("记录状态:  ");	
		transferrecordisnew = new JLabel(transfer.getTransferrecordisnew());
		
		leftpanel08.add(transferrecordisnewlabel);
		leftpanel08.add(transferrecordisnew);

		/**************出库凭证***************/
		
		JPanel leftpanel10 = new JPanel();
		rightpanel.add(leftpanel10, BorderLayout.NORTH);

		JLabel transfercertificatelabel = new JLabel("出库凭证(必填):  ");
		transfercertificate = new JTextField();
		transfercertificate.setColumns(30);

		JButton selectbutton = new JButton("选择");

		selectbutton.addActionListener(new ChooseImageActionListen(
				NewTransferPage.this));

		leftpanel10.add(transfercertificatelabel);
		leftpanel10.add(transfercertificate);
		leftpanel10.add(selectbutton);
		
		rightpanel01 = new JPanel();
		
		JScrollPane rightscroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		rightpanel01.setLayout(new BoxLayout(rightpanel01, BoxLayout.PAGE_AXIS));
		rightpanel.add(rightscroll, BorderLayout.CENTER);

		rightscroll.setViewportView(rightpanel01);

	}

	@Override
	public void packData() {
		// TODO Auto-generated method stub
		transfer = new Transfer();
		
		transfer.setAssetid(asset.getAssetid());
		transfer.setTransferid(Integer.parseInt(transferid.getText()));
		transfer.setTransferdepartment(transferdepartment.getText());
		transfer.setTransferdate(transferdate.getText());
		transfer.setTransferhandler(transferhandler.getText());
		transfer.setTransferremark(transferremark.getText());
		transfer.setTransferstatus(transferstatus.getText());
		transfer.setTransferrecordisnew(transferrecordisnew.getText());

	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		if(transferdepartment.getText().equals("")){
			
			return false;
			
		}else if(transferdate.getText().equals("")){
			
			return false;
			
		}else if(transferhandler.getText().equals("")){
			
			return false;
			
		}else if(transferstatus.getText().equals("")){
			
			return false;
			
		}else if(transfercertificate.getText().equals("")){
			
			return false;
			
		}else{
			
			return true;
			
		}
	}

	@Override
	public void setImagePath(String txt) {
		// TODO Auto-generated method stub
		transfercertificate.setText(txt);
	}

	@Override
	public void isEditable(boolean editable) {
		// TODO Auto-generated method stub
		
	}

}
