package DAO;

import java.sql.SQLException;
import java.util.*;
import Main.*;

public class Demo{
	public static void main(String[] args){
		PlayerDAO dao=null;
		try{
			dao = new PlayerDAO();
			dao.connect();
		ArrayList<Player> p = dao.findPlayer("$#$2$0$0$0");
		for(Player pl:p)
			System.out.println(pl);
		}catch(Exception e) {
			Log.print();
		}finally {
			dao.close();
		}
	}
}

class Log{
	static private String s = null;
	static void add(String a) {
		s+=a+"\n";
	}
	static void print() {
		System.out.println(s);
	}
}
