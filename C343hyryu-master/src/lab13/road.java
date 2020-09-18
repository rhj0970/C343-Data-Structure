package lab13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


	public class road {
	    private static List<List<Integer>> adjacent;
	    private static boolean[] visited;
	    private static int count;

	    public static void main(String[] args) {      
	        Scanner sc = new Scanner(System.in);
	        int query = sc.nextInt();
	        for(int i = 0; i < query; i++){
	            int n = sc.nextInt();
	            
	            adjacent = new ArrayList<>();
	            for (int j = 0; j < n; j++) {
	            	adjacent.add(new ArrayList<>());
	            }
	            visited = new boolean[n];
	            
	            int m = sc.nextInt();
	            int x = sc.nextInt();
	            int y = sc.nextInt();
	            for(int a1 = 0; a1 < m; a1++){
	                int citryFirst = sc.nextInt();
	                int citySecond = sc.nextInt();
	                adjacent.get(citryFirst - 1).add(citySecond - 1);
	                adjacent.get(citySecond - 1).add(citryFirst - 1);
	            }
	            
	            System.out.println(road(x, y));
	        }
	        
	        sc.close();
	    }
	    
	    private static long road(int x, int y) {
	        long cost = 0;
	        
	        for (int k = 0; k < adjacent.size(); k++) {
	            if (!visited[k]) {
	                count = 0;
	                dfs(k);
	                if (x > y) {
	                    cost += x + y * (count - 1);
	                } 
	                
	                else {
	                    cost += x * count;
	                }
	            }
	        }
	        
	        return cost;
	    }
	    
	    private static void dfs(int i) {
	        visited[i] = true;
	        count++;
	        
	        List<Integer> list = adjacent.get(i);
	        for (int j = 0; j < list.size(); j++) {
	            if (!visited[list.get(j)]) {
	                dfs(list.get(j));
	            }
	        }
	    }
	}
