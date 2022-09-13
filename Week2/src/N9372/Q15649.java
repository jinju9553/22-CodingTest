package N9372;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15649 { //���� //1ȸ��: ������ 10%���� �ð� �ʰ� ==> 2ȸ��: StringBuilder�� �ٲ㼭 ����

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
		
		if (k == 0) { //���̻� ���� �� ���ٸ� ��� ���
			for (int i = 0; i < bucket.length; i++)
				sb.append(bucket[i]).append(' ');
			sb.append('\n');
			return;
		}
		//�̹� ���� ����(�� �ε���) = (��Ŷ ũ�� - ������ ���� ��) - 1 
		int lastIndex = bucket.length - k - 1; // ���� �ֱٿ� ���� ���� ����� ��ġ index
		
		for (int i = 0; i < items.length; i++) // candidate items
		{
			int flag = 0;
			for (int j = 0; j <= lastIndex; j++)
				if (bucket[j] == items[i]) //���� �����ִ� item�� �̹� ��Ŷ�� �ִ��� Ȯ��
					flag = 1; //�̹� �����ٰ� ǥ�� (**���հ� �ٸ� �κ�!)
			
			if (flag == 1) //�̹� �����ٸ� ���� ������ 
				continue;
			
			bucket[lastIndex + 1] = items[i]; //�ƴ϶�� ��Ŷ�� ����
			solution(items, bucket, k - 1); //���� Ž��
		}
	}
}
