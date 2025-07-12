package mycode.GreedyAlgm;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ActivitySelection {
	
	public void activitySelection(List<Activity> activities) {
		
		Comparator<Activity> activityComparator = new Comparator<Activity>() {

			@Override
			public int compare(Activity o1, Activity o2) {
				// TODO Auto-generated method stub
				return o1.getEnd()-o2.getEnd();
			}
		};
		
		Collections.sort(activities, activityComparator);
		
		Activity prev = activities.get(0);
		System.out.println("Recommended Schedule : ");
		System.out.println(prev);
		
		for(int i =1; i<activities.size(); i++) {
			if( prev.getEnd() <= activities.get(i).getStart()) {
				System.out.println(activities.get(i));
				prev = activities.get(i);
			}
		}
		
		
		
	}

}
