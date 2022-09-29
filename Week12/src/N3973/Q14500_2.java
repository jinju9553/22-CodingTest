package N3973;

import java.io.*;
import java.util.*;

public class Q14500_2 {
	
	public static int[][] matrix;
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] lines = br.readLine().split(" ");
		int N = Integer.parseInt(lines[0]);
		int M = Integer.parseInt(lines[1]);
		
		matrix = new int[N][M];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++)
				matrix[i][j] = Integer.parseInt(st.nextToken());
		}
		
		//
	}
	
	public static void DFS() { //±î¸Ô¾ú¾î(shit)
		
	}
	
	public static void exDFS() { 
		
	}
	
}
