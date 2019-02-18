package tree;

public class TreeTraversal {
	
	Node root;

	public void Inorder(Node root){
		if(root == null)
			return;
		Inorder(root.left);
		System.out.print(root.data + "\t");
		Inorder(root.right);		
	}
	
	public void Preorder(Node root){
		if(root == null)
			return;
		System.out.print(root.data + "\t");
		Preorder(root.left);
		Preorder(root.right);		
	}
	
	public void Postorder(Node root){
		if(root == null)
			return;
		
		Postorder(root.left);
		Postorder(root.right);
		System.out.print(root.data + "\t");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeTraversal tree = new TreeTraversal();
		tree.root = new Node(4);
		tree.root.left = new Node(2);
		tree.root.right = new Node(6);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(3);
		tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(7);
				
		
		System.out.print("Inorder: "); 
		tree.Inorder(tree.root);

		System.out.print("Preorder: "); 
		tree.Preorder(tree.root);
		
		System.out.print("Postorder: "); 
		tree.Postorder(tree.root);
	}

}
