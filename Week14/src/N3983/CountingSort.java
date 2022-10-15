package N3983;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CountingSort {

	public static int MAX_SIZE = 1000000;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		countingSort(arr);
		
		System.out.println(sb);
	}
	
	public static void countingSort(int[] arr) {
		
		int[] count = new int[MAX_SIZE + 1];
		
		for(int i : arr) {
			count[i] += 1; 
		}
		
		for(int i = 1; i <= MAX_SIZE; i++) {
			for(int j = 0; j < count[i]; j++)
				sb.append(i).append('\n');
		}
	}

}
