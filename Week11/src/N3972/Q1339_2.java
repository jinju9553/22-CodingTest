package N3972;

import java.io.*;
import java.util.*;

public class Q1339_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] words = new String[N];
		int[] numbers = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		Map<Character, Integer> map = new HashMap<>();
		
		//1.입력 문자열 읽기
		int maxLen = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			words[i] = br.readLine();
			int len = words[i].length();
			maxLen = (len > maxLen) ? len : maxLen;
		}
		
		//2.matrix 초기화
		char[][] matrix = new char[N][maxLen];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < maxLen; j++)
				matrix[i][j] = 'x';
		}
		
		//3.문자열 자릿수에 맞게 matrix 채워넣기 (2번과 합칠 수 있음)
		for(int i = 0; i < N; i++) {
			int gap = maxLen - words[i].length();
			for(int j = words[i].length() - 1; j >= 0; j--) {
				matrix[i][j + gap] = words[i].charAt(j);
			}
		}
		
		//4.map을 이용해 다항식 계수 구하기
		for(int j = 0; j < maxLen; j++) { //세로로 한 줄씩 탐색
			for(char c : map.keySet()) { //다음 자릿수로 넘어갈 때마다 자리 올림 수행
				int n = map.get(c);
				map.put(c, n * 10);
			}
			
			for(int i = 0; i < N; i++) { //세로 한 줄의 한 칸씩 
				if(matrix[i][j] != 'x' && !map.containsKey(matrix[i][j])) { 
					//비어있지 않고, map에 없다면
					map.put(matrix[i][j], 1);
				}
				else if(map.containsKey(matrix[i][j])) { //map에 있다면
					int n = map.get(matrix[i][j]);
					map.put(matrix[i][j], n + 1); //계수 추가
				}
			}
		}
		
		//5.계수만 따로 빼기(Comparator를 따로 구현할 수 없음)
		Integer[] arr = new Integer[map.values().size()]; int idx = 0;
		for(int v : map.values())
			arr[idx++] = v;
		
		//6.합계 출력
		int sum = 0;
		Arrays.sort(arr, Collections.reverseOrder());
		for(int i = 0; i < arr.length; i++)
			sum += arr[i] * numbers[i];
		
		System.out.println(sum);
	}
}