package N3979;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Q12919 {

	public static int flag = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String origin = br.readLine();
		String target = br.readLine();
		
		trim(origin, target);
		
		System.out.println(flag);
	}
	
	public static void trim(String origin, String target) {
		
		int oLen = origin.length();
		int tLen = target.length();
		
		if(oLen == tLen) {
			if(origin.equals(target))
				flag = 1;
			return;
		}
		else if(tLen <= 1) {
			return;
		}
		else {		
			if(target.charAt(tLen - 1) == 'A') {
				String removedA = target.substring(0, tLen - 1);
				trim(origin, removedA);
			}

			if(target.charAt(0) == 'B') {
				String removedB = reverse(target).substring(0, tLen - 1);
				trim(origin, removedB);
			}
		}
		
		return;
	}
	
	public static String reverse(String str) {
		String newStr = "";
		
		for(int i = str.length() - 1; i >= 0; i--)
			newStr = newStr + str.charAt(i);
		
		return newStr;
	}

}
