package Main;

public final class PlayerConstants {
	public static final int MAX_ROLES = 4;
	public static final int MAX_BATTING_STYLE=2;
	public static final int MAX_BOWLING_STYLE = 4;
	public static final int MAX_COUNTRIES = 10;
	public static final int MIN_ROLES = 0;
	public static final int MIN_BATTING_STYLE=0;
	public static final int MIN_BOWLING_STYLE = 0;
	public static final int MIN_COUNTRIES = 0;
	public static class Role{
		public static final int ANYTHING = 0;
		public static final int BATSMAN = 1;
		public static final int BOWLER = 2;
		public static final int BATTING_ALLROUNDER = 3;
		public static final int BOWLING_ALLROUNDER= 4;
	}
	public static class BattingStyle{
		public static final int ANYTHING = 0;
		public static final int RIGHT_HANDED = 1;
		public static final int LEFT_HANDED = 2;
	}
	public static class BowlingStyle{
		public static final int ANYTHING = 0;
		public static final int RIGHT_PACER = 1;
		public static final int RIGHT_SPINNER=2;
		public static final int LEFT_PACER=3;
		public static final int LEFT_SPINNER=4;
	}
	public static class Country{
		public static final int ANYTHING=0;
		public static final int INDIA=1;
		public static final int AUSTRALIA=2;
		public static final int ENGLAND=3;
		public static final int SOUTH_AFRICA=4;
		public static final int NEW_ZEALAND=5;
		public static final int PAKISTAN=6;
		public static final int SRI_LANKA=7;
		public static final int WEST_INDIES=8;
		public static final int BANGLADESH=9;
		public static final int AFGHANISTAN=10;
	}
}
