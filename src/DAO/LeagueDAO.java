package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Main.*;

public class LeagueDAO {
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

	public ArrayList<Team> getAllTeams(int lid) throws SQLException {
		ArrayList<Team> teams = new ArrayList<Team>();
		String query = "select * from team where lid = " + lid;
		Statement st = null;
		ResultSet rs = null;

		st = con.createStatement();
		rs = st.executeQuery(query);
		while (rs.next())
			teams.add(new Team(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
		return teams;
	}
}
