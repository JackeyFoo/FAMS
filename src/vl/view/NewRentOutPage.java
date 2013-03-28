package vl.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import vl.interfaces.MyDialog;
import dal.interfaces.ModelObject;
import dal.model.Assets;

public class NewRentOutPage extends MyDialog{

	private static final long serialVersionUID = 1L;

	private JPanel contentpanel;
	private JPanel controlpanel;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public NewRentOutPage(JFrame jframe, ModelObject o) {

		super(jframe, "�豸���", false);
		
		this.jframe = jframe;
		this.asset = (Assets) o;

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
	
	public void initControlPanel(){
		
		JButton save = new JButton("����");
		JButton cancel = new JButton("ȡ��");
		
		controlpanel.add(save);
		controlpanel.add(cancel);
		
		cancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				NewRentOutPage.this.dispose();
			}
			
		});
	}
	
	
	public void initContentPanel(){
	

		
		
		contentpanel.setLayout(new BoxLayout(contentpanel, BoxLayout.X_AXIS));
		
		JPanel leftpanel = new JPanel();
		leftpanel.setLayout(new BoxLayout(leftpanel, BoxLayout.Y_AXIS));
		
		JPanel rightpanel = new JPanel();
		rightpanel.setBorder(BorderFactory.createTitledBorder("���ƾ֤"));		
		
		contentpanel.add(leftpanel);
		contentpanel.add(rightpanel);
		
		
		//JPanel leftpanel05 = new JPanel();	
		//leftpanel01.add(leftpanel05);
		JPanel top1 = new JPanel();
		leftpanel.add(top1);
		JLabel idlabel = new JLabel("�ʲ�ID:  ");
		JLabel assetid = new JLabel("ϵͳ�Զ�����");
		top1.add(idlabel);
		top1.add(assetid);
		
		
		JPanel top2 = new JPanel();
		leftpanel.add(top2);		
		JLabel rentlabel = new JLabel("���ID:  ");
		JLabel rentid = new JLabel("ϵͳ�Զ�����");
		top2.add(rentlabel);
		top2.add(rentid);	
		
		
		JPanel top3 = new JPanel();
		leftpanel.add(top3);		
		JLabel rentpartmentlabel = new JLabel("���ò���:  ");
		JTextField renttype = new JTextField();
		renttype.setColumns(30);
		top3.add(rentpartmentlabel);
		top3.add(renttype);
		

		
		JPanel mid1 = new JPanel();
		leftpanel.add(mid1);		
		JLabel rentmanlabel = new JLabel("������Ա:  ");
		JTextField rentmantype = new JTextField();
		rentmantype.setColumns(30);
		mid1.add(rentmanlabel);
		mid1.add(rentmantype);
		
		JPanel mid2 = new JPanel();
		leftpanel.add(mid2);
		JLabel rentdaylabel = new JLabel("��������:  ");
		JTextField rentdaytype = new JTextField();
		rentdaytype.setColumns(30);
		mid2.add(rentdaylabel);
		mid2.add(rentdaytype);
		
		JPanel mid3 = new JPanel();
		leftpanel.add(mid3);
		JLabel rentbackdaylabel = new JLabel("Ԥ�ƹ黹���ڣ�  ");
		JTextField rentbackdaytype = new JTextField();
		rentbackdaytype.setColumns(30);
		mid3.add(rentbackdaylabel);
		mid3.add(rentbackdaytype);
		
		

		
		JPanel mid4 = new JPanel();
		leftpanel.add(mid4);		
		JLabel rentmanagerlabel = new JLabel("������:  ");
		JTextField rentmanagertype = new JTextField();
		rentmanagertype.setColumns(30);
		mid4.add(rentmanagerlabel);
		mid4.add(rentmanagertype);
		
		JPanel mid5 = new JPanel();
		leftpanel.add(mid5);
		JLabel rentbackday1label = new JLabel("�黹����:  ");
		JTextField rentbackday1type = new JTextField();
		rentbackday1type.setColumns(30);
		mid5.add(rentbackday1label);
		mid5.add(rentbackday1type);
		
		JPanel mid6 = new JPanel();
		leftpanel.add(mid6);
		JLabel rentbackmanlabel = new JLabel("�黹��Ա:  ");
		JTextField rentbackmantype = new JTextField();
		rentbackmantype.setColumns(30);
		mid6.add(rentbackmanlabel);
		mid6.add(rentbackmantype);
		
		JPanel mid7 = new JPanel();
		leftpanel.add(mid7);
		JLabel rentnotelabel = new JLabel("��ע:  ");
		JTextField rentnotetype = new JTextField();
		rentnotetype.setColumns(30);
		mid7.add(rentnotelabel);
		mid7.add(rentnotetype);
		
		
		JPanel mid8 = new JPanel();	
		leftpanel.add(mid8);
		JLabel instatuslabel = new JLabel("��¼״̬״̬:  ");	
		JLabel assetindeliverstatus = new JLabel("new or not");		
		mid8.add(instatuslabel);
		mid8.add(assetindeliverstatus);
	
		
		JPanel right = new JPanel();	
		rightpanel.add(right);		
		JLabel rentcontractlabel = new JLabel("���ƾ֤:  ");	
		JTextField rentcontract = new JTextField();
		rentcontract.setColumns(30);
		
		right.add(rentcontractlabel);
		right.add(rentcontract);

		
	}

	@Override
	public void packData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setImagePath(String txt) {
		// TODO Auto-generated method stub
		
	}
}
