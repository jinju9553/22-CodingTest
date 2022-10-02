package N3974;

import java.io.*;
import java.util.*;

public class Q14501 {

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
		
		int start = 0; int prev = 0; int i = 1;
		while(start < N) {
			if(i + times[i] > N + 1) {
				start++;
				i = start;
				prev = 0;
				continue;
			}
			
			if(pays[i] + prev > DP[i])
				DP[i] = pays[i] + prev;
			
			prev = DP[i];
			
			if(i + times[i] <= N) //날짜를 넘기지 않는다면(N=7이라면 8일째 퇴사)
				i = i + times[i];
			else { //i값 영향 없이 처음부터 하나씩 봄
				start++;
				i = start;
				prev = 0;
			}
		}
		
		Arrays.sort(DP);
		
		System.out.println(DP[N]);
	}

}
