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
import vl.interfaces.MyDialog;
import dal.model.Assets;
import dal.model.RentOut;

public class NewRentOutPage extends MyDialog {

	private RentOut rentout;

	private static final long serialVersionUID = 1L;

	private JPanel contentpanel;
	private JPanel controlpanel;
	private JLabel assetid;
	private JLabel rentoutid;
	private JTextField rentdepartment;
	private JTextField rentstaff;
	private JTextField rentdate;
	private JTextField forecastreturndate;
	private JTextField renthandler;
	private JTextField rentremark;
	private JLabel rentrecordisnew;
	private JTextField rentcertificate;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public NewRentOutPage(JFrame jframe, Assets asset, RentOut rentout,
			boolean editable) {

		super(jframe, "�ʲ����", false);

		this.jframe = jframe;
		this.asset = asset;

		if (rentout == null) {

			this.setTitle("�ʲ����");

			this.rentout = new RentOut();

		} else {

			if (editable) {
				this.setTitle("�ʲ�����༭");
			} else {
				this.setTitle("�ʲ��������");
			}

			this.rentout = rentout;
			;
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
		contentpanel.setBorder(BorderFactory.createTitledBorder("�����Ϣ"));

		add(contentpanel, BorderLayout.CENTER);

		controlpanel = new JPanel();

		add(controlpanel, BorderLayout.PAGE_END);

		initContentPanel();
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
				NewRentOutPage.this.dispose();
			}

		});

		if (this.getTitle().equals("�ʲ����")) {
			save.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if (isFull()) {

						packData();

						Controller.saveNewRentOutInfo(jframe, rentout, files,
								NewRentOutPage.this);

					} else {
						JOptionPane.showMessageDialog(null, "����д��Ҫ������",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}

			});
		} else if (this.getTitle().equals("�ʲ�����༭")) {
			save.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if (isFull()) {

						packData();

						Controller.updateRentOutInfo(jframe, rentout, files,
								NewRentOutPage.this);

					} else {
						JOptionPane.showMessageDialog(null, "����д��Ҫ������",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}

			});
		}
	}

	public void initContentPanel() {

		contentpanel.setLayout(new BoxLayout(contentpanel, BoxLayout.X_AXIS));

		JPanel leftpanel = new JPanel();
		leftpanel.setLayout(new BoxLayout(leftpanel, BoxLayout.Y_AXIS));

		JPanel rightpanel = new JPanel();
		rightpanel.setBorder(BorderFactory.createTitledBorder("���ƾ֤"));
		rightpanel.setLayout(new BorderLayout());

		contentpanel.add(leftpanel);
		contentpanel.add(rightpanel);

		/**************** �ʲ�ID: *************/
		JPanel leftpanel01 = new JPanel();
		leftpanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		leftpanel.add(leftpanel01);

		JLabel assetidlabel = new JLabel("�ʲ�ID:  ");
		assetidlabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		assetid = new JLabel(asset.getFormatID());

		leftpanel01.add(assetidlabel);
		leftpanel01.add(assetid);

		/**************** ���ID *************/
		JPanel leftpanel02 = new JPanel();
		leftpanel.add(leftpanel02);

		JLabel rentoutlabel = new JLabel("����ID(ϵͳ�Զ�����):  ");
		rentoutid = new JLabel(rentout.getFormatID());

		leftpanel02.add(rentoutlabel);
		leftpanel02.add(rentoutid);

		/*************** ���ò��� **************/
		JPanel leftpanel03 = new JPanel();
		leftpanel.add(leftpanel03);

		JLabel rentdepartmentlabel = new JLabel("���ò���(����):  ");
		rentdepartment = new JTextField(rentout.getRentdepartment());
		rentdepartment.setColumns(30);

		leftpanel03.add(rentdepartmentlabel);
		leftpanel03.add(rentdepartment);

		/************** ������ ***************/
		JPanel leftpanel04 = new JPanel();
		leftpanel.add(leftpanel04);

		JLabel rentstafflabel = new JLabel("������(����):  ");
		rentstaff = new JTextField(rentout.getRentstaff());
		rentstaff.setColumns(30);

		leftpanel04.add(rentstafflabel);
		leftpanel04.add(rentstaff);

		/**************** �������� *************/
		JPanel leftpanel05 = new JPanel();
		leftpanel.add(leftpanel05);

		JLabel rentdatelabel = new JLabel("��������(����):  ");
		rentdate = new JTextField(rentout.getRentdate());
		rentdate.setColumns(30);

		leftpanel05.add(rentdatelabel);
		leftpanel05.add(rentdate);

		/************** Ԥ�黹���� ***************/
		JPanel leftpanel06 = new JPanel();
		leftpanel.add(leftpanel06);

		JLabel forecastreturndatelabel = new JLabel("Ԥ�黹����(����):  ");
		forecastreturndate = new JTextField(rentout.getForecastreturndate());
		forecastreturndate.setColumns(30);

		leftpanel06.add(forecastreturndatelabel);
		leftpanel06.add(forecastreturndate);

		/************** ������ ***************/
		JPanel leftpanel07 = new JPanel();
		leftpanel.add(leftpanel07);

		JLabel renthandlerlabel = new JLabel("������(����):  ");
		renthandler = new JTextField(rentout.getRenthandler());
		renthandler.setColumns(30);

		leftpanel07.add(renthandlerlabel);
		leftpanel07.add(renthandler);

		/************** ��ע ***************/
		JPanel leftpanel08 = new JPanel();
		leftpanel.add(leftpanel08);

		JLabel rentremarklabel = new JLabel("��ע:  ");
		rentremark = new JTextField(rentout.getRentremark());
		rentremark.setColumns(30);

		leftpanel08.add(rentremarklabel);
		leftpanel08.add(rentremark);

		/************** ��¼״̬ ***************/
		JPanel leftpanel09 = new JPanel();
		leftpanel.add(leftpanel09);

		JLabel rentrecordisnewlabel = new JLabel("��¼״̬:  ");
		rentrecordisnew = new JLabel(rentout.getRentrecordisnew());

		leftpanel09.add(rentrecordisnewlabel);
		leftpanel09.add(rentrecordisnew);

		/************** ����ƾ֤ ***************/

		leftpanel10 = new JPanel();
		rightpanel.add(leftpanel10, BorderLayout.NORTH);

		JLabel rentcertificatelabel = new JLabel("����ƾ֤(����):  ");
		rentcertificate = new JTextField();
		rentcertificate.setColumns(30);

		JButton selectbutton = new JButton("ѡ��");

		selectbutton.addActionListener(new ChooseImageActionListen(
				NewRentOutPage.this));

		leftpanel10.add(rentcertificatelabel);
		leftpanel10.add(rentcertificate);
		leftpanel10.add(selectbutton);

		rightpanel01 = new JPanel();

		JScrollPane rightscroll = new JScrollPane(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		rightpanel01
				.setLayout(new BoxLayout(rightpanel01, BoxLayout.PAGE_AXIS));
		rightpanel.add(rightscroll, BorderLayout.CENTER);

		rightscroll.setViewportView(rightpanel01);

		addImageToPanel(StrToFile.filesAnalytical(rentout.getRentcertificate(),
				"<"));
	}

	@Override
	public void packData() {
		// TODO Auto-generated method stub
		rentout = new RentOut();

		rentout.setAssetid(asset.getAssetid());
		rentout.setRentoutid(Integer.parseInt(rentoutid.getText()));
		rentout.setRentdepartment(rentdepartment.getText());
		rentout.setRentstaff(rentstaff.getText());
		rentout.setRentdate(rentdate.getText());
		rentout.setForecastreturndate(forecastreturndate.getText());
		rentout.setRenthandler(renthandler.getText());
		rentout.setRentremark(rentremark.getText());
		rentout.setRentrecordisnew(rentrecordisnew.getText());
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub

		if (rentdepartment.getText().equals("")) {
			return false;
		} else if (rentstaff.getText().equals("")) {
			return false;
		} else if (rentdate.getText().equals("")) {
			return false;
		} else if (forecastreturndate.getText().equals("")) {
			return false;
		} else if (renthandler.getText().equals("")) {
			return false;
		} else if (rentcertificate.getText().equals("")) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void setImagePath(String txt) {
		// TODO Auto-generated method stub
		rentcertificate.setText(txt);
	}

	@Override
	public void isEditable(boolean editable) {
		// TODO Auto-generated method stub
		if (editable) {

		} else {

			rentdepartment.setEditable(false);
			rentstaff.setEditable(false);
			rentdate.setEditable(false);
			forecastreturndate.setEditable(false);
			renthandler.setEditable(false);
			rentremark.setEditable(false);
			rentcertificate.setEditable(false);

			cancel.setText("ȷ��");
			save.setVisible(false);
			leftpanel10.setVisible(false);

		}
	}
}
