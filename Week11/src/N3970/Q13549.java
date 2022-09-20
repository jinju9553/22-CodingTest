package N3970;

import java.io.*;
import java.util.*;

public class Q13549 {
	
	static boolean[] visited;
	static int maxSize = 100000;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");
		int start = Integer.parseInt(temp[0]);
		int target = Integer.parseInt(temp[1]);
		
		visited = new boolean[maxSize * 2 + 1]; //초기 상태: false
		
		System.out.print(BFS(start, target));
	}
	
	public static int BFS(int start, int target) {
		Queue<Integer> queue = new LinkedList<>();
		int[] count = new int[maxSize * 2 + 1];
		
		visited[start] = true;
		visited[start * 2] = true;
		queue.add(start);
		queue.add(start * 2); //주의!!: 2의 제곱수 칸에 간다면 무조건 0초 소모됨
		
		while(!queue.contains(target)) {
			int size = queue.size();
			
			while(size-- > 0) {
				int v = queue.poll();
				
				if (v * 2 >= 0 && v * 2 <= 100000) {
					if (!visited[v * 2]) {
						visited[v * 2] = true;
						queue.add(v * 2);
						count[v * 2] = count[v];
					}
				}
				
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
							count[nextIndex] = count[v] + 1;
						}
					}
				}
			} //2의 배수 노드로 가지 않을 때만 증가시켜야 함
		}
		
		return count[target]; 
	}
}
