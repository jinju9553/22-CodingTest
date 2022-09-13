package N3963;

import java.io.*;
import java.util.*;

public class Q15665 { //중복순열

	public static StringBuilder sb = new StringBuilder();
	public static Map<String, Integer> rslt = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		
		String[] temp = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		
		int[] items = new int[N];
		int[] bucket = new int[M];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++)
			items[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(items); 
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
		
		//visited 필요 없을듯
		for(int i = 0; i < items.length; i++) {
			bucket[k] = items[i];
			solution(items, bucket, M, k + 1);
		}
		return;
	}
}
