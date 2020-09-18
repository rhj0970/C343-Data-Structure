package lab10;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;

class Graph {
	private int totalVertex;
	private LinkedList<LinkedList<Integer>> adjList;
	//adjacency list of edges
	public Graph() { totalVertex = 0; }
	public void loadAdjList() {
		Scanner in = new Scanner(System.in);
		totalVertex = in.nextInt();
		adjList = new LinkedList<LinkedList<Integer>>();
		for(int i = 0; i < totalVertex; i ++) {
			LinkedList<Integer> tmp = new LinkedList<Integer>();
			int idx1 = in.nextInt() - 1;
			int degree = in.nextInt();
			//System.out.println("mark idx1 = " + idx1 + " degree = " + degree);
			for(int j = 0; j < degree; j ++) {
				int idx2 = in.nextInt() - 1;
				tmp.add(idx2);
			}	
			adjList.add(tmp);
		}
		in.close();
	}
	public void printAdjMatrix() {
		Integer[][] adjMatrix = new Integer[totalVertex][totalVertex];
		
		int adjLen = adjMatrix.length;
		int adjLenSecond = adjMatrix[0].length;
		for(int i = 0; i < adjLen; i++) {
			for(int j = 0; j < adjLenSecond; j++) {
				adjMatrix[i][j] = 0;
			}
		}
		int flag = 0;
		for( LinkedList<Integer> vertex : adjList) {
			
				if(!vertex.isEmpty()) {
					for(int edge : vertex) {
						adjMatrix[flag][edge] = 1;
					}
				}
				flag++;
		}
		for ( int i = 0; i < totalVertex; i++) {
			String ab = ""; 
			for(int j = 0; j < totalVertex; j++) {
				ab += adjMatrix[i][j];
				if (j < totalVertex - 1) {
					ab += " ";
				}
			}
			System.out.println(ab);
		}
	}
		//complete the following
	}


//change class name GraphRepresentation to Main() for submission to AIZU
public class Main {
	public static void main(String argv[]) {
		Graph g = new Graph();
		g.loadAdjList();
		g.printAdjMatrix();
	}
}