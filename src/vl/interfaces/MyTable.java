package vl.interfaces;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import dal.interfaces.ModelObject;

import vl.util.JTableModelValue;

public abstract class MyTable {
	
	protected JFrame jframe;
	protected String[] col;
	protected ModelObject[] mo;
	
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

				} else if (SwingUtilities.isRightMouseButton(e)) {

					JTable table = (JTable) e.getComponent();

					int row = table.rowAtPoint(e.getPoint());
					if (row == -1) {
						return;
					}

					table.setRowSelectionInterval(row, row);

					JPopupMenu popupmenu = new JPopupMenu();

					if(mo[row] != null){
						initPopMenu(popupmenu, mo[row]);
					}

					popupmenu.show(e.getComponent(), e.getX(), e.getY());

				}
			}
		});

	}
	
	public abstract void initPopMenu(JPopupMenu popupmenu, final ModelObject o);
}
