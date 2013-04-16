package dal.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import dal.model.DeliverOut;

public class DeliverOutDAO {
	public static boolean insert(DeliverOut deliverout) {

		try {

			updateNewRecord(deliverout.getAssetid());

			String sql = "INSERT INTO DeliverOut(AssetID, DeliverDepartment, DeliverStaff, DeliverDate,"
					+ "DeliverAddress, DeliverRemark, DeliverCertificate, DeliverRecordIsNew, ReturnDate, ReturnStaff) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = SQLDBConnect.getSQLDBConection()
					.prepareStatement(sql);

			statement.setInt(1, deliverout.getAssetid());
			statement.setString(2, deliverout.getDeliverdepartment());
			statement.setString(3, deliverout.getDeliverstaff());
			statement.setString(4, deliverout.getDeliverdate());
			statement.setString(5, deliverout.getDeliveraddress());
			statement.setString(6, deliverout.getDeliverremark());
			statement.setString(7, deliverout.getDelivercertificate());
			statement.setString(8, deliverout.getDeliverrecordisnew());
			statement.setString(9, deliverout.getReturndate());
			statement.setString(10, deliverout.getReturnstaff());

			statement.execute();

			AssetsDAO.deliverOut(deliverout.getAssetid());

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public static boolean update(DeliverOut deliverout) {

		try {

			String sql = "UPDATE DeliverOut SET DeliverDepartment=?, DeliverStaff=?, DeliverDate=?,"
					+ "DeliverAddress=?, DeliverRemark=?, DeliverCertificate=?, ReturnDate=?, ReturnStaff=? WHERE DeliverOutID=?";

			PreparedStatement statement = SQLDBConnect.getSQLDBConection()
					.prepareStatement(sql);

			statement.setString(1, deliverout.getDeliverdepartment());
			statement.setString(2, deliverout.getDeliverstaff());
			statement.setString(3, deliverout.getDeliverdate());
			statement.setString(4, deliverout.getDeliveraddress());
			statement.setString(5, deliverout.getDeliverremark());
			statement.setString(6, deliverout.getDelivercertificate());
			statement.setString(7, deliverout.getReturndate());
			statement.setString(8, deliverout.getReturnstaff());
			statement.setInt(9, deliverout.getDeliveroutid());

			statement.execute();

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public static boolean returned(DeliverOut deliverout) {

		try {

			String sql = "UPDATE DeliverOut SET ReturnDate=?, ReturnStaff=? WHERE DeliverOutID=?";

			PreparedStatement statement = SQLDBConnect.getSQLDBConection()
					.prepareStatement(sql);

			statement.setString(1, deliverout.getReturndate());
			statement.setString(2, deliverout.getReturnstaff());
			statement.setInt(3, deliverout.getDeliveroutid());

			statement.execute();

			AssetsDAO.returned(deliverout.getAssetid());

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	private static boolean updateNewRecord(int assetid) {

		try {

			String sql = "update DeliverOut set DeliverRecordIsNew='��' "
					+ "where AssetID=? AND DeliverRecordIsNew='����'";

			PreparedStatement statement = SQLDBConnect.getSQLDBConection()
					.prepareStatement(sql);

			statement.setInt(1, assetid);

			statement.execute();

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return false;
		}
	}

	public static int getID() {
		int id = -1;

		try {

			Statement select = SQLDBConnect.getSQLDBConection()
					.createStatement();

			ResultSet result = select
					.executeQuery("SELECT IDENT_CURRENT('DeliverOut')");

			while (result.next()) { // process results one row at a time
				id = result.getInt(1);
			}

			if (id == 1) {
				result = select.executeQuery("SELECT * FROM DeliverOut");

				if (!result.next()) {
					id = 0;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id + 1;
	}

	public static DeliverOut[] getAllDeliverOut() {

		try {

			DeliverOut[] deliverouts = null;
			int size = 0;
			int i = 0;

			Statement select = SQLDBConnect.getSQLDBConection()
					.createStatement();

			ResultSet result = select
					.executeQuery("SELECT COUNT(*) FROM DeliverOut, Assets WHERE Assets.AssetID = DeliverOut.AssetID AND Assets.AssetInDeliverStatus='����' AND Assets.AssetRunningStatus='����' AND DeliverOut.DeliverRecordIsNew='����'");

			while (result.next()) {
				size = result.getInt(1);
			}

			deliverouts = new DeliverOut[size];

			result = select
					.executeQuery("SELECT DeliverOut.* FROM DeliverOut, Assets WHERE Assets.AssetID = DeliverOut.AssetID AND Assets.AssetInDeliverStatus='����' AND Assets.AssetRunningStatus='����' AND DeliverOut.DeliverRecordIsNew='����'");

			while (result.next() && i < size) { // process results one row at a
												// time

				deliverouts[i] = new DeliverOut();

				deliverouts[i].setDeliveroutid(result.getInt(1));
				deliverouts[i].setAssetid(result.getInt(2));
				deliverouts[i].setDeliverdepartment(result.getString(3));
				deliverouts[i].setDeliverstaff(result.getString(4));
				deliverouts[i].setDeliverdate(result.getString(5));
				deliverouts[i].setDeliveraddress(result.getString(6));
				deliverouts[i].setDeliverremark(result.getString(7));
				deliverouts[i].setDelivercertificate(result.getString(8));
				deliverouts[i].setDeliverrecordisnew(result.getString(9));
				deliverouts[i].setReturndate(result.getString(10));
				deliverouts[i].setReturnstaff(result.getString(11));

				i++;
			}

			return deliverouts;

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		}

	}

	public static DeliverOut getDeliverOut(int id) {

		try {

			DeliverOut deliverouts = null;

			String sql = "SELECT DeliverOut.* FROM DeliverOut WHERE AssetID=? AND DeliverRecordIsNew='����'";

			PreparedStatement statement = SQLDBConnect.getSQLDBConection()
					.prepareStatement(sql);

			statement.setInt(1, id);

			ResultSet result = statement.executeQuery();

			while (result.next()) { // process results one row at a
									// time

				deliverouts = new DeliverOut();

				deliverouts.setDeliveroutid(result.getInt(1));
				deliverouts.setAssetid(result.getInt(2));
				deliverouts.setDeliverdepartment(result.getString(3));
				deliverouts.setDeliverstaff(result.getString(4));
				deliverouts.setDeliverdate(result.getString(5));
				deliverouts.setDeliveraddress(result.getString(6));
				deliverouts.setDeliverremark(result.getString(7));
				deliverouts.setDelivercertificate(result.getString(8));
				deliverouts.setDeliverrecordisnew(result.getString(9));
				deliverouts.setReturndate(result.getString(10));
				deliverouts.setReturnstaff(result.getString(11));
			}

			return deliverouts;

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		}

	}

	public static DeliverOut[] getDeliverOutHistory(int id) {

		try {

			DeliverOut[] deliverouts;
			int size = 0;
			int i = 0;

			String sql = "SELECT COUNT(*) FROM DeliverOut WHERE AssetID=?";

			PreparedStatement statement = SQLDBConnect.getSQLDBConection()
					.prepareStatement(sql);

			statement.setInt(1, id);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				size = result.getInt(1);
			}

			deliverouts = new DeliverOut[size];

			sql = "SELECT * FROM DeliverOut WHERE AssetID=?";

			statement = SQLDBConnect.getSQLDBConection().prepareStatement(sql);

			statement.setInt(1, id);

			result = statement.executeQuery();

			while (result.next() && i < size) { // process results one row at a
												// time

				deliverouts[i] = new DeliverOut();

				deliverouts[i].setDeliveroutid(result.getInt(1));
				deliverouts[i].setAssetid(result.getInt(2));
				deliverouts[i].setDeliverdepartment(result.getString(3));
				deliverouts[i].setDeliverstaff(result.getString(4));
				deliverouts[i].setDeliverdate(result.getString(5));
				deliverouts[i].setDeliveraddress(result.getString(6));
				deliverouts[i].setDeliverremark(result.getString(7));
				deliverouts[i].setDelivercertificate(result.getString(8));
				deliverouts[i].setDeliverrecordisnew(result.getString(9));
				deliverouts[i].setReturndate(result.getString(10));
				deliverouts[i].setReturnstaff(result.getString(11));

				i++;
			}

			return deliverouts;

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		}

	}

}
