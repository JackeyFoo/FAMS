package vl.view.terminalpage;

import java.awt.Component;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;

import bll.server.FAMSClientInfos;
import dal.model.ClientInfo;

public class TerminalPage extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTree jtree;
	private DefaultMutableTreeNode root;

	public TerminalPage(String str, ImageIcon icon) {

		root = new JClientNode(null, null);

		jtree = new JTree(root);

		jtree.setCellRenderer(new ClientRenderer());

		JScrollPane pane = new JScrollPane(jtree);

		this.addTab(str, icon, pane);

		refreshJTree();

	}

	public void refreshJTree() {

		Iterator<Entry<ClientInfo, Socket>> iter = FAMSClientInfos.termap
				.entrySet().iterator();

		while (iter.hasNext()) {
			Map.Entry<ClientInfo, Socket> entry = (Entry<ClientInfo, Socket>) iter
					.next();

			JClientNode node = new JClientNode(entry.getKey(), entry.getValue());
			
			System.out.println(node.getToolTipText());

			root.add(node);
		}

		jtree.expandPath(new TreePath(root));
	}

}

class JClientNode extends DefaultMutableTreeNode {

	/**
	 * 
	 */
	private ClientInfo info;
	private Socket socket;
	private static final long serialVersionUID = 1L;

	public JClientNode(ClientInfo info, Socket socket) {
		this.info = info;
		this.socket = socket;
	}

	public boolean isLeaf() {
		
		if (info == null || socket == null) {
			return false;
		} else {
			return true;
		}
	}

	public String toString() {

		if (info == null || socket == null) {
			return "жу╤к";
		} else {
			return info.getName();
		}
	}

	public String getToolTipText() {

		String str;
		if (info == null || socket == null) {
			str = "";
		} else {
			str = info.getName() + "\n" + info.getMac() + "\n" + info.getIp()
					+ "\n";
		}

		return str;
	}

}

class ClientRenderer extends DefaultTreeCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1540527456177459431L;

	public ClientRenderer() {
	}

	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean sel, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {

		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf,
				row, hasFocus);
		JClientNode node = (JClientNode) value;

		if (leaf) {
			setIcon(new ImageIcon(".\\src\\img\\terminal.png"));
		} else {
			setIcon(new ImageIcon(".\\src\\img\\terminal.png"));
		}

		setToolTipText(node.getToolTipText());

		return this;
	}
}