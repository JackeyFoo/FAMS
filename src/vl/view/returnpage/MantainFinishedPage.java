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
import dal.model.Assets;
import dal.model.Maintain;
import vl.interfaces.MyDialog;
import vl.interfaces.MyJFrame;
import vl.util.NWEDialog;

public class MantainFinishedPage extends MyDialog {
	private static final long serialVersionUID = 1L;

	private Maintain maintain;

	private JPanel contentpanel;
	private JPanel controlpanel;
	private JLabel complimentLabel;
	private JTextField compliment;

	public MantainFinishedPage(MyJFrame jframe, Assets asset, Maintain maintain) {
		
		super(jframe, "资产维修完成", false);
		
		this.jframe = jframe;
		this.asset = asset;
		setResizable(false);
		setSize(400, 150);
		setLocation(400, 150);
		setVisible(true);
		setLayout(new BorderLayout());
		initDialog();

		setVisible(true);
	}

	public void initDialog() {

		contentpanel = new JPanel();
		contentpanel.setBorder(BorderFactory.createTitledBorder("完成信息"));

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
				MantainFinishedPage.this.dispose();
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
					NWEDialog.necessaryDataError(MantainFinishedPage.this);
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
		complimentLabel = new JLabel("完成日期(必填):  ");
		compliment = new JTextField();
		compliment.setColumns(30);

		leftpanel02.add(complimentLabel);
		leftpanel02.add(compliment);

		JPanel leftpanel03 = new JPanel();
		leftpanel.add(leftpanel03);

		// 归还日期(必填)

	}

	public void packData() {
	}

	public boolean isFull() {
		if (compliment.getText().equals("")) {
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
