package N3968;

import java.io.*;
import java.util.*;

public class Q16947 {
	
	private static ArrayList<Integer> graph[];
	private static boolean[] visited;
	private static boolean[] isCycle;
	private static int[] distance;
	
	private static StringBuilder sb = new StringBuilder();

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[T + 1]; //정점의 개수만큼 크기 초기화(0은 제외)
		isCycle = new boolean[T + 1];
		distance = new int[T + 1];
		
		for(int i = 1; i <= T; i++)
			graph[i] = new ArrayList<>();
		
		String[] temp;
		for(int i = 0; i < T; i++) {
			temp = br.readLine().split(" ");
			
			int u = Integer.parseInt(temp[0]);
			int v = Integer.parseInt(temp[1]);
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		//1.사이클 탐색 - DFS
		int cycleStart = 1;
		for(int i = 1; i <= T; i++) {
			visited = new boolean[T + 1]; 
			
			if(DFS(i, 0, i)) {
				cycleStart = i; //사이클 시작점을 기록
				break;
			}
		}
		
		visited = new boolean[T + 1]; //재활용을 위해 초기화
		
		//2.거리 재기 - BFS
		BFS(T, cycleStart); //사이클 시작점부터 탐색
		
		for(int i = 1; i <= T; i++) //BFS 안에서 하면 순서가 꼬이므로 빼냄
			sb.append(distance[i]).append(" ");
		
		System.out.println(sb);
	}

	public static boolean DFS(int current, int prev, int start) {
		visited[current] = true;
		
		for(int w : graph[current]) { //current와 연결된 정점 w 탐색
			if(!visited[w]) { //만약 방문한 적 없으면
				if(DFS(w, current, start)) { //그 점을 기준으로 다시 DFS 
					isCycle[w] = true; //추가 탐색에서 사이클을 발견했다면 이 정점도 사이클에 포함
					return true; //계속 탐색
				}
			}
			else if(visited[w] && (w != prev) && (w == start)) {
				//최초로 (end == start)가 발견되는 곳
				isCycle[w] = true; //이 점과 연결된 사이클은 재귀로 찾는다.
				return true;
			}
		}
		return false;
	}
	
	public static boolean BFS(int vertex, int currentStart) {
		Queue<Integer> queue = new LinkedList<>();
		
		visited[currentStart] = true;
		queue.add(currentStart);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(size-- > 0) {
				int v = queue.poll();
				
				for(int w : graph[v]) {
					if(!visited[w]) {
						visited[w] = true;
						queue.add(w);
						
						if(!isCycle[w]) //사이클 포함 정점이면 길이 변동 X
							distance[w] = distance[v] + 1; //나와 연결된 정점의 너비에서 + 1
					}
				}
			} //한 레벨 종료
		} //큰 while문 종료
		return false;
	}
}
