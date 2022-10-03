package N3974;

import java.io.*;
import java.util.Arrays;

public class Q14501_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] times = new int[N + 1];
		int[] pays = new int[N + 1];
		int[] DP = new int[N + 1];
		
		String[] temp;
		for(int i = 0; i < N; i++) {
			temp = br.readLine().split(" ");
			times[i] = Integer.parseInt(temp[0]);
			pays[i] = Integer.parseInt(temp[1]);
			DP[i] = 0;
		}
		
		for(int i = 0; i < N; i++) { // i < 10 이라면 i = 1~9
			if(i + times[i] < N + 1) { //N일째까지는 가능
				int next = i + times[i];
				DP[next] = Math.max(pays[i] + DP[i], DP[next]);
			}
			DP[i + 1] = Math.max(DP[i + 1], DP[i]);
		}
		
		Arrays.sort(DP);

		System.out.println(DP[N]);
	}

}
