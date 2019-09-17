package Main;

public class TestCareer {
	public int id, matches, runs, wickets;
	public double batting_avg, bowling_avg, batting_sr, bowling_sr;
	public boolean isIDSet;

	public TestCareer(int i, int m, int r, int w, double bta, double boa, double bts, double bos) {
		isIDSet = true;
		id = i;
		matches = m;
		runs = r;
		wickets = w;
		batting_avg = bta;
		bowling_avg = boa;
		batting_sr = bts;
		bowling_avg = bos;
	}

	public TestCareer(int m, int r, int w, double bta, double boa, double bts, double bos) {
		isIDSet = false;
		id = -1;
		matches = m;
		runs = r;
		wickets = w;
		batting_avg = bta;
		bowling_avg = boa;
		batting_sr = bts;
		bowling_avg = bos;
	}

	public String toString() {
		return id + " " + matches + " " + runs + " " + wickets + " " + batting_avg + " " + bowling_avg + " "
				+ batting_sr + " " + bowling_sr;
	}
}
