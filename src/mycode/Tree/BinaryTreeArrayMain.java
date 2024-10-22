package mycode.Tree;

public class BinaryTreeArrayMain {
	public static void main(String[] args) {
		
		BinaryTreeUsingArray b1 = new BinaryTreeUsingArray(9);
		
		b1.insert("N1");
		b1.insert("N2");
		b1.insert("N3");
		b1.insert("N4");
		b1.insert("N5");
		b1.insert("N6");
		b1.insert("N7");
		b1.insert("N8");
		b1.insert("N9");
		b1.insert("N10");
		
		System.out.print( " Preorder ");
		b1.preOrder(1);
		System.out.println();
		
		System.out.print( " Postorder ");
		b1.postOrder(1);
		System.out.println();
		
		System.out.print( " Inorder ");
		b1.inOrder(1);
		System.out.println();
		
		System.out.print( " Levelorder ");
		b1.levelOrder(1);
		System.out.println();
		
		b1.search("N5");
		b1.search("N10");
		
		b1.deleteNode("N5");
		
		System.out.print( " Levelorder ");
		b1.levelOrder(1);
		System.out.println();
	}

}
