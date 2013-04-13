package vl.main;

import java.awt.EventQueue;
import vl.view.MainPage;


public class Main {
	public static MainPage mainpage;
	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					
					System.out.println(System.currentTimeMillis());
					mainpage = new MainPage(100, 100, 1100, 600);
					mainpage.setVisible(true);
					System.out.println(System.currentTimeMillis());
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
