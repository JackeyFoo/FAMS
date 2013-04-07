package vl.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewSearchPage extends JDialog {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JFrame jf;
	private JLabel assetid;
	private JTextField assetidtype;
	private JPanel contentpanel;
	private JPanel controlpanel;
	int textvalue;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public NewSearchPage(JFrame jframe) {
		super(jframe, "����", false);
		this.jf = jframe;

		setResizable(false);
		setSize(400, 120);
		setLocation(450, 250);
		setVisible(true);
		setLayout(new BorderLayout());
        initDialog();
        setVisible(true);
	}
	
	public void initDialog(){
		
		contentpanel = new JPanel();
		add(contentpanel, BorderLayout.CENTER);
		contentpanel.setBorder(BorderFactory.createTitledBorder("�ʲ�ID��ѯ"));

		controlpanel = new JPanel();
		add(controlpanel, BorderLayout.PAGE_END);
		
		
		initContentPanel();
		initControlPanel();
		
	}
    public  void initContentPanel(){
    	
    	assetid = new JLabel("�������ʲ�ID");
    	assetidtype = new JTextField();
    	assetidtype.setColumns(30);
    	contentpanel.add(assetid);
    	contentpanel.add(assetidtype);
    	
    }
    public void initControlPanel(){			 
    JButton search = new JButton ("��ѯ");
    JButton cancel = new JButton("�ر�");
	 controlpanel.add(search);
	 controlpanel.add(cancel);
	 
		search.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				if(!(assetidtype.getText().equals(""))){
					
					new AllAssetsPage(jf,Integer.parseInt(assetidtype.getText()));
					NewSearchPage.this.dispose();
					
				}else{
					JOptionPane.showMessageDialog(null, "����д��Ҫ������", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				NewSearchPage.this.dispose();
			}

		});	
    }
}
