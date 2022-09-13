package N3959;

import java.io.*;

public class Q1699 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		
		int N = Integer.parseInt(br.readLine());
		int[] DP = new int[N + 1]; //0�� ������� ����
		
		DP[1] = 1;
		for(int i = 2; i <= N; i++) {
			if(Math.sqrt(i) % 1 == 0) { //��Ʈ�� �ڿ������
				DP[i] = 1;
				
				for(int j = 2; j <= (N / i); j++)
					if(DP[i * j] == 0 || DP[i * j] > DP[i] * j) DP[i * j] = DP[i] * j;
			}
		}
		
		//�ݷ�: 98989 ==> 3?��? ���;��Ѵٰ�? 4�� �ƴ϶�?
		//�ݷ�: 18 ==> 2�� ���;� �� ���� (�ٵ� 3�̶�� ������ ��) 
		
		int flag = 0; int temp = N; int sum = 0;
		while(flag == 0) { //O(��n)? 
			if(temp == 0) //�� ������
				break;
			
			if(DP[temp] != 0) {
				sum += DP[temp];
				break;
			}
			
			if(DP[N] != 0) { //N�� ��Ʈ�� �ڿ������
				flag = 1;
				break; //�ٷ� ����
			}
			
			int sqrt = (int)Math.floor(Math.sqrt(temp));
			temp = temp - (sqrt * sqrt);
			sum += DP[sqrt * sqrt];
		}
		
		if(flag != 1) DP[N] = sum; //�̸� ������ ���� �����ٸ�
		
		System.out.println(DP[N]);
	}
}