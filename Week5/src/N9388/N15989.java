package N9388;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N15989 {
	
	private static int count = 0;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		int target = 0;
		while(T-- > 0) {
			target = Integer.parseInt(br.readLine());
			count = 0;
			solution(0, target, 1);
			sb.append(count).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void solution(int currentSum, int target, int prev) {
		
		if(currentSum == target) {
			count += 1;
			return;
		}
		else if(currentSum > target) {
			return;
		}
		else { //if(currentSum < target)
			if(prev == 1) { //하드코딩... ==> 시간초과!!!
				solution(currentSum + 1, target, 1);
				solution(currentSum + 2, target, 2);
				solution(currentSum + 3, target, 3);
			}
			else if(prev == 2) {
				solution(currentSum + 2, target, 2);
				solution(currentSum + 3, target, 3);
			}
			else
				solution(currentSum + 3, target, 3);
		}
		return;
	}
}
