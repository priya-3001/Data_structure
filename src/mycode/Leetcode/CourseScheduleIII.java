package mycode.Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CourseScheduleIII {
	
	static class Course{
		Integer startTime;
		Integer endTime;
		
		public Course(int start, int end) {
			this.startTime = start;
			this.endTime = end;
		}
	}
	
	public static void main(String[] args) {
		int[][] courses = {{100,200},{200,1300},{1000,1250},{2000,3200}};
		//int[][] courses = {{3,2},{4,3}};
		System.out.println(" RESULT : " + scheduleCourse(courses));
				}
	
	public static int scheduleCourse(int[][] courses) {
		int count = 0;
		Comparator<Course> comparator = (o1, o2) -> o1.endTime - o2.endTime;
		List<Course> courseList = new ArrayList<>();
		int start = 0;
		for(int[] arr : courses) {
			int totalDuration = start + arr[0];
			if(totalDuration <= arr[1] ) {
			totalDuration = Math.min(totalDuration, arr[1]);
			Course course = new Course(start, totalDuration);
			courseList.add(course);
			start = totalDuration;
		}
			}
		if(!courseList.isEmpty()) {
		Collections.sort(courseList, comparator);
		Course previous = courseList.get(0);count = 1;
		for(int i = 1; i<courseList.size();i++) {
			if(courseList.get(i).startTime >= previous.endTime)
			{	previous = courseList.get(i);
				++count;
			}
		}
		}
        return count;
    }

}
