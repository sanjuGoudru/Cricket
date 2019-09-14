package Main;


public class Player {
	public String name,dob;
	public int id,role,country,batStyle,bowlStyle;
	public Player(int i,String n,int r,int c,int bat,int bowl,String d) {
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
