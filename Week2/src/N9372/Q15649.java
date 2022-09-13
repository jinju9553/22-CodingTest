package N9372;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15649 { //순열 //1회차: 맞지만 10%에서 시간 초과 ==> 2회차: StringBuilder로 바꿔서 성공

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
		//이미 뽑은 개수(의 인덱스) = (버킷 크기 - 앞으로 뽑을 수) - 1 
		int lastIndex = bucket.length - k - 1; // 가장 최근에 뽑힌 수가 저장된 위치 index
		
		for (int i = 0; i < items.length; i++) // candidate items
		{
			int flag = 0;
			for (int j = 0; j <= lastIndex; j++)
				if (bucket[j] == items[i]) //현재 보고있는 item이 이미 버킷에 있는지 확인
					flag = 1; //이미 뽑혔다고 표시 (**조합과 다른 부분!)
			
			if (flag == 1) //이미 뽑혔다면 다음 루프로 
				continue;
			
			bucket[lastIndex + 1] = items[i]; //아니라면 버킷에 담음
			solution(items, bucket, k - 1); //다음 탐색
		}
	}
}
