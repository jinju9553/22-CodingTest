package N3960;

import java.io.*;
import java.util.Arrays;

public class Q2156_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] DP = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			DP[i] = arr[i]; //DP[0] ����
		}
		
		if(N > 1) //�Է��� 1���� �����ϴ� ��Ÿ�� ���� ���� 
			DP[1] = arr[0] + arr[1];
		
		if(N > 2)
			DP[2] = Math.max(DP[1], Math.max(arr[0] + arr[2], arr[1] + arr[2])); //1������ DP(OOX)�ų�, OXO�ų�, XOO�ų�
		
		if(N > 3){
			for(int i = 3; i < N; i++)
				DP[i] = Math.max(DP[i - 1], Math.max(DP[i - 2] + arr[i], DP[i - 3] + arr[i] + arr[i - 1]));
		}
		//(i�� 3��° ����) Math.max(OOX, OXO, ?XOO) 
		
		Arrays.sort(DP);
		System.out.println(DP[N - 1]);
	}

}
