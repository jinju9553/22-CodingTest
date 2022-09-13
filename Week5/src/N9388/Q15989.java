package N9388;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q15989 {

	private static int count = 0;
	private static int[] DP;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		DP = new int[10000]; //n�� ����̸� 10,000���� �۰ų� ����.
		
		int target = 0;
		while(T-- > 0) {
			target = Integer.parseInt(br.readLine());
			
			count = 0;
			//DP�� 2���� �迭�̾�� ��...
			
			DP[target] = count;
			sb.append(DP[target]).append('\n');
		}
		
		System.out.println(sb);
	}

}
