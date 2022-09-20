package N3972;

import java.io.*;
import java.util.*;

public class Q1339 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] words = new String[N];
		int[] numbers = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		Map<Character, Integer> map = new HashMap<>();
		
		int maxLen = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			words[i] = br.readLine();
			int len = words[i].length();
			maxLen = (len > maxLen) ? len : maxLen;
		}
		
		char[][] matrix = new char[N][maxLen];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < maxLen; j++)
				matrix[i][j] = 'x';
		}
		
		for(int i = 0; i < N; i++) {
			int gap = maxLen - words[i].length();
			for(int j = words[i].length() - 1; j >= 0; j--) {
				matrix[i][j + gap] = words[i].charAt(j);
			}
		}
		
		int numIdx = 0; int sum = 0;
		for(int j = 0; j < maxLen; j++) {
			sum *= 10;
			for(int i = 0; i < N; i++) {
				if(matrix[i][j] != 'x' && !map.containsKey(matrix[i][j])) { 
					//비어있지 않고, map에 없다면
					sum += numbers[numIdx];
					map.put(matrix[i][j], numbers[numIdx++]);
				}
				else if(map.containsKey(matrix[i][j])) {
					int n = map.get(matrix[i][j]);
					sum += n;
				}
			}
		}
		
		System.out.println(sum);
	}
}
