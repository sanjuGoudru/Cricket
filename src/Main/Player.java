package Main;


public class Player {
	public String name,dob;
	public int id,role,country,batStyle,bowlStyle;
	public boolean isIDSet;
	public Player(int i,String n,int r,int c,int bat,int bowl,String d) {
		isIDSet=true;
		id=i;
		name=n;
		role=r;
		country=c;
		batStyle = bat;
		bowlStyle = bowl;
		dob=d;
	}
	public Player(String n,int r,int c,int bat,int bowl,String d) {
		isIDSet=false;
		id=-1;
		name=n;
		role=r;
		country=c;
		batStyle = bat;
		bowlStyle = bowl;
		dob=d;
	}
	public boolean isIDSet() {
		return isIDSet;
	}
	public String toString() {
		return id+" "+name+" "+role+" "+country+" "+batStyle+" "+bowlStyle+" "+dob;
	}
	
	
}
