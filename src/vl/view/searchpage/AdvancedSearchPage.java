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
import vl.interfaces.MyDialog;
import vl.interfaces.MyJFrame;
import vl.util.NWEDialog;

public class AdvancedSearchPage extends MyDialog {

	private static final long serialVersionUID = 1L;

	private JCheckBox asset;
	private JCheckBox deliverout;
	private JCheckBox rentout;
	private JCheckBox transfer;
	private JCheckBox maintain;
	private JCheckBox discard;

	private String searchstr[][];

	private JTextField assetkeyword;

	private JTextField assetpurchasedate;

	private JTextField discardkeyword;

	private JTextField discarddate;

	private JTextField deliveroutkeyword;

	private JTextField deliverdate;

	private JTextField deliverreturndate;

	private JTextField transferkeyword;

	private JTextField transferdate;

	private JTextField transferreturndate;

	private JTextField rentoutkeyword;

	private JTextField rentdate;

	private JTextField rentreturndate;

	private JTextField maintainkeyword;

	private JTextField downdate;

	private JTextField maintainfinisheddate;

	public AdvancedSearchPage(MyJFrame jframe) {

		super(jframe, "搜索", false);

		this.jframe = jframe;

		searchstr = new String[6][3];

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
					NWEDialog.necessaryDataError(AdvancedSearchPage.this);
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

		asset = new JCheckBox("资产项");
		panel01.add(asset);

		JPanel panel011 = new JPanel();
		panel01.add(panel011);
		JLabel assetkeywordlabel = new JLabel("资产关键字:      ");
		assetkeyword = new JTextField();
		assetkeyword.setColumns(30);

		panel011.add(assetkeywordlabel);
		panel011.add(assetkeyword);

		JPanel panel012 = new JPanel();
		panel01.add(panel012);
		JLabel assetdatelabel = new JLabel("资产入库日期:    ");
		assetpurchasedate = new JTextField();
		assetpurchasedate.setColumns(30);

		panel012.add(assetdatelabel);
		panel012.add(assetpurchasedate);

		assetkeyword.setEditable(false);
		assetpurchasedate.setEditable(false);

		asset.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if (asset.isSelected()) {

					assetkeyword.setEditable(true);
					assetpurchasedate.setEditable(true);

				} else {

					assetkeyword.setEditable(false);
					assetpurchasedate.setEditable(false);

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
		discardkeyword = new JTextField();
		discardkeyword.setColumns(30);

		panel061.add(discardwordlabel);
		panel061.add(discardkeyword);

		JPanel panel062 = new JPanel();
		panel06.add(panel062);
		JLabel discarddatelabel = new JLabel("资产报废日期:      ");
		discarddate = new JTextField();
		discarddate.setColumns(30);

		panel062.add(discarddatelabel);
		panel062.add(discarddate);

		discardkeyword.setEditable(false);
		discarddate.setEditable(false);

		discard.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if (discard.isSelected()) {

					discardkeyword.setEditable(true);
					discarddate.setEditable(true);

				} else {

					discardkeyword.setEditable(false);
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
		deliveroutkeyword = new JTextField();
		deliveroutkeyword.setColumns(30);

		panel021.add(deliveroutwordlabel);
		panel021.add(deliveroutkeyword);

		JPanel panel022 = new JPanel();
		panel02.add(panel022);
		JLabel deliveroutdatelabel = new JLabel("资产出库时间:    ");
		deliverdate = new JTextField();
		deliverdate.setColumns(30);

		panel022.add(deliveroutdatelabel);
		panel022.add(deliverdate);

		JPanel panel023 = new JPanel();
		panel02.add(panel023);
		JLabel deliveroutreturnlabel = new JLabel("资产归还时间:    ");
		deliverreturndate = new JTextField();
		deliverreturndate.setColumns(30);

		panel023.add(deliveroutreturnlabel);
		panel023.add(deliverreturndate);

		deliveroutkeyword.setEditable(false);
		deliverdate.setEditable(false);
		deliverreturndate.setEditable(false);

		deliverout.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if (deliverout.isSelected()) {

					deliveroutkeyword.setEditable(true);
					deliverdate.setEditable(true);
					deliverreturndate.setEditable(true);

				} else {

					deliveroutkeyword.setEditable(false);
					deliverdate.setEditable(false);
					deliverreturndate.setEditable(false);

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
		transferkeyword = new JTextField();
		transferkeyword.setColumns(30);

		panel041.add(transferwordlabel);
		panel041.add(transferkeyword);

		JPanel panel042 = new JPanel();
		panel04.add(panel042);
		JLabel transferdatelabel = new JLabel("资产转移时间:      ");
		transferdate = new JTextField();
		transferdate.setColumns(30);

		panel042.add(transferdatelabel);
		panel042.add(transferdate);

		JPanel panel043 = new JPanel();
		panel04.add(panel043);
		JLabel transferreturnlabel = new JLabel("资产转移归还时间:  ");
		transferreturndate = new JTextField();
		transferreturndate.setColumns(30);

		panel043.add(transferreturnlabel);
		panel043.add(transferreturndate);

		transferkeyword.setEditable(false);
		transferdate.setEditable(false);
		transferreturndate.setEditable(false);

		transfer.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if (transfer.isSelected()) {

					transferkeyword.setEditable(true);
					transferdate.setEditable(true);
					transferreturndate.setEditable(true);

				} else {

					transferkeyword.setEditable(false);
					transferdate.setEditable(false);
					transferreturndate.setEditable(false);

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
		rentoutkeyword = new JTextField();
		rentoutkeyword.setColumns(30);

		panel031.add(rentoutwordlabel);
		panel031.add(rentoutkeyword);

		JPanel panel032 = new JPanel();
		panel03.add(panel032);
		JLabel rentoutdatelabel = new JLabel("资产借出时间:    ");
		rentdate = new JTextField();
		rentdate.setColumns(30);

		panel032.add(rentoutdatelabel);
		panel032.add(rentdate);

		JPanel panel033 = new JPanel();
		panel03.add(panel033);
		JLabel rentoutreturnlabel = new JLabel("资产借出归还时间:");
		rentreturndate = new JTextField();
		rentreturndate.setColumns(30);

		panel033.add(rentoutreturnlabel);
		panel033.add(rentreturndate);

		rentoutkeyword.setEditable(false);
		rentdate.setEditable(false);
		rentreturndate.setEditable(false);

		rentout.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if (rentout.isSelected()) {

					rentoutkeyword.setEditable(true);
					rentdate.setEditable(true);
					rentreturndate.setEditable(true);

				} else {

					rentoutkeyword.setEditable(false);
					rentdate.setEditable(false);
					rentreturndate.setEditable(false);

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
		maintainkeyword = new JTextField();
		maintainkeyword.setColumns(30);

		panel051.add(maintainwordlabel);
		panel051.add(maintainkeyword);

		JPanel panel052 = new JPanel();
		panel05.add(panel052);
		JLabel maintaindatelabel = new JLabel("资产故障时间:      ");
		downdate = new JTextField();
		downdate.setColumns(30);

		panel052.add(maintaindatelabel);
		panel052.add(downdate);

		JPanel panel053 = new JPanel();
		panel05.add(panel053);
		JLabel maintainreturnlabel = new JLabel("资产维修完成时间:  ");
		maintainfinisheddate = new JTextField();
		maintainfinisheddate.setColumns(30);

		panel053.add(maintainreturnlabel);
		panel053.add(maintainfinisheddate);

		maintainkeyword.setEditable(false);
		downdate.setEditable(false);
		maintainfinisheddate.setEditable(false);

		maintain.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if (maintain.isSelected()) {

					maintainkeyword.setEditable(true);
					downdate.setEditable(true);
					maintainfinisheddate.setEditable(true);

				} else {

					maintainkeyword.setEditable(false);
					downdate.setEditable(false);
					maintainfinisheddate.setEditable(false);

				}
			}

		});

	}

	public void packData() {
		// TODO Auto-generated method stub

		/********** asset *************/
		if (asset.isSelected() && !assetkeyword.equals("")) {
			searchstr[0][0] = assetkeyword.getText();
		} else {
			searchstr[0][0] = null;
		}

		if (asset.isSelected() && !assetpurchasedate.equals("")) {
			searchstr[0][1] = assetpurchasedate.getText();
		} else {
			searchstr[0][1] = null;
		}
		
		searchstr[0][2] = null;
		
		/********** deliverout *************/
		if (deliverout.isSelected() && !deliveroutkeyword.equals("")) {
			searchstr[1][0] = deliveroutkeyword.getText();
		} else {
			searchstr[1][0] = null;
		}

		if (deliverout.isSelected() && !deliverdate.equals("")) {
			searchstr[1][1] = deliverdate.getText();
		} else {
			searchstr[1][1] = null;
		}
		
		if (deliverout.isSelected() && !deliverreturndate.equals("")) {
			searchstr[1][2] = deliverdate.getText();
		} else {
			searchstr[1][2] = null;
		}
		
		/********** rentout *************/
		if (rentout.isSelected() && !rentoutkeyword.equals("")) {
			searchstr[2][0] = rentoutkeyword.getText();
		} else {
			searchstr[2][0] = null;
		}

		if (rentout.isSelected() && !rentdate.equals("")) {
			searchstr[2][1] = rentdate.getText();
		} else {
			searchstr[2][1] = null;
		}
		
		if (rentout.isSelected() && !rentreturndate.equals("")) {
			searchstr[2][2] = rentreturndate.getText();
		} else {
			searchstr[2][2] = null;
		}
		
		/********** transfer *************/
		if (transfer.isSelected() && !transferkeyword.equals("")) {
			searchstr[2][0] = transferkeyword.getText();
		} else {
			searchstr[2][0] = null;
		}

		if (rentout.isSelected() && !transferdate.equals("")) {
			searchstr[2][1] = transferdate.getText();
		} else {
			searchstr[2][1] = null;
		}
		
		if (rentout.isSelected() && !transferreturndate.equals("")) {
			searchstr[2][2] = rentreturndate.getText();
		} else {
			searchstr[2][2] = null;
		}
		
		/********** asset *************/
		if (asset.isSelected() && !assetkeyword.equals("")) {
			searchstr[0][0] = assetkeyword.getText();
		} else {
			searchstr[0][0] = null;
		}

		if (asset.isSelected() && !assetpurchasedate.equals("")) {
			searchstr[0][1] = assetpurchasedate.getText();
		} else {
			searchstr[0][1] = null;
		}
		
		
		/********** asset *************/
		if (asset.isSelected() && !assetkeyword.equals("")) {
			searchstr[0][0] = assetkeyword.getText();
		} else {
			searchstr[0][0] = null;
		}

		if (asset.isSelected() && !assetpurchasedate.equals("")) {
			searchstr[0][1] = assetpurchasedate.getText();
		} else {
			searchstr[0][1] = null;
		}
		
		
		/********** asset *************/
		if (asset.isSelected() && !assetkeyword.equals("")) {
			searchstr[0][0] = assetkeyword.getText();
		} else {
			searchstr[0][0] = null;
		}

		if (asset.isSelected() && !assetpurchasedate.equals("")) {
			searchstr[0][1] = assetpurchasedate.getText();
		} else {
			searchstr[0][1] = null;
		}

		searchstr[0][2] = null;

	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
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