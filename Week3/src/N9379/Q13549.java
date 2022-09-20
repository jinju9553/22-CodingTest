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
	
	//@: 이 문제는 기본적으로는 목표지점에 도달했다고 정답인 문제가 아닙니다.
	//만약 (*2, +1, -1)로 BFS의 코드를 작성하신 경우 해당 목표값에 도달했다고 바로 값을 출력하지 마시고, 
	//방문시간을 계산해서 최소값으로 갱신(==다익스트라)해주는 방식으로 접근해야 합니다.
	public static int BFS(int start, int target) {
		Queue<Integer> queue = new LinkedList<>();
		int count = 0;
		
		visited[start] = true;
		visited[start * 2] = true;
		queue.add(start);
		queue.add(start * 2); //주의!!: 2의 제곱수 칸에 간다면 무조건 0초 소모됨
		
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
			count += 1; //2의 배수 노드로 가지 않을 때만 증가시켜야 함
		}
		
		return count; 
	}

}
