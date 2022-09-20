package N9379;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q13549 {

	static boolean[] visited;
	static int maxSize = 100000;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] initLine = (br.readLine()).split(" ");
		int N = Integer.parseInt(initLine[0]);
		int K = Integer.parseInt(initLine[1]);
		
		visited = new boolean[maxSize + 1];

		for(int i = 0; i <= maxSize; i++)
			visited[i] = false;

		System.out.print(BFS(N, K));
	}
	
	//@: �� ������ �⺻�����δ� ��ǥ������ �����ߴٰ� ������ ������ �ƴմϴ�.
	//���� (*2, +1, -1)�� BFS�� �ڵ带 �ۼ��Ͻ� ��� �ش� ��ǥ���� �����ߴٰ� �ٷ� ���� ������� ���ð�, 
	//�湮�ð��� ����ؼ� �ּҰ����� ����(==���ͽ�Ʈ��)���ִ� ������� �����ؾ� �մϴ�.
	public static int BFS(int start, int target) {
		Queue<Integer> queue = new LinkedList<>();
		int count = 0;
		
		visited[start] = true;
		visited[start * 2] = true;
		queue.add(start);
		queue.add(start * 2); //����!!: 2�� ������ ĭ�� ���ٸ� ������ 0�� �Ҹ��
		
		int v = -1;
		while(!queue.contains(target)) {
			int size = queue.size();
			
			while(size-- > 0) { 
				v = queue.poll();
				
				for(int i = 0; i < 2; i++) { 
					int nextIndex = 0;
					if(i == 0)
						nextIndex = v - 1;
					else if(i == 1)
						nextIndex = v + 1;

					if (nextIndex >= 0 && nextIndex <= 100000) {
						if (!visited[nextIndex]) {
							visited[nextIndex] = true;
							queue.add(nextIndex);
						}
					}
					
					if (nextIndex * 2 >= 0 && nextIndex * 2 <= 100000) {
						if (!visited[nextIndex * 2]) {
							visited[nextIndex * 2] = true;
							queue.add(nextIndex * 2);
						}
					}
				}
			}
			count += 1; //2�� ��� ���� ���� ���� ���� �������Ѿ� ��
		}
		
		return count; 
	}

}
