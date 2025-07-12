package mycode.GreedyAlgm;

public class Activity {

	private String name;
	
	private int start;
	
	private int end;

	public Activity(String name, int start, int end) {
		this.setName(name);
		this.setStart(start);
		this.setEnd(end);
	}

	@Override
	public String toString() {
		return "Activity [name=" + name + ", start=" + start + ", end=" + end + "]";
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
