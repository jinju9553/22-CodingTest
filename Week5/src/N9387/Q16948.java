package N9387;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q16948 {

	private static int T;
	private static int count = 0;
	private static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		visited = new boolean[T][T];

		String[] temp = br.readLine().split(" ");
		int row1 = Integer.parseInt(temp[0]);
		int col1 = Integer.parseInt(temp[1]);
		int row2 = Integer.parseInt(temp[2]);
		int col2 = Integer.parseInt(temp[3]);
		
		BFS(row1, col1, row2, col2);
		
		System.out.println(count);
	}
	
	public static void BFS(int row1, int col1, int row2, int col2) {
		Queue<Point> queue = new LinkedList<>(); //Integer �迭�� �� �پ� ����ִ� ť
		Point target = new Point(row2, col2);
		
		visited[row1][col1] = true;
		queue.add(new Point(row1, col1));
		
		int flag = 0;
		while (!queue.isEmpty()) { //�̰� ����? ==> ��.
			int size = queue.size();

			while (size-- > 0) {
				Point p = queue.poll(); //���� ���� �ϳ� ����

				int x = 0; int y = 0; //�� ������ Ž���� ��ǥ ����
				for (int i = 0; i < 6; i++) {
					switch(i) {
						case 0: { x = p.x - 2; y = p.y - 1; break; }
						case 1: { x = p.x - 2; y = p.y + 1; break; }
						case 2: { x = p.x; y = p.y - 2; break; }
						case 3: { x = p.x; y = p.y + 2; break; }
						case 4: { x = p.x + 2; y = p.y - 1; break; }
						case 5: { x = p.x + 2; y = p.y + 1; break; }
					}

					//���� ��ǥ�� �����ߴٸ� Ž��
					if (x < T && y < T && x > -1 && y > -1) { //ü���� ���� �����
						if (!visited[x][y]) {
							visited[x][y] = true;
							queue.add(new Point(x, y));
						}
					}
				} //for�� ���� 
			} //�� ���� Ž�� �Ϸ�
			count++;	
			if(queue.contains(target)) { flag = 1; break; }
		}
		if(flag != 1) count = -1;
	}

}
