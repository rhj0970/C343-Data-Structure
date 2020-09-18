package lab10;

import java.util.*;

public class DFS {
	
	public static int[][] table;
	public static int[] depth;
	public static int[] first;
	public static int time =1;
	
	public static void dfs(int v) {
		depth[v] = time;
		time++;
		int j =0;
		while (table[v][j] != 0) {
			if (depth[table[v][j]] ==0) {
				dfs(table[v][j]);
				
			}
			j++;
		}
		first[v] = time;
		time++;
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		table = new int [input+1][100];
		depth = new int [input+1];
		first = new int [input +1];
		
		for (int i=1; i<=input; i++) {
			
			int u = sc.nextInt();
			int k = sc.nextInt();
			for (int j=0; j< k; j++) {
				int v = sc.nextInt();
				table[u][j] = v;
				
				
			}
		}
		for (int k=1; k<= input; k++) {
			
			if (depth[k]==0) {
				dfs(k);
				
			}
		}
		for (int l=1; l<=input; l++) {
			
			System.out.println(l+ " " + depth[l] + " " + first[l]);
		}
		
		
	}

}
