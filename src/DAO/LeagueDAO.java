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

	public ArrayList<League> getAllLeagues() throws SQLException {
		String query = "select * from league";
		Statement st = null;
		ResultSet rs = null;
		st = con.createStatement();
		rs = st.executeQuery(query);
		ArrayList<League> l = new ArrayList<League>();
		while (rs.next()) {
			l.add(new League(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		return l;
	}
}
