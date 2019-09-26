package DAO;

import java.sql.SQLException;
import java.util.*;
import Main.*;

public class Demo{
	public static void main(String[] args){
		TestCareerDAO tcdao = new TestCareerDAO();
		ODICareerDAO ocdao = new ODICareerDAO();
		T20CareerDAO t20dao = new T20CareerDAO();
		tcdao.connect();
		ocdao.connect();
		t20dao.connect();
		try {
			TestCareer tc = tcdao.getTestCareer(1);
			ODICareer oc = ocdao.getODICareer(1);
			T20Career t20c = t20dao.getT20Career(1);
			System.out.println(tc);
			System.out.println(oc);
			System.out.println(t20c);
		}catch(Exception e) {
			e.printStackTrace();
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
