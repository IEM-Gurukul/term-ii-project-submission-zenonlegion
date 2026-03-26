//THIS FILE IS A PACKAGE

package utilsss;

public class constant {
	public static class direc{
		public static final int left=0;
		public static final int right=1;
		public static final int up=2;
		public static final int down=3;
		
	}
	
	public static class playerconst{
		public static final int run=1;
		public static final int idle=0;
		public static final int fall=3;
		public static final int jump=2;

		public static int GetSpriteAmt(int action) {
			switch(action) {
			case run: 
				return 1;
			case idle:
				return 0;
			case fall:
				return 3;
			case jump:
				return 2;
			default:
				return 0;
				
			}
		}
}
}
