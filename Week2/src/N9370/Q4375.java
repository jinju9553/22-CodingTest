package N9370;

import java.util.Scanner;

public class Q4375 { //�ð��ʰ�, 9901���� �����÷ο� 
	//@: ū ���� ������ �����鼭 ���� ���� ����� ������ ������. (��...)
	//@: 1�� ������ ���� �´��� �Ǻ��ϴ� �� �ƴ϶�, 1�� ������� ���� operand�� �������� ���� �Ǻ�

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int operand; int flag = 0; 
		while(sc.hasNext()) { //�Է¹��� ��� ���� ó���ϱ� ����
			operand = sc.nextInt();
			int multiplier = 1;
			while(flag == 0) { //�Է¹��� �� ���� ����� ã�´�
				if(multiplier % 2 == 0 || multiplier % 5 == 0) {
					multiplier++;
					continue;
				}
				
				int rslt = isAllOne(operand * multiplier);			
				if(rslt == -1) {
					multiplier++;
					continue;
				}
				else {
					//System.out.println(operand * multiplier);
					System.out.println(rslt);
					break;
				}
			}
		}
		
		sc.close();
	}
	
	public static int isAllOne(int num) {
		
		int rslt = 0;
		
		while(true) {			
			if(num == 1) {
				rslt++;
				return rslt;
			}
			else if (num % 10 == 1) {
				num = num / 10;
				rslt++;
				continue;
			}
			else
				return -1;
		}
	}
}
