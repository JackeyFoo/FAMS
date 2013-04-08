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
import bll.controll.StrToFile;
import dal.model.Assets;
import dal.model.Discard;

import vl.interfaces.MyDialog;

public class NewDiscardPage extends MyDialog {

	/**
	 * Launch the application.
	 */
	private static final long serialVersionUID = 1L;

	private Discard discard;

	private JPanel contentpanel;
	private JPanel controlpanel;
	private JLabel assetid;
	private JLabel discardid;
	private JTextField discarddepartment;
	private JTextField discarddate;
	private JTextField discardreason;
	private JTextField discardcertificate;

	private JButton cancel;

	private JButton save;

	/**
	 * Create the dialog.
	 */
	public NewDiscardPage(JFrame jframe, Assets asset, Discard discard,
			boolean editable) {

		super(jframe, false);

		this.jframe = jframe;
		this.asset = asset;

		if (discard == null) {
			
			this.setTitle("设备报废");
			
			this.discard = new Discard();
			
		} else {

			if(editable){
				this.setTitle("资产报废编辑");
			}else{
				this.setTitle("资产报废详情");
			}

			this.discard = discard;
		
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
		contentpanel.setBorder(BorderFactory.createTitledBorder("报废信息"));

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
				NewDiscardPage.this.dispose();
			}

		});

		if(this.getTitle().equals("设备报废")){
			save.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if (isFull()) {

						packData();

						Controller.saveNewDiscardInfo(jframe, discard, files,
								NewDiscardPage.this);

					} else {
						JOptionPane.showMessageDialog(null, "请填写必要的数据", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
				}

			});
		}else if(this.getTitle().equals("资产报废编辑")){
			save.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if (isFull()) {

						packData();

						Controller.updateDiscardInfo(jframe, discard, files,
								NewDiscardPage.this);

					} else {
						JOptionPane.showMessageDialog(null, "请填写必要的数据", "ERROR",
								JOptionPane.ERROR_MESSAGE);
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

		JPanel rightpanel = new JPanel();
		rightpanel.setBorder(BorderFactory.createTitledBorder("报废凭证"));
		rightpanel.setLayout(new BorderLayout());

		contentpanel.add(leftpanel);
		contentpanel.add(rightpanel);

		/**************** 资产ID: *************/
		JPanel leftpanel01 = new JPanel();
		leftpanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		leftpanel.add(leftpanel01);

		JLabel assetidlabel = new JLabel("资产ID:  ");
		assetidlabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		assetid = new JLabel(asset.getFormatID());

		leftpanel01.add(assetidlabel);
		leftpanel01.add(assetid);

		/**************** 报废ID *************/
		JPanel leftpanel02 = new JPanel();
		leftpanel.add(leftpanel02);

		JLabel discardidlabel = new JLabel("报废ID(系统自动生成):  ");
		discardid = new JLabel(discard.getFormatID());

		leftpanel02.add(discardidlabel);
		leftpanel02.add(discardid);

		/*************** 报废部门 **************/
		JPanel leftpanel03 = new JPanel();
		leftpanel.add(leftpanel03);

		JLabel discarddepartmentlabel = new JLabel("报废部门(必填):  ");
		discarddepartment = new JTextField(discard.getDiscarddepartment());
		discarddepartment.setColumns(30);

		leftpanel03.add(discarddepartmentlabel);
		leftpanel03.add(discarddepartment);

		/************** 报废时间 ***************/
		JPanel leftpanel04 = new JPanel();
		leftpanel.add(leftpanel04);

		JLabel discarddatelabel = new JLabel("报废时间(必填):  ");
		discarddate = new JTextField(discard.getDiscarddate());
		discarddate.setColumns(30);

		leftpanel04.add(discarddatelabel);
		leftpanel04.add(discarddate);

		/**************** 报废原因 *************/
		JPanel leftpanel05 = new JPanel();
		leftpanel.add(leftpanel05);

		JLabel discardreasonlabel = new JLabel("报废原因(必填):  ");
		discardreason = new JTextField(discard.getDiscardreason());
		discardreason.setColumns(30);

		leftpanel05.add(discardreasonlabel);
		leftpanel05.add(discardreason);

		/************** 报废凭证 ***************/

		JPanel leftpanel10 = new JPanel();
		rightpanel.add(leftpanel10, BorderLayout.NORTH);

		JLabel discardcertificatelabel = new JLabel("报废凭证(必填):  ");
		discardcertificate = new JTextField();
		discardcertificate.setColumns(30);

		JButton selectbutton = new JButton("选择");

		selectbutton.addActionListener(new ChooseImageActionListen(
				NewDiscardPage.this));

		leftpanel10.add(discardcertificatelabel);
		leftpanel10.add(discardcertificate);
		leftpanel10.add(selectbutton);

		rightpanel01 = new JPanel();

		JScrollPane rightscroll = new JScrollPane(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		rightpanel01
				.setLayout(new BoxLayout(rightpanel01, BoxLayout.PAGE_AXIS));
		rightpanel.add(rightscroll, BorderLayout.CENTER);

		rightscroll.setViewportView(rightpanel01);

		addImageToPanel(StrToFile.filesAnalytical(
				discard.getDiscardcertificate(), "<"));
	}

	@Override
	public void packData() {
		// TODO Auto-generated method stub
		discard = new Discard();

		discard.setAssetid(asset.getAssetid());
		discard.setDiscardid(Integer.parseInt(discardid.getText()));
		discard.setDiscarddepartment(discarddepartment.getText());
		discard.setDiscarddate(discarddate.getText());
		discard.setDiscardreason(discardreason.getText());

	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		if (discarddepartment.getText().equals("")) {
			return false;
		} else if (discarddate.getText().equals("")) {
			return false;
		} else if (discardreason.getText().equals("")) {
			return false;
		} else if (discardcertificate.getText().equals("")) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void setImagePath(String txt) {
		// TODO Auto-generated method stub
		discardcertificate.setText(txt);
	}

	@Override
	public void isEditable(boolean editable) {
		// TODO Auto-generated method stub
		if(editable){


		}else{

			discarddepartment.setEditable(false);
			discarddate.setEditable(false);
			discardreason.setEditable(false);


			cancel.setText("确定");
			save.setVisible(false);
			leftpanel10.setVisible(false);
			addImageToPanel(StrToFile.filesAnalytical(discard.getDiscardcertificate(),"<"));


		}
	}

}
