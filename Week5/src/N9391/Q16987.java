package N9391;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q16987 { //69% : 틀렸습니다 ==> 71% : 틀렸습니다 (네?) (등호를 빼셨더군요...)

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
		
		if(isBroken[start]) {//새로 집은 계란이 이미 깨져있다면?
			solution(eggs, start + 1, T); //다음 계란을 집는다.
			return; //깰 대상(j)과는 관계 없다. 재귀를 반환받고 아래의 for문으로 진출하면 안된다.
		}
		
		//남은 계란이 1개거나 0개라면?(더이상 깰 계란이 없다면)
		if(T - countBroken(T) < 2) { //바로 개수 세기로 넘어간다.
			solution(eggs, start + 1, T); 
			return; //재귀를 반환받고 아래의 for문으로 진출하면 안된다.
		}
		
		//위의 조건에서 걸러졌다면 이 for문으로 올 수 없다. (return문 없으면 여기로 새버림)
		//즉, 위의 조건에서 걸러지려면 이 for문 안으로 들어오면 안 된다.
		//start번째 계란으로 다른 계란을 모두 깨본다.(DFS) 
		for(int j = 0; j < T; j++) { //start로 깰 계란을 정하는 반복문. 매번 모든 item 중에서 탐색
			//자기 자신을 깰 순 없음 & 대상이 이미 깨졌으면 다음 대상(j)을 찾는다 
			if(j == start || isBroken[j])
				continue;
			
			//계란을 깬다.
			eggs[start].durability -= eggs[j].weight;
			eggs[j].durability -= eggs[start].weight;
				
			if(eggs[start].durability <= 0) isBroken[start] = true;
			if(eggs[j].durability <= 0) isBroken[j] = true;

			solution(eggs, start + 1, T); //다음 계란을 집는다.
			
			//여기서 싹 원복
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