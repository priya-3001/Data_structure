package mycode.Tree;

import java.util.ArrayList;
import java.util.List;

public class BasicTreeNode {
	
	String data;
	List<BasicTreeNode> child;
	
	public BasicTreeNode(String data){
		this.data = data;
		this.child = new ArrayList<>();
	}
	
	public void addChild(BasicTreeNode child) {
		this.child.add(child);
	}
	
	public String print(int level) {
		String ret;
		ret = generateIndentation(level)+data+"\n";
		for(BasicTreeNode children : child) {
			ret += children.print(level+1);
		}
		return ret;
	}
	
	private String generateIndentation(int level) {
		StringBuilder indent = new StringBuilder();
		for (int i = 0; i < level; i++) {
			indent.append("  "); // Two spaces for each level
		}
		return indent.toString();
	}
}
