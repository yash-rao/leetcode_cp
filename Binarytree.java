import java.util.*;

public class Binarytree {

	static Scanner sc = null;
	static int maxx,minn;
	public static void main (String a[]) {
		sc = new Scanner(System.in);
		Node root = createTree();
		System.out.print("Preorder Traversal : ");
		preorderTraversal(root);
		System.out.print("\nInorder Traversal : ");
		inorderTraversal(root);
		System.out.print("\nPostorder Traversal : ");
		postorderTraversal(root);

		System.out.println("\nHeight of Tree: "+height(root));
		System.out.println("Size of Tree: "+size(root));
		System.out.println("Maximum in Binary Tree: "+binMax(root));
		System.out.println("Minimum in Binary Tree: "+binMin(root));
		
		System.out.println("Enter Level ");
		int level = sc.nextInt();
		printLevel(root,level);
		System.out.println("Level Order Traversal\n");
		levelOrderTraversal(root);
		printView(root);
	}
	
	static Node createTree() {
		Node root=null;
		
		System.out.println("Enter Data : ");
		int data = sc.nextInt();
		if (data == -1) return null;
		
		root = new Node(data);
		System.out.println("Enter Data for left of "+data);
		root.left = createTree();
		
		System.out.println("Enter Data for right of "+data);
		root.right = createTree();
			
		return root;
	}

	//Preorder Traversal = NLR
	//Inorder Traversal  = LNR
	//POstorder Traversal= LRN
	
	static void preorderTraversal(Node root){
		if (root==null){
			return ;
		}
		
		System.out.print(root.data+" ");
		preorderTraversal(root.left);
		preorderTraversal(root.right);
	}

	static void inorderTraversal(Node root){
		if (root==null){
			return ;
		}
		
		inorderTraversal(root.left);
		System.out.print(root.data+" ");
		inorderTraversal(root.right);
	}

	static void postorderTraversal(Node root){
		if (root==null){
			return ;
		}
		
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		System.out.print(root.data+" ");
	}

	static int height(Node root){
		if (root == null) {
			return 0;
		}
		
		return Math.max(height(root.left),height(root.right))+1;
	}

	static int size(Node root) {
		if(root==null) {
			return 0;
		}

		return size(root.left)+size(root.right)+1;
	}
	
	static int binMax(Node root) {
		if (root==null){
		return Integer.MIN_VALUE;
		}

		int l_r=Math.max(binMax(root.left),binMax(root.right));	
		maxx=Math.max(root.data,l_r);
		
		return maxx;
	}
	
	static int binMin(Node root) {
		if (root==null){
		return Integer.MAX_VALUE;
		}

		int l_r=Math.min(binMin(root.left),binMin(root.right));
		minn=Math.min(root.data,l_r);
		
		return minn;
	}

	static void printLevel(Node root,int level){
		if(root==null){return;}
		
		if (level==1) {
			System.out.println(root.data);
		}
		else if(level>1){
			printLevel(root.left,level-1);
			printLevel(root.right,level-1);
		}
	}

	static void levelOrderTraversal (Node root) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		q.add(null);
		int level = 1;
		
		while (!q.isEmpty()){
			Node temp = q.poll();
			
			if (temp == null) {
				if(q.isEmpty()){
					return;
				}
			q.add(null);
			System.out.println();
			}
			else{
			System.out.print(temp.data);

			if (temp.left!=null){
				q.add(temp.left);
			}
			if (temp.right!=null){
				q.add(temp.right);
			}
			}
		}
	}
	
	static void leftView(Node root, ArrayList<Node> temp, int []maxLevel, int level){
		if(root==null) {
			return;
		}
		if (level>maxLevel[0]) {
			temp.add(root);
			maxLevel[0]=level;
		}
		leftView(root.left,temp,maxLevel,level+1);
		leftView(root.right,temp,maxLevel,level+1);
	}

	static void rightView(Node root, ArrayList<Node> temp, int []maxLevel, int level) {
		if(root==null) {
			return;
		}
		if (level>maxLevel[0]) {
			temp.add(root);
			maxLevel[0]=level;
		}
		rightView(root.right,temp,maxLevel,level+1);
		rightView(root.left,temp,maxLevel,level+1);
	}

	static void printView(Node root) {
		ArrayList<Node> leftView = new ArrayList<Node>();
		int[] maxLevel = new int[] {-1};
		leftView(root,leftView,maxLevel,0);
		System.out.println("Left View");
		for (Node cur:leftView) {
			System.out.print(cur.data+" ");
		}
		int[] maxLevel2 = new int[]{-1};
		ArrayList<Node> rightView = new ArrayList<Node>();
		rightView(root,rightView,maxLevel2,0);
		System.out.println(" \nRight View");
		for (Node cur:rightView) {
			System.out.print(cur.data+" ");
		}
	}
}

class Node {
	int data;
	Node left, right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}
