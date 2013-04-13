package vl.view.returnpage;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import bll.controll.NWEDialog;
import dal.model.Assets;
import vl.interfaces.MyDialog;
import vl.interfaces.MyJFrame;
import dal.interfaces.ModelObject;

public class NewReturnPage extends MyDialog {

	private static final long serialVersionUID = 1L;

	private ModelObject mo;

	private JPanel contentpanel;
	private JPanel controlpanel;
	private JLabel returnmanLabel;
	private JLabel returntimeLabel;
	private JTextField returnman;
	private JTextField returntime;

	public NewReturnPage(MyJFrame jframe, Assets asset, ModelObject mo) {

		super(jframe, "资产归还", false);
		this.jframe = jframe;
		this.asset = asset;
		setResizable(false);
		setSize(400, 200);
		setLocation(400, 150);
		setVisible(true);
		setLayout(new BorderLayout());
		initDialog();

		setVisible(true);
	}

	public void initDialog() {

		contentpanel = new JPanel();
		contentpanel.setBorder(BorderFactory.createTitledBorder("归还信息"));

		add(contentpanel, BorderLayout.CENTER);

		controlpanel = new JPanel();

		add(controlpanel, BorderLayout.PAGE_END);

		initContentPanel();
		initControlPanel();
	}

	public void initControlPanel() {

		save = new JButton("保存");
		cancel = new JButton("取消");

		controlpanel.add(save);
		controlpanel.add(cancel);

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				NewReturnPage.this.dispose();
			}

		});

		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (isFull()) {

					packData();

					// Controller.saveNewMaintainInfo(jframe, mo,
					// NewReturnPage.this);

				} else {
					NWEDialog.necessaryDataError();
				}
			}

		});

	}

	public void initContentPanel() {
		contentpanel.setLayout(new BoxLayout(contentpanel, BoxLayout.X_AXIS));

		JPanel leftpanel = new JPanel();
		leftpanel.setLayout(new BoxLayout(leftpanel, BoxLayout.Y_AXIS));

		contentpanel.add(leftpanel);

		JPanel leftpanel02 = new JPanel();
		leftpanel.add(leftpanel02);

		// 归还人员（必填
		returnmanLabel = new JLabel("归还人员(必填):  ");
		returnman = new JTextField();
		returnman.setColumns(30);

		leftpanel02.add(returnmanLabel);
		leftpanel02.add(returnman);

		JPanel leftpanel03 = new JPanel();
		leftpanel.add(leftpanel03);

		// 归还日期(必填)
		returntimeLabel = new JLabel("归还日期(必填):  ");
		returntime = new JTextField();
		returntime.setColumns(30);

		leftpanel03.add(returntimeLabel);
		leftpanel03.add(returntime);
	}

	public void packData() {
	}

	public boolean isFull() {
		if (returnman.getText().equals("")) {
			return false;
		} else if (returntime.getText().equals("")) {
			return false;
		} else {
			return true;
		}
	}

	public void setImagePath(String txt) {
		// TODO Auto-generated method stub

	}

	public void isEditable(boolean editable) {

	}
}
