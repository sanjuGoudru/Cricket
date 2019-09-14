package DAO;
import Main.*;
import java.sql.*;
import java.util.*;
public class PlayerDAO {
	Connection con;
	static final String url = "jdbc:mysql://localhost:3306/cricket";
	static final  String username = "root";
	static final String password = "root";
	public void connect(){
		try{
			con = DriverManager.getConnection(url, username, password);
		}catch(SQLException e){
			System.out.println("Error in setting connection");
			e.printStackTrace();
		}
	}
	public void close(){
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Error in closing the connection");
			e.printStackTrace();
		}
	}
	public Player getPlayer(int id){
		Player p=null;
		String query = "select * from player where id = "+id;
		Statement st = null;
		ResultSet rs=null;
		String name=null,role=null,country=null,batStyle=null,bowlStyle=null,dob=null;
		try {
			st = con.createStatement();
			rs  = st.executeQuery(query);
			rs.next();
			name=rs.getString(2);
			role=rs.getString(3);
			country=rs.getString(4);
			batStyle=rs.getString(5);
			bowlStyle=rs.getString(6);
			dob=rs.getString(7);
		} catch (Exception e) {
			System.out.println("Error in creating statement ");
			e.printStackTrace();
		}
		p = new Player(id, name, role, country, batStyle, bowlStyle, dob);
		return p;
	}
	public static void main(String[]args){
		PlayerDAO dao = new PlayerDAO();
		dao.connect();
		
		Player p = dao.getPlayer(1);
		System.out.println(p);
	}
	public ArrayList<Player> findPlayer(String query) throws IllegalArgumentException,SQLException{
		StringTokenizer st = new StringTokenizer(query, "$");
		if(st.countTokens()!=5) {
			throw new IllegalArgumentException("Expected $: 5\nActual $:"+st.countTokens());
		}
		String[] arg = new String[5];
		for(int i=0;i<arg.length;i++) {
			arg[i]=st.nextToken();
		}
		String name;
		int role,country,battingStyle,bowlingStyle;
		if(arg[0].equals("#"))
			name="";
		else
			name=arg[0];
		try {
		role = Integer.parseInt(arg[1]);
		country = Integer.parseInt(arg[2]);
		battingStyle = Integer.parseInt(arg[3]);
		bowlingStyle = Integer.parseInt(arg[4]);
		}catch(NumberFormatException e){
			throw new IllegalArgumentException("Any of role,country,batting_style,bowling_style are wrong",e);
		}
		if(role<PlayerConstants.MIN_ROLES||role>PlayerConstants.MAX_ROLES)
			throw new IllegalArgumentException("Role value is invalid. Role:"+role);
		if(country<PlayerConstants.MIN_COUNTRIES||country>PlayerConstants.MAX_COUNTRIES)
			throw new IllegalArgumentException("Country value is invalid. Country:"+country);
		if(battingStyle<PlayerConstants.MIN_BATTING_STYLE||battingStyle>PlayerConstants.MAX_BATTING_STYLE)
			throw new IllegalArgumentException("Batting Style value is invalid. BattingStyle:"+battingStyle);
		if(bowlingStyle<PlayerConstants.MIN_BOWLING_STYLE||bowlingStyle>PlayerConstants.MAX_BOWLING_STYLE)
			throw new IllegalArgumentException("Bowling Style value is invalid. BowlingStyle:"+bowlingStyle);
		String dbmsQuery = "select id from player where  name like '%"+name+"% ";
		if(role!=PlayerConstants.Role.ANYTHING) {
			dbmsQuery+="and role="+role+" ";
		}
		if(country!=PlayerConstants.Country.ANYTHING) {
			dbmsQuery+="and country="+country+" ";
		}
		if(battingStyle!=PlayerConstants.BattingStyle.ANYTHING) {
			dbmsQuery+="and batting_style="+battingStyle+" ";
		}
		if(bowlingStyle!=PlayerConstants.BowlingStyle.ANYTHING) {
			dbmsQuery+="and bowling_style="+bowlingStyle+" ";
		}
		Statement s = null;
		ResultSet rs=null;
		s = con.createStatement();
		rs  = s.executeQuery(dbmsQuery);
		ArrayList<Player> p = new ArrayList<Player>();
		while(rs.next()) {
			p.add(getPlayer(rs.getInt(1)));
		}
		return p;
	}
}

