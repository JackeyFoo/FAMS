package vl.component;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import bll.controll.MenuItemActionListen;

public class Jmenubar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Jmenubar() {
		super();
		// setFont();
	}

	public void setJmenu(JFrame jframe, final String arg, final String args[],
			final int argc[], final String itemclassname) {

		Jmenu jmenu = new Jmenu(arg);
		jmenu.setJmenu(jframe,args, argc, itemclassname);

		add(jmenu);
	}

}

class Jmenu extends JMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Jmenu(String text) {

		super();
		// setFont();
		setText(text);
	}

	public void setJmenu(JFrame jframe, String args[], int argc[], String itemclassname) {

		for (int i = 0, j = 0; i < args.length; i++) {

			if (itemclassname == "checkboxitem") {
				Jcheckboxmenuitem item = new Jcheckboxmenuitem(args[i]);

				this.add(item);
			} else if (itemclassname == "menuitem") {

				Jmenuitem jmenuitem = new Jmenuitem(jframe, args[i]);

				this.add(jmenuitem);
			}

			if ((argc != null) && (j < argc.length) && (i == argc[j] - 1)) {
				j++;
				addSeparator();
			}
		}
	}
}

class Jmenuitem extends JMenuItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Jmenuitem(JFrame jframe, String text) {
		super();
		// setFont(font);
		setText(text + "   ");
		setActionCommand(text);

		addActionListener(new MenuItemActionListen(jframe));
		// set icon
		/*
		 * if (text == "Find/Replace") setIcon(new
		 * ImageIcon(".\\src\\icon16\\Find Replace.png")); else setIcon(new
		 * ImageIcon(".\\src\\icon16\\" + text + ".png"));
		 */
	}
}

class Jcheckboxmenuitem extends JCheckBoxMenuItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Jcheckboxmenuitem(String text) {
		super();
		// setFont(JFrame_alpha.font_sub);
		setText(text + "   ");
		setActionCommand(text);
		// addItemListener();
	}
}
