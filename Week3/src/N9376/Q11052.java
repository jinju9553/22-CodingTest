package N9376;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11052 { 

	public static int[] DP;
 	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		DP = new int[T + 1];
		for(int i = 1; i <= T; i++) { //����: 1���� ����
			DP[i] = Integer.parseInt(st.nextToken());
		}
		
		DP[2] = (DP[1] * 2 > DP[2]) ? DP[1] * 2 : DP[2];
		
		//3�� �̻��� ���� ���� DP�� �ִ����� ����
		int sum; int target;
		for(int i = 3; i <= T; i++){
			sum = 0;
			target = i; //�̰���� ��� == �ε���
			for(int j = (i - 1); j > 0; j--) { 
				if(j > target)
					continue;

				if(target == 0)
					break;

				target = target - j;
				sum += DP[j]; //�ε���: ���� ��� - 1
			}
			DP[i] = (sum > DP[i]) ? sum : DP[i];
		}
		
		System.out.println(DP[T]);
	}

}
