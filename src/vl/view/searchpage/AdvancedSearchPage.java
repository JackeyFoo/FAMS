package vl.view.searchpage;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import bll.controll.NWEDialog;
import vl.interfaces.MyDialog;
import vl.interfaces.MyJFrame;

public class AdvancedSearchPage extends MyDialog {

	private static final long serialVersionUID = 1L;

	private MyJFrame jf;
	private JPanel contentpanel;
	private JPanel controlpanel;
	private JCheckBox newasset;
	private JCheckBox deliverout;
	private JCheckBox rentout;
	private JCheckBox transfer;
	private JCheckBox maintain;
	private JCheckBox discard;

	public AdvancedSearchPage(MyJFrame jframe) {

		super(jframe, "搜索", false);
		
		this.jf = jframe;

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
		add(contentpanel, BorderLayout.CENTER);
		contentpanel.setBorder(BorderFactory.createTitledBorder("资产高级查询"));

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
				AdvancedSearchPage.this.dispose();
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
		contentpanel.setLayout(new GridLayout(3, 3));

		// 资产选择
		JPanel panel01 = new JPanel();
		panel01.setLayout(new BoxLayout(panel01, BoxLayout.Y_AXIS));
		contentpanel.add(panel01);

		newasset = new JCheckBox("资产项");
		panel01.add(newasset);

		JPanel panel011 = new JPanel();
		panel01.add(panel011);
		JLabel assetkeywordlabel = new JLabel("资产关键字:      ");
		final JTextField assetkeyword = new JTextField();
		assetkeyword.setColumns(30);

		panel011.add(assetkeywordlabel);
		panel011.add(assetkeyword);

		JPanel panel012 = new JPanel();
		panel01.add(panel012);
		JLabel assetdatelabel = new JLabel("资产入库日期:    ");
		final JTextField assetdate = new JTextField();
		assetdate.setColumns(30);

		panel012.add(assetdatelabel);
		panel012.add(assetdate);

		assetkeyword.setEditable(false);
		assetdate.setEditable(false);

		newasset.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if (newasset.isSelected()) {

					assetkeyword.setEditable(true);
					assetdate.setEditable(true);

				} else {

					assetkeyword.setEditable(false);
					assetdate.setEditable(false);

				}
			}

		});

		// 报废选择
		JPanel panel06 = new JPanel();
		panel06.setLayout(new BoxLayout(panel06, BoxLayout.Y_AXIS));
		contentpanel.add(panel06);

		discard = new JCheckBox("报废项");
		panel06.add(discard);

		JPanel panel061 = new JPanel();
		panel06.add(panel061);
		JLabel discardwordlabel = new JLabel("资产报废关键字:    ");
		final JTextField discardword = new JTextField();
		discardword.setColumns(30);

		panel061.add(discardwordlabel);
		panel061.add(discardword);

		JPanel panel062 = new JPanel();
		panel06.add(panel062);
		JLabel discarddatelabel = new JLabel("资产报废日期:      ");
		final JTextField discarddate = new JTextField();
		discarddate.setColumns(30);

		panel062.add(discarddatelabel);
		panel062.add(discarddate);

		discardword.setEditable(false);
		discarddate.setEditable(false);

		discard.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if (discard.isSelected()) {

					discardword.setEditable(true);
					discarddate.setEditable(true);

				} else {

					discardword.setEditable(false);
					discarddate.setEditable(false);

				}
			}

		});

		// 出库选择
		JPanel panel02 = new JPanel();
		panel02.setLayout(new BoxLayout(panel02, BoxLayout.Y_AXIS));
		contentpanel.add(panel02);

		deliverout = new JCheckBox("出库项");
		panel02.add(deliverout);

		JPanel panel021 = new JPanel();
		panel02.add(panel021);
		JLabel deliveroutwordlabel = new JLabel("资产出库关键字:  ");
		final JTextField deliveroutword = new JTextField();
		deliveroutword.setColumns(30);

		panel021.add(deliveroutwordlabel);
		panel021.add(deliveroutword);

		JPanel panel022 = new JPanel();
		panel02.add(panel022);
		JLabel deliveroutdatelabel = new JLabel("资产出库时间:    ");
		final JTextField deliveroutdate = new JTextField();
		deliveroutdate.setColumns(30);

		panel022.add(deliveroutdatelabel);
		panel022.add(deliveroutdate);

		JPanel panel023 = new JPanel();
		panel02.add(panel023);
		JLabel deliveroutreturnlabel = new JLabel("资产归还时间:    ");
		final JTextField deliveroutreturn = new JTextField();
		deliveroutreturn.setColumns(30);

		panel023.add(deliveroutreturnlabel);
		panel023.add(deliveroutreturn);

		deliveroutword.setEditable(false);
		deliveroutdate.setEditable(false);
		deliveroutreturn.setEditable(false);

		deliverout.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if (deliverout.isSelected()) {

					deliveroutword.setEditable(true);
					deliveroutdate.setEditable(true);
					deliveroutreturn.setEditable(true);

				} else {

					deliveroutword.setEditable(false);
					deliveroutdate.setEditable(false);
					deliveroutreturn.setEditable(false);

				}
			}

		});

		// 转移选择

		JPanel panel04 = new JPanel();
		panel04.setLayout(new BoxLayout(panel04, BoxLayout.Y_AXIS));
		contentpanel.add(panel04);

		transfer = new JCheckBox("转移项");
		panel04.add(transfer);

		JPanel panel041 = new JPanel();
		panel04.add(panel041);
		JLabel transferwordlabel = new JLabel("资产转移关键字:    ");
		final JTextField transferword = new JTextField();
		transferword.setColumns(30);

		panel041.add(transferwordlabel);
		panel041.add(transferword);

		JPanel panel042 = new JPanel();
		panel04.add(panel042);
		JLabel transferdatelabel = new JLabel("资产转移时间:      ");
		final JTextField transferdate = new JTextField();
		transferdate.setColumns(30);

		panel042.add(transferdatelabel);
		panel042.add(transferdate);

		JPanel panel043 = new JPanel();
		panel04.add(panel043);
		JLabel transferreturnlabel = new JLabel("资产转移归还时间:  ");
		final JTextField transferreturn = new JTextField();
		transferreturn.setColumns(30);

		panel043.add(transferreturnlabel);
		panel043.add(transferreturn);

		transferword.setEditable(false);
		transferdate.setEditable(false);
		transferreturn.setEditable(false);

		transfer.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if (transfer.isSelected()) {

					transferword.setEditable(true);
					transferdate.setEditable(true);
					transferreturn.setEditable(true);

				} else {

					transferword.setEditable(false);
					transferdate.setEditable(false);
					transferreturn.setEditable(false);

				}
			}

		});

		// 出租选择

		JPanel panel03 = new JPanel();
		panel03.setLayout(new BoxLayout(panel03, BoxLayout.Y_AXIS));
		contentpanel.add(panel03);

		rentout = new JCheckBox("借出项");
		panel03.add(rentout);

		JPanel panel031 = new JPanel();
		panel03.add(panel031);
		JLabel rentoutwordlabel = new JLabel("资产借出关键字:  ");
		final JTextField rentoutword = new JTextField();
		rentoutword.setColumns(30);

		panel031.add(rentoutwordlabel);
		panel031.add(rentoutword);

		JPanel panel032 = new JPanel();
		panel03.add(panel032);
		JLabel rentoutdatelabel = new JLabel("资产借出时间:    ");
		final JTextField rentoutdate = new JTextField();
		rentoutdate.setColumns(30);

		panel032.add(rentoutdatelabel);
		panel032.add(rentoutdate);

		JPanel panel033 = new JPanel();
		panel03.add(panel033);
		JLabel rentoutreturnlabel = new JLabel("资产借出归还时间:");
		final JTextField rentoutreturn = new JTextField();
		rentoutreturn.setColumns(30);

		panel033.add(rentoutreturnlabel);
		panel033.add(rentoutreturn);

		rentoutword.setEditable(false);
		rentoutdate.setEditable(false);
		rentoutreturn.setEditable(false);

		rentout.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if (rentout.isSelected()) {

					rentoutword.setEditable(true);
					rentoutdate.setEditable(true);
					rentoutreturn.setEditable(true);

				} else {

					rentoutword.setEditable(false);
					rentoutdate.setEditable(false);
					rentoutreturn.setEditable(false);

				}
			}

		});

		// 维修选择
		JPanel panel05 = new JPanel();
		panel05.setLayout(new BoxLayout(panel05, BoxLayout.Y_AXIS));
		contentpanel.add(panel05);

		maintain = new JCheckBox("维修项");
		panel05.add(maintain);

		JPanel panel051 = new JPanel();
		panel05.add(panel051);
		JLabel maintainwordlabel = new JLabel("资产维修关键字:    ");
		final JTextField maintainword = new JTextField();
		maintainword.setColumns(30);

		panel051.add(maintainwordlabel);
		panel051.add(maintainword);

		JPanel panel052 = new JPanel();
		panel05.add(panel052);
		JLabel maintaindatelabel = new JLabel("资产报修时间:      ");
		final JTextField maintaindate = new JTextField();
		maintaindate.setColumns(30);

		panel052.add(maintaindatelabel);
		panel052.add(maintaindate);

		JPanel panel053 = new JPanel();
		panel05.add(panel053);
		JLabel maintainreturnlabel = new JLabel("资产维修完成时间:  ");
		final JTextField maintainreturn = new JTextField();
		maintainreturn.setColumns(30);

		panel053.add(maintainreturnlabel);
		panel053.add(maintainreturn);

		maintainword.setEditable(false);
		maintaindate.setEditable(false);
		maintainreturn.setEditable(false);

		maintain.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if (maintain.isSelected()) {

					maintainword.setEditable(true);
					maintaindate.setEditable(true);
					maintainreturn.setEditable(true);

				} else {

					maintainword.setEditable(false);
					maintaindate.setEditable(false);
					maintainreturn.setEditable(false);

				}
			}

		});

	}

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