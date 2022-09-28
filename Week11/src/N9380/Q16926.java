package N9380;

import java.io.*;
import java.util.*;

public class Q16926 {

	private static int[] dx = {1, 0, -1, 0};
	private static int[] dy = {0, 1, 0, -1};
	
	private static int[][] matrix;
	private static StringBuilder sb = new StringBuilder(); 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]); //row
		int M = Integer.parseInt(temp[1]); //col
		int num = Integer.parseInt(temp[2]); //회전 횟수
		
		matrix = new int[N][M];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++)
				matrix[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int groupIdx = Math.min(N, M) / 2; //그룹의 개수를 토대로 나눠서 계산
		
		for(int i = 0; i < num; i++) //num 횟수만큼 돌린다.
			rotate(N, M, groupIdx);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
				sb.append(matrix[i][j]).append(" ");
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void rotate(int row, int col, int groupIdx) {
		
		for(int i = 0; i < groupIdx; i++) {
			int temp = matrix[i][i]; //시작점을 미리 백업한다.
			
			int count = 0;
			int currX = i; int currY = i;
			while(count < 4) {
				int nx = currX + dx[count]; //회전시킬 다음 원소를 찾는다.
				int ny = currY + dy[count];
				
				if(nx >= i && ny >= i && nx < col - i && ny < row - i) {
					matrix[currY][currX] = matrix[ny][nx]; //다음 원소를 현재 위치로 복사한다.
					currX = nx; //현재 좌표를 갱신한다.
					currY = ny;
				}
				else
					count++;
			}
			
			matrix[i + 1][i] = temp; //가장 처음에 저장해둔 것을 복사한다.
		}
	}

}
