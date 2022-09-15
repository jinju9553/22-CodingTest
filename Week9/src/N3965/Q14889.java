package N3965;

import java.io.*;
import java.util.*;

public class Q14889 {

	public static int[][] matrix;
	public static boolean[] picked;
	public static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		matrix = new int[N][N];
		picked = new boolean[N];
		int[] bucket = new int[N/2]; //1부터 N까지 N/2개의 수를 뽑음
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++)
				matrix[i][j] = Integer.parseInt(st.nextToken());
		}
		
		pick(N, N/2, bucket, 0, 0);
		
		System.out.println(min);
	}
	
	public static void pick(int N, int M, int[] bucket, int k, int lastIndex) {
		if(M == k) {
			int sum1 = 0; //모든 (i, j) 쌍을 구해야 하므로 이중 for문
			for(int i = 0; i < bucket.length - 1; i++) {
				for(int j = (i + 1); j < bucket.length; j++) {
					int x = bucket[i];
					int y = bucket[j];
					sum1 += (matrix[x - 1][y - 1] + matrix[y - 1][x - 1]);
				}
			}
		
			int sum2 = 0;
			for(int i = 0; i < picked.length - 1; i++) {
				for(int j = (i + 1); j < picked.length; j++) {
					if(picked[i] == false && picked[j] == false)
						sum2 += (matrix[i][j] + matrix[j][i]);
				}
			}
			
			int s = Math.abs(sum1 - sum2);
			min = (min > s) ? s : min;
			
			return;
		}
		
		for(int i = lastIndex; i < N; i++) {
			picked[i] = true;
			bucket[k] = (i + 1);
			
			pick(N, M, bucket, k + 1, i + 1);
			picked[i] = false;
		}
	}

}
