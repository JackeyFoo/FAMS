package vl.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class NewRentOut extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel contentpanel;
	private JPanel controlpanel;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public NewRentOut() {
		super();

		setResizable(false);
		setTitle("设备借出");
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
		contentpanel.setBorder(BorderFactory.createTitledBorder("借出信息"));
		
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
				NewRentOut.this.dispose();
			}
			
		});
	}
	//initContengpanel
	void initContentPanel(){
		contentpanel.setLayout(new BoxLayout(contentpanel, BoxLayout.X_AXIS));
		JPanel leftpanel01 = new JPanel();
		leftpanel01.setLayout(new BoxLayout(leftpanel01, BoxLayout.Y_AXIS));
		
		JPanel leftpanel02 = new JPanel();
		leftpanel02.setLayout(new BoxLayout(leftpanel02, BoxLayout.Y_AXIS));

		contentpanel.add(leftpanel01);
		contentpanel.add(leftpanel02);
		
		
		JPanel leftpanel05 = new JPanel();	
		leftpanel01.add(leftpanel05);
		
		JLabel idlabel = new JLabel("资产ID:  ");
		leftpanel05.add(idlabel);
		
		
		JLabel rentlabel = new JLabel("借出ID:  ");
		leftpanel01.add(rentlabel);
		
		
		JLabel rentpartmentlabel = new JLabel("租用部门:  ");
		leftpanel01.add(rentpartmentlabel);
		
		
		JLabel rentmanlabel = new JLabel("租用人员:  ");
		leftpanel01.add(rentmanlabel);
		
		
		JLabel rentdaylabel = new JLabel("租用日期:  ");
		leftpanel01.add(rentdaylabel);
		
		
		JLabel rentbackdaylabel = new JLabel("预计归还日期：  ");
		leftpanel01.add(rentbackdaylabel);
				
		
		JLabel rentmanagerlabel = new JLabel("经手人:  ");
		leftpanel01.add(rentmanagerlabel);
		
		JLabel rentbackday1label = new JLabel("归还日期:  ");
		leftpanel01.add(rentbackday1label);
		
		
		JLabel rentbackmanlabel = new JLabel("归还人员:  ");
		leftpanel01.add(rentbackmanlabel);
		
		JLabel rentnotelabel = new JLabel("备注:  ");
		leftpanel01.add(rentnotelabel);
		
		
	}
}
