package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Main.ODICareer;

public class ODICareerDAO {
	Connection con = null;
	static final String url = "jdbc:mysql://localhost:3306/cricket";
	static final String username = "root";
	static final String password = "root";

	public void connect() {
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("Error in setting connection");
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Error in closing the connection");
			e.printStackTrace();
		}
	}

	public ODICareer getODICareer(int id) {
		ODICareer oc = null;
		Statement st = null;
		ResultSet rs = null;
		String query = "select * from odi_career where id = " + id;
		int matches = -1, runs = -1, wickets = -1;
		double batting_avg = -1, bowling_avg = -1, batting_sr = -1, bowling_sr = -1;
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			rs.next();
			matches = rs.getInt(2);
			runs = rs.getInt(3);
			wickets = rs.getInt(4);
			batting_avg = rs.getDouble(5);
			bowling_avg = rs.getDouble(6);
			batting_sr = rs.getDouble(7);
			bowling_sr = rs.getDouble(8);
		} catch (Exception e) {
			System.out.println("Error in creating statement ");
			e.printStackTrace();
		}
		oc = new ODICareer(id, matches, runs, wickets, batting_avg, bowling_avg, batting_sr, bowling_sr);
		try {
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oc;
	}

	public void insertODICareer(ODICareer oc) throws SQLException {
		int matches, runs, wickets, id;
		double batting_avg, bowling_avg, batting_sr, bowling_sr;
		matches = oc.matches;
		runs = oc.runs;
		wickets = oc.wickets;
		id = oc.id;
		batting_avg = oc.batting_avg;
		bowling_avg = oc.bowling_avg;
		batting_sr = oc.batting_sr;
		bowling_sr = oc.bowling_sr;
		String query = "insert into odi_career values (?,?,?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, id);
		st.setInt(2, matches);
		st.setInt(3, runs);
		st.setInt(4, wickets);
		st.setDouble(5, batting_avg);
		st.setDouble(6, bowling_avg);
		st.setDouble(7, batting_sr);
		st.setDouble(8, bowling_sr);
		st.executeUpdate();
		st.close();
	}

	public void updateBattingAverage(int id, double battingAvg) throws SQLException {
		String query = "update odi_career set batting_avg=? where id=?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setDouble(1, battingAvg);
		pst.setInt(2, id);
		pst.executeUpdate();
	}

	public void updateBowlingAverage(int id, double bowlingAvg) throws SQLException {
		String query = "update odi_career set bowling_avg=? where id=?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setDouble(1, bowlingAvg);
		pst.setInt(2, id);
		pst.executeUpdate();
	}

	public void updateBattingStrikeRate(int id, double battingSR) throws SQLException {
		String query = "update odi_career set batting_sr=? where id=?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setDouble(1, battingSR);
		pst.setInt(2, id);
		pst.executeUpdate();
	}

	public void updateBowlingStrikeRate(int id, double bowlingSR) throws SQLException {
		String query = "update odi_career set bowling_sr=? where id=?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setDouble(1, bowlingSR);
		pst.setInt(2, id);
		pst.executeUpdate();
	}

	public void updateRuns(int id, int runs) throws SQLException {
		String query = "upadte odi_career set runs=? where id=?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, runs);
		pst.setInt(2, id);
		pst.executeUpdate();
	}

	public void updateMatches(int id, int matches) throws SQLException {
		String query = "upadte odi_career set matches=? where id=?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, matches);
		pst.setInt(2, id);
		pst.executeUpdate();
	}

	public void updateWickets(int id, int wickets) throws SQLException {
		String query = "upadte odi_career set wickets=? where id=?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, wickets);
		pst.setInt(2, id);
		pst.executeUpdate();
	}
}
