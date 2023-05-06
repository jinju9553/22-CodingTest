package N9372;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15649_2 { //순열

	public static boolean[] visited;
	public static int[] bucket;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer s = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(s.nextToken()); //item.length
		int M = Integer.parseInt(s.nextToken()); //recursion depth
		
		visited = new boolean[N];
		bucket = new int[M];
		
		solution(N, M, 0);
		System.out.println(sb);
	}
	
	public static void solution(int N, int M, int k) {
		
		if(k == M) {
			for(int i = 0; i < bucket.length; i++) 
				sb.append(bucket[i]).append(" ");
			sb.append('\n');	
			return;
		}

		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				bucket[k] = (i + 1); //item의 값을 담는다
				solution(N, M, k + 1);
				
				visited[i] = false; 
			}
			//방문 했으면 다음 반복문으로
		}
		
		return;
	}

}
