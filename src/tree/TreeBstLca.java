package tree;

import java.util.Scanner;


public class TreeBstLca {

	
    public static Node lca(Node root, int v1, int v2) {
      	// Write your code here.
        Node lca=null;
        if(root.left==null && root.right==null)
            return root;
        int first = 0, second=0;
        if(v1 < v2){
            first = v1;
            second = v2;
        }else if(v1 > v2){
            first = v2;
            second = v1;
        }
        if(first<=root.data && second>=root.data)
            return root;
        
        if(first > root.data && second > root.data){
            lca = lca(root.right,first,second);
        }else if(first < root.data && second < root.data){
            lca = lca(root.left,first,second);
        }
        return lca;

    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

	/*
	 * Sample input
	 * 6
	 * 4 2 3 1 7 6
	 * 1 7
	 */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        int v1 = scan.nextInt();
      	int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }	
}
