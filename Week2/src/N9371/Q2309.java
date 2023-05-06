package N9371;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2309 { //오답: 재귀가 아닌 중첩 for문(브루트포스)으로 풀이한다.

	public static StringBuilder sb = new StringBuilder();
	public static final int N = 9;
	public static final int M = 2;
	public static int[] items = new int[N];
	public static int[] bucket = new int[M];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		for(int i = 0; i < N; i++) { //개수가 정해져 있음 (상수 개의 입력)
			int num = Integer.parseInt(br.readLine());
			items[i] = num;
			sum += num;
		}
		int target = sum - 100;

		Arrays.sort(items);
		solution(items, bucket, 2, target);
		System.out.println(sb);
	}

	public static void solution(int[] items, int[] bucket, int k, int target) { 

		if (k == 0) { 
			if(target == bucket[0] + bucket[1]) { //주의: target이 되는 경우가 여러가지 나타날 수 있음
				for (int i = 0; i < items.length; i++)
					if(items[i] != bucket[0] && items[i] != bucket[1])
						sb.append(items[i]).append('\n');
			}
			return;
		}
		
		int lastIndex = bucket.length - k - 1;
		
		for (int i = 0; i < items.length; i++) 
		{
			if(bucket.length == k) {
				bucket[0] = items[i];
				solution(items, bucket, k - 1, target);
			}
			else if (bucket[lastIndex] < items[i]) {
				bucket[lastIndex + 1] = items[i]; 
				solution(items, bucket, k - 1, target);
			}
		}
	}
}
