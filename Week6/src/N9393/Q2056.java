package N9393;

import java.io.*;
import java.util.*;

public class Q2056 { //9%

	public static int[] time;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		@SuppressWarnings("unchecked")
		LinkedList<Integer> graph[] = new LinkedList[T + 1];
		int[] indegree = new int[T + 1];
		int[] weight = new int[T + 1]; //여기서 가중치는 시간
		time = new int[T + 1];
		
		for(int i = 1; i <= T; i++)
			graph[i] = new LinkedList<Integer>();

		//주의: 단방향 그래프, i = 1번 노드부터 시작
		StringTokenizer st; int n = 0;
		for(int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			weight[i] = Integer.parseInt(st.nextToken()); //첫 번째: 가중치
			
			n = Integer.parseInt(st.nextToken()); //두 번째: 진입 간선의 개수
			indegree[i] = n;
			
			for(int j = 0; j < n; j++) //세 번째 이후: 연결된 간선들
				graph[Integer.parseInt(st.nextToken())].add(i);
		}
		
		System.out.println(topological(graph, indegree, weight));
	}

	public static int topological(LinkedList<Integer> graph[], int[] indegree, int[] weight) {
		
		Queue<Integer> queue = new LinkedList<>();
		int maxTime = Integer.MIN_VALUE;
		
		//1.큐에 진입 차수가 0인 노드만 담는다. (1번 노드부터 시작)
		for(int i = 1; i < indegree.length; i++) { //길이는 인덱스에 미포함이므로 주의
			if(indegree[i] == 0)
				queue.add(i);
		}
		
		//2.큐가 빌 때까지
		while(!queue.isEmpty()) {
			//3.노드 하나를 꺼내고
			int v = queue.poll();
			
			if(time[v] == 0) time[v] = weight[v]; //아직 계산된 적 없을 때만 초기화
			
			for(int w : graph[v]) { //v와 연결된 모든 w에 대해
				indegree[w]--; //진입 차수를 1씩 감소시킨다
			
				//4.만약 진입 차수가 0이 된 노드가 있다면 큐에 넣는다.
				if(indegree[w] == 0)
					queue.add(w);
				
				time[w] = Math.max((time[v] + weight[w]), time[w]);
			}
			maxTime = (time[v] > maxTime) ? time[v] : maxTime; 
		}
		return maxTime; //전체 걸리는 시간 중에 가장 긴 시간이 총 소요시간임 
	}
}
