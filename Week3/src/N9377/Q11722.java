package N9377;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11722 {

	public static int[] DP;
	public static int[] list;
	public static int maxLength = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		DP = new int[T];
		list = new int[T];

		for(int i = 0; i < T; i++) {
			list[i] = Integer.parseInt(st.nextToken());
			DP[i] = 1; //i까지의 최대 길이
		}
		
		for(int i = 0; i < T; i++) {
			//에?
		}
		
		
	}
	
}