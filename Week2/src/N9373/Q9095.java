package N9373;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9095 {

	public static int count; 
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			int num = Integer.parseInt(br.readLine());
			count = 0;
			solution(0, num);
			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}
	
	public static void solution(int currentSum, int target) {
		
		if(currentSum == target) {
			count += 1;
			return;
		}
		else if(currentSum > target) {
			return;
		}
		else { // if(currentSum < target)
			solution(currentSum + 1, target); 
			solution(currentSum + 2, target);
			solution(currentSum + 3, target);
		}
	}
	
}