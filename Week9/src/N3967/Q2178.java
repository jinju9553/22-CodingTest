package N3967;

import java.io.*;
import java.util.*;
import java.awt.*;

public class Q2178 {

	public static int count = 0;
	public static int[][] matrix;
	public static boolean[][] visited;
	
	public static int[] dx = {0, 0, -1, 1}; //위, 아래, 왼, 오른쪽
	public static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		
		matrix = new int[N][M];
		visited = new boolean[N][M];
		
		String line;
		for(int i = 0; i < N; i++) {
			line = br.readLine();
			for(int j = 0; j < M; j++)
				matrix[i][j] = line.charAt(j) - '0';
		}
		
		BFS(0, 0, N - 1, M - 1); //(4, 5)
		
		System.out.println(count);
	}

	public static void BFS(int row1, int col1, int row2, int col2) {
		Queue<Point> queue = new LinkedList<>();
		Point target = new Point(col2, row2); //Point(5, 4) //(x, y) 순서에 맞춤
		
		visited[row1][col1] = true;
		queue.add(new Point(row1, col1));
		count++;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			int flag = 0;
			
			while(size-- > 0) {
				Point p = queue.poll();
				
				int x = 0; int y = 0;
				for(int i = 0; i < dx.length; i++) { //변량 결정
					x = p.x + dx[i];
					y = p.y + dy[i];
					
					//주의: (y, x)가 (row, col)에 대응됨
					if(x <= col2 && x > -1 && y <= row2 && y > -1) { //범위 체크
						if(!visited[y][x] && matrix[y][x] == 1) { //방문한 적 없고, 이동가능할 때
							Point nextP = new Point(x, y);
							
							visited[y][x] = true;
							queue.add(nextP);
							flag = 1;
							
							if(target.x == nextP.x && target.y == nextP.y) {
								count++;
								return;
							}
						}
					}
				}
				//같은 레벨 내에서 두 점 중 하나만 선택해야함 => count 계산은? => queue에 추가된 게 있다면 그 레벨에서 +1
			} //한 레벨 탐색 완료
			if(flag == 1) count++;
		}
	}
}
