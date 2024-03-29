package N3963;

import java.io.*;
import java.util.*;

public class Q15666 {

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
		solution(items, bucket, M, 0, 0);
			
		System.out.println(sb);
	}

	public static void solution(int[] items, int[] bucket, int M, int k, int lastIndex) {
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
		
		//항상 이전에 뽑은 item보다 *같거나* 큰 item만 뽑는다 ==> lastIndex를 통한 조절
		for(int i = lastIndex; i < items.length; i++) {
				bucket[k] = items[i];
				solution(items, bucket, M, k + 1, i);
		}
		return;
	}
}
