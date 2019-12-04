
public class Main4 {

	public static void main(String[] args) {
		
		int min = 128392;
		int max = 643281;
		int valid = 0;
		
		for(int pass = min; pass <= max; pass++) {
			
			if(Main4.passCheck(pass)) valid++;
			
		}
		
		System.out.println(valid);
		
	}
	
	public static boolean passCheck(int pass) {
		
		char[] chars = String.valueOf(pass).toCharArray();
		
		boolean doub = false;
		char banned = 'a';
		
		for(int i = 0; i < chars.length-1; i++) {
			if(chars[i] > chars[i+1]) return false;	//Decreasing pass
			if(chars[i] == chars[i+1] && chars[i] != banned) {//Pair check
				//Might be a double. Check one more
				if(i+2 <= chars.length-1 && chars[i] == chars[i+2] && chars[i] != banned) {
					//More than just 2, ban this character
					banned = chars[i];
				} else {
					doub = true;
				}
			}
		}
		return doub;
	}
	
}
