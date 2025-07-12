package mycode.Hashing;

public class HashMain {
public static void main(String[] args) {
	/*DirectChaining dc = new DirectChaining(15);
	dc.insert("Quicks");
	dc.insert("brown");
	dc.insert("fox");
	dc.insert("ran");
	dc.insert("over");
	dc.insert("the");
	dc.insert("jungle");
	dc.display();
	dc.search("the");
	dc.delete("the");
	dc.search("the");
	dc.display();*/
	
	LinearProbing lp = new LinearProbing(15);
	lp.insert("Quicks");
	lp.insert("brown");
	lp.insert("fox");
	lp.insert("ran");
	lp.insert("over");
	lp.insert("the");
	lp.insert("jungle");
	lp.display();
	lp.search("over");
	lp.delete("over");
	lp.search("over");
}
}
