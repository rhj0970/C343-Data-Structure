package lab6;
import java.util.*;


class Node <E> {

		private Node<E> left;
		private Node<E> right;
		private E data;
		
		Node(E data) {
			this.data = data;
			left = null;
			right = null;
		}

		void setData(E d) {
			data = d;
		}

		E getData() {
			return data;
		}

		void setLeft(Node<E> i) {
			left = i;
		}

		void setRight(Node<E> i) {
			right = i;
		}

		Boolean hasLeft() {
			return left != null;
		}
		
		Node<E> getLeft() {
			return left;
		}

		Boolean hasRight() {
			return right != null;
		}
		Node<E> getRight() {
			return right;
		}


	}
	
	
class AVL <E extends Comparable<?super E>> {
////////////////////////////////////////// height and balance implementation /////////////////////////////////////////////
		 int get_height(Node<E> n) {
			if (n == null) {
			return -1;
			}
			
			if (n.getLeft() == null && n.getRight() == null) {
				return 0;
			}
			
			//System.out.print("Current data: "+ n.getData());
			int leftheight = 1 + get_height(n.getLeft());
			int rightheight = 1 + get_height(n.getRight());

			
			// The height of a node is equal to the maximum of the height of its two children + 1
			int height = (Math.max(leftheight, rightheight));
			//System.out.println("height: "+height);
			return height;
		}
	
		int getBalance(Node<E> n) { // For a tree to be balanced, the difference in height between its children has to be <= 1 AND its children must be balanced.
			if (n == null) { // if the node is null
			return 0;
			}
			return get_height(n.getLeft()) - get_height(n.getRight());

		}
////////////////////////////////// height and balance implementation end//////////////////////////////////////////////////

		
		private Node<E> root;
		BST() {
			root = null;
		}
		Node<E> getRoot() { 

			return root; 
		}
		
		
		void inOrder() {
			System.out.print("in-order: ");
			inOrder(root);
			System.out.println();
		}
		void inOrder(Node<E>root) {
			if(root == null) return;
			inOrder(root.getLeft());
			System.out.print(root.getData() + " ");
			inOrder(root.getRight());
		}
		void preOrder() {
			System.out.print("pre-order: ");
			preOrder(root);
			System.out.println();
		}
		void preOrder(Node<E>root) {
			if(root == null) return;
			System.out.print(root.getData() + " ");
			if(root.hasLeft()) preOrder(root.getLeft());
			if(root.hasRight()) preOrder(root.getRight());
		}
		void insert(E data) {
			root = insert(root, data);
		}

		
		Node<E> insert(Node<E> root, E data) {
			
			if (root == null) {
				return new Node<E>(data);
			} else {
				Node<E> cur;
				if (root.getData().compareTo(data) > 0) {
					cur = insert(root.getLeft(), data);
					root.setLeft(cur);
					
				} else {
					cur = insert(root.getRight(), data);
					root.setRight(cur);
				}
		
////////////////////////////////////////////// implementation /////////////////////////////////////////////////////////////////////////
				int bal = getBalance(root);
				
				/// example root 
				/*
			     r
                 /   \
               x     s
             /   \
           y     z
                /   \
              c1  c2
              */
				
				// balance bigger than 1 and if the input is is smaller than the data 
				if (bal >1) {//LR
					if (getBalance(root.getLeft()) <0) { // left right case 
					// rotate left sub tree to the left
						// lets assume r is the root
						Node<E> original = root.getLeft(); // x
						Node<E> newRoot = root.getLeft().getRight(); // z
						Node<E> originalSub = original.getLeft(); // y
						root.setLeft(newRoot); // the new root is now z
						original.setLeft(originalSub); // set y to z's children
						rotateRight(); // since left rotation is done now to right rotation
						
					}
					
					if (getBalance(root.getLeft()) > 0) { // left left case 
						rotateRight();

					}
					
				
				} // bal >1 if end
				
				if (bal <-1) {
					if (getBalance(root.getRight()) < 0) { // Right right case 
						Node<E> original = root.getLeft(); 
						Node<E> newRoot = root.getLeft().getRight();
						Node<E> originalSub = original.getLeft();
						root.setLeft(newRoot);
						original.setLeft(originalSub);
					}
					
					if (getBalance(root.getRight()) >0) { //right left case
						Node<E> original = root.getLeft(); 
						Node<E> newRoot = root.getLeft().getRight();
						Node<E> originalSub = original.getLeft();
						root.setLeft(newRoot);
						original.setLeft(originalSub);
					}
				}
				
				
				
				/*
				if (bal > 1 && data.compareTo(root.getData()) < 0) { // left left
					rotateRight(); // rotate right
				}
				
				if (bal <-1 && data.compareTo(root.getData()) > 0) { // right right
					rotateLeft();
				}
				
				if (bal >1 && data.compareTo(root.getData()) > 0) { // left right
					rotateRight();
				}
				
				if (bal <-1 && data.compareTo(root.getData()) < 0) { // right left 
					rotateLeft();
				}
		
				*/
///////////////////////////////////////////////////// implementation end////////////////////////////////////////////////////////////////	
				return root;

			}
		}
		
		//apply left rotate to the root node
		void rotateLeft() {
			Node<E> original = root.getLeft(); 
			Node<E> newRoot = root.getLeft().getRight();
			Node<E> originalSub = original.getLeft();
			root.setLeft(newRoot);
			original.setLeft(originalSub);
			}
			

		//apply right rotate to the root node
		void rotateRight() {
			Node<E> original = root.getLeft(); 
			root.setLeft(original.getRight());	
			original.setRight(root);
			
		}
		
	}
	

	public class AVLTree {
		public static void main(String[] argv) {
			int n; // integer value
			String str; // string value 
			Scanner in = new Scanner(System.in);
			n = in.nextInt();		
			str = in.next();
			
			if (str.equals("string")) {
				BST<String> tree = new BST<String>();
				for (int j=0; j<n; j++) {
					tree.insert(in.next());
				}
				System.out.println("root= " +" " + tree.getRoot().getData() + "height= " + tree.get_height(tree.getRoot()) +" " + "heightfactor: " + tree.getBalance(tree.getRoot())); // tree.getRoot
			}
			
			else {
			BST<Integer> tree = new BST<Integer>();
			for(int i = 0; i < n; i ++) {
				tree.insert(in.nextInt());
			}
			System.out.println("root= " +" " + tree.getRoot().getData() + "height= " + tree.get_height(tree.getRoot()) +" " + "heightfactor: " + tree.getBalance(tree.getRoot())); // tree.getRoot
			}
			in.close();
			//if BST is correctly built, items will be displayed in sorted order using
			//in-order traversal
			/*
			tree.inOrder();
			
			System.out.println("before rotation: ");
			tree.preOrder();
			
			System.out.println("after rotating left: ");
			tree.rotateLeft();
			tree.preOrder();	
			
			System.out.println("after rotating right: ");
			tree.rotateRight();
			tree.preOrder();
		*/
		}	
	}