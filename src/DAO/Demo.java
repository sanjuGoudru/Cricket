package DAO;

import java.sql.SQLException;
import java.util.*;
import Main.*;

public class Demo {
	public static void main(String[] args) throws Exception {
		LeagueDAO ldao = new LeagueDAO();
		ldao.connect();
		ArrayList<Player> players = ldao.getAllPlayers(1, 1);
		for (Player player : players)
			System.out.println(player);
		ldao.close();
	}
}

class Log {
	static private String s = null;

	static void add(String a) {
		s += a + "\n";
	}

	static void print() {
		System.out.println(s);
	}
}
