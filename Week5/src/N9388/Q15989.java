package N9388;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q15989 {

	private static int count = 0;
	private static int[] DP;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		DP = new int[10000]; //n은 양수이며 10,000보다 작거나 같다.
		
		int target = 0;
		while(T-- > 0) {
			target = Integer.parseInt(br.readLine());
			
			count = 0;
			//DP가 2차원 배열이어야 함...
			
			DP[target] = count;
			sb.append(DP[target]).append('\n');
		}
		
		System.out.println(sb);
	}

}
