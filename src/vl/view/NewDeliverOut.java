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

		super(jframe, "�豸����", false);

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
		contentpanel.setBorder(BorderFactory.createTitledBorder("������Ϣ"));
		
		add(contentpanel, BorderLayout.CENTER);
		
		controlpanel = new JPanel();
		
		add(controlpanel, BorderLayout.PAGE_END);

		initContentPanel();
		initControlPanel();
	}
	
	void initControlPanel(){
		
		JButton save = new JButton("����");
		JButton cancel = new JButton("ȡ��");
		
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
		rightpanel.setBorder(BorderFactory.createTitledBorder("����ƾ֤"));		
		
		contentpanel.add(leftpanel);
		contentpanel.add(rightpanel);
		
		//kkkkkkkkkk
		
		/****************�ʲ�ID:*************/
		JPanel leftpanel01 = new JPanel();	
		leftpanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		leftpanel.add(leftpanel01);
		
		JLabel idlabel = new JLabel("�ʲ�ID:  ");
		idlabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		JLabel assetid = new JLabel("ϵͳ�Զ�����");
		
		leftpanel01.add(idlabel);
		leftpanel01.add(assetid);
		
		/****************����ID*************/
		JPanel leftpanel05 = new JPanel();	
		leftpanel.add(leftpanel05);
		
		JLabel modellabel = new JLabel("����ID:  ");	
		JTextField assetmodel = new JTextField("�Զ�����");
		assetmodel.setColumns(30);
		
		leftpanel05.add(modellabel);
		leftpanel05.add(assetmodel);
		
		/***************���ò���**************/
		JPanel leftpanel02 = new JPanel();	
		leftpanel.add(leftpanel02);
		
		JLabel typelabel = new JLabel("���ò���:  ");	
		JTextField assettype = new JTextField();
		assettype.setColumns(30);
		
		leftpanel02.add(typelabel);
		leftpanel02.add(assettype);
		
		/**************������***************/
		JPanel leftpanel03 = new JPanel();	
		leftpanel.add(leftpanel03);
		
		JLabel namelabel = new JLabel("������:  ");	
		JTextField assetname = new JTextField();
		assetname.setColumns(30);
		
		leftpanel03.add(namelabel);
		leftpanel03.add(assetname);
		
		/****************��������*************/
		JPanel leftpanel04 = new JPanel();	
		leftpanel.add(leftpanel04);
		
		JLabel brandlabel = new JLabel("��������:  ");	
		JTextField assetbrand = new JTextField("ץȡϵͳʱ��");
		assetbrand.setColumns(30);
		
		leftpanel04.add(brandlabel);
		leftpanel04.add(assetbrand);
		

		
		/**************���ڵ�ַ***************/
		JPanel leftpanel06 = new JPanel();	
		leftpanel.add(leftpanel06);
		
		JLabel nolabel = new JLabel("���ڵ�ַ:  ");	
		JTextField assetno = new JTextField();
		assetno.setColumns(30);
		
		leftpanel06.add(nolabel);
		leftpanel06.add(assetno);
		
		
		/**************�黹��Ա***************/
		JPanel leftpanel09 = new JPanel();	
		leftpanel.add(leftpanel09);
		
		JLabel dealerlabel = new JLabel("�黹��Ա:  ");	
		JTextField assetdealer = new JTextField();
		assetdealer.setColumns(30);
		
		leftpanel09.add(dealerlabel);
		leftpanel09.add(assetdealer);
		
		
		/**************�黹����***************/
		JPanel leftpanel07 = new JPanel();	
		leftpanel.add(leftpanel07);
		
		JLabel datelabel = new JLabel("�黹����:  ");	
		JTextField assetpurchasedate = new JTextField("ץȡϵͳʱ��");
		assetpurchasedate.setColumns(30);
		
		leftpanel07.add(datelabel);
		leftpanel07.add(assetpurchasedate);
		
		/**************��ע***************/
		JPanel leftpanel08 = new JPanel();	
		leftpanel.add(leftpanel08);
		
		JLabel manufacturerlabel = new JLabel("��ע:  ");	
		JTextField assetmanufacturer = new JTextField();
		assetmanufacturer.setColumns(30);
		
		leftpanel08.add(manufacturerlabel);
		leftpanel08.add(assetmanufacturer);
		

		
		/**************��¼״̬***************/
		JPanel leftpanel11 = new JPanel();	
		leftpanel.add(leftpanel11);
		
		JLabel instatuslabel = new JLabel("��¼״̬״̬:  ");	
		JLabel assetindeliverstatus = new JLabel("new or not");
		
		leftpanel11.add(instatuslabel);
		leftpanel11.add(assetindeliverstatus);
		
		

		/**************����ƾ֤***************/
		
		JPanel leftpanel10 = new JPanel();	
		rightpanel.add(leftpanel10);
		
		JLabel contractlabel = new JLabel("����ƾ֤:  ");	
		JTextField assetcontract = new JTextField();
		assetcontract.setColumns(30);
		
		leftpanel10.add(contractlabel);
		leftpanel10.add(assetcontract);

	}
	


}
