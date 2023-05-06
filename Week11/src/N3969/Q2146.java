package N3969;

import java.io.*;
import java.util.*;
import java.awt.*;

public class Q2146 {

	public static int[][] island;
	public static int[][] border;
	public static boolean[][] visited;
	
	public static int borderIdx = 1;
	public static int min = Integer.MAX_VALUE;
	
	public static int[] dx = {0, 0, 1, -1}; //대각선 이동 X
	public static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		
		island = new int[N][N];
		border = new int[N][N];
		visited = new boolean[N][N];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++)
				island[i][j] = Integer.parseInt(st.nextToken());
		}
		
		//1.같은 대륙끼리 구별하기 ==> O(n^2 * (n^2 + n^2)) = O(n^4)
		for(int i = 0; i < N; i++) { //O(n)
			for(int j = 0; j < N; j++) { //O(n)
				if(island[i][j] == 1) //땅이 있다면
					borderBFS(i, j, N); //O(V+E)
			}
		}

		//2.최소 다리 길이 재기 ==> O(n^4)
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				visited = new boolean[N][N]; //초기화
				if(island[i][j] == 1) //땅이 있다면
					findBridgeBFS(i, j, N, border[i][j]);
			}
		}
		
		System.out.println(min);
	}
	
	public static void borderBFS(int row, int col, int N) {
		Queue<Point> queue = new LinkedList<>();
		
		if(border[row][col] != 0) //시작점이 이미 탐색 완료한 대륙 한가운데라면
			return;
		
		visited[row][col] = true;
		queue.add(new Point(col, row));
		
		if(island[row][col] == 1)
			border[row][col] = borderIdx;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(size-- > 0) {
				Point p = queue.poll();
				
				int prow = 0; int pcol = 0;
				for(int i = 0; i < dx.length; i++) {
					pcol = p.x + dx[i];
					prow = p.y + dy[i];
					
					if(pcol > -1 && prow > -1 && pcol < N && prow < N) {
						if(!visited[prow][pcol] && island[prow][pcol] == 1) {
							visited[prow][pcol] = true;
							border[prow][pcol] = borderIdx;
							queue.add(new Point(pcol, prow));
						}
					}
				} //좌표 더하기 끝
			} //한 레벨 끝
			
			if(!isBorderLine(queue)) { //큐에 1이 없음 => 0밖에 없음 => 한 대륙 탐색 완료
				borderIdx++;
				return; //함수 종료
			}
		}
	}
	
	public static void findBridgeBFS(int row, int col, int N, int borderNum) {
		Queue<Point> queue = new LinkedList<>();
		int count = 0;
		
		visited[row][col] = true;
		queue.add(new Point(col, row));
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(size-- > 0) {
				Point p = queue.poll();
				
				int prow = 0; int pcol = 0;
				for(int i = 0; i < dx.length; i++) {
					pcol = p.x + dx[i];
					prow = p.y + dy[i];
					
					if(pcol > -1 && prow > -1 && pcol < N && prow < N) {
						if(!visited[prow][pcol] && border[prow][pcol] != borderNum) {
							//방문한 적 없고, 같은 대륙이 아닐 때(바다 포함)
							if(border[prow][pcol] == 0) { //바다라면
								visited[prow][pcol] = true;
								queue.add(new Point(pcol, prow));
							}
							else { //다른 대륙이라면 min 갱신
								min = (count < min) ? count : min;
								return; //종료
							}
						}
					}
				}
			}
			count++;
		}
	}
	
	public static boolean isBorderLine(Queue<Point> queue) {
		for(Point p : queue) {
			if(island[p.y][p.x] == 1) //하나라도 1이라면
				return true;
		}
		
		return false;
	}
}
