package bll.controll;

import java.io.File;

import vl.interfaces.MyDialog;
import vl.interfaces.MyJFrame;
import vl.main.Main;
import vl.util.NWEDialog;
import vl.view.listpage.AllAssetsDeliverOutPage;
import vl.view.listpage.AllAssetsDiscardPage;
import vl.view.listpage.AllAssetsInStoragePage;
import vl.view.listpage.AllAssetsMaintainPage;
import vl.view.listpage.AllAssetsPage;
import vl.view.listpage.AllAssetsRentOutPage;
import vl.view.listpage.AllAssetsTransferPage;
import vl.view.newpage.NewAssetPage;
import vl.view.newpage.NewDeliverOutPage;
import vl.view.newpage.NewDiscardPage;
import vl.view.newpage.NewMaintainPage;
import vl.view.newpage.NewRentOutPage;
import vl.view.newpage.NewTransferPage;
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

	public static void saveNewAssetInfo(MyJFrame jframe, Assets asset,
			File[] files, NewAssetPage page) {

		String temp = new ImageFileCopy().copyFile(files, asset);

		asset.setAssetcontract(temp);

		if (AssetsDAO.insert(asset)) {

			NWEDialog.dataSaveSuccess(page);

			page.dispose();

			new AllAssetsInStoragePage(jframe);
		} else {
			NWEDialog.dataSaveFailed(page);
		}

	}

	public static void updateAssetInfo(MyJFrame jframe, Assets asset,
			File[] files, NewAssetPage page) {

		String temp = new ImageFileCopy().copyFile(files, asset);

		asset.setAssetcontract(temp);

		if (AssetsDAO.update(asset)) {

			NWEDialog.dataUpdateSuccess(page);

			page.dispose();

			new AllAssetsPage(jframe);
		} else {
			NWEDialog.dataUpdateFailed(page);
		}

	}

	public static void saveNewDeliverOutInfo(MyJFrame jframe,
			DeliverOut deliverout, File[] files, NewDeliverOutPage page) {

		String temp = new ImageFileCopy().copyFile(files, deliverout);

		deliverout.setDelivercertificate(temp);

		if (DeliverOutDAO.insert(deliverout)) {

			NWEDialog.dataSaveSuccess(page);

			page.dispose();

			new AllAssetsDeliverOutPage(jframe,
					DeliverOutDAO.getAllDeliverOut());
		} else {
			NWEDialog.dataSaveFailed(page);
		}

	}

	public static void updateDeliverOutInfo(MyJFrame jframe,
			DeliverOut deliverout, File[] files, NewDeliverOutPage page) {

		String temp = new ImageFileCopy().copyFile(files, deliverout);

		deliverout.setDelivercertificate(temp);

		if (DeliverOutDAO.update(deliverout)) {

			NWEDialog.dataUpdateSuccess(page);

			page.dispose();

			new AllAssetsDeliverOutPage(jframe,
					DeliverOutDAO.getAllDeliverOut());
		} else {
			NWEDialog.dataUpdateFailed(page);
		}

	}

	public static void saveNewRentOutInfo(MyJFrame jframe, RentOut rentout,
			File[] files, NewRentOutPage page) {

		String temp = new ImageFileCopy().copyFile(files, rentout);

		rentout.setRentcertificate(temp);

		if (RentOutDAO.insert(rentout)) {

			NWEDialog.dataSaveSuccess(page);

			page.dispose();

			new AllAssetsRentOutPage(jframe, RentOutDAO.getAllRentOut());
		} else {
			NWEDialog.dataSaveFailed(page);
		}

	}

	public static void updateRentOutInfo(MyJFrame jframe, RentOut rentout,
			File[] files, NewRentOutPage page) {

		String temp = new ImageFileCopy().copyFile(files, rentout);

		rentout.setRentcertificate(temp);

		if (RentOutDAO.update(rentout)) {

			NWEDialog.dataUpdateSuccess(page);

			page.dispose();

			new AllAssetsRentOutPage(jframe, RentOutDAO.getAllRentOut());
		} else {
			NWEDialog.dataUpdateFailed(page);
		}

	}

	public static void saveNewTransferInfo(MyJFrame jframe, Transfer transfer,
			File[] files, NewTransferPage page) {

		String temp = new ImageFileCopy().copyFile(files, transfer);

		transfer.setTransfercertificate(temp);

		if (TransferDAO.insert(transfer)) {

			NWEDialog.dataSaveSuccess(page);

			page.dispose();

			new AllAssetsTransferPage(jframe, TransferDAO.getAllTransfer());
		} else {
			NWEDialog.dataSaveFailed(page);
		}

	}

	public static void updateTransferInfo(MyJFrame jframe, Transfer transfer,
			File[] files, NewTransferPage page) {

		String temp = new ImageFileCopy().copyFile(files, transfer);

		transfer.setTransfercertificate(temp);

		if (TransferDAO.update(transfer)) {

			NWEDialog.dataUpdateSuccess(page);

			page.dispose();

			new AllAssetsTransferPage(jframe, TransferDAO.getAllTransfer());
		} else {
			NWEDialog.dataUpdateFailed(page);
		}

	}

	public static void saveNewMaintainInfo(MyJFrame jframe, Maintain maintain,
			NewMaintainPage page) {

		if (MaintainDAO.insert(maintain)) {

			NWEDialog.dataSaveSuccess(page);

			page.dispose();

			new AllAssetsMaintainPage(jframe, MaintainDAO.getAllMaintain());

		} else {
			NWEDialog.dataSaveFailed(page);
		}

	}

	public static void updateMaintainInfo(MyJFrame jframe, Maintain maintain,
			NewMaintainPage page) {

		if (MaintainDAO.update(maintain)) {

			NWEDialog.dataUpdateSuccess(page);

			page.dispose();

			new AllAssetsMaintainPage(jframe, MaintainDAO.getAllMaintain());

		} else {
			NWEDialog.dataUpdateFailed(page);
		}

	}

	public static void saveNewDiscardInfo(MyJFrame jframe, Discard discard,
			File[] files, NewDiscardPage page) {

		String temp = new ImageFileCopy().copyFile(files, discard);

		discard.setDiscardcertificate(temp);

		if (DiscardDAO.insert(discard)) {

			NWEDialog.dataSaveSuccess(page);

			page.dispose();

			new AllAssetsDiscardPage(jframe);
		} else {
			NWEDialog.dataSaveFailed(page);
		}

	}

	public static void updateDiscardInfo(MyJFrame jframe, Discard discard,
			File[] files, NewDiscardPage page) {

		String temp = new ImageFileCopy().copyFile(files, discard);

		discard.setDiscardcertificate(temp);

		if (DiscardDAO.update(discard)) {

			NWEDialog.dataUpdateSuccess(page);

			page.dispose();

			new AllAssetsDiscardPage(jframe);
		} else {
			NWEDialog.dataUpdateFailed(page);
		}

	}

	public static void showScanResult(String msg) {
		if (NWEDialog.showScan(msg)) {
			new AllAssetsPage(Main.mainpage, Integer.parseInt(msg));
		}
	}

	public static Assets getAssets(String msg) {
		Assets assets = AssetsDAO.getAsset(Integer.parseInt(msg));

		return assets;
	}

	public static void deliveroutReturn(MyJFrame jframe, DeliverOut deliverout,
			MyDialog dialog) {
		if (DeliverOutDAO.returned(deliverout)) {

			NWEDialog.returnSuccess(dialog);

			dialog.dispose();

			new AllAssetsInStoragePage(Main.mainpage);

		} else {
			NWEDialog.returnFailed(dialog);
		}
	}

	public static void rentoutReturn(MyJFrame jframe, RentOut rentout,
			MyDialog dialog) {
		if (RentOutDAO.returned(rentout)) {

			NWEDialog.returnSuccess(dialog);

			dialog.dispose();

			new AllAssetsInStoragePage(Main.mainpage);

		} else {
			NWEDialog.returnFailed(dialog);
		}
	}

	public static void maintainFinished(MyJFrame jframe, Assets asset,
			Maintain maintain, MyDialog dialog) {

		if (MaintainDAO.maintainFinished(maintain)) {

			NWEDialog.dataUpdateSuccess(dialog);

			dialog.dispose();

			if (asset.getAssetindeliverstatus().equals("³ö¿â")) {

				new AllAssetsDeliverOutPage(jframe,
						DeliverOutDAO.getAllDeliverOut());

			} else if (asset.getAssetindeliverstatus().equals("×ªÒÆ")) {

				new AllAssetsTransferPage(jframe, TransferDAO.getAllTransfer());

			}

		} else {

			NWEDialog.dataUpdateFailed(dialog);
		}
	}
}
