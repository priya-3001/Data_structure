package mycode.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLL {
	
	public BinaryNode root;
	
	public BinaryTreeLL() {
		this.root = null;
	}
	
	public void preorder(BinaryNode node) {
		
		if(node==null)
			return;
		
		System.out.print(" " + node.value+ " ");
		preorder(node.left);
		preorder(node.right);
	}
	
	public void inOrder(BinaryNode node) {
		
		if(node==null)
			return;
		inOrder(node.left);
		System.out.print(" " + node.value+ " ");
		inOrder(node.right);
	}

	public void postorder(BinaryNode node) {
	
	if(node==null)
		return;
	postorder(node.left);
	postorder(node.right);
	System.out.print(" " + node.value+ " ");
	
	}
	
	public void levelOrder() {
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			System.out.print(" " + presentNode.value+ " ");
			if(presentNode.left!=null)
			{
				queue.add(presentNode.left);
			}
			if(presentNode.right!=null)
			{
				queue.add(presentNode.right);
			}
		}
	}
	
	public void search(String value) {
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			if(presentNode.value == value) {
				System.out.println("Found ");return;
			}
			else {
				if(presentNode.left!=null)
					queue.add(presentNode.left);
				if(presentNode.right!=null)
					queue.add(presentNode.right);
				
			}
		}
		System.out.print(" Not Found ");
	}
	
	public void insert(String value) {
		BinaryNode newNode = new BinaryNode();
		newNode.value = value;
		if(root == null) {
			root = newNode;System.out.println("Added successfully ");return;
		}
		else {
			Queue<BinaryNode> queue = new LinkedList<>();
			queue.add(root);
			while(!queue.isEmpty()) {
				BinaryNode presentNode = queue.remove();
				if (presentNode.left == null) {
					presentNode.left = newNode;System.out.println("Added successfully ");return;
				}
				else if (presentNode.right == null) {
					presentNode.right = newNode;System.out.println("Added successfully ");return;
				}
				else {
					queue.add(presentNode.left);
					queue.add(presentNode.right);
				}
			}
		}
	}
	
	public BinaryNode getDeepestNode() {
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		BinaryNode presentNode = null;
		while(!queue.isEmpty()) {
			presentNode = queue.remove();
			if(presentNode.left!=null)
				queue.add(presentNode.left);
			if(presentNode.right!=null)
				queue.add(presentNode.right);
			
		}
		
		return presentNode;
	}
	
	public void deleteDeepestNode() {
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		BinaryNode previousNode,presentNode = null;
		while(!queue.isEmpty()) {
			previousNode = presentNode;
			presentNode = queue.remove();
			if(presentNode.left ==null) {
				previousNode.right = null;return;
			}
			else if(presentNode.right ==null) {
				presentNode.left = null;return;
			}
			
			queue.add(presentNode.left);
			queue.add(presentNode.right);
		}
	}
	
	public void deleteSelectedNode(String value) {
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			if(presentNode.value == value) {
				presentNode.value = getDeepestNode().value;
				deleteDeepestNode();
				System.out.println("Deleted successfully");
				return;
			}
			else
				if(presentNode.left !=null)queue.add(presentNode.left);
			if(presentNode.right !=null)queue.add(presentNode.right);
		}
		System.out.println("Not found ");
	}
}
