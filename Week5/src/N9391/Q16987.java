package N9391;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q16987 { //69% : Ʋ�Ƚ��ϴ� ==> 71% : Ʋ�Ƚ��ϴ� (��?) (��ȣ�� ���̴�����...)

	private static boolean[] isBroken;
	private static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		Egg[] eggs = new Egg[T];
		isBroken = new boolean[T];
		
		String[] temp;
		for(int i = 0; i < T; i++) {
			temp = br.readLine().split(" ");
			eggs[i] = new Egg(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
		}
		
		solution(eggs, 0, T);
		
		System.out.println(count);
	}
	
	public static int countBroken(int T) {
		int curr = 0;
		for(int i = 0; i < T; i++)
			if(isBroken[i]) curr++;
		
		return curr;
	}
	
	public static void solution(Egg[] eggs, int start, int T) {
		
		if(start == T) {
			int curr = countBroken(T);
			count = (curr > count) ? curr : count;

			return;
		}
		
		if(isBroken[start]) {//���� ���� ����� �̹� �����ִٸ�?
			solution(eggs, start + 1, T); //���� ����� ���´�.
			return; //�� ���(j)���� ���� ����. ��͸� ��ȯ�ް� �Ʒ��� for������ �����ϸ� �ȵȴ�.
		}
		
		//���� ����� 1���ų� 0�����?(���̻� �� ����� ���ٸ�)
		if(T - countBroken(T) < 2) { //�ٷ� ���� ����� �Ѿ��.
			solution(eggs, start + 1, T); 
			return; //��͸� ��ȯ�ް� �Ʒ��� for������ �����ϸ� �ȵȴ�.
		}
		
		//���� ���ǿ��� �ɷ����ٸ� �� for������ �� �� ����. (return�� ������ ����� ������)
		//��, ���� ���ǿ��� �ɷ������� �� for�� ������ ������ �� �ȴ�.
		//start��° ������� �ٸ� ����� ��� ������.(DFS) 
		for(int j = 0; j < T; j++) { //start�� �� ����� ���ϴ� �ݺ���. �Ź� ��� item �߿��� Ž��
			//�ڱ� �ڽ��� �� �� ���� & ����� �̹� �������� ���� ���(j)�� ã�´� 
			if(j == start || isBroken[j])
				continue;
			
			//����� ����.
			eggs[start].durability -= eggs[j].weight;
			eggs[j].durability -= eggs[start].weight;
				
			if(eggs[start].durability <= 0) isBroken[start] = true;
			if(eggs[j].durability <= 0) isBroken[j] = true;

			solution(eggs, start + 1, T); //���� ����� ���´�.
			
			//���⼭ �� ����
			eggs[start].durability += eggs[j].weight;
			eggs[j].durability += eggs[start].weight;
			
			if(eggs[start].durability > 0) isBroken[start] = false;
			if(eggs[j].durability > 0) isBroken[j] = false;
		}
	}
	
	static class Egg {
		
		int durability;
		int weight;
		
		public Egg(int durability, int weight) {
			this.durability = durability;
			this.weight = weight;
		}
		
		public void setDurability(int durability) {
			this.durability = durability;
		}
		
		public void setWeight(int weight) {
			this.weight = weight;
		}
		
		public int getDurability() { return durability; }
		
		public int getWeight() { return weight; }
	}
}