package N3965;

import java.io.*;
import java.util.*;

public class Q2529 {

	public static int length = 10;
	public static long max = Long.MIN_VALUE;
	public static String maxStr = "";
	public static long min = Long.MAX_VALUE;
	public static String minStr = "";

	public static int[] items = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	public static boolean[] visited = new boolean[length];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int[] bucket = new int[T + 1];
		char[] operator = new char[T];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
		for(int i = 0; i < T; i++)
			operator[i] = st.nextToken().charAt(0);
		
		pick(bucket, operator, T + 1, 0);
		
		System.out.println(maxStr); //그냥 array에 넣어놓고 정렬해서 첫 번째랑 마지막 값을 출력해도 됨
		System.out.println(minStr);
	}
	
	public static void pick(int[] bucket, char[] operator, int N, int k) {
		if(N == k) {
			for(int i = 1; i < bucket.length; i++) {
				if(!check(operator[i - 1], bucket[i - 1], bucket[i]))
					return;
			}
			
			String temp1 = "";
			for(int i = 0; i < bucket.length; i++)
				temp1 += bucket[i];
			
			long temp2 = Long.parseLong(temp1);
			if(temp2 > max) {
				max = temp2;
				maxStr = temp1;
			}
			
			if(temp2 < min) {
				min = temp2;
				minStr = temp1;
			}
			
			return;
		}
		
		for(int i = 0; i < length; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			bucket[k] = items[i];
			pick(bucket, operator, N, k + 1);
			visited[i] = false;
		}
	}

	public static boolean check(char operator, int op1, int op2) {
		switch(operator) {
			case '<':
				return (op1 < op2);
			case '>':
				return (op1 > op2);
		}
		return false;
	}
}