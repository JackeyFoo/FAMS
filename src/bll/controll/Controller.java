package bll.controll;

import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vl.view.AllAssetsDeliverOutPage;
import vl.view.AllAssetsDiscardPage;
import vl.view.AllAssetsInStoragePage;
import vl.view.AllAssetsMaintainPage;
import vl.view.AllAssetsPage;
import vl.view.AllAssetsRentOutPage;
import vl.view.AllAssetsTransferPage;
import vl.view.NewAssetPage;
import vl.view.NewDeliverOutPage;
import vl.view.NewDiscardPage;
import vl.view.NewMaintainPage;
import vl.view.NewRentOutPage;
import vl.view.NewTransferPage;
import dal.dal.AssetsDAO;
import dal.dal.DeliverOutDAO;
import dal.dal.DiscardDAO;
import dal.dal.MaintainDAO;
import dal.dal.RentOutDAO;
import dal.dal.TransferDAO;
import dal.model.Assets;
import dal.model.DeliverOut;
import dal.model.Discard;
import dal.model.Maintain;
import dal.model.RentOut;
import dal.model.Transfer;

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
	
	public static void updateAssetInfo(JFrame jframe, Assets asset,
			File[] files, NewAssetPage page) {

		String temp = new ImageFileCopy().copyFile(files, asset);

		asset.setAssetcontract(temp);

		if (AssetsDAO.update(asset)) {

			JOptionPane.showMessageDialog(null, "数据更新成功", "SUCCESS",
					JOptionPane.INFORMATION_MESSAGE);

			page.dispose();

			new AllAssetsPage(jframe);
		} else {
			JOptionPane.showMessageDialog(null, "数据更新失败", "FAILED",
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

			new AllAssetsDeliverOutPage(jframe, DeliverOutDAO.getAllDeliverOut());
		} else {
			JOptionPane.showMessageDialog(null, "数据保存失败", "FAILED",
					JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public static void updateDeliverOutInfo(JFrame jframe,
			DeliverOut deliverout, File[] files, NewDeliverOutPage page) {

		String temp = new ImageFileCopy().copyFile(files, deliverout);

		deliverout.setDelivercertificate(temp);

		if (DeliverOutDAO.update(deliverout)) {

			JOptionPane.showMessageDialog(null, "数据更新成功", "SUCCESS",
					JOptionPane.INFORMATION_MESSAGE);

			page.dispose();

			new AllAssetsDeliverOutPage(jframe, DeliverOutDAO.getAllDeliverOut());
		} else {
			JOptionPane.showMessageDialog(null, "数据更新失败", "FAILED",
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

			new AllAssetsRentOutPage(jframe, RentOutDAO.getAllRentOut());
		} else {
			JOptionPane.showMessageDialog(null, "数据保存失败", "FAILED",
					JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public static void updateRentOutInfo(JFrame jframe,
			RentOut rentout, File[] files, NewRentOutPage page) {

		String temp = new ImageFileCopy().copyFile(files, rentout);

		rentout.setRentcertificate(temp);

		if (RentOutDAO.update(rentout)) {

			JOptionPane.showMessageDialog(null, "数据更新成功", "SUCCESS",
					JOptionPane.INFORMATION_MESSAGE);

			page.dispose();

			new AllAssetsRentOutPage(jframe, RentOutDAO.getAllRentOut());
		} else {
			JOptionPane.showMessageDialog(null, "数据更新失败", "FAILED",
					JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public static void saveNewTransferInfo(JFrame jframe,
			Transfer transfer, File[] files, NewTransferPage page) {

		String temp = new ImageFileCopy().copyFile(files, transfer);

		transfer.setTransfercertificate(temp);

		if (TransferDAO.insert(transfer)) {

			JOptionPane.showMessageDialog(null, "数据保存成功", "SUCCESS",
					JOptionPane.INFORMATION_MESSAGE);

			page.dispose();

			new AllAssetsTransferPage(jframe, TransferDAO.getAllTransfer());
		} else {
			JOptionPane.showMessageDialog(null, "数据保存失败", "FAILED",
					JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public static void updateTransferInfo(JFrame jframe,
			Transfer transfer, File[] files, NewTransferPage page) {

		String temp = new ImageFileCopy().copyFile(files, transfer);

		transfer.setTransfercertificate(temp);

		if (TransferDAO.update(transfer)) {

			JOptionPane.showMessageDialog(null, "数据更新成功", "SUCCESS",
					JOptionPane.INFORMATION_MESSAGE);

			page.dispose();

			new AllAssetsTransferPage(jframe, TransferDAO.getAllTransfer());
		} else {
			JOptionPane.showMessageDialog(null, "数据更新失败", "FAILED",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void saveNewMaintainInfo(JFrame jframe,
			Maintain maintain, NewMaintainPage page) {

		if (MaintainDAO.insert(maintain)) {

			JOptionPane.showMessageDialog(null, "数据保存成功", "SUCCESS",
					JOptionPane.INFORMATION_MESSAGE);

			page.dispose();

			new AllAssetsMaintainPage(jframe,  MaintainDAO.getAllMaintain());
			
		} else {
			JOptionPane.showMessageDialog(null, "数据保存失败", "FAILED",
					JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public static void updateMaintainInfo(JFrame jframe,
			Maintain maintain, NewMaintainPage page) {

		if (MaintainDAO.update(maintain)) {

			JOptionPane.showMessageDialog(null, "数据更新成功", "SUCCESS",
					JOptionPane.INFORMATION_MESSAGE);

			page.dispose();

			new AllAssetsMaintainPage(jframe,  MaintainDAO.getAllMaintain());
			
		} else {
			JOptionPane.showMessageDialog(null, "数据更新失败", "FAILED",
					JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public static void saveNewDiscardInfo(JFrame jframe,
			Discard discard, File[] files, NewDiscardPage page) {

		String temp = new ImageFileCopy().copyFile(files, discard);

		discard.setDiscardcertificate(temp);

		if (DiscardDAO.insert(discard)) {

			JOptionPane.showMessageDialog(null, "数据保存成功", "SUCCESS",
					JOptionPane.INFORMATION_MESSAGE);

			page.dispose();

			new AllAssetsDiscardPage(jframe);
		} else {
			JOptionPane.showMessageDialog(null, "数据保存失败", "FAILED",
					JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public static void updateDiscardInfo(JFrame jframe,
			Discard discard, File[] files, NewDiscardPage page) {

		String temp = new ImageFileCopy().copyFile(files, discard);

		discard.setDiscardcertificate(temp);

		if (DiscardDAO.update(discard)) {

			JOptionPane.showMessageDialog(null, "数据更新成功", "SUCCESS",
					JOptionPane.INFORMATION_MESSAGE);

			page.dispose();

			new AllAssetsDiscardPage(jframe);
		} else {
			JOptionPane.showMessageDialog(null, "数据更新失败", "FAILED",
					JOptionPane.ERROR_MESSAGE);
		}

	}
}
