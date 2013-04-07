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

		super(jframe, "�豸ת��", false);

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
		contentpanel.setBorder(BorderFactory.createTitledBorder("ת����Ϣ"));

		add(contentpanel, BorderLayout.CENTER);

		controlpanel = new JPanel();

		add(controlpanel, BorderLayout.PAGE_END);

		initContentPanel();
		initControlPanel();
	}

	public void initControlPanel() {

		JButton save = new JButton("����");
		JButton cancel = new JButton("ȡ��");

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
					JOptionPane.showMessageDialog(null, "����д��Ҫ������", "ERROR",
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
		rightpanel.setBorder(BorderFactory.createTitledBorder("ת��ƾ֤"));
		rightpanel.setLayout(new BorderLayout());

		contentpanel.add(leftpanel);
		contentpanel.add(rightpanel);

		/****************�ʲ�ID:*************/
		JPanel leftpanel01 = new JPanel();	
		leftpanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		leftpanel.add(leftpanel01);
		
		JLabel assetidlabel = new JLabel("�ʲ�ID:  ");
		assetidlabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		assetid = new JLabel(asset.getFormatID());
		
		leftpanel01.add(assetidlabel);
		leftpanel01.add(assetid);
		
		/****************ת��ID*************/
		JPanel leftpanel02 = new JPanel();	
		leftpanel.add(leftpanel02);
		
		JLabel transferidlabel = new JLabel("����ID(ϵͳ�Զ�����):  ");	
		transferid = new JLabel(transfer.getFormatID());
		
		leftpanel02.add(transferidlabel);
		leftpanel02.add(transferid);
		
		/***************ת�Ʋ���**************/
		JPanel leftpanel03 = new JPanel();	
		leftpanel.add(leftpanel03);
		
		JLabel transferdepartmentlabel = new JLabel("ת�Ʋ���(����):  ");	
		transferdepartment = new JTextField(transfer.getTransferdepartment());
		transferdepartment.setColumns(30);
		
		leftpanel03.add(transferdepartmentlabel);
		leftpanel03.add(transferdepartment);
		
		/**************ת������***************/
		JPanel leftpanel04 = new JPanel();	
		leftpanel.add(leftpanel04);
		
		JLabel transferdatelabel = new JLabel("ת������(����):  ");	
		transferdate = new JTextField(transfer.getTransferdate());
		transferdate.setColumns(30);
		
		leftpanel04.add(transferdatelabel);
		leftpanel04.add(transferdate);
		
		/****************������*************/
		JPanel leftpanel05 = new JPanel();	
		leftpanel.add(leftpanel05);
		
		JLabel transferhandlerlabel = new JLabel("������(����):  ");	
		transferhandler = new JTextField(transfer.getTransferhandler());
		transferhandler.setColumns(30);
		
		leftpanel05.add(transferhandlerlabel);
		leftpanel05.add(transferhandler);
		
		
		/**************��ע***************/
		JPanel leftpanel06 = new JPanel();	
		leftpanel.add(leftpanel06);
		
		JLabel transferremarklabel = new JLabel("��ע:  ");	
		transferremark = new JTextField(transfer.getTransferremark());
		transferremark.setColumns(30);
		
		leftpanel06.add(transferremarklabel);
		leftpanel06.add(transferremark);
		
		
		/**************ת�����***************/
		JPanel leftpanel07 = new JPanel();	
		leftpanel.add(leftpanel07);
		
		JLabel transferstatuslabel = new JLabel("ת�����(����):  ");	
		transferstatus = new JTextField(transfer.getTransferstatus());
		transferstatus.setColumns(30);
		
		leftpanel07.add(transferstatuslabel);
		leftpanel07.add(transferstatus);

		
		
		/**************��¼״̬***************/
		JPanel leftpanel08 = new JPanel();	
		leftpanel.add(leftpanel08);
		
		JLabel transferrecordisnewlabel = new JLabel("��¼״̬:  ");	
		transferrecordisnew = new JLabel(transfer.getTransferrecordisnew());
		
		leftpanel08.add(transferrecordisnewlabel);
		leftpanel08.add(transferrecordisnew);

		/**************����ƾ֤***************/
		
		JPanel leftpanel10 = new JPanel();
		rightpanel.add(leftpanel10, BorderLayout.NORTH);

		JLabel transfercertificatelabel = new JLabel("����ƾ֤(����):  ");
		transfercertificate = new JTextField();
		transfercertificate.setColumns(30);

		JButton selectbutton = new JButton("ѡ��");

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
