package homework9;

import java.util.Scanner;

public class Main {
	Scanner sc = new Scanner(System.in);

	public void profit() {
		int num = sc.nextInt();
		int[] store = new int[num];
		for (int i = 0; i < num; i++) {
			store[i] = sc.nextInt();
		}
		
		int min = store[0];
		int max = -Integer.MAX_VALUE;
		
		for (int i = 1; i < num; i++) {
			max = Math.max(max, store[i] - min);
			min = Math.min(min, store[i]);
		}
		System.out.println(max);
	}

	
	
	public static void main(String[] args) {
		new Main().profit();
	}
}