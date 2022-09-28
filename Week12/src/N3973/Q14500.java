package N3973;

import java.io.*;
import java.util.*;

public class Q14500 {
	
	public static int[][] matrix;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		
		matrix = new int[N][M];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++)
				matrix[i][j] = Integer.parseInt(st.nextToken());
		}
		
		String[][] tetromino = new String[19][]; //[19][4]
		
		tetromino[0] = new String[] {"00", "01", "10", "11"};
		tetromino[1] = new String[] {"00", "01", "02", "03"};
		tetromino[2] = new String[] {"00", "10", "20", "21"};
		tetromino[3] = new String[] {"00", "10", "11", "21"};
		tetromino[4] = new String[] {"00", "01", "02", "11"};
		
		//블록 대칭으로 뒤집기
		int idx = 5;
		for(int i = 2; i < tetromino.length;) {
			for(int j = 0; j < tetromino[0].length; j++) {
				int row = tetromino[i][j].charAt(0) - '0';
				int col = tetromino[i][j].charAt(1) - '0';
				//좌표 계산... 
			}
		}
		
		System.out.println();
	}

}
