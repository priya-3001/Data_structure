package mycode.GreedyAlgm;

import java.util.ArrayList;
import java.util.List;

public class GreedyMain {
public static void main(String[] args) {
		
	/*List<Activity> listActivity = new ArrayList<>();
	listActivity.add(new Activity("A1",0,6));
	listActivity.add(new Activity("A2",3,4));
	listActivity.add(new Activity("A3",1,2));
	listActivity.add(new Activity("A4",5,7));
	listActivity.add(new Activity("A5",5,8));
	listActivity.add(new Activity("A6",8,9));
	
	ActivitySelection selection = new ActivitySelection();
	selection.activitySelection(listActivity);*/
	
	coinChange cc = new coinChange();
	System.out.println("Min coins required : "+cc.mincoins(1250));
}
}
