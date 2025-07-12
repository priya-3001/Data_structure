package mycode.Tree.BinaryHeap;

public class BHMain {
public static void main(String[] args) {
	BinaryHeap bh = new BinaryHeap(10);
	bh.insert(5, "Min");
	bh.insert(10, "Min");
	bh.insert(20, "Min");
	bh.insert(30, "Min");
	bh.insert(40, "Min");
	bh.insert(50, "Min");
	bh.insert(80, "Min");
	bh.levelOrder();
	System.out.println("Size of BH "+bh.sizeBH());
	bh.extractRoot("Min");
	bh.levelOrder();
}
}
