package N9378;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q1260 {

	static ArrayList<Integer> graph[]; //연결리스트로 구현한 그래프: O(V + E)
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] initLine = (br.readLine()).split(" ");
		int vertex = Integer.parseInt(initLine[0]);
		int edge = Integer.parseInt(initLine[1]);
		int start = Integer.parseInt(initLine[2]);
		
		visited = new boolean[vertex + 1]; //인덱스 0번은 사용하지 않음
		graph = new ArrayList[vertex + 1];
		
		for(int i = 1; i <= vertex; i++) {
			graph[i] = new ArrayList<>();
			visited[i] = false;
		}
		
		String[] initGraph; int v; int u;
		for(int i = 0; i < edge; i++) {
			initGraph = br.readLine().split(" ");
			u = Integer.parseInt(initGraph[0]);
			v = Integer.parseInt(initGraph[1]);
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		DFS(vertex, start);
		sb.append('\n');
		
		for(int i = 1; i <= vertex; i++)
			visited[i] = false; //다음 탐색을 위해 재활용
		
		BFS(vertex, start);
		
		System.out.print(sb);
	}
	
	public static void DFS(int vertex, int currentStart) {
		visited[currentStart] = true;
		sb.append(currentStart).append(" ");
		for(int w : graph[currentStart]) { //인접한 정점들(w)을 탐색함
			if(!visited[w]) //currentStart 배열의 w번째 값 == 연결되어 있는 정점들
				DFS(vertex, w);
		}
	}
	
	public static void BFS(int vertex, int currentStart) {
		Queue<Integer> queue = new LinkedList<>();
		
		visited[currentStart] = true;
		queue.add(currentStart);
		sb.append(currentStart).append(" ");
		
		while(!queue.isEmpty()) {
			int v = queue.poll();
			for(int w = 1; w <= vertex; w++) { //DFS에서는 재귀로 구현한 것을 BFS에서는 반복문으로 구현
				if(graph[v].contains(w) && !visited[w]) {
					visited[w] = true;
					queue.add(w);
					sb.append(w).append(" ");
				}
			}
		}
	}

}
