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

	private String[] col = new String[] { "�ʲ�ID", "�ʲ�����", "�ʲ�����", "�ʲ�Ʒ��",
			"�ʲ��ͺ�", "�ʲ�����", "�ʲ���������", "�ʲ�������", "�ʲ�������", "�ʲ����״̬", "�ʲ�����״̬" };
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

		JMenuItem deliverout = new JMenuItem("�ʲ� " + o.getFormatID() + " ����");
		JMenuItem rentout = new JMenuItem("�ʲ� " + o.getFormatID() + " ���");

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
