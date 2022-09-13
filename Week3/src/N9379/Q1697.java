package N9379;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q1697 {

	static boolean[] visited;
	static int maxSize = 100000;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] initLine = (br.readLine()).split(" ");
		int N = Integer.parseInt(initLine[0]);
		int K = Integer.parseInt(initLine[1]);
		
		visited = new boolean[maxSize + 1];
		
		//1 100000�� �Է����� ��, v - 1 = 0�� �Ǳ� ������ 0�� ���
		for(int i = 0; i <= maxSize; i++)
			visited[i] = false;

		System.out.print(BFS(N, K));
	}
	
	public static int BFS(int start, int target) {
		Queue<Integer> queue = new LinkedList<>();
		int count = 0;
		
		visited[start] = true;
		queue.add(start);
		
		int v = -1;
		//��ͷ� �����ϴ� �� ���� ������ 
		while(!queue.contains(target)) { //Ÿ���� ã�� ������ �ݺ�
			int size = queue.size();
			
			//���� ������ �κ�: BFS���� Ʈ���� ���� ���ϱ�
			while(size-- > 0) { //���� ť�� �ִ� ��� ���� Ž���ߴٸ� �ϳ��� ������ Ž�� �Ϸ��� ��
				v = queue.poll();
				//System.out.println("v: " + v + ", size: " + size);
				
				for(int i = 0; i < 3; i++) { //���ο� ������ ����� ����
					int nextIndex = 0;
					if(i == 0)
						nextIndex = v - 1;
					else if(i == 1)
						nextIndex = v + 1;
					else if(i == 2)
						nextIndex = 2 * v;

					//����: nextIndex�� 0���� �۾����ų� 100000���� Ŀ�� �� ����
					if (nextIndex >= 0 && nextIndex <= 100000) {
						if (!visited[nextIndex]) {
							visited[nextIndex] = true;
							queue.add(nextIndex);
						}
					}
				}
			}
			count += 1;
		}
		
		return count; 
	}

}
