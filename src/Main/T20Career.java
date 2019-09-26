package Main;

public class T20Career {
	public int id, matches, runs, wickets;
	public double batting_avg, bowling_avg, batting_sr, bowling_sr;
	public boolean isIDSet;

	public T20Career(int i, int m, int r, int w, double bta, double boa, double bts, double bos) {
		isIDSet = true;
		id = i;
		matches = m;
		runs = r;
		wickets = w;
		batting_avg = bta;
		bowling_avg = boa;
		batting_sr = bts;
		bowling_sr = bos;
	}

	public T20Career(int m, int r, int w, double bta, double boa, double bts, double bos) {
		isIDSet = false;
		id = -1;
		matches = m;
		runs = r;
		wickets = w;
		batting_avg = bta;
		bowling_avg = boa;
		batting_sr = bts;
		bowling_sr = bos;
	}

	public String toString() {
		return id + " " + matches + " " + runs + " " + wickets + " " + batting_avg + " " + bowling_avg + " "
				+ batting_sr + " " + bowling_sr;
	}

}
