package DAO;

import java.sql.SQLException;
import java.util.*;
import Main.*;

public class Demo{
	public static void main(String[] args){
		PlayerDAO dao = new PlayerDAO();
		dao.connect();
		ArrayList<Player> players=null;
		try {
			players = dao.findPlayer("$#$0$1$0$0");
		} catch (Exception e) {
			Log.print();
			e.printStackTrace();
		}
		System.out.println(players.toString());
		dao.close();
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
