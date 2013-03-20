package vl.main;

import java.awt.EventQueue;

import vl.view.MainPage;


public class Main {
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					
					System.out.println(System.currentTimeMillis());
					MainPage frame = new MainPage(100, 100, 1000, 600);
					frame.setVisible(true);
					System.out.println(System.currentTimeMillis());
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
