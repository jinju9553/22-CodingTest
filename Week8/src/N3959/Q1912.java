package N3959;

import java.io.*;
import java.util.*;

public class Q1912 { //33%에서 시간 초과

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
			DP[i] = arr[i]; //초기화
		}
		
		int lastIndex = -1;
		for(int i = 0; i < n; i++) { //O(n)
			if(i != lastIndex && lastIndex != -1) {
				DP[i] = DP[i - 1] - arr[i - 1];
				continue;
			}
			
			if(lastIndex >= n - 1)
				break;
			
			lastIndex = calcDp(i); //최악이 O(n) //시간초과 되지 않을까...(YES) 
		}
		
		Arrays.sort(DP);
		System.out.println(DP[n - 1]);
	}

	public static int calcDp(int start) {
		int lastIndex = -1; int sum = 0;
		for(int i = start; i < arr.length - 1; i++) {
			sum += arr[i];
			if(sum + arr[i + 1] > DP[start]) {
				DP[start] = sum + arr[i + 1];
				lastIndex = i + 1;
			}
		}
		
		return lastIndex;
	}
}
