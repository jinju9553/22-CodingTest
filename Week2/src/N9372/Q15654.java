package N9372;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q15654 {

	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String[] tokens = str.split(" ");
		
		int N = Integer.parseInt(tokens[0]);
		int M = Integer.parseInt(tokens[1]);
		
		StringTokenizer s = new StringTokenizer(br.readLine(), " ");
		
		int[] items = new int[N]; //사용자 입력으로 받은 item
		int[] bucket = new int[M];
		
		for(int i = 0; i < N; i++)
			items[i] = Integer.parseInt(s.nextToken());
		
		Arrays.sort(items); //다른 방법은 없을까? (일단 괜찮네요)
		solution(items, bucket, M);
		System.out.println(sb);
	}
	
	public static void solution(int[] items, int[] bucket, int k) {

		if (k == 0) { // 더이상 뽑을 게 없다면 모두 출력
			for (int i = 0; i < bucket.length; i++)
				sb.append(bucket[i]).append(' ');
			sb.append('\n');
			return;
		}

		int lastIndex = bucket.length - k - 1; // 가장 최근에 뽑힌 수가 저장된 위치 index

		for (int i = 0; i < items.length; i++) // candidate items
		{
			int flag = 0;
			for (int j = 0; j <= lastIndex; j++)
				if (bucket[j] == items[i]) // 현재 보고있는 item이 이미 버킷에 있는지 확인
					flag = 1; // 이미 뽑혔다고 표시 (**조합과 다른 부분!)

			if (flag == 1) // 이미 뽑혔다면 다음 루프로
				continue;

			bucket[lastIndex + 1] = items[i]; // 아니라면 버킷에 담음
			solution(items, bucket, k - 1); // 다음 탐색
		}
	}
}
