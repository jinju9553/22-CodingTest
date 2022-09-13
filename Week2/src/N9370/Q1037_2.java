package N9370;

import java.util.Scanner;

public class Q1037_2 {

	public static void main(String[] args) {
		//����: Scanner���� BufferedReader�� �� ������
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		//Ư¡: ��� ����� �־����� ��, p * q���� ��� �� �μ� p�� ���� ���� ����� q�� ���� ū ���̴�.
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < T; i++) {
			int nextNum = sc.nextInt();
			if(nextNum > max) max = nextNum;
			if(nextNum < min) min = nextNum;
		}
		
		System.out.print(max * min);
		
		sc.close();
	}

}
