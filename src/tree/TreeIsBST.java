package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TreeIsBST {

	 static void inOrder(Node root,List<Node> list,HashMap<Integer,Integer> map){
	        if(root == null)
	            return;
	        inOrder(root.left,list,map);
	        list.add(root);
	        if(map.containsKey((Integer)root.data)){
	            Integer temp  = (Integer)root.data;
	            map.put(temp,map.get(temp)+1);
	        }else{
	            Integer temp  = (Integer)root.data;
	            map.put(temp,1);
	        }
	        inOrder(root.right,list,map);
	    }
	    static boolean checkBST(Node root) {
	        boolean isBST = true;
	        List<Node> inOrderList = new ArrayList<Node>();
	        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	        inOrder(root,inOrderList,map);
	        for(Map.Entry m: map.entrySet()){
	            Integer temp = (Integer)m.getValue();
	            if(temp.intValue()>1)
	                isBST = false;
	        }
	        int prev = 0;
	        for(Node n: inOrderList){
	            if(n.data < prev)
	                isBST = false;
	            else
	                prev = n.data;
	        }
	        /*System.out.print(map);
	        for(Node n: inOrderList)
	            System.out.print(n.data+ "\t");
	        */
	        return isBST;
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
	/**
	 * @param args
	 */
	/*Input 1
	 * 7
	 * 1 2 3 4 5 6 7
	 * 
	 * Input 2
	 * 7
	 * 1 2 4 3 5 6 7
	 */
	public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
	        int t = scan.nextInt();
	        Node root = null;
	        while(t-- > 0) {
	            int data = scan.nextInt();
	            root = insert(root, data);
	        }
	        scan.close();
	        boolean ans = checkBST(root);
	        if(ans)
	        	System.out.println("YES");
	        else
	        	System.out.println("NO");
	    }	

	}
