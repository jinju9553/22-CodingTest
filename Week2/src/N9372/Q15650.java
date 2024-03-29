package N9372;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15650 { //조합

	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer s = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(s.nextToken());
		int M = Integer.parseInt(s.nextToken());
		
		int[] items = new int[N];
		int[] bucket = new int[M];
		
		for(int i = 0; i < N; i++)
			items[i] = (i + 1);
		
		solution(items, bucket, M);
		System.out.println(sb);
	}

	public static void solution(int[] items, int[] bucket, int k) { 
		
		if (k == 0) { 
			for (int i = 0; i < bucket.length; i++)
				sb.append(bucket[i]).append(' ');
			sb.append('\n');
			return;
		}
		
		int lastIndex = bucket.length - k - 1; //하나도 안 뽑혔을 때는 lastIndex가 -1이라 사용 불가
		
		for (int i = 0; i < items.length; i++) 
		{
			//**순열과 다른 부분!
			if(bucket.length == k) { //아직 하나도 안 뽑혔다면
				bucket[0] = items[i]; //첫째 자리에 현재 탐색중인 아이템을 넣는다 
				solution(items, bucket, k - 1);
			}
			else if (bucket[lastIndex] < items[i]) { //가장 최근에 뽑힌 것이 현재 item보다 작을 때에만
				bucket[lastIndex + 1] = items[i]; 
				solution(items, bucket, k - 1);
			}
		}
	}
}
