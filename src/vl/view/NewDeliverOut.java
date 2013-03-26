package vl.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
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

	public NewDeliverOut(JFrame jframe) {

		super(jframe, "设备出库", false);

		setResizable(false);
		setSize(800, 500);
		setLocation(200, 150);
		setVisible(true);
		setLayout(new BorderLayout());
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
		
		//kkkkkkkkkk
		
		/****************资产ID:*************/
		JPanel leftpanel01 = new JPanel();	
		leftpanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		leftpanel.add(leftpanel01);
		
		JLabel idlabel = new JLabel("资产ID:  ");
		idlabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		JLabel assetid = new JLabel("系统自动生成");
		
		leftpanel01.add(idlabel);
		leftpanel01.add(assetid);
		
		/****************出库ID*************/
		JPanel leftpanel05 = new JPanel();	
		leftpanel.add(leftpanel05);
		
		JLabel modellabel = new JLabel("出库ID:  ");	
		JTextField assetmodel = new JTextField("自动生成");
		assetmodel.setColumns(30);
		
		leftpanel05.add(modellabel);
		leftpanel05.add(assetmodel);
		
		/***************领用部门**************/
		JPanel leftpanel02 = new JPanel();	
		leftpanel.add(leftpanel02);
		
		JLabel typelabel = new JLabel("领用部门:  ");	
		JTextField assettype = new JTextField();
		assettype.setColumns(30);
		
		leftpanel02.add(typelabel);
		leftpanel02.add(assettype);
		
		/**************领用人***************/
		JPanel leftpanel03 = new JPanel();	
		leftpanel.add(leftpanel03);
		
		JLabel namelabel = new JLabel("领用人:  ");	
		JTextField assetname = new JTextField();
		assetname.setColumns(30);
		
		leftpanel03.add(namelabel);
		leftpanel03.add(assetname);
		
		/****************领用日期*************/
		JPanel leftpanel04 = new JPanel();	
		leftpanel.add(leftpanel04);
		
		JLabel brandlabel = new JLabel("领用日期:  ");	
		JTextField assetbrand = new JTextField("抓取系统时间");
		assetbrand.setColumns(30);
		
		leftpanel04.add(brandlabel);
		leftpanel04.add(assetbrand);
		

		
		/**************存在地址***************/
		JPanel leftpanel06 = new JPanel();	
		leftpanel.add(leftpanel06);
		
		JLabel nolabel = new JLabel("存在地址:  ");	
		JTextField assetno = new JTextField();
		assetno.setColumns(30);
		
		leftpanel06.add(nolabel);
		leftpanel06.add(assetno);
		
		
		/**************归还人员***************/
		JPanel leftpanel09 = new JPanel();	
		leftpanel.add(leftpanel09);
		
		JLabel dealerlabel = new JLabel("归还人员:  ");	
		JTextField assetdealer = new JTextField();
		assetdealer.setColumns(30);
		
		leftpanel09.add(dealerlabel);
		leftpanel09.add(assetdealer);
		
		
		/**************归还日期***************/
		JPanel leftpanel07 = new JPanel();	
		leftpanel.add(leftpanel07);
		
		JLabel datelabel = new JLabel("归还日期:  ");	
		JTextField assetpurchasedate = new JTextField("抓取系统时间");
		assetpurchasedate.setColumns(30);
		
		leftpanel07.add(datelabel);
		leftpanel07.add(assetpurchasedate);
		
		/**************备注***************/
		JPanel leftpanel08 = new JPanel();	
		leftpanel.add(leftpanel08);
		
		JLabel manufacturerlabel = new JLabel("备注:  ");	
		JTextField assetmanufacturer = new JTextField();
		assetmanufacturer.setColumns(30);
		
		leftpanel08.add(manufacturerlabel);
		leftpanel08.add(assetmanufacturer);
		

		
		/**************记录状态***************/
		JPanel leftpanel11 = new JPanel();	
		leftpanel.add(leftpanel11);
		
		JLabel instatuslabel = new JLabel("记录状态状态:  ");	
		JLabel assetindeliverstatus = new JLabel("new or not");
		
		leftpanel11.add(instatuslabel);
		leftpanel11.add(assetindeliverstatus);
		
		

		/**************出库凭证***************/
		
		JPanel leftpanel10 = new JPanel();	
		rightpanel.add(leftpanel10);
		
		JLabel contractlabel = new JLabel("出库凭证:  ");	
		JTextField assetcontract = new JTextField();
		assetcontract.setColumns(30);
		
		leftpanel10.add(contractlabel);
		leftpanel10.add(assetcontract);

	}
	


}
