package N9380;

import java.io.*;
import java.util.*;

public class Q16926 {

	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {1, 0, -1, 0};
	
	private static int[][] result; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]); //row
		int M = Integer.parseInt(temp[1]); //col
		int num = Integer.parseInt(temp[2]); //ȸ�� Ƚ��
		
		int[][] matrix = new int[N][M];
		result = new int[N][M];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++)
				matrix[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int groupIdx = Math.min(N, M) / 2;
		
	}
	
	public static void rotate(int N, int M, int num) {
		
		
		//�׷��� ������ ���� ������ ���
		
	}

}
