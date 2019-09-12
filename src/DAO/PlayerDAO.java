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
}
