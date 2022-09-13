package N3959;

import java.io.*;

public class Q1699_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		
		int N = Integer.parseInt(br.readLine());
		int[] DP = new int[N + 1];
		
		DP[1] = 1;
		for(int i = 2; i <= N; i++) {
			DP[i] = Integer.MAX_VALUE;
			//Math.sqrt�� �ð��� ���� �ɸ��� �� ���� & Math.min ���� ��������...
			//DP[1]+DP[9]�� �������� ���� DP[9]+DP[1]�� ���� �ʿ� ����
			//if�� �ϳ��� �� ������ �ð��ʰ��� �ߴ� ���簣���� ���� 
			for(int j = 1; j <= (i / 2); j++) {
				if((j * j) == i) {
					DP[i] = 1;
					break;
				}
				DP[i] = (DP[i] > DP[j] + DP[i - j]) ? (DP[j] + DP[i - j]) : DP[i];
			}
		}
		
		System.out.println(DP[N]);
	}

}
