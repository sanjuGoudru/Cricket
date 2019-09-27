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
		st.close();
		return teams;
	}

	public ArrayList<League> getAllLeagues() throws SQLException {
		String query = "select * from league";
		Statement st = null;
		ResultSet rs = null;
		st = con.createStatement();
		rs = st.executeQuery(query);
		ArrayList<League> leagues = new ArrayList<League>();
		while (rs.next()) {
			leagues.add(new League(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		st.close();
		return leagues;
	}

	public ArrayList<Player> getAllPlayers(int tid, int lid) throws SQLException {
		ArrayList<Player> players = new ArrayList<Player>();
		String query = "select * from player where id in (select pid from league_players where lid = " + lid
				+ " and tid = " + tid + ")";
		Statement st = null;
		ResultSet rs = null;
		st = con.createStatement();
		rs = st.executeQuery(query);
		while (rs.next())
			players.add(new Player(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
					rs.getInt(6), rs.getString(7)));
		st.close();
		return players;
	}
}
