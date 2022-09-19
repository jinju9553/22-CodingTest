package N3960;

import java.io.*;
import java.util.Arrays;

public class Q2156 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] DP = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			DP[i] = arr[i];
		}
		
		int count = 2; int curr = 0;
		for(int i = 1; i < N; i++) { //틀린 답: 두 잔 연속으로 안 마시는 케이스를 대비할 수 없음
			if(count >= 3) {
				if(DP[i - 1] <= DP[i]) { //등호가 여기 들어가야 함
					int a = DP[i] + arr[i - 1];
					int b = DP[i] + arr[i - 2];
					DP[i] = Math.max(a, b);
					if(DP[i] == a) count = 3; else count = 2;
					curr = i;
				}
				else if(DP[i - 1] > DP[i]) {
					DP[i] = DP[i - 1];
					curr = i - 1;
					count = 1;
				}
			}
			else {
				DP[i] += DP[curr];
				count++;
				curr = i;
			}
		}
		
		Arrays.sort(DP);
		System.out.println(DP[N - 1]);
	}
}
