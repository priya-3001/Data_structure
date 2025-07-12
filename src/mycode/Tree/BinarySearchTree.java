package mycode.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinarySearchTree {
	
	BinaryNode root;
	
	public BinarySearchTree() {
		root =null;
	}
	
	private BinaryNode insert(BinaryNode curr, int value) {
		if (curr == null)
		{
			BinaryNode newNode = new BinaryNode();
			newNode.bstvalue = value;
			System.out.println("Node inserted successfully");
			return newNode;
		}
		else if(value <= curr.bstvalue) {
			curr.left = insert(curr.left, value);
			return curr;
		}
		else {
			curr.right = insert(curr.right, value);
			return curr;
		}
	}
	
	public void insert(int value) {
		root = insert(root,value);
	}
	
	public void levelOrder(BinaryNode root) {
		Queue<BinaryNode> queue = new LinkedList<>();
		if(root == null)
			return;
		queue.add(root);
		BinaryNode curr = null;
		while(!queue.isEmpty()) {
			 curr = queue.remove();
			 System.out.print(curr.bstvalue + " ");
			if(curr.left !=null) {
				queue.add(curr.left);
			}
			if(curr.right != null) {
				queue.add(curr.right);
			}
			
		}
		
	}
	
	  public List<List<Integer>> levelOrder2(BinaryNode root) {
		List<List<Integer>> lists = new LinkedList<>();
		Queue<BinaryNode> queue = new LinkedList<>();
		if(root == null)
			return lists;
		queue.add(root);
		BinaryNode curr = null;
		
		while(!queue.isEmpty()) {
			List<Integer> list = new LinkedList<>();
			int levelSize = queue.size();
			for(int i=0;i<levelSize;i++)
			{
				curr = queue.poll();
				list.add(curr.bstvalue);
			
			if(curr.left !=null) {
				queue.add(curr.left);
			}
			if(curr.right != null) {
				queue.add(curr.right);
			}
			
			}
			lists.add(list);
			
		}
		return lists;
	}
	
	public void preOrder(BinaryNode node) {
		if(node == null) return;
		System.out.print(node.bstvalue +" ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public void postOrder(BinaryNode node) {
		if(node == null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.bstvalue +" ");
		
	}
	
	public void inOrder(BinaryNode node) {
		if(node == null) return;
		inOrder(node.left);
		System.out.print(node.bstvalue +" ");
		inOrder(node.right);
	}
	
	public BinaryNode search(BinaryNode node, int value)
	{
		if(node == null) {System.out.println("Not Found");return null;}
		else if (value == node.bstvalue) {
			System.out.println("Found");
			return node;
		}
		else if (value < node.bstvalue) {
			return search(node.left, value);
		}
		else if (value > node.bstvalue) {
			return search(node.right, value);
		}
		return null;
	}
	
	public BinaryNode minNode(BinaryNode root) {
		if(root.left == null) return root;
		
		return minNode(root.left);
	}
	
	public BinaryNode deleteNode(BinaryNode root, int value) {
		if(root == null) {
			System.out.println("Not found");return null;
		}
		
		if(value > root.bstvalue) {
			root.right = deleteNode(root.right,value);
		}
		else if(value < root.bstvalue) {
			root.left = deleteNode(root.left,value);
		}
		else {
			if(root.right !=null && root.left !=null) {
				BinaryNode temp = root;
				BinaryNode minNode = minNode(root.right);
				root.bstvalue = minNode.bstvalue;
				root.right = deleteNode(root.right,minNode.bstvalue);
			}
			else if (root.left!=null) {
				root = root.left;
			}
			else if (root.right !=null) {
				root = root.right;
			}
			else {
				root =null;
			}
		}
		return root;
	}
}
