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
		
		int[] items = new int[N]; //����� �Է����� ���� item
		int[] bucket = new int[M];
		
		for(int i = 0; i < N; i++)
			items[i] = Integer.parseInt(s.nextToken());
		
		Arrays.sort(items); //�ٸ� ����� ������? (�ϴ� �����׿�)
		solution(items, bucket, M);
		System.out.println(sb);
	}
	
	public static void solution(int[] items, int[] bucket, int k) {

		if (k == 0) { // ���̻� ���� �� ���ٸ� ��� ���
			for (int i = 0; i < bucket.length; i++)
				sb.append(bucket[i]).append(' ');
			sb.append('\n');
			return;
		}

		int lastIndex = bucket.length - k - 1; // ���� �ֱٿ� ���� ���� ����� ��ġ index

		for (int i = 0; i < items.length; i++) // candidate items
		{
			int flag = 0;
			for (int j = 0; j <= lastIndex; j++)
				if (bucket[j] == items[i]) // ���� �����ִ� item�� �̹� ��Ŷ�� �ִ��� Ȯ��
					flag = 1; // �̹� �����ٰ� ǥ�� (**���հ� �ٸ� �κ�!)

			if (flag == 1) // �̹� �����ٸ� ���� ������
				continue;

			bucket[lastIndex + 1] = items[i]; // �ƴ϶�� ��Ŷ�� ����
			solution(items, bucket, k - 1); // ���� Ž��
		}
	}
}
