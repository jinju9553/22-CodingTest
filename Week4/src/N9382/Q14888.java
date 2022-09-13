package N9382;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14888 {

	public static int [] operand; 
	public static int [] operator;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) ); 
		
		int N = Integer.parseInt(br.readLine());
		
		char[] items = {'+', '-', '*', '/'};
		char[] bucket = new char[N - 1];
		operand = new int[N];
		operator = new int[4];
		int[] operatorCount = new int[4];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			operand[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < 4; i++) { // (+ , - , * , /) ����
			operator[i] = Integer.parseInt(st.nextToken());
			operatorCount[i] = operator[i];
		}
		
		pick(items, bucket, operatorCount, N - 1);
		
		System.out.println(sb);
	}

	public static void pick(char[] items, char[] bucket, int[] operatorCount, int k) {
		if(k == 0) {
			//�׽�Ʈ�� �ڵ�
			for(int i = 0; i < bucket.length; i++)
				sb.append(bucket[i]).append(" ");
			sb.append('\n');
			
			//���⼭ operator �纻 �迭 �ʱ�ȭ 
			//�ٵ� java.lang.OutOfMemoryError: Java heap space (��...)
			for(int i = 0; i < operator.length; i++)
				operatorCount[i] = operator[i];
			
			return;
		}
		
		int lastIndex = bucket.length - k - 1;
		
		for (int i = 0; i < items.length;) { //item�� �ٲ���� �� ������ operator�� ���͵Ǿ�� ��
			if(operatorCount[i] <= 0) { //�� items�� �� ���� �� ���� ��
				i++; //���� �������� Ȯ��
				continue;
			}
					
			operatorCount[i] -= 1;
			bucket[lastIndex + 1] = items[i]; 
			pick(items, bucket, operatorCount, k - 1); 
			//��Ŷ�� ��� ���� �������� i�� items.length���� �۾Ƽ� for���� �����Ű�� ����(���ѷ���)
			
			if(bucket.length == operand.length - 1)
				break; //Ž������ �����۰� ������ ��Ŷ�� �� á�ٸ� for�� ����
			//�̷��� ù ���ڷ� *�� ���� �� ���� (i�� 2���� �����ϴ� ��Ͱ� �־�� �ϴµ� �װ� ����...)
		}
		
	}
}
