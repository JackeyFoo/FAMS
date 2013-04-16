package vl.view.newpage;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import vl.interfaces.MyDialog;
import vl.interfaces.MyJFrame;
import vl.util.NWEDialog;
import dal.model.Assets;
import bll.controll.ChooseImageActionListen;
import bll.controll.Controller;
import bll.controll.StrToFile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewAssetPage extends MyDialog {

	private JLabel assetid;
	private JTextField assettype;
	private JTextField assetname;
	private JTextField assetbrand;
	private JTextField assetmodel;
	private JTextField assetno;
	private JTextField assetpurchasedate;
	private JTextField assetmanufacturer;
	private JTextField assetdealer;
	private JLabel assetindeliverstatus;
	private JLabel assetrunningstatus;
	private JTextField assetcontract;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NewAssetPage(MyJFrame jframe, Assets a, boolean editable) {

		super(jframe, false);

		if (a == null) {

			this.setTitle("����ʲ�");

			asset = new Assets();

		} else {

			if (editable) {
				this.setTitle("�ʲ��༭");
			} else {
				this.setTitle("�ʲ�����");
			}

			asset = a;
		}

		this.jframe = jframe;

		setResizable(false);
		setSize(800, 500);
		setLocation(200, 150);
		setVisible(true);
		setLayout(new BorderLayout());
		initDialog();
		isEditable(editable);
		setVisible(true);

	}

	public void initDialog() {

		contentpanel = new JPanel();
		contentpanel.setBorder(BorderFactory.createTitledBorder("�ʲ���Ϣ"));

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
				NewAssetPage.this.dispose();
			}

		});

		if (this.getTitle().equals("����ʲ�")) {

			save.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if (isFull()) {

						packData();

						Controller.saveNewAssetInfo(jframe, asset, files,
								NewAssetPage.this);

					} else {
						NWEDialog.necessaryDataError(NewAssetPage.this);
					}
				}

			});

		} else if (this.getTitle().equals("�ʲ��༭")) {

			save.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if (isFull()) {

						packData();

						Controller.updateAssetInfo(jframe, asset, files,
								NewAssetPage.this);

					} else {
						NWEDialog.necessaryDataError(NewAssetPage.this);
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
		rightpanel.setBorder(BorderFactory.createTitledBorder("��ͬ"));
		rightpanel.setLayout(new BorderLayout());

		contentpanel.add(leftpanel);
		contentpanel.add(rightpanel);

		/**************** �ʲ�ID: *************/
		JPanel leftpanel01 = new JPanel();
		leftpanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		leftpanel.add(leftpanel01);

		JLabel idlabel = new JLabel("�ʲ�ID(ϵͳ�Զ�����):  ");
		assetid = new JLabel(asset.getFormatAssetid());

		leftpanel01.add(idlabel);
		leftpanel01.add(assetid);

		/*************** �ʲ����� **************/
		JPanel leftpanel02 = new JPanel();
		leftpanel.add(leftpanel02);

		JLabel typelabel = new JLabel("�ʲ�����(����):  ");
		assettype = new JTextField(asset.getAssettype());
		assettype.setColumns(30);

		leftpanel02.add(typelabel);
		leftpanel02.add(assettype);

		/************** �ʲ����� ***************/
		JPanel leftpanel03 = new JPanel();
		leftpanel.add(leftpanel03);

		JLabel namelabel = new JLabel("�ʲ�����(����):  ");
		assetname = new JTextField(asset.getAssetname());
		assetname.setColumns(30);

		leftpanel03.add(namelabel);
		leftpanel03.add(assetname);

		/**************** �ʲ�Ʒ�� *************/
		JPanel leftpanel04 = new JPanel();
		leftpanel.add(leftpanel04);

		JLabel brandlabel = new JLabel("�ʲ�Ʒ��(����):  ");
		assetbrand = new JTextField(asset.getAssetbrand());
		assetbrand.setColumns(30);

		leftpanel04.add(brandlabel);
		leftpanel04.add(assetbrand);

		/**************** �ʲ��ͺ� *************/
		JPanel leftpanel05 = new JPanel();
		leftpanel.add(leftpanel05);

		JLabel modellabel = new JLabel("�ʲ��ͺ�(����):  ");
		assetmodel = new JTextField(asset.getAssetmodel());
		assetmodel.setColumns(30);

		leftpanel05.add(modellabel);
		leftpanel05.add(assetmodel);

		/************** �ʲ����� ***************/
		JPanel leftpanel06 = new JPanel();
		leftpanel.add(leftpanel06);

		JLabel nolabel = new JLabel("�ʲ�����(����):  ");
		assetno = new JTextField(asset.getAssetno() + "");
		assetno.setColumns(30);

		leftpanel06.add(nolabel);
		leftpanel06.add(assetno);

		/************** �������� ***************/
		JPanel leftpanel07 = new JPanel();
		leftpanel.add(leftpanel07);

		JLabel datelabel = new JLabel("��������(����):  ");
		assetpurchasedate = new JTextField(asset.getAssetpurchasedate());
		assetpurchasedate.setColumns(30);

		leftpanel07.add(datelabel);
		leftpanel07.add(assetpurchasedate);

		/************** �ʲ������� ***************/
		JPanel leftpanel08 = new JPanel();
		leftpanel.add(leftpanel08);

		JLabel manufacturerlabel = new JLabel("�ʲ�������(����):");
		assetmanufacturer = new JTextField(asset.getAssetManufacturer());
		assetmanufacturer.setColumns(30);

		leftpanel08.add(manufacturerlabel);
		leftpanel08.add(assetmanufacturer);

		/************** �ʲ������� ***************/
		JPanel leftpanel09 = new JPanel();
		leftpanel.add(leftpanel09);

		JLabel dealerlabel = new JLabel("�ʲ�������(����):");
		assetdealer = new JTextField(asset.getAssetdealer());
		assetdealer.setColumns(30);

		leftpanel09.add(dealerlabel);
		leftpanel09.add(assetdealer);

		/************** �ʲ�λ��״̬ ***************/
		JPanel leftpanel11 = new JPanel();
		leftpanel.add(leftpanel11);

		JLabel instatuslabel = new JLabel("�ʲ�λ��״̬:  ");
		assetindeliverstatus = new JLabel(asset.getAssetindeliverstatus());

		leftpanel11.add(instatuslabel);
		leftpanel11.add(assetindeliverstatus);

		/************** �ʲ�����״�� ***************/
		JPanel leftpanel12 = new JPanel();
		leftpanel.add(leftpanel12);

		JLabel runningstatuslabel = new JLabel("�ʲ�����״��:  ");
		assetrunningstatus = new JLabel(asset.getAssetrunningstatus());

		leftpanel12.add(runningstatuslabel);
		leftpanel12.add(assetrunningstatus);

		/************** ��ͬ��Ϣ ***************/

		leftpanel10 = new JPanel();
		rightpanel.add(leftpanel10, BorderLayout.NORTH);

		JLabel contractlabel = new JLabel("��ͬ��Ϣ:  ");
		assetcontract = new JTextField();
		assetcontract.setColumns(30);

		JButton selectbutton = new JButton("ѡ��");

		selectbutton.addActionListener(new ChooseImageActionListen(
				NewAssetPage.this));

		leftpanel10.add(contractlabel);
		leftpanel10.add(assetcontract);
		leftpanel10.add(selectbutton);

		rightpanel01 = new JPanel();

		JScrollPane rightscroll = new JScrollPane(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		rightpanel01
				.setLayout(new BoxLayout(rightpanel01, BoxLayout.PAGE_AXIS));
		rightpanel.add(rightscroll, BorderLayout.CENTER);

		rightscroll.setViewportView(rightpanel01);

		addImageToPanel(StrToFile
				.filesAnalytical(asset.getAssetcontract(), "<"));

	}

	public void packData() {

		asset.setAssetid(Integer.parseInt(assetid.getText()));
		asset.setAssettype(assettype.getText());
		asset.setAssetname(assetname.getText());
		asset.setAssetbrand(assetbrand.getText());
		asset.setAssetmodel(assetmodel.getText());
		asset.setAssetno(Integer.parseInt(assetno.getText()));
		asset.setAssetpurchasedate(assetpurchasedate.getText());
		asset.setAssetManufacturer(assetmanufacturer.getText());
		asset.setAssetdealer(assetdealer.getText());
		asset.setAssetindeliverstatus(assetindeliverstatus.getText());
		asset.setAssetrunningstatus(assetrunningstatus.getText());

	}

	public boolean isFull() {
		if (assettype.getText().equals("")) {
			return false;
		} else if (assetname.getText().equals("")) {
			return false;
		} else if (assetbrand.getText().equals("")) {
			return false;
		} else if (assetmodel.getText().equals("")) {
			return false;
		} else if (assetno.getText().equals("")) {
			return false;
		} else if (assetpurchasedate.getText().equals("")) {
			return false;
		} else if (assetmanufacturer.getText().equals("")) {
			return false;
		} else if (assetdealer.getText().equals("")) {
			return false;
		} else if (assetindeliverstatus.getText().equals("")) {
			return false;
		} else if (assetrunningstatus.getText().equals("")) {
			return false;
		} else {

			if (!assetno.getText().equals("")) {

				try {
					Integer.parseInt(assetno.getText());

					return true;
				} catch (Exception o) {
					NWEDialog.inputError(NewAssetPage.this);
					return false;
				}
			}
			return true;
		}
	}

	@Override
	public void setImagePath(String txt) {
		// TODO Auto-generated method stub
		assetcontract.setText(txt);
	}

	@Override
	public void isEditable(boolean editablejudge) {
		// TODO Auto-generated method stub
		if (editablejudge) {

		} else {

			assettype.setEditable(false);
			assetname.setEditable(false);
			assetbrand.setEditable(false);
			assetmodel.setEditable(false);
			assetno.setEditable(false);
			assetpurchasedate.setEditable(false);
			assetmanufacturer.setEditable(false);
			assetdealer.setEditable(false);

			cancel.setText("ȷ��");
			save.setVisible(false);
			leftpanel10.setVisible(false);

		}

	}

}
