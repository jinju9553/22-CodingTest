package N9386;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q16947 {

	private static ArrayList<Integer> graph[]; //여러 줄의 ArrayList를 달고 있는 배열
	private static boolean[] visited; //처음엔 모두 false
	private static boolean[] isCycle;
	private static int[] distance;
	
	private static StringBuilder sb = new StringBuilder();
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int T = Integer.parseInt(br.readLine());
		graph = new ArrayList[T + 1]; //정점의 개수만큼 크기 초기화(0은 제외)
		visited = new boolean[T + 1]; 
		isCycle = new boolean[T + 1];
		distance = new int[T + 1];
		
		for(int i = 1; i <= T; i++) //크기를 설정하고, 그 안에 들어갈 컬렉션 리스트를 하나하나 만들어야 함
			graph[i] = new ArrayList<>();
		
		String[] initLine; int u; int v;
		for(int i = 0; i < T; i++) {
			initLine = br.readLine().split(" ");
			u = Integer.parseInt(initLine[0]);
			v = Integer.parseInt(initLine[1]);
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		//포인트: 가장 최초의 진입정점을 다르게 하여 탐색. 최근에 방문한 정점만 가지고는 판별 불가함
		for(int i = 1; i <= T; i++)
			if(DFS(i, 0, i)) 
				break; //사이클을 발견했다면 탐색 종료
		
		visited = new boolean[T + 1]; //재활용을 위해 초기화
		
		BFS(T, 1); //문제: 정점 1부터 찾으면 안됨
		
		for(int i = 1; i <= T; i++) //BFS 안에서 하면 순서가 꼬이므로 빼냄
			sb.append(distance[i]).append(" ");
		
		System.out.println(sb);
	}

	public static boolean DFS(int current, int prev, int start) { //start: 최초의 진입 정점을 기록
		visited[current] = true;

		//사이클: 시작 정점과 종료 정점이 동일(동시에, 직전에 방문한 정점이 아닌데도 이미 visited된 정점이 있음)
		for(int w : graph[current]) { //currentStart의 모든 인접정점 w를 탐색한다 
				if (!visited[w]) { //방문한 적 없다면
					if(DFS(w, current, start)) { //다음 정점을 시작점으로 삼아 새롭게 탐색
						isCycle[w] = true; //만약 추가 탐색에서 사이클이 있다고 하였으면, 직전 정점도 사이클에 포함됨!
						return true; //계속 탐색
					}
				}
				else if(visited[w] && (w != prev) && (w == start)) { 
					//방문한 적 있는 정점을 발견하였는데 직전정점과 다르고, 최초의 진입지점으로 되돌아 왔다면 사이클
					isCycle[w] = true; //이 w와 연결된 사이클 정점들은 재귀로 찾는다.
					return true; //계속 탐색
				}
		}
		return false; //한 지점으로부터 끝까지 탐색을 마쳤음. 더 이상 탐색 가능한 인접 정점이 없다 
	}
	
	public static void BFS(int vertex, int currentStart) {
		Queue<Integer> queue = new LinkedList<>();

		visited[currentStart] = true;
		queue.add(currentStart);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(size-- > 0) {
				int v = queue.poll();
				
				for(int w : graph[v]) { //DFS에서는 재귀로 구현한 것을 BFS에서는 반복문으로 구현
					if(!visited[w]) {
						visited[w] = true;
						queue.add(w);

						if(!isCycle[w]) //사이클 포함 정점이면 길이 변동 X
							distance[w] = distance[v] + 1; //나와 연결된 정점의 너비에서 + 1
					}
				}
			}
		}
	}
}
