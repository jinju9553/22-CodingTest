package N3966;

import java.io.*;
import java.util.StringTokenizer;

public class Q1182 {
	
	public static int[] items;
	public static int[] bucket;
	public static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int target = Integer.parseInt(temp[1]);
		items = new int[N];
		bucket = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++)
			items[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= N; i++)
			pick(i, 0, 0, target);
		
		System.out.println(count);
	}
	
	public static void pick(int N, int k, int lastIndex, int target) {
		if(N == k) {
			int sum = 0;
			for(int i = 0; i < bucket.length; i++)
				sum += bucket[i];
			
			if(sum == target)
				count += 1;
			
			return;
		}
		
		for(int i = lastIndex; i < items.length; i++) {
			bucket[k] = items[i];
			pick(N, k + 1, i + 1, target);
		}
	}

}
