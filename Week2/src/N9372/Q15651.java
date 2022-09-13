package N9372;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15651 { //중복순열

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
		
		if (k == 0) { //더이상 뽑을 게 없다면 모두 출력
			for (int i = 0; i < bucket.length; i++)
				sb.append(bucket[i]).append(' ');
			sb.append('\n');
			return;
		}
		
		int lastIndex = bucket.length - k - 1; // 가장 최근에 뽑힌 수가 저장된 위치 index
		
		for (int i = 0; i < items.length; i++) // candidate items
		{
			//**이미 뽑혔는지를 검증하는 과정이 없다!
			bucket[lastIndex + 1] = items[i]; //아니라면 버킷에 담음
			solution(items, bucket, k - 1); //다음 탐색
		}
	}
}
