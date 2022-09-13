package N9388;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9251 {

	private static int[][] DP;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String X = br.readLine();
		String Y = br.readLine();
		
		int i = X.length();
		int j = Y.length();
		DP = new int[i + 1][j + 1]; //�ε��� 0�� ������� ����. ����: (r - 1), (c - 1)�� 0 ���Ϸ� �������� �ȵ�
		
		for(int k = 0; k <= i; k++)
			DP[k][0] = 0; //���� �� �ʱ�ȭ ==> ������� �ʴ� ����(���ڿ��� ���̰� 0�� ��)
		
		for(int k = 0; k <= j; k++)
			DP[0][k] = 0; //���� õ�� �ʱ�ȭ ==> ������� �ʴ� ����(���ڿ��� ���̰� 0�� ��)
		
		for(int r = 1; r <= i; r++) {
			for(int c = 1; c <= j; c++) {
				if(X.charAt(r - 1) == Y.charAt(c - 1))
					DP[r][c] = DP[r - 1][c - 1] + 1; //DP�迭 �밢�� ���� ���� +1�� ����
				else
					DP[r][c] = Math.max(DP[r][c - 1], DP[r - 1][c]);
			}
		}
		
		System.out.println(DP[i][j]);
	}
}
