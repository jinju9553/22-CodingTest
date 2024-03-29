package N9376;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11053 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );

		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] DP = new int[T];
		int[] arr = new int[T];
		
		for(int i = 0; i < T; i++) {
			arr[i] = Integer.parseInt( st.nextToken() );
			DP[i] = 1;
		}
		
		for(int i = 1; i < T; i++) { //arr[0]의 최대길이는 1이므로 범위에서 제외
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j] && DP[i] < DP[j] + 1) {
					DP[i] = DP[j] + 1;
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < T; i++) {
			max = (DP[i] > max) ? DP[i] : max;
		}
		
		System.out.println(max);
	}

}
