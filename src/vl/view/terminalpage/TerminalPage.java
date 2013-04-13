package vl.view.terminalpage;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;

public class TerminalPage extends JTabbedPane{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTree jtree;
	
	public TerminalPage(String str, ImageIcon icon){
		
		JScrollPane pane = new JScrollPane();
		
		jtree = new JTree();
		
		pane.add(jtree);
		
		this.addTab(str, icon, pane);
		
	}

}
