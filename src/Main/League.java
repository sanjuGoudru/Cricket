package Main;

public class League {
	public int lid;
	public String lname, lshortname;

	public League(int l, String ln, String ls) {
		lid = l;
		lname = ln;
		lshortname = ls;
	}

	public String toString() {
		return lid + " " + lname + " " + lshortname + " ";
	}
}
