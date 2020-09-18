package lab1;

import java.util.Random;
import java.util.Scanner;

public class RandomDNA {

	
	public static void main (String args[]) {	
		String s = "";
		Random rnd = new Random();
		String[] array = new String[] {"A","T", "C", "G"};
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter number");
		int a = in.nextInt();
		
		for (int i=0; i<a; i++) {
			
			int t = rnd.nextInt(4);
			
				s = s + array[t];
		
			
		}
		System.out.println(s);
		
	}

}
