package DAO;

import Main.*;
import java.sql.*;
import java.util.*;

public class PlayerDAO {
	Connection con=null;
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


	public Player getPlayer(int id) {

		Player p = null;
		String query = "select * from player where id = " + id;
		Statement st = null;
		ResultSet rs = null;
		int role = -1, country = -1, batStyle = -1, bowlStyle = -1;
		String name = null, dob = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			rs.next();
			name = rs.getString(2);
			role = rs.getInt(3);
			country = rs.getInt(4);
			batStyle = rs.getInt(5);
			bowlStyle = rs.getInt(6);
			dob = rs.getString(7);
		} catch (Exception e) {
			System.out.println("Error in creating statement ");
			e.printStackTrace();
		}
		p = new Player(id, name, role, country, batStyle, bowlStyle, dob);
		try {
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;

	}

	public ArrayList<Player> findPlayer(String query) throws IllegalArgumentException, SQLException {
		StringTokenizer st = new StringTokenizer(query, "$");
		if (st.countTokens() != 5) {
			Log.add("$ count is now 5.Instead it is " + st.countTokens());
			throw new IllegalArgumentException("Expected $: 5\nActual $:" + st.countTokens());
		}
		String[] arg = new String[5];
		for (int i = 0; i < arg.length; i++) {
			arg[i] = st.nextToken();
		}
		Log.add("arg[]  is set up.");
		String name;
		int role, country, battingStyle, bowlingStyle;

		if (arg[0].equals("#")) {
			Log.add("Name is empty");
			name = "";
		}
		else {
			Log.add("Name is "+arg[0]);
			name = arg[0];
		}

		try {
			role = Integer.parseInt(arg[1]);
			Log.add("Role is set up");
			country = Integer.parseInt(arg[2]);
			Log.add("Country is set up");
			battingStyle = Integer.parseInt(arg[3]);
			Log.add("battingStyle is set up");
			bowlingStyle = Integer.parseInt(arg[4]);
			Log.add("BowlingStyle is set up");
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Any of role,country,batting_style,bowling_style are wrong", e);
		}
		if (role < PlayerConstants.MIN_ROLES || role > PlayerConstants.MAX_ROLES)
			throw new IllegalArgumentException("Role value is invalid. Role:" + role);
		if (country < PlayerConstants.MIN_COUNTRIES || country > PlayerConstants.MAX_COUNTRIES)
			throw new IllegalArgumentException("Country value is invalid. Country:" + country);
		if (battingStyle < PlayerConstants.MIN_BATTING_STYLE || battingStyle > PlayerConstants.MAX_BATTING_STYLE)
			throw new IllegalArgumentException("Batting Style value is invalid. BattingStyle:" + battingStyle);
		if (bowlingStyle < PlayerConstants.MIN_BOWLING_STYLE || bowlingStyle > PlayerConstants.MAX_BOWLING_STYLE)
			throw new IllegalArgumentException("Bowling Style value is invalid. BowlingStyle:" + bowlingStyle);

		Log.add("Every parameter is valid");
		String dbmsQuery = "select id from player where  name like '%" + name + "%' ";
		if (role != PlayerConstants.Role.ANYTHING) {
			Log.add("Role is something");
			dbmsQuery += "and role=" + role + " ";
		}
		if (country != PlayerConstants.Country.ANYTHING) {
			Log.add("Country is something");
			dbmsQuery += "and country=" + country + " ";
		}
		if (battingStyle != PlayerConstants.BattingStyle.ANYTHING) {
			Log.add("BattingStyle is something");
			dbmsQuery += "and batting_style=" + battingStyle + " ";
		}
		if (bowlingStyle != PlayerConstants.BowlingStyle.ANYTHING) {
			Log.add("Bowling Style is something");
			dbmsQuery += "and bowling_style=" + bowlingStyle + " ";
		}
		Statement s = null;
		ResultSet rs = null;
		s = con.createStatement();
		rs = s.executeQuery(dbmsQuery);
		ArrayList<Player> p = new ArrayList<Player>();
		while (rs.next()) {
			p.add(getPlayer(rs.getInt(1)));
		}
		return p;
	}

	public void insertPlayer(Player p) throws SQLException {
		String name, dob;
		int role, country, batStyle, bowlStyle;
		role = p.role;
		country = p.country;
		name = p.name;
		batStyle = p.batStyle;
		bowlStyle = p.bowlStyle;
		dob = p.dob;
		String query = "insert into player (name,role,country,batting_style,bowling_style,dob) values(?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, name);
		st.setInt(2, role);
		st.setInt(3, country);
		st.setInt(4, batStyle);
		st.setInt(5, bowlStyle);
		st.setString(6, dob);
		st.executeUpdate();
		st.close();
	}
}
