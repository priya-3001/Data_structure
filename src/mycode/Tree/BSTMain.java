package mycode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BSTMain {
public static void main(String[] arg0s) {
	
	BinarySearchTree bst = new BinarySearchTree();
	bst.insert(70);
	bst.insert(50);
	bst.insert(90);
	bst.insert(30);
	bst.insert(60);
	bst.insert(80);
	bst.insert(85);
	bst.insert(100);
	bst.insert(20);
	bst.insert(40);
	bst.insert(10);
	
	System.out.print("BST " );
	bst.levelOrder2(bst.root);
	/*System.out.println( );
	bst.deleteNode(bst.root, 70);
	bst.levelOrder(bst.root);
	System.out.println( );*/
	
	/*System.out.println("BST preorder s" );
	bst.preOrder(bst.root);
	
	System.out.println("BST inorder " );
	bst.inOrder(bst.root);
	
	System.out.println("BST postsorder " );
	bst.postOrder(bst.root);
	
	bst.search(bst.root, 69);*/
	
	String bu = "cards";
	Integer ver = 55;
	
	List<String> ques = new ArrayList<>();
	
	if(bu == "cards" && ver >=55) {
		
	}
	else {
		ques.add("abc");
	}
	
	
}
}
