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
		

/*
		public String toString() {
			return (left != null ? left.data.toString() : ("" + -1)) + ", " + data + ", " + (right != null ? right.data.toString() : ("" + -2));
		}*/
	}
	
	
	class BST <E extends Comparable<?super E>> {
		
	
		int maxDepth(Node<E> node)  
	    { 
	        if (node == null) {
	            return 0; 
	        }
	        
	        else if (node.getLeft() == null && node.getRight() == null) {
				return 1;
			}
	        else 
	        { 
	            /* compute the depth of each subtree */
	            int lDepth = maxDepth(node.getLeft()); 
	            int rDepth = maxDepth(node.getRight()); 
	   
	            /* use the larger one */
	            if (lDepth > rDepth) 
	                return (lDepth + 1); 
	             else 
	                return (rDepth + 1); 
	        } 
	    }
		
////////////////////////////////////////// height and balance implementation /////////////////////////////////////////////
		
		
		/*
		 int get_height(Node<E> n) {
			if (n == null) {
				return 0;
			}
			
			if (n.getLeft() == null && n.getRight() == null) {
				return 1;
			}

			int leftheight =  get_height(n.getLeft());
			int rightheight =  get_height(n.getRight());
			// The height of a node is equal to the maximum of the height of its two children + 1
			int height = (Math.max(leftheight, rightheight) +1);
			return height;
		}
		*/
	
		int getBalance(Node<E> n) { // For a tree to be balanced, the difference in height between its children has to be <= 1 AND its children must be balanced.
			if (n == null) { // if the node is null
			return 0;
			}
			
			
			return maxDepth(n.getLeft()) - maxDepth(n.getRight());

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

				// balance bigger than 1 and if the input is is smaller than the data 
				 if (bal ==2) {//LR
					if (getBalance(root.getLeft()) ==-1) { // left right case 

					// rotate left sub tree to the left
						Node<E> original = root.getLeft(); 
						//Node<E> rootChild = root.getRight();
						Node<E> sub = original.getRight();
						Node<E> subLeftChild = sub.getLeft();						
						//Node<E> subRightChild = sub.getLeft();
						
						original.setRight(subLeftChild);
						sub.setLeft(original);
						root.setLeft(sub);
	
					}

						//System.out.println("left left");
						Node<E> original = root.getLeft(); 
						root.setLeft(original.getRight());	
						original.setRight(root);
						root = original;

				} // bal >1 if end
				
				 else if (bal ==-2) {
					if (getBalance(root.getRight()) ==1) {
						 //right left case
					//	System.out.println("right left");
						Node<E> original = root.getRight(); 
						Node<E> sub = original.getLeft();
						Node<E> subChild = sub.getRight();
					
						original.setLeft(subChild);
						sub.setRight(original);
						root.setRight(sub);	

					}

						//System.out.println("right right");
						Node<E> original = root.getRight(); 
						root.setRight(original.getLeft());	
						original.setLeft(root);
						root = original;


				}

///////////////////////////////////////////////////// implementation end////////////////////////////////////////////////////////////////	
				return root;

			}
		}
		
		//apply left rotate to the root node
		void rotateLeft() {
			System.out.println(root.getData());
			Node<E> original = root.getRight(); 
			root.setRight(original.getLeft());	
			original.setLeft(root);
			root = original;
			}
			

		//apply right rotate to the root node
		void rotateRight() {
			Node<E> original = root.getLeft(); 
			root.setLeft(original.getRight());	
			original.setRight(root);
			root = original;
			
		}
		
	}
	

	public class RotationMain {
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
				System.out.println("root="  + tree.getRoot().getData() + " " + "height=" + tree.maxDepth(tree.getRoot()) +" " + "heightfactor=" + tree.getBalance(tree.getRoot())); // tree.getRoot
			}
			
			else if (str.equals("int")) {
				BST<Integer> tree = new BST<Integer>();
				for(int i = 0; i < n; i ++) {
					int n2 = in.nextInt();
					tree.insert(n2);
				}
				System.out.println("root="  + tree.getRoot().getData() +" "+ "height=" + tree.maxDepth(tree.getRoot()) +" " + "heightfactor=" + tree.getBalance(tree.getRoot())); // tree.getRoot
				}
				in.close();

		}	
	}