package DAO;

import java.sql.SQLException;
import java.util.*;
import Main.*;

public class Demo{
	public static void main(String[] args){
		TestCareerDAO dao = new TestCareerDAO();
		dao.connect();
		TestCareer tc = new TestCareer(4, 4, 4, 4, 4, 4, 4, 4);
		try {
			dao.insertTestCareer(tc);
		} catch (SQLException e) {
			System.out.println("Errorrrr");
			e.printStackTrace();
		}
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
