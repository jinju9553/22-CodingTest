package N3961;

import java.io.*;

public class Q1309 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[] DP = new long[N + 1];
		
		DP[0] = 1; DP[1] = 3;
		for(int i = 2; i <= N; i++) {
			DP[i] = 2 * DP[i - 1] + DP[i - 2];
			DP[i] = DP[i] % 9901;
		}
		
		System.out.println(DP[N]);
	}

}
