package mycode.GreedyAlgm;

public class coinChange {

	int[] coins = {1,2,5,10,20,50,100,1000};
	
	public int mincoins(int amount) {
		int count =0;
		
		if(amount == 0)
			return amount;
		 
		
		for(int i =coins.length-1; i>=0 ;i--) {
			if(amount >= coins[i]) {
				amount-= coins[i];
				count++;
			}
			
			if(amount == 0)
				break;
		}
		
		
		return count;
	}
}
