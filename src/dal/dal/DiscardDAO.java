package dal.dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import dal.model.Discard;


public class DiscardDAO {
	public boolean insert(Discard discard) {

		try {
			String sql = "insert into Discard(AssetID, DiscardDepartment, PreDiscardDate, DiscardDate,"
					+ "DiscardReason, DiscardCertificate) "
					+ "value(?, ?, ?, ?, ?, ?,)";

			PreparedStatement statement = SQLDBConnect.getSQLDBConection()
					.prepareStatement(sql);

			statement.setInt(1, discard.getAssetid());
			statement.setString(2, discard.getDiscarddepartment());
			statement.setString(3, discard.getPrediscarddate());
			statement.setString(4, discard.getDiscarddate());
			statement.setString(5, discard.getDiscardreason());
			statement.setString(6, discard.getDiscardcertificate());


			return statement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
