package N3965;

import java.io.*;
import java.util.*;

public class Q1759 { 

	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		
		String[] temp = br.readLine().split(" ");
		int M = Integer.parseInt(temp[0]);
		int N = Integer.parseInt(temp[1]); //nCm
		char[] items = new char[N];
		char[] bucket = new char[M];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++)
			items[i] = st.nextToken().charAt(0);
		
		Arrays.sort(items); //알파벳 사전순 정렬
		
		pick(items, bucket, M, 0, 0);
		
		System.out.println(sb);
	}
	
	public static void pick(char[] items, char[] bucket, int M, int k, int lastIndex) {
		if(M == k) {
			String temp = "";
			int count = 0;
			for(int i = 0; i < bucket.length; i++) {
				temp += bucket[i];
				if(bucket[i] == 'a' || bucket[i] == 'e' || bucket[i] == 'i' 
						|| bucket[i] == 'o' || bucket[i] == 'u')
					count++;
			}
			
			if(count > 0 && bucket.length - count > 1)
				sb.append(temp).append('\n');

			return;
		}
		
		for(int i = lastIndex; i < items.length; i++) {
			bucket[k] = items[i];
			pick(items, bucket, M, k + 1, i + 1);
		}
	}
}
