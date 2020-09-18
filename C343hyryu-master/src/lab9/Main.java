package lab9;
import java.util.Scanner;
import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String first;
		String second;
		int firstLen, secondLen;
		int [][] table;
		
		
			first = sc.next();
			second = sc.next();
			firstLen = first.length();
			secondLen = second.length();
			table = new int [firstLen+1][secondLen +1];
			
			for (int j=0; j<=firstLen; j++) {
				for (int k=0; k<=secondLen; k++) {
					if (j ==0) {
						table[0][k] = k;
						
					}
					
					else if (k ==0) {
						table[j][0] = j;
					}
					
					else if(first.charAt(j-1) == second.charAt(k-1)) {
						table[j][k] = table[j-1][k-1];
					}
					else {
						table[j][k] = Math.min(table[j-1][k-1], Math.min(table[j-1][k], table[j][k-1]) ) +1;
					}
					System.out.print(table[j][k]);
					System.out.print(' ');

				} // inner for end
				System.out.println();
				
			} // ounter for end
			
			System.out.println(table[firstLen][secondLen]);
	
		
		
	} // main
	

} //class end
