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

		super(jframe, "设备维护", false);

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
		contentpanel.setBorder(BorderFactory.createTitledBorder("维护信息"));
		
		
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
		rightpanel.setBorder(BorderFactory.createTitledBorder("维护细节"));
		rightpanel.setLayout(new BoxLayout(rightpanel, BoxLayout.Y_AXIS));
		
		contentpanel.add(leftpanel);
		contentpanel.add(rightpanel);
		
		
	//资产id
		JPanel left1 = new JPanel();
		leftpanel.add(left1);
		JLabel idlabel = new JLabel("资产ID:  ");
		JLabel assetid = new JLabel("系统自动生成");
		left1.add(idlabel);
		left1.add(assetid);
		
	//维修id	
		JPanel left2 = new JPanel();
		leftpanel.add(left2);		
		JLabel maintainlabel = new JLabel("维修ID:  ");
		JLabel maintainid = new JLabel("系统自动生成");
		left2.add(maintainlabel);
		left2.add(maintainid);	
		
	//维修部门	
		JPanel left3 = new JPanel();
		leftpanel.add(left3);		
		JLabel maintainpartmentlabel = new JLabel("维修部门:  ");
		JTextField maintaintype = new JTextField();
		maintaintype.setColumns(30);
		left3.add(maintainpartmentlabel);
		left3.add(maintaintype);
		
    // 经办人
		JPanel left4 = new JPanel();
		leftpanel.add(left4);		
		JLabel maintainmanagerlabel = new JLabel("经办人:  ");
		JTextField maintainmanagertype = new JTextField();
		maintainmanagertype.setColumns(30);
		left4.add(maintainmanagerlabel);
		left4.add(maintainmanagertype);
		
    //维修过程
		JPanel left5 = new JPanel();
		leftpanel.add(left5);
		JLabel maintainInglabel = new JLabel("维修过程:  ");
		JTextField maintainIngtype = new JTextField();
		maintainIngtype.setColumns(30);
		left5.add(maintainInglabel);
		left5.add(maintainIngtype);
		
	//维修费用
		JPanel left6 = new JPanel();
		leftpanel.add(left6);
		JLabel maintainCostlabel = new JLabel("维修费用：  ");
		JTextField maintainCosttype = new JTextField();
		maintainCosttype.setColumns(30);
		left6.add(maintainCostlabel);
		left6.add(maintainCosttype);
		
	//	rightpanel
	//故障日期	
		JPanel mid4 = new JPanel();
		rightpanel.add(mid4);
		JLabel maintainDaylabel = new JLabel("故障日期:  ");
		JTextField maintainDaytype = new JTextField();
		maintainDaytype.setColumns(30);
		mid4.add(maintainDaylabel);
		mid4.add(maintainDaytype);
		
		
	//故障情况	
		JPanel mid5 = new JPanel();
		rightpanel.add(mid5);
		JLabel maintainsituationlabel = new JLabel("故障情况:  ");
		JTextField maintainsituationtype = new JTextField();
		maintainsituationtype.setColumns(30);
		mid5.add(maintainsituationlabel);
		mid5.add(maintainsituationtype);
		
		
	//故障现象
		JPanel mid6 = new JPanel();
		rightpanel.add(mid6);
		JLabel maintainPhenomenalabel = new JLabel("故障现象:  ");
		JTextField maintainPhenomenatype = new JTextField();
		maintainPhenomenatype.setColumns(30);
		mid6.add(maintainPhenomenalabel);
		mid6.add(maintainPhenomenatype);
		
	//设备状况
		JPanel mid7 = new JPanel();
		rightpanel.add(mid7);
		JLabel maintainnotelabel = new JLabel("设备状况:  ");
		JTextField maintainnotetype = new JTextField();
		maintainnotetype.setColumns(30);
		mid7.add(maintainnotelabel);
		mid7.add(maintainnotetype);
		
	// 更新	
		JPanel mid8 = new JPanel();	
		rightpanel.add(mid8);
		JLabel instatuslabel = new JLabel("记录状态状态:  ");	
		JLabel assetindeliverstatus = new JLabel("new or not");		
		mid8.add(instatuslabel);
		mid8.add(assetindeliverstatus);
	
		
	}
	
}
