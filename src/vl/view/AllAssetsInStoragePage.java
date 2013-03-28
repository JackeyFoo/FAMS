package vl.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import dal.dal.AssetsDAO;
import dal.interfaces.ModelObject;

import vl.util.JTableModelValue;

public class AllAssetsInStoragePage {
	
	private JFrame jframe;

	private String[] col = new String[] { "资产ID", "资产类型", "资产名称", "资产品牌",
			"资产型号", "资产机号", "资产购入日期", "资产生产商", "资产经销商", "资产库存状态", "资产运行状态" };
	private ModelObject[] mo;

	public AllAssetsInStoragePage(JFrame j) {
		
		this.jframe = j;

		Container pane = jframe.getContentPane();

		pane.setLayout(new BorderLayout());

		mo = (ModelObject[]) AssetsDAO.getAllInStorage();

		initJTable(pane);

		jframe.validate();
	}

	public void initJTable(Container pane) {

		pane.removeAll();

		JTableModelValue values = new JTableModelValue(mo, col);

		JTable table = new JTable(values);

		table.setRowHeight(30);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollpane = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		pane.add(scrollpane, BorderLayout.CENTER);

		table.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)
						&& e.getClickCount() > 1) {

					System.out.println("double left click");

				} else if (SwingUtilities.isRightMouseButton(e)) {

					JTable table = (JTable) e.getComponent();

					int row = table.rowAtPoint(e.getPoint());
					if (row == -1) {
						return;
					}

					table.setRowSelectionInterval(row, row);

					JPopupMenu popupmenu = new JPopupMenu();

					initPopMenu(popupmenu, mo[row]);

					popupmenu.show(e.getComponent(), e.getX(), e.getY());

				}
			}
		});

	}

	public void initPopMenu(JPopupMenu popupmenu, final ModelObject o) {

		JMenuItem deliverout = new JMenuItem("资产 " + o.getFormatID() + " 出库");
		JMenuItem rentout = new JMenuItem("资产 " + o.getFormatID() + " 借出");

		popupmenu.add(deliverout);
		popupmenu.addSeparator();
		popupmenu.add(rentout);
		
		deliverout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new NewDeliverOutPage(jframe, o);
			}
			
		});

	}

}
