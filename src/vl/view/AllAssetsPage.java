package vl.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import dal.dal.AssetsDAO;
import dal.interfaces.ModelObject;

import vl.util.JTableModelValue;

public class AllAssetsPage {

	private String[] col = new String[] { "�ʲ�ID", "�ʲ�����", "�ʲ�����", "�ʲ�Ʒ��",
			"�ʲ��ͺ�", "�ʲ�����", "�ʲ���������", "�ʲ�������", "�ʲ�������", "�ʲ����״̬", "�ʲ�����״̬" };

	public AllAssetsPage(JFrame jframe) {

		Container pane = jframe.getContentPane();

		pane.setLayout(new BorderLayout());

		initJTable(pane);

		jframe.validate();
	}

	public void initJTable(Container pane) {

		pane.removeAll();

		JTableModelValue values = new JTableModelValue(
				(ModelObject[]) AssetsDAO.getAll(), col);

		JTable table = new JTable(values);

		table.setRowHeight(30);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollpane = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		pane.add(scrollpane, BorderLayout.CENTER);

		table.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() > 1) {

					System.out.println("double left click");

				}
			}

			public void mousePressed(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)) {

					System.out.println("right click");

				}
			}

		});

	}

}
