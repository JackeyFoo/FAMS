package bll.controll;

import java.io.File;
import vl.interfaces.MyJFrame;
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
			
			NWEDialog.dataSaveSuccess();

			page.dispose();

			new AllAssetsInStoragePage(jframe);
		} else {
			NWEDialog.dataSaveFailed();
		}

	}
	
	public static void updateAssetInfo(MyJFrame jframe, Assets asset,
			File[] files, NewAssetPage page) {

		String temp = new ImageFileCopy().copyFile(files, asset);

		asset.setAssetcontract(temp);

		if (AssetsDAO.update(asset)) {

			NWEDialog.dataUpdateSuccess();

			page.dispose();

			new AllAssetsPage(jframe);
		} else {
			NWEDialog.dataUpdateFailed();
		}

	}

	public static void saveNewDeliverOutInfo(MyJFrame jframe,
			DeliverOut deliverout, File[] files, NewDeliverOutPage page) {

		String temp = new ImageFileCopy().copyFile(files, deliverout);

		deliverout.setDelivercertificate(temp);

		if (DeliverOutDAO.insert(deliverout)) {

			NWEDialog.dataSaveSuccess();

			page.dispose();

			new AllAssetsDeliverOutPage(jframe, DeliverOutDAO.getAllDeliverOut());
		} else {
			NWEDialog.dataSaveFailed();
		}

	}
	
	public static void updateDeliverOutInfo(MyJFrame jframe,
			DeliverOut deliverout, File[] files, NewDeliverOutPage page) {

		String temp = new ImageFileCopy().copyFile(files, deliverout);

		deliverout.setDelivercertificate(temp);

		if (DeliverOutDAO.update(deliverout)) {

			NWEDialog.dataUpdateSuccess();

			page.dispose();

			new AllAssetsDeliverOutPage(jframe, DeliverOutDAO.getAllDeliverOut());
		} else {
			NWEDialog.dataUpdateFailed();
		}

	}
	
	public static void saveNewRentOutInfo(MyJFrame jframe,
			RentOut rentout, File[] files, NewRentOutPage page) {

		String temp = new ImageFileCopy().copyFile(files, rentout);

		rentout.setRentcertificate(temp);

		if (RentOutDAO.insert(rentout)) {

			NWEDialog.dataSaveSuccess();

			page.dispose();

			new AllAssetsRentOutPage(jframe, RentOutDAO.getAllRentOut());
		} else {
			NWEDialog.dataSaveFailed();
		}

	}
	
	public static void updateRentOutInfo(MyJFrame jframe,
			RentOut rentout, File[] files, NewRentOutPage page) {

		String temp = new ImageFileCopy().copyFile(files, rentout);

		rentout.setRentcertificate(temp);

		if (RentOutDAO.update(rentout)) {

			NWEDialog.dataUpdateSuccess();

			page.dispose();

			new AllAssetsRentOutPage(jframe, RentOutDAO.getAllRentOut());
		} else {
			NWEDialog.dataUpdateFailed();
		}

	}
	
	public static void saveNewTransferInfo(MyJFrame jframe,
			Transfer transfer, File[] files, NewTransferPage page) {

		String temp = new ImageFileCopy().copyFile(files, transfer);

		transfer.setTransfercertificate(temp);

		if (TransferDAO.insert(transfer)) {

			NWEDialog.dataSaveSuccess();

			page.dispose();

			new AllAssetsTransferPage(jframe, TransferDAO.getAllTransfer());
		} else {
			NWEDialog.dataSaveFailed();
		}

	}
	
	public static void updateTransferInfo(MyJFrame jframe,
			Transfer transfer, File[] files, NewTransferPage page) {

		String temp = new ImageFileCopy().copyFile(files, transfer);

		transfer.setTransfercertificate(temp);

		if (TransferDAO.update(transfer)) {

			NWEDialog.dataUpdateSuccess();

			page.dispose();

			new AllAssetsTransferPage(jframe, TransferDAO.getAllTransfer());
		} else {
			NWEDialog.dataUpdateFailed();
		}

	}

	public static void saveNewMaintainInfo(MyJFrame jframe,
			Maintain maintain, NewMaintainPage page) {

		if (MaintainDAO.insert(maintain)) {

			NWEDialog.dataSaveSuccess();

			page.dispose();

			new AllAssetsMaintainPage(jframe,  MaintainDAO.getAllMaintain());
			
		} else {
			NWEDialog.dataSaveFailed();
		}

	}
	
	public static void updateMaintainInfo(MyJFrame jframe,
			Maintain maintain, NewMaintainPage page) {

		if (MaintainDAO.update(maintain)) {

			NWEDialog.dataUpdateSuccess();

			page.dispose();

			new AllAssetsMaintainPage(jframe,  MaintainDAO.getAllMaintain());
			
		} else {
			NWEDialog.dataUpdateFailed();
		}

	}
	
	public static void saveNewDiscardInfo(MyJFrame jframe,
			Discard discard, File[] files, NewDiscardPage page) {

		String temp = new ImageFileCopy().copyFile(files, discard);

		discard.setDiscardcertificate(temp);

		if (DiscardDAO.insert(discard)) {

			NWEDialog.dataSaveSuccess();

			page.dispose();

			new AllAssetsDiscardPage(jframe);
		} else {
			NWEDialog.dataSaveFailed();
		}

	}
	
	public static void updateDiscardInfo(MyJFrame jframe,
			Discard discard, File[] files, NewDiscardPage page) {

		String temp = new ImageFileCopy().copyFile(files, discard);

		discard.setDiscardcertificate(temp);

		if (DiscardDAO.update(discard)) {

			NWEDialog.dataUpdateSuccess();

			page.dispose();

			new AllAssetsDiscardPage(jframe);
		} else {
			NWEDialog.dataUpdateFailed();
		}

	}
	
	public static void showScanResult(){
		
	}
}
