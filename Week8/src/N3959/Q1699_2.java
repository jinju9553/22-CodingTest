package N3959;

import java.io.*;

public class Q1699_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		
		int N = Integer.parseInt(br.readLine());
		int[] DP = new int[N + 1];
		
		DP[1] = 1;
		for(int i = 2; i <= N; i++) {
			DP[i] = Integer.MAX_VALUE;
			//Math.sqrt가 시간이 오래 걸리는 것 같음 & Math.min 또한 마찬가지...
			//DP[1]+DP[9]를 구했으면 굳이 DP[9]+DP[1]을 구할 필요 없음
			//if문 하나라도 더 있으면 시간초과가 뜨는 간당간당한 문제 
			for(int j = 1; j <= (i / 2); j++) {
				if((j * j) == i) {
					DP[i] = 1;
					break;
				}
				DP[i] = (DP[i] > DP[j] + DP[i - j]) ? (DP[j] + DP[i - j]) : DP[i];
			}
		}
		
		System.out.println(DP[N]);
	}

}
