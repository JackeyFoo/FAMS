package dal.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import dal.model.Discard;


public class DiscardDAO {
	public static boolean insert(Discard discard) {

		try {
			String sql = "insert into Discard(AssetID, DiscardDepartment, DiscardDate,"
					+ "DiscardReason, DiscardCertificate) "
					+ "values(?, ?, ?, ?, ?)";

			PreparedStatement statement = SQLDBConnect.getSQLDBConection()
					.prepareStatement(sql);

			statement.setInt(1, discard.getAssetid());
			statement.setString(2, discard.getDiscarddepartment());
			statement.setString(3, discard.getDiscarddate());
			statement.setString(4, discard.getDiscardreason());
			statement.setString(5, discard.getDiscardcertificate());


			statement.execute();

			AssetsDAO.discard(discard.getAssetid());

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean update(Discard discard) {

		try {
			String sql = "UPDATE Discard SET DiscardDepartment=?, DiscardDate=?,"
					+ "DiscardReason=?, DiscardCertificate=? WHERE DiscardID=?";

			PreparedStatement statement = SQLDBConnect.getSQLDBConection()
					.prepareStatement(sql);

			statement.setString(1, discard.getDiscarddepartment());
			statement.setString(2, discard.getDiscarddate());
			statement.setString(3, discard.getDiscardreason());
			statement.setString(4, discard.getDiscardcertificate());
			statement.setInt(4, discard.getDiscardid());

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
					.executeQuery("SELECT IDENT_CURRENT('Discard')");

			while (result.next()) { // process results one row at a time
				id = result.getInt(1);
			}

			if (id == 1) {
				result = select.executeQuery("SELECT * FROM Discard");

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
	
	public static Discard[] getAllDiscard() {

		try {

			Discard[] discards;
			int size = 0;
			int i = 0;

			Statement select = SQLDBConnect.getSQLDBConection()
					.createStatement();

			ResultSet result = select
					.executeQuery("SELECT COUNT(*) FROM Discard, Assets WHERE Assets.AssetID = Discard.AssetID AND Assets.AssetRunningStatus='±¨·Ï'");

			while (result.next()) {
				size = result.getInt(1);
			}

			discards = new Discard[size];

			result = select
					.executeQuery("SELECT Discard.* FROM Discard, Assets WHERE Assets.AssetID = Discard.AssetID AND Assets.AssetRunningStatus='±¨·Ï'");

			while (result.next() && i < size) { // process results one row at a
												// time

				discards[i] = new Discard();

				discards[i].setDiscardid(result.getInt(1));
				discards[i].setAssetid(result.getInt(2));
				discards[i].setDiscarddepartment(result.getString(3));
				discards[i].setDiscarddate(result.getString(4));
				discards[i].setDiscardreason(result.getString(5));
				discards[i].setDiscardcertificate(result.getString(6));
				
				i++;
			}

			return discards;

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		}

	}
}
