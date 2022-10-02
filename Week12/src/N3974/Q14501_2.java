package N3974;

import java.io.*;

public class Q14501_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] times = new int[N + 1];
		int[] pays = new int[N + 1];
		int[] DP = new int[N + 1];
		
		String[] temp;
		for(int i = 1; i < N + 1; i++) {
			temp = br.readLine().split(" ");
			times[i] = Integer.parseInt(temp[0]);
			pays[i] = Integer.parseInt(temp[1]);
			DP[i] = 0;
		}
		
		//
	}

}
