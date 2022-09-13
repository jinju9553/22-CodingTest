package N3963;

import java.io.*;
import java.util.*;

public class Q15663 { //순열

	public static StringBuilder sb = new StringBuilder();
	public static boolean[] visited;
	public static Map<String, Integer> rslt = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		
		String[] temp = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		
		int[] items = new int[N];
		int[] bucket = new int[M];
		visited = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++)
			items[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(items); //결과 수열이 사전순으로 증가해야 함 (1, 7, 9, 9)
		solution(items, bucket, M, 0);
			
		System.out.println(sb);
	}
	
	public static void solution(int[] items, int[] bucket, int M, int k) {
		
		if(M == k) {
			String temp = "";
			for(int i = 0; i < bucket.length; i++)
				temp = temp + bucket[i] + " ";
			
			if(!rslt.containsKey(temp)) {
				rslt.put(temp, 1);
				sb.append(temp).append("\n");
			}
			return;
		}
		
		for(int i = 0; i < items.length; i++) {
			if(visited[i] == false) { //중복 제거
				visited[i] = true;
				bucket[k] = items[i];
				
				solution(items, bucket, M, k + 1);
				visited[i] = false;
			}
		}	
		return;
	}
}
