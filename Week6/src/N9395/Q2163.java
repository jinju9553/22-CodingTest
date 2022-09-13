package N9395;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2163 {

	private static int[][] DP;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		
		DP = new int[N + 1][M + 1];
		
		DP[1][1] = 0;
		
		for(int i = 1; i <= N; i++)
			DP[i][1] = i - 1;
		
		for(int j = 1; j <= M; j++)
			DP[1][j] = j - 1;
		
		for(int i = 2; i <= N; i++) {
			for(int j = 2; j <= M; j++) {
				if(DP[i][j] == 0) {
					double p = ((double)j/2);
					double q = ((double)j/2);
					DP[i][j] = DP[i][(int)Math.ceil(p)] + DP[i][(int)Math.floor(q)] + 1; 
					
					if(j <= N && i <= M)
						DP[j][i] = DP[i][j];
				}
			}
		}
		
		System.out.println(DP[N][M]);
	}

}
