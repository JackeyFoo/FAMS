package vl.view;

import java.awt.BorderLayout;
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

public class NewMaintain extends JDialog {

	/**
	 * Launch the application.
	 */
	
	private static final long serialVersionUID = 1L;

	private JPanel contentpanel;
	private JPanel controlpanel;
	/**
	/**
	 * Create the dialog.
	 */
	public NewMaintain(JFrame jframe) {

		super(jframe, "�豸ά��", false);

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
		contentpanel.setBorder(BorderFactory.createTitledBorder("ά����Ϣ"));
		
		
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
				NewMaintain.this.dispose();
			}
			
		});
	}
	//initContengpanel
	void initContentPanel(){
	

		
		
		contentpanel.setLayout(new BoxLayout(contentpanel, BoxLayout.X_AXIS));
		
		JPanel leftpanel = new JPanel();
		leftpanel.setLayout(new BoxLayout(leftpanel, BoxLayout.Y_AXIS));
		
		JPanel rightpanel = new JPanel();
		rightpanel.setBorder(BorderFactory.createTitledBorder("ά��ϸ��"));
		rightpanel.setLayout(new BoxLayout(rightpanel, BoxLayout.Y_AXIS));
		
		contentpanel.add(leftpanel);
		contentpanel.add(rightpanel);
		
		
	//�ʲ�id
		JPanel left1 = new JPanel();
		leftpanel.add(left1);
		JLabel idlabel = new JLabel("�ʲ�ID:  ");
		JLabel assetid = new JLabel("ϵͳ�Զ�����");
		left1.add(idlabel);
		left1.add(assetid);
		
	//ά��id	
		JPanel left2 = new JPanel();
		leftpanel.add(left2);		
		JLabel maintainlabel = new JLabel("ά��ID:  ");
		JLabel maintainid = new JLabel("ϵͳ�Զ�����");
		left2.add(maintainlabel);
		left2.add(maintainid);	
		
	//ά�޲���	
		JPanel left3 = new JPanel();
		leftpanel.add(left3);		
		JLabel maintainpartmentlabel = new JLabel("ά�޲���:  ");
		JTextField maintaintype = new JTextField();
		maintaintype.setColumns(30);
		left3.add(maintainpartmentlabel);
		left3.add(maintaintype);
		
    // ������
		JPanel left4 = new JPanel();
		leftpanel.add(left4);		
		JLabel maintainmanagerlabel = new JLabel("������:  ");
		JTextField maintainmanagertype = new JTextField();
		maintainmanagertype.setColumns(30);
		left4.add(maintainmanagerlabel);
		left4.add(maintainmanagertype);
		
    //ά�޹���
		JPanel left5 = new JPanel();
		leftpanel.add(left5);
		JLabel maintainInglabel = new JLabel("ά�޹���:  ");
		JTextField maintainIngtype = new JTextField();
		maintainIngtype.setColumns(30);
		left5.add(maintainInglabel);
		left5.add(maintainIngtype);
		
	//ά�޷���
		JPanel left6 = new JPanel();
		leftpanel.add(left6);
		JLabel maintainCostlabel = new JLabel("ά�޷��ã�  ");
		JTextField maintainCosttype = new JTextField();
		maintainCosttype.setColumns(30);
		left6.add(maintainCostlabel);
		left6.add(maintainCosttype);
		
	//	rightpanel
	//��������	
		JPanel mid4 = new JPanel();
		rightpanel.add(mid4);
		JLabel maintainDaylabel = new JLabel("��������:  ");
		JTextField maintainDaytype = new JTextField();
		maintainDaytype.setColumns(30);
		mid4.add(maintainDaylabel);
		mid4.add(maintainDaytype);
		
		
	//�������	
		JPanel mid5 = new JPanel();
		rightpanel.add(mid5);
		JLabel maintainsituationlabel = new JLabel("�������:  ");
		JTextField maintainsituationtype = new JTextField();
		maintainsituationtype.setColumns(30);
		mid5.add(maintainsituationlabel);
		mid5.add(maintainsituationtype);
		
		
	//��������
		JPanel mid6 = new JPanel();
		rightpanel.add(mid6);
		JLabel maintainPhenomenalabel = new JLabel("��������:  ");
		JTextField maintainPhenomenatype = new JTextField();
		maintainPhenomenatype.setColumns(30);
		mid6.add(maintainPhenomenalabel);
		mid6.add(maintainPhenomenatype);
		
	//�豸״��
		JPanel mid7 = new JPanel();
		rightpanel.add(mid7);
		JLabel maintainnotelabel = new JLabel("�豸״��:  ");
		JTextField maintainnotetype = new JTextField();
		maintainnotetype.setColumns(30);
		mid7.add(maintainnotelabel);
		mid7.add(maintainnotetype);
		
	// ����	
		JPanel mid8 = new JPanel();	
		rightpanel.add(mid8);
		JLabel instatuslabel = new JLabel("��¼״̬״̬:  ");	
		JLabel assetindeliverstatus = new JLabel("new or not");		
		mid8.add(instatuslabel);
		mid8.add(assetindeliverstatus);
	
		
	}
	
}
