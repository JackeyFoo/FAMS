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

public class NewDiscard extends JDialog {

	/**
	 * Launch the application.
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentpanel;
	private JPanel controlpanel;


	/**
	 * Create the dialog.
	 */
	public NewDiscard(JFrame jframe) {
		
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
				NewDiscard.this.dispose();
			}
			
		});
	}
	//initContengpanel
	void initContentPanel(){
	

		
		
		contentpanel.setLayout(new BoxLayout(contentpanel, BoxLayout.X_AXIS));
		
		JPanel leftpanel = new JPanel();
		leftpanel.setLayout(new BoxLayout(leftpanel, BoxLayout.Y_AXIS));
		
		JPanel rightpanel = new JPanel();
		rightpanel.setBorder(BorderFactory.createTitledBorder("����ƾ֤"));		
		
		contentpanel.add(leftpanel);
		contentpanel.add(rightpanel);
		
		
	//�ʲ�id
		JPanel top1 = new JPanel();
		leftpanel.add(top1);
		JLabel idlabel = new JLabel("�ʲ�ID:  ");
		JLabel assetid = new JLabel("ϵͳ�Զ�����");
		top1.add(idlabel);
		top1.add(assetid);
		
	//����id	
		JPanel top2 = new JPanel();
		leftpanel.add(top2);		
		JLabel Transferlabel = new JLabel("����ID:  ");
		JLabel Transferid = new JLabel("ϵͳ�Զ�����");
		top2.add(Transferlabel);
		top2.add(Transferid);	
		
	//���ϲ���	
		JPanel top3 = new JPanel();
		leftpanel.add(top3);		
		JLabel Transferpartmentlabel = new JLabel("���ϲ���:  ");
		JTextField Transfertype = new JTextField();
		Transfertype.setColumns(30);
		top3.add(Transferpartmentlabel);
		top3.add(Transfertype);
		
    // ����ԭ��
		JPanel mid4 = new JPanel();
		leftpanel.add(mid4);		
		JLabel Transfermanagerlabel = new JLabel("����ԭ��:  ");
		JTextField Transfermanagertype = new JTextField();
		Transfermanagertype.setColumns(30);
		mid4.add(Transfermanagerlabel);
		mid4.add(Transfermanagertype);
		
    //����ʱ��
		JPanel mid2 = new JPanel();
		leftpanel.add(mid2);
		JLabel Transferdaylabel = new JLabel("����ʱ��" +
				":  ");
		JTextField Transferdaytype = new JTextField();
		Transferdaytype.setColumns(30);
		mid2.add(Transferdaylabel);
		mid2.add(Transferdaytype);
		
	//Ԥ����ʱ��
		JPanel mid3 = new JPanel();
		leftpanel.add(mid3);
		JLabel Transferwaylabel = new JLabel("Ԥ����ʱ�䣺  ");
		JTextField Transferwaytype = new JTextField();
		Transferwaytype.setColumns(30);
		mid3.add(Transferwaylabel);
		mid3.add(Transferwaytype);
		

	
	//ƾ֤	
		JPanel right = new JPanel();	
		rightpanel.add(right);		
		JLabel Transfercontractlabel = new JLabel("ת��ƾ֤:  ");	
		JTextField Transfercontract = new JTextField();
		Transfercontract.setColumns(30);
		
		right.add(Transfercontractlabel);
		right.add(Transfercontract);

		
	}

}
