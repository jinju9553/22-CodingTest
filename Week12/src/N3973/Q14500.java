package N3973;

import java.io.*;
import java.util.*;

public class Q14500 {
	
	public static int[][] matrix;
	public static int idx = 0;

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
		
		String[][] tetromino = new String[19][]; //[19][4] 
		
		tetromino[idx++] = new String[] {"00", "01", "10", "11"};
		tetromino[idx++] = new String[] {"00", "01", "02", "03"};
		
		tetromino[idx++] = new String[] {"00", "10", "20", "21"};
		rotateBlock(tetromino, idx - 1, idx + 4, idx);
		
		tetromino[idx++] = new String[] {"00", "10", "11", "21"};
		rotateBlock(tetromino, idx - 1, idx + 2, idx);
		
		tetromino[idx++] = new String[] {"00", "01", "02", "11"};
		rotateBlock(tetromino, idx - 1, idx + 4, idx);
		
		System.out.println();
	}

	public static void rotateBlock(String[][] tetromino, int start, int end, int idx) {
		//블록 시계방향으로 뒤집기
		for (int i = start; i < end; i++) { //기존에 만들어진 블록을 3회 뒤집음
			tetromino[idx] = new String[4];
			for (int j = 0; j < tetromino[0].length; j++) { // 각 원소별로 접근
				String temp = "";
				int row = tetromino[i][j].charAt(0) - '0'; // y
				int col = tetromino[i][j].charAt(1) - '0'; // x
				//*문제: 문자열에서 '0'을 빼서 int로 변환하면 음수를 변환할 때 오차가 생긴다.

				// 1)좌표 계산
				row = row * (-1);
				temp += col;
				temp += row;

				// 2)새 배열에 바뀐 좌표 넣기
				tetromino[idx][j] = temp;
			}
			idx++;
		}
	}
}
