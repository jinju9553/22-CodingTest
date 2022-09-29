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
		//��� �ð�������� ������
		for (int i = start; i < end; i++) { //������ ������� ����� 3ȸ ������
			tetromino[idx] = new String[4];
			for (int j = 0; j < tetromino[0].length; j++) { // �� ���Һ��� ����
				String temp = "";
				int row = tetromino[i][j].charAt(0) - '0'; // y
				int col = tetromino[i][j].charAt(1) - '0'; // x
				//*����: ���ڿ����� '0'�� ���� int�� ��ȯ�ϸ� ������ ��ȯ�� �� ������ �����.

				// 1)��ǥ ���
				row = row * (-1);
				temp += col;
				temp += row;

				// 2)�� �迭�� �ٲ� ��ǥ �ֱ�
				tetromino[idx][j] = temp;
			}
			idx++;
		}
	}
}
