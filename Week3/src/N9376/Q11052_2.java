package N9376;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11052_2 {

	public static int[] DP;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		DP = new int[T + 1];
		for(int i = 1; i <= T; i++) { //����: 1���� ����
			DP[i] = Integer.parseInt(st.nextToken());
		}

		//DP[2]�� ��ȭ�Ŀ� ���Խ�ų �� �ִ� �ع� 
		for(int n = 1; n <= T; n++) {
			for(int i = 1; i <= n; i++) {
				int calc = DP[n - i] + DP[i];
				DP[n] = (calc > DP[n]) ? calc : DP[n];
			}
		}
		System.out.println(DP[T]);
	}

}
