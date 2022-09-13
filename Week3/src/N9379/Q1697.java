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
		
		//1 100000을 입력했을 때, v - 1 = 0이 되기 때문에 0도 고려
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
		//재귀로 구현하는 게 낫지 않을까 
		while(!queue.contains(target)) { //타겟을 찾을 때까지 반복
			int size = queue.size();
			
			//내가 몰랐던 부분: BFS에서 트리의 레벨 구하기
			while(size-- > 0) { //현재 큐에 있는 모든 수를 탐색했다면 하나의 레벨을 탐색 완료한 것
				v = queue.poll();
				//System.out.println("v: " + v + ", size: " + size);
				
				for(int i = 0; i < 3; i++) { //새로운 레벨을 만드는 과정
					int nextIndex = 0;
					if(i == 0)
						nextIndex = v - 1;
					else if(i == 1)
						nextIndex = v + 1;
					else if(i == 2)
						nextIndex = 2 * v;

					//주의: nextIndex가 0보다 작아지거나 100000보다 커질 수 있음
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
