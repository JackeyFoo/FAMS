package vl.view.searchpage;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import vl.interfaces.MyDialog;
import vl.interfaces.MyJFrame;
import vl.util.NWEDialog;
import vl.view.listpage.AllAssetsPage;

public class IDSearchPage extends MyDialog {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private JLabel assetid;
	private JTextField assetidtype;

	int textvalue;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public IDSearchPage(MyJFrame jframe) {

		super(jframe, "搜索", false);
		this.jframe = jframe;

		setResizable(false);
		setSize(400, 120);
		setLocation(450, 250);
		setVisible(true);
		setLayout(new BorderLayout());
		initDialog();
		setVisible(true);
	}

	public void initDialog() {

		contentpanel = new JPanel();
		add(contentpanel, BorderLayout.CENTER);
		contentpanel.setBorder(BorderFactory.createTitledBorder("资产ID查询"));

		controlpanel = new JPanel();
		add(controlpanel, BorderLayout.PAGE_END);

		initContentPanel();
		initControlPanel();

	}

	public void initContentPanel() {

		assetid = new JLabel("请输入资产ID");
		assetidtype = new JTextField();
		assetidtype.setColumns(30);
		contentpanel.add(assetid);
		contentpanel.add(assetidtype);

	}

	public void initControlPanel() {

		JButton search = new JButton("查询");
		JButton cancel = new JButton("关闭");
		controlpanel.add(search);
		controlpanel.add(cancel);

		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				if (!(assetidtype.getText().equals(""))) {

					try {

						int id = Integer.parseInt(assetidtype.getText());

						new AllAssetsPage(jframe, id);

						IDSearchPage.this.dispose();

					} catch (Exception e) {
						NWEDialog.inputError(IDSearchPage.this);
					}

				} else {
					NWEDialog.necessaryDataError(IDSearchPage.this);
				}
			}

		});

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				IDSearchPage.this.dispose();
			}

		});
	}

	@Override
	public void packData() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub

		// if(assetidtype.getText()){
		//
		// }
		return false;
	}

	@Override
	public void setImagePath(String txt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void isEditable(boolean editable) {
		// TODO Auto-generated method stub

	}
}
