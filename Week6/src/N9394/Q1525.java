package N9394;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1525 {

	private static StringBuilder sb = new StringBuilder(); 
	private static String answer = "123456780"; 
	
	private static Map<String, Integer> map = new HashMap<>();
	
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
 	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;

		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 3; j++)
				sb.append(st.nextToken());
		}
		
		System.out.println(BFS(sb.toString()));
	}
	
	public static int BFS(String start) {
		Queue<String> queue = new LinkedList<>();

		queue.add(start);
		map.put(start, 0);
		
		while(!queue.isEmpty()) {
			String v = queue.poll();
			int zeroIdx = v.indexOf('0'); //빈 칸이 어딘지 찾기 
			int numOfSearch = map.get(v); //지금까지의 탐색 횟수
			
			//정답 스트링과 v가 동일하면 종료 or 큐에 정답 스트링이 존재한다면(contains) 종료 
			if(v.equals(answer))
				return numOfSearch;
						
			//일차원 배열의 인덱스에 연산을 가해서 2차원 배열(3*3)처럼 나타내는 방법이 있다.
			int x = zeroIdx / 3;
			int y = zeroIdx % 3;
			
			for(int i = 0; i < dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				//만약 범위를 넘겼다면 다음 변량으로 컨티뉴
				if(nx >= 3 || nx < 0 || ny >= 3 || ny < 0)
					continue;
				
				//인접 정점과 0의 칸을 서로 바꾼다. 
				int idx = (nx * 3) + ny; //인접 정점의 일차원 인덱스 
				char newChar = v.charAt(idx);
				
				String nextStr = v.replace(newChar, '9'); //'9'는 temp
				nextStr = nextStr.replace('0', newChar);
				nextStr = nextStr.replace('9', '0');

				//큐에 바뀐 스트링을 담음 ==> 맵에도 담으면서 Value를 +1 증가시켜줌.
				if(!map.containsKey(nextStr)) {
					queue.add(nextStr);
					map.put(nextStr, numOfSearch + 1);
				}
			}
		}
		return -1;
	}

}
