package lab3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RoundRobin {
	Queue<Integer> time = new LinkedList<Integer>();
	Queue<String> name = new LinkedList<String>();
	
	Scanner sc = new Scanner(System.in);
	
	
	
	
	public void check() {

		int input = sc.nextInt();
		int quantum = sc.nextInt();
		int timestamp = 0;
		sc.nextLine();
		String p = "";
		int t = 0;
		for (int i =0; i< input; i++) { //////  p1 = p,    500 = t
		  p = sc.next();
		  name.add(p);
		  t = sc.nextInt();
		  time.add(t);

		}
		
		while(!name.isEmpty()) {
			String a = name.poll();
			int ti = time.poll();
			if( ti <= quantum) {
				timestamp += ti;
				System.out.println(a + " " + timestamp);
			
				
			}
			else {
				ti = ti - quantum;
				name.add(a);
				time.add(ti);
				timestamp += quantum;
			}
			
		}
		

	}
	
	

	
	
	
	public static void main(String[] args) {
		
		
	}
	}
	


