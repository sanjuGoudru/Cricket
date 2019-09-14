package DAO;
import Main.*;
import java.sql.*;
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
		int role=-1,country=-1,batStyle=-1,bowlStyle=-1;
		String name=null,dob=null;
		try {
			st = con.createStatement();
			rs  = st.executeQuery(query);
			rs.next();
			name=rs.getString(2);
			role=rs.getInt(3);
			country=rs.getInt(4);
			batStyle=rs.getInt(5);
			bowlStyle=rs.getInt(6);
			dob=rs.getString(7);
		} catch (Exception e) {
			System.out.println("Error in creating statement ");
			e.printStackTrace();
		}
		p = new Player(id, name, role, country, batStyle, bowlStyle, dob);
		return p;
	}
	public static void main(String[]args) throws SQLException{
		PlayerDAO dao = new PlayerDAO();
		dao.connect();
		Player p = new Player(1,"asd",1,1,1,1,"1999-4-13");
		dao.insertPlayer(p);
		dao.close();
	}
	public static void findPlayer(String query) {
		//TODO: Complete this.
	}
	public void insertPlayer(Player p)throws SQLException{
		String name,dob;
		int role,country,batStyle,bowlStyle;
		role=p.role;
		country=p.country;
		name=p.name;
		batStyle=p.batStyle;
		bowlStyle=p.bowlStyle;
		dob=p.dob;
		String query="insert into player (name,role,country,batting_style,bowling_style,dob) values(?,?,?,?,?,?)";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1,name);
		st.setInt(2,role);
		st.setInt(3,country);
		st.setInt(4,batStyle);
		st.setInt(5,bowlStyle);
		st.setString(6,dob);
		st.executeUpdate();
	}
}


