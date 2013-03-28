package bll.controll;

import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vl.view.AllAssetsInStoragePage;
import vl.view.NewAssetPage;
import vl.view.NewDeliverOutPage;
import vl.view.NewRentOutPage;
import dal.dal.AssetsDAO;
import dal.dal.DeliverOutDAO;
import dal.dal.RentOutDAO;
import dal.model.Assets;
import dal.model.DeliverOut;
import dal.model.RentOut;

public class Controller {

	public static void saveNewAssetInfo(JFrame jframe, Assets asset,
			File[] files, NewAssetPage page) {

		String temp = new ImageFileCopy().copyFile(files, asset);

		asset.setAssetcontract(temp);

		if (AssetsDAO.insert(asset)) {

			JOptionPane.showMessageDialog(null, "数据保存成功", "SUCCESS",
					JOptionPane.INFORMATION_MESSAGE);

			page.dispose();

			new AllAssetsInStoragePage(jframe);
		} else {
			JOptionPane.showMessageDialog(null, "数据保存失败", "FAILED",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void saveNewDeliverOutInfo(JFrame jframe,
			DeliverOut deliverout, File[] files, NewDeliverOutPage page) {

		String temp = new ImageFileCopy().copyFile(files, deliverout);

		deliverout.setDelivercertificate(temp);

		if (DeliverOutDAO.insert(deliverout)) {

			JOptionPane.showMessageDialog(null, "数据保存成功", "SUCCESS",
					JOptionPane.INFORMATION_MESSAGE);

			page.dispose();

			new AllAssetsInStoragePage(jframe);
		} else {
			JOptionPane.showMessageDialog(null, "数据保存失败", "FAILED",
					JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public static void saveNewRentOutInfo(JFrame jframe,
			RentOut rentout, File[] files, NewRentOutPage page) {

		String temp = new ImageFileCopy().copyFile(files, rentout);

		rentout.setRentcertificate(temp);

		if (RentOutDAO.insert(rentout)) {

			JOptionPane.showMessageDialog(null, "数据保存成功", "SUCCESS",
					JOptionPane.INFORMATION_MESSAGE);

			page.dispose();

			new AllAssetsInStoragePage(jframe);
		} else {
			JOptionPane.showMessageDialog(null, "数据保存失败", "FAILED",
					JOptionPane.ERROR_MESSAGE);
		}

	}

}
