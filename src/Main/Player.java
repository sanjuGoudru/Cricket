package Main;


public class Player {
	int id;
	String name,role,country,batStyle,bowlStyle,dob;
	public Player(int i,String n,String r,String c,String bat,String bowl,String d) {
		id=i;
		name=n;
		role=r;
		country=c;
		batStyle = bat;
		bowlStyle = bowl;
		dob=d;
	}
	public String toString() {
		return id+" "+name+" "+role+" "+country+" "+batStyle+" "+bowlStyle+" "+dob;
	}
	
}
