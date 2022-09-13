package N3959;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1912_2 {

	private static int[] arr;
	private static int[] DP;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		DP = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			DP[i] = arr[i]; //�ʱ�ȭ
		}
		
		int sum = 0;
		for(int i = 0; i < n; i++) { //O(n)
			sum += arr[i];
			if(sum > DP[i])
				DP[i] = sum;
			else sum = arr[i];
		}
		
		Arrays.sort(DP);
		System.out.println(DP[n - 1]);
	}

}
