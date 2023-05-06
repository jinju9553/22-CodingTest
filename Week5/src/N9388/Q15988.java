package N9388;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q15988 {

	//방법의 수를 1,000,000,009로 나눈 나머지를 출력한다. ==> long 타입 사용
	private static long divisor = (long) 1000000009;
	private static long[] DP;
	private static int MAX = 1000000;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		DP = new long[MAX + 1];
		DP[1] = 1;
		DP[2] = 2;
		DP[3] = 4;
		
		for(int i = 4; i <= MAX; i++) 
			DP[i] = (DP[i - 1] + DP[i - 2] + DP[i - 3]) % divisor;
		
		int target = 0;
		while(T-- > 0) {
			target = Integer.parseInt(br.readLine()); 
			sb.append(DP[target]).append('\n');
		}
		
		System.out.println(sb);
	}

}
