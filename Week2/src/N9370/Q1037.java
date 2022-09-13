package N9370;

import java.util.ArrayList;
import java.util.Scanner;

public class Q1037 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {
			list.add(sc.nextInt());
		}
		
		int p = 0, q = 1;
		for(int i = 0; i < list.size() - 1; i++) { //p�� ������ �ε���(���� - 1)�� ����Ű�� ���� ����
			int rslt = list.get(p) * list.get(q);
			for (int j = 1; j < list.size(); j++) {
				if(j == q)
					continue;
				
				if(rslt % list.get(j) != 0) {
					//if() ����?������?�����ϱ⿡�� �ʹ� �����ѵ�
					p = p + 1;
					q = p + 1;
					break;
				}
			}
		}
		
		sc.close();
	}
}
