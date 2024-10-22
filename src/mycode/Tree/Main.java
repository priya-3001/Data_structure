package mycode.Tree;

public class Main {
	public static void main(String[] args) {
		
	/*Exercise 1 : Impl of basic Tree Node
		BasicTreeNode drinks = new BasicTreeNode("Drinks");
		BasicTreeNode cold = new BasicTreeNode("Cold");
		BasicTreeNode hot = new BasicTreeNode("Hot");
		BasicTreeNode tea = new BasicTreeNode("Tea");
		BasicTreeNode coffee = new BasicTreeNode("Coffee");
		BasicTreeNode beer = new BasicTreeNode("Beer");
		BasicTreeNode wine = new BasicTreeNode("Wine");
		
		drinks.addChild(cold);
		drinks.addChild(hot);
		 
		cold.addChild(wine);
		cold.addChild(beer);
		
		hot.addChild(tea);
		hot.addChild(coffee);
		
		System.out.println(drinks.print(0));*/
		
		BinaryTreeLL tree = new BinaryTreeLL();
		
		BinaryNode N1 = new BinaryNode();
		N1.value = "N1";
		BinaryNode N2 = new BinaryNode();
		N2.value = "N2";
		BinaryNode N3 = new BinaryNode();
		N3.value = "N3";
		BinaryNode N4 = new BinaryNode();
		N4.value = "N4";
		BinaryNode N5 = new BinaryNode();
		N5.value = "N5";
		BinaryNode N6 = new BinaryNode();
		N6.value = "N6";
		BinaryNode N7 = new BinaryNode();
		N7.value = "N7";
		BinaryNode N8 = new BinaryNode();
		N8.value = "N8";
		BinaryNode N9 = new BinaryNode();
		N9.value = "N9";
		
		N1.left = N2;
		N1.right = N3;
		
		N2.left = N4;
		N2.right = N5;
		
		N3.left = N6;
		N3.right = N7;
		
		N4.left = N8;
		N4.right = N9;
		
		tree.root = N1;
		
		/*System.out.print("Preorder : "  ); tree.preorder(N1);
		System.out.print("Inorder : "  ); tree.inOrder(N1);
		System.out.print("Postorder : "  ); tree.postorder(N1);
		
		System.out.print("Level order : "  ); tree.levelOrder();
		
		tree.search("N11");
		System.out.print("Before Level order : "  ); tree.levelOrder();
		tree.insert("N10");
		System.out.print("After Level order : "  ); tree.levelOrder();
		System.out.print("Before Level order : "  ); tree.levelOrder();
		tree.insert("N10");
		System.out.print("After Level order : "  ); tree.levelOrder();
		
		System.out.println("Deepest Node Level order : " +tree.getDeepestNode().value );
		System.out.print("Before Level order : "  ); tree.levelOrder();
		tree.deleteDeepestNode();
		System.out.print("After Level order : "  ); tree.levelOrder();
		
		System.out.print("Before Level order : "  ); tree.levelOrder();
		
		tree.deleteSelectedNode("N5");
		System.out.print("After Level order : "  ); tree.levelOrder();*/
		tree.deleteSelectedNode("N10");
}
}
