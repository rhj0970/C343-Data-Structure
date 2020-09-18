package homework11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class NearestNode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		Node[] nodes = new Node[num + 1];
		for (int i = 1; i < nodes.length; i++) {
			nodes[i] = new Node();
		}
		int m = sc.nextInt();
		for (int j = 0; j < m; j++) {
			int vertex1 = sc.nextInt();
			int vertex2 = sc.nextInt();

			if (vertex1 >= nodes.length || vertex2 >= nodes.length) {
				System.out.println(-1);

				sc.close();
				return;
			}

			nodes[vertex1].nearest.add(vertex2);
			nodes[vertex2].nearest.add(vertex1);
		}
		for (int i = 1; i < nodes.length; i++) {
			nodes[i].color = sc.nextInt();
		}
		int color = sc.nextInt();

		System.out.println(method(nodes, color));

		sc.close();
	}

	static int method(Node[] nodes, int color) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i < nodes.length; i++) {
			if (nodes[i].color == color) {
				nodes[i].source = i;
				nodes[i].distance = 0;

				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int head = queue.poll();

			for (int k : nodes[head].nearest) {
				if (nodes[k].source != nodes[head].source) {
					if (nodes[k].source > 0) {
						return nodes[k].distance + nodes[head].distance + 1;
					} 
					
					else {
						nodes[k].source = nodes[head].source;
						nodes[k].distance = nodes[head].distance + 1;

						queue.offer(k);
					}
				}
			}
		}

		return -1;
	}
}

class Node {
	List<Integer> nearest = new ArrayList<>();
	int color;
	int source = -1;
	int distance = -1;
}