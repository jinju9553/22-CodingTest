package N3959;

import java.io.*;

public class Q1699 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		
		int N = Integer.parseInt(br.readLine());
		int[] DP = new int[N + 1]; //0은 사용하지 않음
		
		DP[1] = 1;
		for(int i = 2; i <= N; i++) {
			if(Math.sqrt(i) % 1 == 0) { //루트가 자연수라면
				DP[i] = 1;
				
				for(int j = 2; j <= (N / i); j++)
					if(DP[i * j] == 0 || DP[i * j] > DP[i] * j) DP[i * j] = DP[i] * j;
			}
		}
		
		//반례: 98989 ==> 3?이? 나와야한다고? 4가 아니라?
		//반례: 18 ==> 2가 나와야 할 거임 (근데 3이라고 오답이 뜸) 
		
		int flag = 0; int temp = N; int sum = 0;
		while(flag == 0) { //O(√n)? 
			if(temp == 0) //다 구했음
				break;
			
			if(DP[temp] != 0) {
				sum += DP[temp];
				break;
			}
			
			if(DP[N] != 0) { //N의 루트가 자연수라면
				flag = 1;
				break; //바로 종료
			}
			
			int sqrt = (int)Math.floor(Math.sqrt(temp));
			temp = temp - (sqrt * sqrt);
			sum += DP[sqrt * sqrt];
		}
		
		if(flag != 1) DP[N] = sum; //미리 구해진 값이 없었다면
		
		System.out.println(DP[N]);
	}
}