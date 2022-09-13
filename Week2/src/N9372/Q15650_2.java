package N9372;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15650_2 { //����

	public static int[] bucket;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer s = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(s.nextToken()); // item.length
		int M = Integer.parseInt(s.nextToken()); // recursion depth

		bucket = new int[M];

		solution(N, M, 0, 0);
		System.out.println(sb);
	}
	
	public static void solution(int N, int M, int k, int lastIndex) {

		if (k == M) { 
			for (int i = 0; i < bucket.length; i++)
				sb.append(bucket[i]).append(" ");
			sb.append('\n');
			return;
		}

		//�׻� ������ ���� item���� ū item�� �̴´� ==> lastIndex�� ���� ����
		for (int i = lastIndex; i < N; i++) { 
			bucket[k] = (i + 1); 
			solution(N, M, k + 1, i + 1); //���� Ž�� (��� ���� i���� �ϳ� ū �� ��������� index�� �ش�)
		}
		
		return;
	}
}
