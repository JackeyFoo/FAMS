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

import bll.controll.Controller;
import dal.dal.MaintainDAO;
import dal.model.Assets;
import dal.model.Maintain;
import vl.interfaces.MyDialog;
import vl.interfaces.MyJFrame;
import vl.util.NWEDialog;

public class MantainFinishedPage extends MyDialog {
	private static final long serialVersionUID = 1L;

	private Maintain mo;

	private JLabel assetsid;
	private JLabel maintainid;
	private JTextField maintainfinisheddate;

	public MantainFinishedPage(MyJFrame jframe, Assets asset, Maintain maintain) {

		super(jframe, "资产维修完成", false);

		this.jframe = jframe;
		this.asset = asset;
		this.mo = maintain;
		
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
		contentpanel.setBorder(BorderFactory.createTitledBorder("维修完成信息"));

		add(contentpanel, BorderLayout.CENTER);

		controlpanel = new JPanel();

		add(controlpanel, BorderLayout.PAGE_END);

		initContentPanel();
		getMaintain();
		
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

					Controller.maintainFinished(jframe, asset, mo, MantainFinishedPage.this);

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

		// 资产ID
		JPanel leftpanel01 = new JPanel();
		leftpanel.add(leftpanel01);

		JLabel assetsidlabel = new JLabel("资产ID:  ");
		assetsid = new JLabel(asset.getFormatID());

		leftpanel01.add(assetsidlabel);
		leftpanel01.add(assetsid);

		// 维修ID
		JPanel leftpanel02 = new JPanel();
		leftpanel.add(leftpanel02);

		JLabel maintainidlabel = new JLabel("维修ID:  ");
		maintainid = new JLabel();

		leftpanel02.add(maintainidlabel);
		leftpanel02.add(maintainid);

		// 维修完成时间
		JPanel leftpanel03 = new JPanel();
		leftpanel.add(leftpanel03);

		JLabel maintainfinisheddatelabel = new JLabel("维修完成时间(必填):  ");
		maintainfinisheddate = new JTextField();
		maintainfinisheddate.setColumns(30);

		leftpanel03.add(maintainfinisheddatelabel);
		leftpanel03.add(maintainfinisheddate);

	}

	public void getMaintain() {

		if (mo == null) {

			if (asset.getAssetrunningstatus().equals("维修")) {

				mo = MaintainDAO.getMaintain(asset.getAssetid());
				getMaintain();
			}
		} else {
			maintainid.setText(mo.getFormatID());
		}
	}

	public void packData() {
	}

	public boolean isFull() {
		if (maintainfinisheddate.getText().equals("")) {
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
