package vl.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewDeliverOut extends JDialog {

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	
	private static final long serialVersionUID = 1L;

	private JPanel contentpanel;
	private JPanel controlpanel;

	public NewDeliverOut() {

		super();

		setResizable(false);
		setTitle("设备出库");
		setSize(800, 500);
		setLocation(200, 150);
		setVisible(true);
		setLayout(new BorderLayout());
		setAlwaysOnTop(true);
		initDialog();

		setVisible(true);
	}

	void initDialog() {

		contentpanel = new JPanel(); 
		contentpanel.setBorder(BorderFactory.createTitledBorder("出库信息"));
		
		add(contentpanel, BorderLayout.CENTER);
		
		controlpanel = new JPanel();
		
		add(controlpanel, BorderLayout.PAGE_END);

		initContentPanel();
		initControlPanel();
	}
	
	void initControlPanel(){
		
		JButton save = new JButton("保存");
		JButton cancel = new JButton("取消");
		
		controlpanel.add(save);
		controlpanel.add(cancel);
		
		cancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				NewDeliverOut.this.dispose();
			}
			
		});
	}
	
	void initContentPanel(){
		
		contentpanel.setLayout(new BoxLayout(contentpanel, BoxLayout.X_AXIS));
		
		JPanel leftpanel = new JPanel();
		leftpanel.setLayout(new BoxLayout(leftpanel, BoxLayout.Y_AXIS));
		
		JPanel rightpanel = new JPanel();
		rightpanel.setBorder(BorderFactory.createTitledBorder("出库凭证"));		
		
		contentpanel.add(leftpanel);
		contentpanel.add(rightpanel);
		
		
		
		/****************资产ID:*************/
		JPanel leftpanel01 = new JPanel();	
		leftpanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		leftpanel.add(leftpanel01);
		
		JLabel idlabel = new JLabel("资产ID:  ");		
		JLabel assetid = new JLabel("系统自动生成");
		
		leftpanel01.add(idlabel);
		leftpanel01.add(assetid);
		
		/***************资产类型**************/
		JPanel leftpanel02 = new JPanel();	
		leftpanel.add(leftpanel02);
		
		JLabel typelabel = new JLabel("资产类型:  ");	
		JTextField assettype = new JTextField();
		assettype.setColumns(30);
		
		leftpanel02.add(typelabel);
		leftpanel02.add(assettype);
		
		/**************资产名称***************/
		JPanel leftpanel03 = new JPanel();	
		leftpanel.add(leftpanel03);
		
		JLabel namelabel = new JLabel("资产名称:  ");	
		JTextField assetname = new JTextField();
		assetname.setColumns(30);
		
		leftpanel03.add(namelabel);
		leftpanel03.add(assetname);
		
		/****************资产品牌*************/
		JPanel leftpanel04 = new JPanel();	
		leftpanel.add(leftpanel04);
		
		JLabel brandlabel = new JLabel("资产品牌:  ");	
		JTextField assetbrand = new JTextField();
		assetbrand.setColumns(30);
		
		leftpanel04.add(brandlabel);
		leftpanel04.add(assetbrand);
		
		/****************资产型号*************/
		JPanel leftpanel05 = new JPanel();	
		leftpanel.add(leftpanel05);
		
		JLabel modellabel = new JLabel("资产型号:  ");	
		JTextField assetmodel = new JTextField();
		assetmodel.setColumns(30);
		
		leftpanel05.add(modellabel);
		leftpanel05.add(assetmodel);
		
		/**************资产机号***************/
		JPanel leftpanel06 = new JPanel();	
		leftpanel.add(leftpanel06);
		
		JLabel nolabel = new JLabel("资产机号:  ");	
		JTextField assetno = new JTextField();
		assetno.setColumns(30);
		
		leftpanel06.add(nolabel);
		leftpanel06.add(assetno);
		
		/**************购入日期***************/
		JPanel leftpanel07 = new JPanel();	
		leftpanel.add(leftpanel07);
		
		JLabel datelabel = new JLabel("购入日期:  ");	
		JTextField assetpurchasedate = new JTextField();
		assetpurchasedate.setColumns(30);
		
		leftpanel07.add(datelabel);
		leftpanel07.add(assetpurchasedate);
		
		/**************资产生产商***************/
		JPanel leftpanel08 = new JPanel();	
		leftpanel.add(leftpanel08);
		
		JLabel manufacturerlabel = new JLabel("资产生产商:  ");	
		JTextField assetmanufacturer = new JTextField();
		assetmanufacturer.setColumns(30);
		
		leftpanel08.add(manufacturerlabel);
		leftpanel08.add(assetmanufacturer);
		
		
		/**************资产经销商***************/
		JPanel leftpanel09 = new JPanel();	
		leftpanel.add(leftpanel09);
		
		JLabel dealerlabel = new JLabel("资产经销商:  ");	
		JTextField assetdealer = new JTextField();
		assetdealer.setColumns(30);
		
		leftpanel09.add(dealerlabel);
		leftpanel09.add(assetdealer);
		
		
		/**************资产位置状态***************/
		JPanel leftpanel11 = new JPanel();	
		leftpanel.add(leftpanel11);
		
		JLabel instatuslabel = new JLabel("资产位置状态:  ");	
		JLabel assetindeliverstatus = new JLabel("库中");
		
		leftpanel11.add(instatuslabel);
		leftpanel11.add(assetindeliverstatus);
		
		
		/**************资产运行状况***************/
		JPanel leftpanel12 = new JPanel();	
		leftpanel.add(leftpanel12);
		
		JLabel runningstatuslabel = new JLabel("资产运行状况:  ");	
		JLabel assetrunningstatus = new JLabel("正常");
		
		leftpanel12.add(runningstatuslabel);
		leftpanel12.add(assetrunningstatus);
		

		/**************合同信息***************/
		
		JPanel leftpanel10 = new JPanel();	
		rightpanel.add(leftpanel10);
		
		JLabel contractlabel = new JLabel("合同信息:  ");	
		JTextField assetcontract = new JTextField();
		assetcontract.setColumns(30);
		
		leftpanel10.add(contractlabel);
		leftpanel10.add(assetcontract);

	}
	


}
