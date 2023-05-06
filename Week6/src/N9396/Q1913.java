package N9396;

import java.io.*;

public class Q1913 {
	
	private static int[] dx = {0, 1, 0, -1}; //��, ������, �Ʒ�, ���� 
	private static int[] dy = {-1, 0, 1, 0};
	private static int[][] matrix;
	
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int target = Integer.parseInt(br.readLine());
		
		matrix = new int[T][T];
		
		solution(T, target);
		
		int targetR = 0; int targetC = 0;
		for(int i = 0; i < T; i++) { 
			for(int j = 0; j < T; j++) {
				sb.append(matrix[i][j] + " ");
				if(matrix[i][j] == target) {
					targetR = (i + 1); //�ε����� �ƴ϶� ��ǥ ó��(Point)
					targetC = (j + 1);
				}
			}
			sb.append('\n');		
		}
		
		System.out.print(sb);
		System.out.print(targetR + " " + targetC);
	}
	
	public static void solution(int N, int target) {
		
		int start = (N * N) / 2;
		int r = start / N;
		int c = start % N;
		
		matrix[r][c] = 1; 
		
		int d = 0;
		for(int i = 1; i < (N * N); i++) {
			r = r + dy[d];
			c = c + dx[d];
			
			if(d < 3) {
				d = d + 1;
				if(matrix[r + dy[d]][c + dx[d]] != 0)
					d = d - 1; //���� ĭ�� ������� �ʴٸ� d�� ���� 
			}
			else { //(d == 3)
				d = 0;
				if(matrix[r + dy[d]][c + dx[d]] != 0)
					d = 3;
			}
			
			//���� �ε����� �ʴ��� üũ, �ε����� �ʴ´ٸ� �� ���� 
			if(r >= 0 && c >= 0 && r < N && c < N) 
				matrix[r][c] = (i + 1);	//���� x ���� 
		}
	}

}
