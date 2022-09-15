package N3967;

import java.io.*;
import java.util.*;
import java.awt.*;

public class Q7576 {

	public static int[][] box;
	public static boolean[][] visited;
	public static int count = 0;
	
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//M은 상자의 가로 칸(col)의 수, N은 상자의 세로 칸(row)의 수
		String[] temp = br.readLine().split(" ");
		int M = Integer.parseInt(temp[0]);
		int N = Integer.parseInt(temp[1]);
		
		box = new int[N][M];
		visited = new boolean[N][M];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(!check(N, M)) { //처음부터 익었는지 체크
			BFS(N, M);
			if(check(N, M)) //BFS를 끝내고 다 익었는지 체크
				System.out.println(count - 1);
			else 
				System.out.println("-1");
		}
		else
			System.out.println(count);
	}
	
	public static void BFS(int N, int M) {
		Queue<Point> queue = new LinkedList<>();
		//문제: 시작점을 어떻게 찾을 것인가?
		//시작할 때 1인 점을 모두 Queue에 넣는다.
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(box[i][j] == 1) {
					visited[i][j] = true; //[row][col]
					queue.add(new Point(j, i));
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(size-- > 0) {
				Point p = queue.poll();
				
				int x = 0; int y = 0;
				for(int i = 0; i < dx.length; i++) {
					x = p.x + dx[i];
					y = p.y + dy[i];
					
					if(x > -1 && x < M && y > -1 && y < N) {
						if(box[y][x] == 0 && !visited[y][x]) {
							visited[y][x] = true;
							box[y][x] = 1;
							queue.add(new Point(x, y));
						}
					}
				}
				//for문 끝
			}
			//한 레벨 끝
			count++;
		}
	}
	
	public static boolean check(int N, int M) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(box[i][j] == 0)
					return false;
			}
		}
		return true;
	}

}
