package N9372;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15651_2 { //중복순열2

	//public static boolean[] visited;
	public static int[] bucket;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer s = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(s.nextToken()); //item.length
		int M = Integer.parseInt(s.nextToken()); //recursion depth
		
		//visited = new boolean[N]; //중복00에서는 필요 없음
		bucket = new int[M];
		
		solution(N, M, 0);
		System.out.println(sb);
	}

	public static void solution(int N, int M, int k) {

		if (k == M) { 
			for (int i = 0; i < bucket.length; i++)
				sb.append(bucket[i]).append(" ");
			sb.append('\n');
			return;
		}

		for (int i = 0; i < N; i++) {	
			// **이미 뽑혔는지를 검증하는 과정(visited[i])이 없다!
			bucket[k] = (i + 1); 
			solution(N, M, k + 1); // 다음 탐색
		}
		
		return;
	}

}
