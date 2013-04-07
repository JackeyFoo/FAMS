package dal.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import dal.model.Maintain;

public class MaintainDAO {
	public static boolean insert(Maintain maintain) {

		try {
			updateNewRecord(maintain.getAssetid());

			String sql = "insert into Maintain(AssetID, MaintainDepartment, DownDate, MaintainHandler,"
					+ "DownRemark, DownPhenomenon, MaintainProcess, DeviceStatus, MaintainCost, MaintainRecordIsNew) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = SQLDBConnect.getSQLDBConection()
					.prepareStatement(sql);

			statement.setInt(1, maintain.getAssetid());
			statement.setString(2, maintain.getMaintaindepartment());
			statement.setString(3, maintain.getDowndate());
			statement.setString(4, maintain.getMaintainhandler());
			statement.setString(5, maintain.getDownremark());
			statement.setString(6, maintain.getDownphenomenon());
			statement.setString(7, maintain.getMaintainprocess());
			statement.setString(8, maintain.getDevicestatus());
			statement.setDouble(9, maintain.getMaintaincost());
			statement.setString(10, maintain.getMaintainrecordisnew());

			statement.execute();

			AssetsDAO.maintain(maintain.getAssetid());

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	private static boolean updateNewRecord(int assetid) {

		PreparedStatement statement;
		try {

			String sql = "update Maintain set MaintainRecordIsNew='·ñ' "
					+ "where AssetID=? AND MaintainRecordIsNew='×îÐÂ'";

			statement = SQLDBConnect.getSQLDBConection().prepareStatement(sql);

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
					.executeQuery("SELECT IDENT_CURRENT('Maintain')");

			while (result.next()) { // process results one row at a time
				id = result.getInt(1);
			}

			if (id == 1) {
				result = select.executeQuery("SELECT * FROM Maintain");

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

	public static Maintain[] getAllMaintain() {

		try {

			Maintain[] maintains;
			int size = 0;
			int i = 0;

			Statement select = SQLDBConnect.getSQLDBConection()
					.createStatement();

			ResultSet result = select
					.executeQuery("SELECT COUNT(*) FROM Maintain, Assets WHERE Assets.AssetID = Maintain.AssetID  AND Assets.AssetRunningStatus='Î¬ÐÞ'");

			while (result.next()) {
				size = result.getInt(1);
			}

			maintains = new Maintain[size];

			result = select
					.executeQuery("SELECT Maintain.* FROM Maintain, Assets WHERE Assets.AssetID = Maintain.AssetID  AND Assets.AssetRunningStatus='Î¬ÐÞ'");

			while (result.next() && i < size) { // process results one row at a
												// time

				maintains[i] = new Maintain();

				maintains[i].setMaintainid(result.getInt(1));
				maintains[i].setAssetid(result.getInt(2));
				maintains[i].setMaintaindepartment(result.getString(3));
				maintains[i].setDowndate(result.getString(4));
				maintains[i].setMaintainhandler(result.getString(5));
				maintains[i].setDownremark(result.getString(6));
				maintains[i].setDownphenomenon(result.getString(7));
				maintains[i].setMaintainprocess(result.getString(8));
				maintains[i].setDevicestatus(result.getString(9));
				maintains[i].setMaintaincost(result.getDouble(10));
				maintains[i].setMaintainrecordisnew(result.getString(11));

				i++;
			}

			return maintains;

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		}

	}

	public static Maintain getMaintain(int id) {

		try {

			Maintain maintains = new Maintain();
			
			String sql = "SELECT * FROM Maintain WHERE MaintainID=?";

			PreparedStatement statement = SQLDBConnect.getSQLDBConection()
					.prepareStatement(sql);

			statement.setInt(1, id);

			ResultSet result = statement.executeQuery();

			while (result.next()) { // process results one row at a

				maintains.setMaintainid(result.getInt(1));
				maintains.setAssetid(result.getInt(2));
				maintains.setMaintaindepartment(result.getString(3));
				maintains.setDowndate(result.getString(4));
				maintains.setMaintainhandler(result.getString(5));
				maintains.setDownremark(result.getString(6));
				maintains.setDownphenomenon(result.getString(7));
				maintains.setMaintainprocess(result.getString(8));
				maintains.setDevicestatus(result.getString(9));
				maintains.setMaintaincost(result.getDouble(10));
				maintains.setMaintainrecordisnew(result.getString(11));

			}

			return maintains;

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		}

	}
}
