package N3962;

import java.io.*;
import java.util.Arrays;

public class Q2309 {

	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = 9;
		int[] height = new int[n];
		
		int sum = 0;
		for(int i = 0; i < n; i++) {
			height[i] = Integer.parseInt(br.readLine());
			sum += height[i];
		}
		
		Arrays.sort(height);
		
		int target1 = 0; int target2 = 0;
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				if(sum - (height[i] + height[j]) == 100) {
					target1 = height[i];
					target2 = height[j];
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			if(height[i] != target1 && height[i] != target2)
				sb.append(height[i]).append('\n');
		}
			
		System.out.println(sb);
	}

}
