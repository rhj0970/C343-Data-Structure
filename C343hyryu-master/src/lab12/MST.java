package lab12;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;

class Graph {
	int totalDist;
	private int totalVertex;
	//adjMatrix[u][v] = 1 if there is an edge from u to v, otherwise 0
	private int[][] adjMatrix;
	//adjWeight[u][v] -- the weight of the edge from u to v if there is one
	private int[][] adjWeight;
	//if a node is settled (e.g., processed in the Dijkstra's algorithm)
	private Boolean[] ifSettled;
	public Graph() { totalVertex = 0; }
	public int getTotalVertex() { return totalVertex; }
	//load graph from standard input
	public void loadAdjMatrix() {
		Scanner in = new Scanner(System.in);
		totalVertex = in.nextInt();
		adjMatrix = new int[totalVertex][totalVertex];
		adjWeight = new int[totalVertex][totalVertex];
		ifSettled = new Boolean[totalVertex];
		int i, j;
		for(i = 0; i < totalVertex; i ++) {
			ifSettled[i] = false;
			for(j = 0; j < totalVertex; j ++) {
				adjWeight[i][j] = in.nextInt();
				if (adjWeight[i][j] != -1) {
					adjMatrix[i][j] = 1;
				}
			}
		}
		in.close();
	}
	//return weight of the edge from u to v if there is one
	public int getWeight(int u, int v) {
		return adjWeight[u][v];
	}
	//return neighbors of u as a LinkedList
	public LinkedList<Integer> getNeighbors(int u) {
		LinkedList<Integer> tmp = new LinkedList<Integer>();
		for(int v = 0; v < totalVertex; v ++) {
			if(adjMatrix[u][v] == 1) tmp.add(v);
		}
		return tmp;
	}
	//return unsettled neighbors of u as a LinkedList
	public LinkedList<Integer> getUnsettledNeighbors(int u) {
		LinkedList<Integer> tmp = new LinkedList<Integer>();
		for(int v = 0; v < totalVertex; v ++) {
			if((adjMatrix[u][v] == 1) && (ifSettled[v] == false)) tmp.add(v);
		}
		return tmp;
	}
	//return the unsettled node that has the smallest dist
	public int getUnsettledNearest(int[] dist) {
		int md = Integer.MAX_VALUE;
		int mv = -1;
		int v;
		for(v = 0; v < totalVertex; v ++) {
			if((ifSettled[v] == false) && (dist[v] < md)) {
				md = dist[v];
				mv = v;
			}
		}
		return mv;
	}
	//implement the following	
	public int minimum(int s) {
		int[] dist = new int[totalVertex];
		LinkedList<Integer> unsettled = new LinkedList<Integer>();
		for(int i = 0; i < totalVertex; i++) {
			unsettled.add(i);
			dist[i] = Integer.MAX_VALUE;
			ifSettled[i] = false;
		}
		dist[0] = 0;
		
		while(!unsettled.isEmpty()) {
			Integer shortestNeighbor = getUnsettledNearest(dist);
			
			ifSettled[shortestNeighbor] = true;
			unsettled.remove(shortestNeighbor); 
			
			LinkedList<Integer> neigh = getUnsettledNeighbors(shortestNeighbor);
			Iterator<Integer> iter = neigh.iterator();
			
			while(iter.hasNext()){
				int current = iter.next();
				if(dist[current] > adjWeight[shortestNeighbor][current]) {
					dist[current] = adjWeight[shortestNeighbor][current];
				}
			}
			
		}
		for(int i = 0; i < dist.length; i++) {
			totalDist += dist[i];
		}
		
		return totalDist;
	}
}


public class MST {
	public static void main(String[] argv) {
		Graph g = new Graph();
		g.loadAdjMatrix();
		int dist = g.minimum(0);
		System.out.println(dist);
	}
}
