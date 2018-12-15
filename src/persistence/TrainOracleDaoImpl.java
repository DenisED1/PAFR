package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Train;
import ui.Logger;

public class TrainOracleDaoImpl extends OracleBaseDao implements TrainDao {
	private static Logger logger = new Logger();
	
	public boolean createTrain(Train train) {
		if (checkTrainName(train.getName())) {
			try (Connection conn = super.getConnection()) {
				String query = "insert into train values(?)";
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1, train.getName());
				pstmt.executeQuery();
				return true;
			} catch (SQLException e) {
				logger.printStackTrace(e);
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean deleteTrain(String name) {
		deleteTrainComponents(name);
		try (Connection conn = super.getConnection()) {
			String query = "delete from train where name = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.executeQuery();
			return true;
		} catch (SQLException e) {
			logger.printStackTrace(e);
			return false;
		}
	}

	public int getSeatsTrain(String trainName) {
		try (Connection conn = super.getConnection()) {
			String query = "select sum(c.seats) as seats\r\n" + "from component c, connection conn\r\n"
					+ "where c.name = conn.componentname\r\n" + "and conn.trainname = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, trainName);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("SEATS");				
			} else {
				return -1;
			}
		} catch (SQLException e) {
			logger.printStackTrace(e);
			return -1;
		}
	}

	private void deleteTrainComponents(String name) {
		try (Connection conn = super.getConnection()) {
			String query = "delete from connection where trainname = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.executeQuery();
		} catch (SQLException e) {
			logger.printStackTrace(e);
		}
	}

	private boolean checkTrainName(String name) {
		try (Connection conn = super.getConnection()) {
			String query = "select name from train where name = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return false;
			} else {
				return true;
			}
		} catch (

		SQLException e) {
			logger.printStackTrace(e);
			return false;
		}
	}
}
