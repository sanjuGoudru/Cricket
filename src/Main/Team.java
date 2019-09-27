package Main;

public class Team {
	public int tid, lid;
	public String tname, tsn;

	public Team(int tid, int lid, String tname, String tsn) {
		this.tid = tid;
		this.lid = lid;
		this.tname = tname;
		this.tsn = tsn;
	}

	@Override
	public String toString() {
		return tid + " " + lid + " " + tname + " " + tsn;
	}

}
