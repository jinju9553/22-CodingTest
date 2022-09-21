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
		
		//1.�Է� ���ڿ� �б�
		int maxLen = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			words[i] = br.readLine();
			int len = words[i].length();
			maxLen = (len > maxLen) ? len : maxLen;
		}
		
		//2.matrix �ʱ�ȭ
		char[][] matrix = new char[N][maxLen];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < maxLen; j++)
				matrix[i][j] = 'x';
		}
		
		//3.���ڿ� �ڸ����� �°� matrix ä���ֱ� (2���� ��ĥ �� ����)
		for(int i = 0; i < N; i++) {
			int gap = maxLen - words[i].length();
			for(int j = words[i].length() - 1; j >= 0; j--) {
				matrix[i][j + gap] = words[i].charAt(j);
			}
		}
		
		//4.map�� �̿��� ���׽� ��� ���ϱ�
		for(int j = 0; j < maxLen; j++) { //���η� �� �پ� Ž��
			for(char c : map.keySet()) { //���� �ڸ����� �Ѿ ������ �ڸ� �ø� ����
				int n = map.get(c);
				map.put(c, n * 10);
			}
			
			for(int i = 0; i < N; i++) { //���� �� ���� �� ĭ�� 
				if(matrix[i][j] != 'x' && !map.containsKey(matrix[i][j])) { 
					//������� �ʰ�, map�� ���ٸ�
					map.put(matrix[i][j], 1);
				}
				else if(map.containsKey(matrix[i][j])) { //map�� �ִٸ�
					int n = map.get(matrix[i][j]);
					map.put(matrix[i][j], n + 1); //��� �߰�
				}
			}
		}
		
		//5.����� ���� ����(Comparator�� ���� ������ �� ����)
		Integer[] arr = new Integer[map.values().size()]; int idx = 0;
		for(int v : map.values())
			arr[idx++] = v;
		
		//6.�հ� ���
		int sum = 0;
		Arrays.sort(arr, Collections.reverseOrder());
		for(int i = 0; i < arr.length; i++)
			sum += arr[i] * numbers[i];
		
		System.out.println(sum);
	}
}