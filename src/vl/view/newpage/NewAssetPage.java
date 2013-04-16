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

			this.setTitle("添加资产");

			asset = new Assets();

		} else {

			if (editable) {
				this.setTitle("资产编辑");
			} else {
				this.setTitle("资产详情");
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
		contentpanel.setBorder(BorderFactory.createTitledBorder("资产信息"));

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
				NewAssetPage.this.dispose();
			}

		});

		if (this.getTitle().equals("添加资产")) {

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

		} else if (this.getTitle().equals("资产编辑")) {

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
		rightpanel.setBorder(BorderFactory.createTitledBorder("合同"));
		rightpanel.setLayout(new BorderLayout());

		contentpanel.add(leftpanel);
		contentpanel.add(rightpanel);

		/**************** 资产ID: *************/
		JPanel leftpanel01 = new JPanel();
		leftpanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		leftpanel.add(leftpanel01);

		JLabel idlabel = new JLabel("资产ID(系统自动生成):  ");
		assetid = new JLabel(asset.getFormatAssetid());

		leftpanel01.add(idlabel);
		leftpanel01.add(assetid);

		/*************** 资产类型 **************/
		JPanel leftpanel02 = new JPanel();
		leftpanel.add(leftpanel02);

		JLabel typelabel = new JLabel("资产类型(必填):  ");
		assettype = new JTextField(asset.getAssettype());
		assettype.setColumns(30);

		leftpanel02.add(typelabel);
		leftpanel02.add(assettype);

		/************** 资产名称 ***************/
		JPanel leftpanel03 = new JPanel();
		leftpanel.add(leftpanel03);

		JLabel namelabel = new JLabel("资产名称(必填):  ");
		assetname = new JTextField(asset.getAssetname());
		assetname.setColumns(30);

		leftpanel03.add(namelabel);
		leftpanel03.add(assetname);

		/**************** 资产品牌 *************/
		JPanel leftpanel04 = new JPanel();
		leftpanel.add(leftpanel04);

		JLabel brandlabel = new JLabel("资产品牌(必填):  ");
		assetbrand = new JTextField(asset.getAssetbrand());
		assetbrand.setColumns(30);

		leftpanel04.add(brandlabel);
		leftpanel04.add(assetbrand);

		/**************** 资产型号 *************/
		JPanel leftpanel05 = new JPanel();
		leftpanel.add(leftpanel05);

		JLabel modellabel = new JLabel("资产型号(必填):  ");
		assetmodel = new JTextField(asset.getAssetmodel());
		assetmodel.setColumns(30);

		leftpanel05.add(modellabel);
		leftpanel05.add(assetmodel);

		/************** 资产机号 ***************/
		JPanel leftpanel06 = new JPanel();
		leftpanel.add(leftpanel06);

		JLabel nolabel = new JLabel("资产机号(必填):  ");
		assetno = new JTextField(asset.getAssetno() + "");
		assetno.setColumns(30);

		leftpanel06.add(nolabel);
		leftpanel06.add(assetno);

		/************** 购入日期 ***************/
		JPanel leftpanel07 = new JPanel();
		leftpanel.add(leftpanel07);

		JLabel datelabel = new JLabel("购入日期(必填):  ");
		assetpurchasedate = new JTextField(asset.getAssetpurchasedate());
		assetpurchasedate.setColumns(30);

		leftpanel07.add(datelabel);
		leftpanel07.add(assetpurchasedate);

		/************** 资产生产商 ***************/
		JPanel leftpanel08 = new JPanel();
		leftpanel.add(leftpanel08);

		JLabel manufacturerlabel = new JLabel("资产生产商(必填):");
		assetmanufacturer = new JTextField(asset.getAssetManufacturer());
		assetmanufacturer.setColumns(30);

		leftpanel08.add(manufacturerlabel);
		leftpanel08.add(assetmanufacturer);

		/************** 资产经销商 ***************/
		JPanel leftpanel09 = new JPanel();
		leftpanel.add(leftpanel09);

		JLabel dealerlabel = new JLabel("资产经销商(必填):");
		assetdealer = new JTextField(asset.getAssetdealer());
		assetdealer.setColumns(30);

		leftpanel09.add(dealerlabel);
		leftpanel09.add(assetdealer);

		/************** 资产位置状态 ***************/
		JPanel leftpanel11 = new JPanel();
		leftpanel.add(leftpanel11);

		JLabel instatuslabel = new JLabel("资产位置状态:  ");
		assetindeliverstatus = new JLabel(asset.getAssetindeliverstatus());

		leftpanel11.add(instatuslabel);
		leftpanel11.add(assetindeliverstatus);

		/************** 资产运行状况 ***************/
		JPanel leftpanel12 = new JPanel();
		leftpanel.add(leftpanel12);

		JLabel runningstatuslabel = new JLabel("资产运行状况:  ");
		assetrunningstatus = new JLabel(asset.getAssetrunningstatus());

		leftpanel12.add(runningstatuslabel);
		leftpanel12.add(assetrunningstatus);

		/************** 合同信息 ***************/

		leftpanel10 = new JPanel();
		rightpanel.add(leftpanel10, BorderLayout.NORTH);

		JLabel contractlabel = new JLabel("合同信息:  ");
		assetcontract = new JTextField();
		assetcontract.setColumns(30);

		JButton selectbutton = new JButton("选择");

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

			cancel.setText("确定");
			save.setVisible(false);
			leftpanel10.setVisible(false);

		}

	}

}
