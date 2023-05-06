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
	
	public static int[] dx = {0, 0, 1, -1}; //�밢�� �̵� X
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
		
		//1.���� ������� �����ϱ� ==> O(n^2 * (n^2 + n^2)) = O(n^4)
		for(int i = 0; i < N; i++) { //O(n)
			for(int j = 0; j < N; j++) { //O(n)
				if(island[i][j] == 1) //���� �ִٸ�
					borderBFS(i, j, N); //O(V+E)
			}
		}

		//2.�ּ� �ٸ� ���� ��� ==> O(n^4)
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				visited = new boolean[N][N]; //�ʱ�ȭ
				if(island[i][j] == 1) //���� �ִٸ�
					findBridgeBFS(i, j, N, border[i][j]);
			}
		}
		
		System.out.println(min);
	}
	
	public static void borderBFS(int row, int col, int N) {
		Queue<Point> queue = new LinkedList<>();
		
		if(border[row][col] != 0) //�������� �̹� Ž�� �Ϸ��� ��� �Ѱ�����
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
				} //��ǥ ���ϱ� ��
			} //�� ���� ��
			
			if(!isBorderLine(queue)) { //ť�� 1�� ���� => 0�ۿ� ���� => �� ��� Ž�� �Ϸ�
				borderIdx++;
				return; //�Լ� ����
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
							//�湮�� �� ����, ���� ����� �ƴ� ��(�ٴ� ����)
							if(border[prow][pcol] == 0) { //�ٴٶ��
								visited[prow][pcol] = true;
								queue.add(new Point(pcol, prow));
							}
							else { //�ٸ� ����̶�� min ����
								min = (count < min) ? count : min;
								return; //����
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
			if(island[p.y][p.x] == 1) //�ϳ��� 1�̶��
				return true;
		}
		
		return false;
	}
}
