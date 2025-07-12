package mycode.DivideAndConquer;

public class HouseRobber {

	public int maxValueFromHouse(int[] houseWealth, int houseindex) {
		if(houseindex>=houseWealth.length) {
			return 0;
		}
		
		int stealCurrentHouse = houseWealth[houseindex] + maxValueFromHouse(houseWealth, houseindex+2);
		int skipCurrentHouse =maxValueFromHouse(houseWealth, houseindex+1);
		return Math.max(stealCurrentHouse, skipCurrentHouse);
	}
	
	public int maxAmount(int[] houseWealth) {
		return maxValueFromHouse(houseWealth, 0);
	}
}
