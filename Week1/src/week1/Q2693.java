package week1;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q2693 { //����: ���� �� Ŭ������ Main���� ������ ��

	public static void main(String[] args) {
		//1.�迭 T���� �Է¹ޱ�
		Scanner sc = new Scanner(System.in);
		int arraySize = 10; //���� ����: �迭�� ���� ����
		
		//����: ArrayList�� Array�� �ð��� �Ȱ��� 
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int T = sc.nextInt(); //���� ����
		for (int i = 0; i < T; i++) { 
			for (int j = 0; j < arraySize; j++) {
				list.add(sc.nextInt());
			}
			//2.�����ϱ�
			Collections.sort(list);
			
			//3.N��° ū ���� ã��
			System.out.println(list.get(7));
			list.clear();
		}
		sc.close();
	}
}
